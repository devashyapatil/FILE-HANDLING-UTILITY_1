# FILE-HANDLING-UTILITY_1

**COMPANY**: CODETECH IT SOLUTIONS

**NAME**: Devashya Tulsidas Patil

**INTERN ID**: CT08JFE

**DOMAIN**: JAVA PROGRAMMING

**BATCH DURATIONN**: January 5th, 2025 to February 5th, 2025

**MENTOR NAME**: Neela Santhosh Kumar

# DESCRIPTION: 

     **Functionality**:
        This program acts as a simple file management tool that allows users to perform various 
        operations on text files. Here's a breakdown of the functionalities it offers:
        
          1. Writing to a File: Users can create a new file or write content to an existing one. The program
             prompts the user for the file name and the content to be written. It then uses a FileWriter
             object to save the data to the specified file.
             
          3. Reading from a File: Users can view the contents of a text file. The program prompts for the
             file name and then uses a BufferedReader object to read the file line by line, displaying
             the content on the screen.
             
          6. Modifying a File: This feature provides options to:
             -> Replace the entire content of a file.
             -> Append new text to an existing file.
             -> Delete specific lines from a file.
             
      **Code Structure**:
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
                 
      **Key Points**:
        =>The code effectively utilizes exception handling (try-catch blocks) to manage potential 
           errors during file operations, providing informative messages to the user in case of issues.
           
        =>For reading and modifying files, the code uses BufferedReader and FileWriter objects 
           from Java's standard library, which provide convenient methods for working with text files.
           
        =>When modifying a file, the code reads the existing content line by line into a list, makes the 
           necessary changes (replacement, deletion, or appending), and then writes the modified list back to the file.
           
      **TOOLS**:
         Having knowldge of Java documentation and programming tools, to demonstrate file handling operations. 
         I also referred to online programming resources and utilized an AI assistant for brainstorming and debugging certain features. Like : Chatgpt,Google.
        
    Overall, this file handling utility demonstrates a good understanding of Java's file I/O functionalities and provides a user-friendly interface for basic file management tasks.  
