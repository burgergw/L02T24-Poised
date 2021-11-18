import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
public class Finalizing {
    //Displays tasks for user to select to finalise
    public static void finalise() throws IOException {
        //Openeing the file and creating a scanner object
        File inFile = new File("output.txt");
        Scanner sc = new Scanner(inFile);
        //Creating empty string to append lines of text file to with a while loop.
        String lines = "";
        while (sc.hasNext()) {
            lines += sc.nextLine();
        }
        //Creating a counter to number the projects printed
        int indexCount = 0;
        //Creating an array by splitting string by "#" which will be written to the text file when a new project is added
        String[] lineArr = lines.split("#");
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
        sc.close();
        finaliseEdit();
    }
    //Selecting project to finalise
    public static void finaliseEdit() throws IOException {
        //Creating scanner object and reading the file
        Scanner s = new Scanner(new File("output.txt"));
        Scanner sc2 = new Scanner(System.in);
        //Empty string to append the lines of the file to
        String lines = "";
        //While loop to append lines of file to empty string
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
        //For loop to split array by ", "
        for (int i = 0; i < lineArr.length; i++) {
            String[] projectInfo = lineArr[i].split(", ");
            //Prompting the user to enter a number to select a project to finalise
            System.out.println("Enter index number of task to finalise: \ne - Exit");
            int proSelect = sc2.nextInt();
            //Opening the file and creating a bufferedwriter object
            FileWriter writer = new FileWriter("output.txt",false);
            BufferedWriter buffer = new BufferedWriter(writer);
            //The project gets selected by the user entering a number to select. That number will be subtracted by 1 to get the correct index of the selected project
            String selectedProj = inLines.get(proSelect - 1);
            //Creating array by splitting the string
            String[] selectedProjarr = selectedProj.split(", ");
            //Changing the value of the index
            selectedProjarr[21] = "finalised";
            //Creating a string from the edited array
            String projLinestr = Arrays.toString(selectedProjarr);
            //Replacing the selected project in the arraylist with the string of the edited project
            inLines.set(proSelect - 1 , projLinestr);
            //For loop to write the arraylist to file. I got this method from https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file/6548204
            for(String str:inLines) {
                buffer.write((str + "#\n"));
            }
            buffer.close();
            //Reading integers from file to calculate amount to be paid
            String feeStr = selectedProjarr[5];
            int feeINT = Integer.valueOf(feeStr);
            String ptdStr = selectedProjarr[6];
            int ptdInt = Integer.valueOf(ptdStr);
            int tobePaid = feeINT - ptdInt;
            //If there still is money to be payed when a project gets finalised, an invoice will be created, if all fees are paid, no invoive will be made
            if (tobePaid != 0) {
                //Opening the file and creating buffered writer to write to the file
                FileWriter writer2 = new FileWriter("invoice.txt");
                BufferedWriter buffer2 = new BufferedWriter(writer2);
                //Writing to the file
                buffer2.write("Customer name: " + selectedProjarr[12] + " " + selectedProjarr[13] + "\n");
                buffer2.write("Customer tel number: " + selectedProjarr[14] + "\n");
                buffer2.write("Customer email: " + selectedProjarr[15] + "\n");
                buffer2.write("Customer address: " + selectedProjarr[16] + "\n");
                buffer2.write("Amount to be paid: " + "R" + tobePaid);
                buffer2.close();
                System.out.println("Project has been finalised and invoice was created.");
            }
            else
            {
                System.out.println("Total amount has been paid, invoice was not created.\nProject was finalised.");
            }
            //Opening file and creating buffered writer object to write to the completed projects file
            FileWriter writer3 = new FileWriter("completedProject.txt");
            BufferedWriter buffer3 = new BufferedWriter(writer3);
            //Writing the project info to the file
            buffer3.write("Project name: " + selectedProjarr[0] + "\n");
            buffer3.write("Project number: " + selectedProjarr[1] + "\n");
            buffer3.write("Building type: " + selectedProjarr[2] + "\n");
            buffer3.write("Address: " + selectedProjarr[3] + "\n");
            buffer3.write("ERF Number: " + selectedProjarr[4] + "\n");
            buffer3.write("Fee: " + "R" + selectedProjarr[5] + "\n");
            buffer3.write("Amount paid to date: " + "R" + selectedProjarr[6] + "\n");
            buffer3.write("Due date: " + selectedProjarr[7] + "\n");
            //Creating date format to get the current date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            buffer3.write("Date completed: " + dtf.format(now) + "\n");
            //Writing Contractor information
            buffer3.write("Contractor name: " + selectedProjarr[8] + "\n");
            buffer3.write("Contractor tel number: " + selectedProjarr[9] + "\n");
            buffer3.write("Contractor email: " + selectedProjarr[10] + "\n");
            buffer3.write("Contractor address: " + selectedProjarr[11] + "\n");
            //Writing Customer information
            buffer3.write("Customer name: " + selectedProjarr[12] + " " + selectedProjarr[13] + "\n");
            buffer3.write("Customer tel number: " + selectedProjarr[14] + "\n");
            buffer3.write("Customer email: " + selectedProjarr[15] + "\n");
            buffer3.write("Customer address: " + selectedProjarr[16] + "\n");
            //Writing Architect information
            buffer3.write("Architect name: " + selectedProjarr[17] + "\n");
            buffer3.write("Architect tel numbert: " + selectedProjarr[18] + "\n");
            buffer3.write("Architect email: " + selectedProjarr[19] + "\n");
            buffer3.write("Architect address: " + selectedProjarr[20] + "\n");
            buffer3.close();
            break;
        }
    }
}
/*Reference fot the current date method https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java/5175900*/