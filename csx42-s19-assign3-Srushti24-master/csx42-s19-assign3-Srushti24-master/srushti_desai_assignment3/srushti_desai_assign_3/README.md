# CSX42: Assignment 3
## Name: 

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<inputFile.txt> -Darg1=<outputFile.txt> -Darg2=<Logger-Value> 

Example:

The last argument is the Logger value. 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=inputFile.txt -Darg1=outputFile.txt -Darg2=3



-----------------------------------------------------------------------
## Description:

The timeComplexity of the Insertion, Deletion and Search function is O(Log n) since its a Binary Search Tree.
The reason why i choose this tree is to reduce the time complexity and also because the one of the requiremtns of the project is that
we print in ascending order which can easily be done using inorder function of the binary tree.
The entire implementation of Binary tree insert,search and delete is my own.
I have referred the following link for printing(which i have mentioned where is is printed) tree:
https://github.com/jaydeepingle/design-patterns-impl/blob/master/observer/studentCoursesBackup/src/studentCoursesBackup/driver/Driver.java.


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 7/9/2019


