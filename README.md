# FILE-HANDLING-UTILITY_1

**COMPANY**: CODETECH IT SOLUTIONS

**NAME**: Devashya Tulsidas Patil

**INTERN ID**: CT08JFE

**DOMAIN**: JAVA PROGRAMMING

**BATCH DURATIONN**: January 5th, 2025 to February 5th, 2025

**MENTOR NAME**: Neela Santhosh Kumar

# DESCRIPTION: 

     Introduction:
          This program is designed as a simple yet powerful file management utility, allowing users to perform 
          a variety of text file operations. It provides an intuitive and user-friendly interface for writing, reading,
          and modifying files. The program leverages Java’s built-in file handling classes, such as FileWriter,
          BufferedReader, and Scanner, to facilitate efficient file operations. Additionally, it incorporates 
          exception handling to ensure smooth execution and prevent unexpected crashes.
          
          By using this tool, users can create, edit, and manipulate text files effortlessly. Whether you need to
          save notes, log data, or modify existing text documents, this program serves as a practical solution.
          
     Functionality:
        This program acts as a simple file management tool that allows users to perform various 
        operations on text files. Here's a breakdown of the functionalities it offers:
        
          1. Writing to a File:
               -> Users can create a new file or write content to an existing one.
               -> The program prompts the user for the file name and content.
               -> A FileWriter object is utilized to store the data in the specified file.
               -> If the file already exists, the program provides an option to overwrite or append content.
                  
          3. Reading from a File:
               -> Users can view the contents of a specified text file.
               -> The program prompts the user for the file name.
               -> A BufferedReader object reads the file line by line and displays its content.
               -> If the file does not exist, an error message is displayed.
             
          6. Modifying a File: This feature provides options to:
               -> Replace File Content: Completely overwrites the existing file with new content.
               -> Append to File: Adds new text to an existing file without deleting previous content.
               -> Delete Specific Lines: Users can specify which lines they want to remove.
               -> Replace Specific Text: Finds and replaces specific words or phrases.
               -> Insert a Paragraph: Allows users to insert a paragraph at a specified line number.
             
      Code Structure:
        The code is well-organized and uses clear naming conventions, making it relatively easy to 
        understand. Here's a breakdown of the key components:
        
          1. Scanner: A single Scanner object is used throughout the program to get user input for 
             various operations.
             
          2. Main Function: This function serves as the entry point of the program. It presents a menu to
             the user with different options for file operations (write, read, modify, exit). Based on the
             user's choice, it calls the corresponding functions to handle the specific operation.
             
          3. Helper Functions:
              ->writetofile(): Handles writing user input to a file.
              ->readfromfile(): Reads and displays the contents of a file.
              ->modifyfile(): Provides options for modifying a file's content.
                 1. replaceFileContent(): Replaces the entire content of a file.
                 2. appendToFile(): Appends new text to the end of a file.
                 3. deleteSpecificLines(): Deletes user-specified lines from a file.
                 4. replaceTextInFile(): Finds and replaces specific words or phrases.
                 5. insertParagraphAtLine(): Inserts a paragraph at a given line number.
                 
      Key Points:
        =>The code effectively utilizes exception handling (try-catch blocks) to manage potential 
           errors during file operations, providing informative messages to the user in case of issues.
           
        =>For reading and modifying files, the code uses BufferedReader and FileWriter objects 
           from Java's standard library, which provide convenient methods for working with text files.
           
        =>When modifying a file, the code reads the existing content line by line into a list, makes the 
           necessary changes (replacement, deletion, or appending), and then writes the modified list back to the file.
           
      TOOLS:
          To develop this file management utility, the following tools and resources were used:
          -> Java Standard Library: Built-in classes for file I/O operations.
          -> Online Programming Resources: Java documentation, coding tutorials, and community forums.
          -> AI Assistance & Debugging: Used AI tools like ChatGPT for brainstorming and debugging.
          -> Google Search & References: Researched best practices for handling text files in Java.
        
      Conclusion:
          This file management utility provides an efficient way to work with text files, offering robust features 
          like writing, reading, and modifying files. It demonstrates a strong understanding of Java’s file
          handling capabilities and serves as a useful tool for students, developers, and anyone dealing 
          with text-based data storage.


# OUTPUT OF THE TASK : 

**Write to file** :
![Image](https://github.com/user-attachments/assets/6c46af83-6158-4fa4-8090-6051f4254a0d)

**Read from file** :
![Image](https://github.com/user-attachments/assets/31f02f03-a531-47ff-9349-bff4443f2dce)

**Modifications** : 
Appending text :
![Image](https://github.com/user-attachments/assets/7a2b8862-7d89-46f5-a809-6b43cf45c6b9)

Replace text :     
![Image](https://github.com/user-attachments/assets/d58e0c3c-8fc9-4c05-9cf2-76409465d3e7)
![Image](https://github.com/user-attachments/assets/8aa348b2-796e-435a-b0cd-581746b7b481)

Delete specific line :
![Image](https://github.com/user-attachments/assets/ad528c6d-8285-4497-8a23-f7f0a4623732)

Insert a paragraph :
![Image](https://github.com/user-attachments/assets/cfbcf807-caa8-465b-8179-76a9f829beac)

Exit :     
![Image](https://github.com/user-attachments/assets/39709449-37c8-4101-9203-884993a71621)

**After Modifications**:
![Image](https://github.com/user-attachments/assets/f38abd1e-5167-4d31-a1f9-f3c6bba09974)
