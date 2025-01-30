import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/**
 * A simple file utility program to help with reading, writing,
 * and modifying files. Designed to be interactive and easy to use.
 */
public class FileOperations {

    // Scanner object for user input
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Displaying menu options
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Write to a File");
            System.out.println("2. Read from a File");
            System.out.println("3. Modify a File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Taking user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Handling user choice with switch-case
            switch (choice) {
                case 1 -> writetofile();
                case 2 -> readfromfile();
                case 3 -> modifyfile();
                case 4 -> {
                    System.out.println("Exiting the program. See you next time!");
                    System.exit(0);  // Terminate the program
                }
                default -> System.out.println("Oops! That's not a valid choice. Try again.");
            }
        }
    }

    /**
     * Writes user-inputted content to a file.
     */
    public static void writetofile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        System.out.println("Enter the content (Type 'END' on a new line to finish):");

        StringBuilder content = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("END")) {
                break;
            }
            content.append(line).append("\n");
        }

        try (FileWriter writer = new FileWriter(fileName, true)) { // 'true' to append content
            writer.write(content.toString());
            System.out.println("Content written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Reads and displays the content of a specified file.
     */
    private static void readfromfile() {
        String fileName = getValidatedInput("Enter the name of the file to read from: ");

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Hmm... I couldn't find that file. Are you sure it exists?");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\nHere’s what’s inside the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Yikes! Something went wrong while reading the file.");
            e.printStackTrace();
        }
    }


    /**
     * Allows the user to modify an existing file through various operations.
     */
    private static void modifyfile() {
        String fileName = getValidatedInput("Enter the name of the file you want to modify: ");

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Hmm... I couldn’t find that file. Double-check the name.");
            return;
        }

        // Displaying modification options
        System.out.println("\nChoose an option to modify the file:");
        System.out.println("1. Replace the entire content");
        System.out.println("2. Append text to the file");
        System.out.println("3. Delete specific lines");
        System.out.println("4. Replace specific text");
        System.out.println("5. Insert a paragraph at a specific position");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        //Calling methods
        switch (choice) {
            case 1 -> replaceFileContent(file);
            case 2 -> appendToFile(file);
            case 3 -> deleteSpecificLines(file);
            case 4 -> replaceSpecificText(file);
            case 5 -> insertParagraphInFile(file);
            default -> System.out.println("Invalid option. Returning to the main menu."); //msg for invalid input
        }
    }

    /**
     * Inserts a paragraph at a specific line number in the given file.
     *
     * @param file The file in which the paragraph should be inserted.
     */
    private static void insertParagraphInFile(File file) {
        try {
            // Read all lines from the file into a list
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

            // Display the file content with line numbers for user reference
            System.out.println("\nHere’s the content of the file with line numbers:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }

            // Get the line number where the user wants to insert the paragraph
            int lineNumber = Integer.parseInt(getValidatedInput("Enter the line number where you want to insert the paragraph: "));

            // Validate the line number input
            if (lineNumber < 1 || lineNumber > lines.size() + 1) {
                System.out.println("Invalid line number.");
                return;
            }

            // Prompt user to enter the paragraph to be inserted
            System.out.println("Enter the paragraph you want to insert (type 'END' on a new line to finish):");
            StringBuilder paragraph = new StringBuilder();

            // Read user input line by line until "END" is entered
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) {
                    break;
                }
                paragraph.append(line).append(System.lineSeparator());
            }

            // Insert the paragraph at the specified position in the list
            lines.add(lineNumber - 1, paragraph.toString());

            // Write the updated content back to the file
            Files.write(file.toPath(), lines, StandardCharsets.UTF_8);
            System.out.println("The paragraph was inserted successfully.");
        } catch (IOException e) {
            // Handle file-related errors
            System.out.println("Something went wrong while modifying the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle invalid number input
            System.out.println("Invalid input. Please enter a valid line number.");
        }
    }


    /**
     * Replaces the entire content of the given file with new user-provided content.
     *
     * @param file The file whose content needs to be replaced.
     */
    private static void replaceFileContent(File file) {
        System.out.println("Enter the new content for the file (type 'END' on a new line to finish):");

        // StringBuilder to store the new content entered by the user
        StringBuilder newContent = new StringBuilder();

        // Read user input line by line until "END" is entered
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("END")) {
                break; // Stop reading input when the user types "END"
            }
            newContent.append(line).append(System.lineSeparator());
        }

        // Write the new content to the file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newContent.toString()); // Overwrites the file with new content
            System.out.println("The file has been updated successfully.");
        } catch (IOException e) {
            // Handle file-related errors
            System.out.println("Oops! Couldn’t update the file.");
            e.printStackTrace();
        }
    }


    /**
     * Appends user-provided text to the specified file.
     *
     * @param file The file to which text should be appended.
     */
    private static void appendToFile(File file) {
        // Prompt the user to enter text to append
        String textToAppend = getValidatedInput("Enter the text you want to append:");

        try (FileWriter writer = new FileWriter(file, true)) { // Open file in append mode
            // Check if the file is not empty and whether it ends with a newline
            if (file.length() > 0) {
                try (RandomAccessFile raf = new RandomAccessFile(file, "r")) { // Open file for reading
                    raf.seek(file.length() - 1); // Move to the last character of the file
                    char lastChar = (char) raf.readByte(); // Read the last character

                    // If the last character is not a newline, add a new line before appending
                    if (lastChar != '\n' && lastChar != '\r') {
                        writer.write(System.lineSeparator());
                    }
                }
            }

            // Append the new text followed by a newline
            writer.write(textToAppend + System.lineSeparator());
            System.out.println("The text was added to the file successfully.");
        } catch (IOException e) {
            // Handle any file-related errors
            System.out.println("Something went wrong while appending to the file.");
            e.printStackTrace();
        }
    }

    /**
     * Deletes specific lines from the given file based on user input.
     *
     * @param file The file from which lines should be deleted.
     */
    private static void deleteSpecificLines(File file) {
        // Prompt the user to enter line numbers to delete, separated by commas
        String lineNumbersInput = getValidatedInput("Enter the line numbers you want to delete (comma-separated):");

        List<Integer> lineNumbers = new ArrayList<>();
        try {
            // Parse the user input into a list of integers
            for (String num : lineNumbersInput.split(",")) {
                lineNumbers.add(Integer.parseInt(num.trim())); // Convert each number from string to integer
            }

            // Read all lines from the file into a list
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            List<String> updatedLines = new ArrayList<>();

            // Iterate through the file's lines, keeping only those not marked for deletion
            for (int i = 0; i < lines.size(); i++) {
                if (!lineNumbers.contains(i + 1)) { // Line numbers are 1-based, while index is 0-based
                    updatedLines.add(lines.get(i));
                }
            }

            // Write the updated content back to the file
            Files.write(file.toPath(), updatedLines, StandardCharsets.UTF_8);
            System.out.println("The specified lines were removed successfully.");
        } catch (IOException e) {
            // Handle file-related errors
            System.out.println("Uh-oh! Couldn’t modify the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle invalid input errors
            System.out.println("Please enter valid line numbers.");
        }
    }

    /**
     * Replaces specific text in a file, either in a specific line or throughout the entire file.
     *
     * @param file The file in which text replacement should be performed.
     */
    private static void replaceSpecificText(File file) {
        try {
            // Read all lines from the file into a list
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

            // Display the file content with line numbers
            System.out.println("\nHere’s the content of the file with line numbers:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }

            // Ask the user if they want to replace text in a specific line or the whole file
            System.out.println("\nDo you want to replace text in a specific line or the whole file?");
            System.out.println("1. Specific line\n2. Entire file");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                // Get the line number where the user wants to replace text
                int lineNumber = Integer.parseInt(getValidatedInput("Enter the line number where you want to replace text: "));

                // Validate the line number
                if (lineNumber < 1 || lineNumber > lines.size()) {
                    System.out.println("Invalid line number.");
                    return;
                }

                // Retrieve the specified line
                String line = lines.get(lineNumber - 1);
                String oldText = getValidatedInput("Enter the text to replace: ");
                String newText = getValidatedInput("Enter the new text: ");

                // Find all occurrences of the text in the selected line
                List<Integer> indices = findOccurrences(line, oldText);

                if (indices.isEmpty()) {
                    System.out.println("No occurrences found.");
                    return;
                }

                // Display all occurrences with context for better user selection
                System.out.println("Multiple occurrences found. Choose one to replace:");
                for (int i = 0; i < indices.size(); i++) {
                    int startIndex = indices.get(i);
                    int endIndex = startIndex + oldText.length();

                    // Show some surrounding text (20 characters before and after)
                    int contextStart = Math.max(0, startIndex - 20);
                    int contextEnd = Math.min(line.length(), endIndex + 20);

                    String context = line.substring(contextStart, startIndex) +
                            "[" + line.substring(startIndex, endIndex) + "]" +
                            line.substring(endIndex, contextEnd);

                    System.out.println((i + 1) + ": " + context);
                }

                // Get user's choice for which occurrence to replace
                System.out.print("Enter the number of the occurrence to replace: ");
                int occurrenceChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Validate the user's selection
                if (occurrenceChoice < 1 || occurrenceChoice > indices.size()) {
                    System.out.println("Invalid choice.");
                    return;
                }

                // Replace the selected occurrence in the line
                int selectedIndex = indices.get(occurrenceChoice - 1);
                line = line.substring(0, selectedIndex) + newText + line.substring(selectedIndex + oldText.length());

                // Update the modified line in the list
                lines.set(lineNumber - 1, line);

            } else if (choice == 2) {
                // Replace text throughout the entire file
                String oldText = getValidatedInput("Enter the text to replace: ");
                String newText = getValidatedInput("Enter the new text: ");

                for (int i = 0; i < lines.size(); i++) {
                    lines.set(i, lines.get(i).replace(oldText, newText));
                }
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            // Write the modified content back to the file
            Files.write(file.toPath(), lines, StandardCharsets.UTF_8);
            System.out.println("The text was replaced successfully.");

        } catch (IOException e) {
            // Handle file-related errors
            System.out.println("Something went wrong while replacing the text.");
            e.printStackTrace();
        }
    }

    // Method to find all occurrences of a given text in the line
    private static List<Integer> findOccurrences(String line, String textToReplace) {
        // Create a list to store the indices of occurrences
        List<Integer> indices = new ArrayList<>();

        // Start by finding the first occurrence of the textToReplace in the line
        int index = line.indexOf(textToReplace);

        // Loop to find all occurrences of the textToReplace in the line
        while (index != -1) {
            // Add the current index to the list
            indices.add(index);

            // Find the next occurrence starting from the position after the current index
            index = line.indexOf(textToReplace, index + 1);
        }

        // Return the list of indices where the textToReplace was found
        return indices;
    }



    /**
     * Validates user input to ensure it is not empty.
     *
     * @param prompt The prompt message for the user
     * @return The validated user input
     */
    private static String getValidatedInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
        return input;
    }
}
