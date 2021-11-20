# L02T24-Poised
Poised Project Management System
For this task, we were asked create a project management program for a building company named Poised. Users needed to be able to add new project, which would then be stored in a text file. The details of the project along with the contact details of the contractor, customer and architect would be entered by the user and then be used to create a project, customer, contractor and architect object respectvely. 

When the user runs the program, they will be prompted by a main menu, which will ask them to select one of the following options: to add a new project, to view a all projects, search project by project number, edit project, finalise project, seec completed projects and see overdue project.

If the user selects to add a new project, they will be promted to enter the details of the project, customer, contractor and architect, which will then be used to create objects and be written to the text file.

If the user selects to view all project, the information in the text file will be read and used to create project objects. The project objects will then be displayed with a To String method. 

If the user selects to search for a project, they will be prompted to enter a project number. The lines in the text file will then be iterated through and split. If the project number of a project is equal to the number entered by the user, the project will be printed.

If the user selects to edit a project, all the projects in the textfile will be printed and the user will be prompted to select a project to edit. Once the user has selected a project, they will then be prompted to edit either the project name, due date or amount paid to date. Once the user has selected what attribute to edit and entered the new details, all the lines in the textfile will be written into an arraylist. The arraylist will then be iterated through to find the project the user selected. The index of the attribute the user selected will be changed to the new value and the arraylist will then be written to the file. When the arraylist gets written to the file, it overwrites the file with the arraylist.

If the user selects to finalise a project, they will be prompted to select a project to finalise. The last attribute of the project will then be changed from "not finalised" to "finalised". An invoice and summary of the project will then be created and written to textfiles. The details of the customer along with the amoumnt to be paid will be written to a the invoice textfile and the summary to the completedproject textfile.

If the user selects to see completed projects, all the projects withe the attribute "finalised" will be printed in an east to read manner.

If the user selects to see the overdue tasks, the projects with a date value less than the current date will be printed.


