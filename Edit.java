import java.io.*;
import java.util.*;
import java.text.*;
public class Edit {
    //Method to display tasks for the user to select for editing
    public static void editTask() throws IOException, ParseException {
        //Openeing the file and creating a scanner object
        Scanner s = new Scanner(new File("output.txt"));
        //Creating empty string to append lines of text file to with a while loop.
        String lines = "";
        while (s.hasNext()) {
            lines += s.nextLine();
        }
        //Creating array by splitting the string by "#" which will be written in when a project is added
        String[] lineArr = lines.split("#");
        //Creating arraylist and appending lines from array with while loop
        List<String> inLines = Arrays.asList(lineArr);
        while (s.hasNextLine()) {
            inLines.add(s.nextLine());
        }
        s.close();
        //Creating a counter to number the projects printed
        int indexCount = 0;
        //For loop to print the projects with a counter, which the user will use to select a project to finalise
        for (int i = 0; i < lineArr.length; i++) {
            indexCount += 1;
            String[] projectInfo = lineArr[i].split(", ");
            System.out.println("Index number: " + indexCount);
            System.out.println("Project name: " + projectInfo[0]);
            System.out.println("Project number: " + projectInfo[1]);
            System.out.println("Build type: " + projectInfo[2]);
            System.out.println("Address: " + projectInfo[3]);
            System.out.println("ERF number: " + projectInfo[4]);
            System.out.println("Fee: " + projectInfo[5]);
            System.out.println("Paid to date: " + projectInfo[6]);
            System.out.println("Due date: " + projectInfo[7] + "\n");
        }
        //Calling method to edit the selected project
        Edit.taskSelect();
        s.close();
    }
        //Method to edit selected project
        public static void taskSelect () throws IOException, ParseException {
            //Opening file and creating scanne objects to read the file and take user input
            Scanner s = new Scanner(new File("output.txt"));
            Scanner sc2 = new Scanner(System.in);
            //Creating empty string to append lines of text file to with a while loop.
            String lines = "";
            while (s.hasNext()) {
                lines += s.nextLine();
            }
            //Creating an array by splitting string by "#" which will be written to the text file when a new project is added
            String[] lineArr = lines.split("#");
            //Creating arraylist and appending lines from array with while loop
            List<String> inLines = Arrays.asList(lineArr);
            while (s.hasNextLine()) {
                inLines.add(s.nextLine());
            }
            s.close();

            //Prompting the user to select a task by entering the corresponding number
            System.out.println("Enter index of project to edit: \ne - Exit");
            int proSelect = sc2.nextInt();

            System.out.println("\nSelect attribute to edit: ");
            System.out.println("1 ~ Project name\n2 ~ Due date\n3 ~ Amount paid to date\ne - exit");
            String attSelect = sc2.next();

            //For loop to create string array by splitting the array by ", "
            for (int i = 0; i < lineArr.length; i++) {
                String[] projectInfo = lineArr[i].split(", ");



                //Opening file and creating file writer object to write to the file
                FileWriter writer = new FileWriter("output.txt",false);
                BufferedWriter buffer = new BufferedWriter(writer);
                //The project gets selected by the user entering a number to select. That number will be subtracted by 1 to get the correct index of the selected project
                String selectedProj = inLines.get(proSelect - 1);
                //Creating array by splitting string by ", "
                String[] selectedProjarr = selectedProj.split(", ");
                //Prompting the user to select an attribute to edit

            if (attSelect.equals("e")) {
                break;
            }
            /*If the user selects 1, they will be prompted to enter a new project name and the
            value of the index which contains the project name will be changed to the new name.
            The selected project will be replaced in the array with the edited project*/
            if (attSelect.equals("1")) {
                System.out.println("Enter new project name: ");
                String newPN = sc2.next();
                selectedProjarr[0] = newPN;
                String projLinestr = Arrays.toString(selectedProjarr);
                inLines.set(proSelect - 1, projLinestr);

                for (String str : inLines) {
                    buffer.write(str + "#\n");
                }
                System.out.println("Project name has been updated.");
                buffer.close();
                break;
            }
            /*If the user selects 2, they will be prompted to enter a new due date and the
            value of the index which contains the due date will be changed to the new date.
            The selected project will be replaced in the array with the edited project
            */
            if (attSelect.equals("2")) {
                System.out.println("Enter new due date (dd/MM/yyyy):");
                String newDate = sc2.next();
                String patt = "dd/MM/yyyy";
                SimpleDateFormat datefor = new SimpleDateFormat(patt);
                Date dueDate = datefor.parse(newDate);
                selectedProjarr[7] = String.valueOf(dueDate);
                String projLinestr = Arrays.toString(selectedProjarr);
                inLines.set(proSelect - 1, projLinestr);

                for (String str : inLines) {
                    buffer.write((str + "#\n"));
                }
                buffer.close();
                break;
            }
            /*If the user selects 3, they will be prompted to enter a new amount paid to date and the
            value of the index which contains the amount paid to date will be changed to the new amount.
            The selected project will be replaced in the array with the edited project
            */
            if (attSelect.equals("3")) {
                System.out.println("Enter new amount paid to date: ");
                String newPTD = sc2.next();
                selectedProjarr[6] = newPTD;
                String projLinestr = Arrays.toString(selectedProjarr);
                inLines.set(proSelect - 1, projLinestr);

                for (String str : inLines) {
                    buffer.write((str + "#\n"));
                }
                buffer.close();
                break;
            }
        }
    }
}



























