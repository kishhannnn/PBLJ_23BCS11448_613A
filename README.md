# Develop Java Programs Using Autoboxing, Serialization, File Handling, and Efficient Data Processing and Management

# Part a: Sum of Integers Using Autoboxing and Unboxing
Objective:
To build a Java program that utilizes autoboxing and unboxing to calculate the sum of a list of integers. The program should also demonstrate parsing string inputs into integer values using methods like Integer.parseInt().

Explanation:
This task focuses on:

Autoboxing: Automatically converting primitive int values into Integer objects.
Unboxing: Converting Integer objects back into primitive int.
String Parsing: Using Integer.parseInt() to convert user input from strings to integers.
The program should:

Accept multiple integer inputs as strings.
Convert each string to an Integer using parsing methods.
Store them in a collection like ArrayList<Integer>.
Calculate and display the total sum using enhanced for-loops with unboxing.

# Part b: Serialization and Deserialization of a Student Object
Objective:
To implement Java serialization to save a Student object to a file and later retrieve it through deserialization.

Explanation:
Serialization helps persist object state and is useful for saving objects in files or transmitting over a network. This task includes:

Creating a Student class with fields like studentID, name, and grade.

Making the class implement the Serializable interface.

Writing a program to:

Serialize the Student object using ObjectOutputStream.
Save it to a file.
Deserialize it using ObjectInputStream to reconstruct the object.
Print the student’s data to confirm successful deserialization.

# Part c: Menu-Based Employee Management System Using File Handling
Objective:
To develop a menu-driven Java application for adding and displaying employee records using file handling mechanisms.

Explanation:
This task combines user interaction, file operations, and object or text data storage. The application should:

Display a menu with three options:

Add an Employee

Prompt user to enter employee details (name, ID, designation, salary).
Save the data to a file either in serialized form or as formatted text.
Display All Employees

Read data from the file.
Display employee records in a readable format.
Exit the Application

End the program gracefully.
This exercise demonstrates:

Practical usage of file I/O classes like FileWriter, BufferedWriter, FileReader, BufferedReader, or object streams.
Structuring applications with loops and Scanner for repeated menu interaction.
Efficient data management through persistent storage and retrieval.
