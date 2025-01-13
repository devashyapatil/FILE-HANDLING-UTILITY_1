import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/**
 * A simple file utility program to help with reading, writing,
 * and modifying files. Designed to be interactive and easy to use.
 */
public class FileOperations {

    // Using a single Scanner instance for all user inputs
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Displaying the menu options
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Write to a File");
            System.out.println("2. Read from a File");
            System.out.println("3. Modify a File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Getting the user's choice and handling invalid input
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the leftover newline

            switch (choice) {
                case 1 -> writetofile(); // Call write functionality
                case 2 -> readfromfile(); // Call read functionality
                case 3 -> modifyfile(); // Call modify functionality
                case 4 -> {
                    System.out.println("Exiting the program. See you next time!");
                    System.exit(0);
                }
                default -> System.out.println("Oops! That's not a valid choice. Try again.");
            }
        }
    }

    /**
     * Writes user input to a file. If the file doesn't exist, it creates one.
     */
    private static void writetofile() {
        System.out.print("Enter the name of the file to write to: ");
        String fileName = scanner.nextLine();

        System.out.println("Enter the text you want to save in the file:");
        String content = scanner.nextLine();

        // Try writing to the file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content); // Save the content
            System.out.println("Great! The data was saved successfully in " + fileName);
        } catch (IOException e) {
            // If something goes wrong during the file writing process
            System.out.println("Uh-oh! There was an issue writing to the file.");
            e.printStackTrace(); // Prints details to help debug the problem
        }
    }

    /**
     * Reads and displays the contents of a file.
     */
    private static void readfromfile() {
        System.out.print("Enter the name of the file to read from: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        if (!file.exists()) {
            // Check if the file exists before trying to read it
            System.out.println("Hmm... I couldn't find that file. Are you sure it exists?");
            return;
        }

        // Try reading the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\nHere’s what’s inside the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line
            }
        } catch (IOException e) {
            // Catch any issues during the file reading process
            System.out.println("Yikes! Something went wrong while reading the file.");
            e.printStackTrace(); // Helpful for debugging
        }
    }

    /**
     * Offers multiple options to modify the contents of a file.
     */
    private static void modifyfile() {
        System.out.print("Enter the name of the file you want to modify: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        if (!file.exists()) {
            // Check if the file exists before modifying
            System.out.println("Hmm... I couldn’t find that file. Double-check the name.");
            return;
        }

        System.out.println("\nChoose an option to modify the file:");
        System.out.println("1. Replace the entire content");
        System.out.println("2. Append text to the file");
        System.out.println("3. Delete specific lines");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline

        switch (choice) {
            case 1 -> replaceFileContent(file);
            case 2 -> appendToFile(file);
            case 3 -> deleteSpecificLines(file);
            default -> System.out.println("Invalid option. Returning to the main menu.");
        }
    }

    // Option 1: Replace the entire file content
    private static void replaceFileContent(File file) {
        System.out.println("Enter the new content for the file:");
        String newContent = scanner.nextLine();

        // Try replacing the content
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newContent); // Overwrite with new content
            System.out.println("The file has been updated successfully.");
        } catch (IOException e) {
            System.out.println("Oops! Couldn’t update the file.");
            e.printStackTrace(); // Debugging details
        }
    }

    // Option 2: Append new content to the file
    private static void appendToFile(File file) {
        System.out.println("Enter the text you want to append:");
        String textToAppend = scanner.nextLine();

        // Try appending to the file
        try (FileWriter writer = new FileWriter(file, true)) { // true enables appending
            writer.write(textToAppend + System.lineSeparator()); // Add text with a new line
            System.out.println("The text was added to the file successfully.");
        } catch (IOException e) {
            System.out.println("Something went wrong while appending to the file.");
            e.printStackTrace(); // Debugging details
        }
    }

    // Option 3: Delete specific lines from the file
    private static void deleteSpecificLines(File file) {
        System.out.println("Enter the line numbers you want to delete (comma-separated):");
        String lineNumbersInput = scanner.nextLine();

        List<Integer> lineNumbers = new ArrayList<>();
        for (String num : lineNumbersInput.split(",")) {
            lineNumbers.add(Integer.parseInt(num.trim()));
        }

        // Try deleting the specified lines
        try {
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            List<String> updatedLines = new ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                if (!lineNumbers.contains(i + 1)) { // Line numbers are 1-based
                    updatedLines.add(lines.get(i));
                }
            }

            Files.write(file.toPath(), updatedLines, StandardCharsets.UTF_8);
            System.out.println("The specified lines were removed successfully.");
        } catch (IOException e) {
            System.out.println("Uh-oh! Couldn’t modify the file.");
            e.printStackTrace(); // Debugging details
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid line numbers.");
        }
    }
}
