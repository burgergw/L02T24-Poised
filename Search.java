//Importing java packages
import java.io.*;
import java.text.*;
import java.util.*;
//Method to search for a project by entering project number
public class Search {
    public static void search() throws IOException, ParseException {
        //Opening the file and creating scanner object
        File inFile = new File("output.txt");
        Scanner sc = new Scanner(inFile);
        //Creating empty string to append the line of the file to
        String lines ="";
        //While loop to append the lines of the file to the empty string
        while (sc.hasNext()){
            lines += sc.nextLine();
        }
        //Prompting the user to enter project number and storring it to a variable
        System.out.println("Enter project number: ");
        Scanner sc2 = new Scanner(System.in);
       String projNumsearch = sc2.next();
        //Splitting the projects by "#" which will be written into the text file when projects are added
        String[] lineArr = lines.split("#");
        //For loop to iterate through the array and split by ", ". When it gets to an index where the project number matches the entered number, the project will be printed
        for (int i = 0; i < lineArr.length; i++) {
            String[] projectInfo = lineArr[i].split(", ");
            if (projNumsearch.equals(projectInfo[1])) {
                System.out.println("Project name: " + projectInfo[0]);
                System.out.println("Project number: " + projectInfo[1]);
                System.out.println("Build type: " + projectInfo[2]);
                System.out.println("Address: " + projectInfo[3]);
                System.out.println("ERF number: " + projectInfo[4]);
                System.out.println("Fee: " + projectInfo[5]);
                System.out.println("Paid to date: " + projectInfo[6]);
                System.out.println("Due date: " + projectInfo[7] + "\n");
                System.out.println("Contractor name: " + projectInfo[8]);
                System.out.println("Contractor tel number: " + projectInfo[9]);
                System.out.println("Contractor email: " + projectInfo[10]);
                System.out.println("Contractor address: " + projectInfo[11] + "\n");
                System.out.println("Customer name: " + projectInfo[12] + " " + projectInfo[13]);
                System.out.println("Customer tel number: " + projectInfo[14]);
                System.out.println("Customer email: " + projectInfo[15]);
                System.out.println("Customer address: " + projectInfo[16] + "\n");
                System.out.println("Architect name: " + projectInfo[17]);
                System.out.println("Architect tel number: " + projectInfo[18]);
                System.out.println("Architect email: " + projectInfo[19]);
                System.out.println("Architect address: " + projectInfo[20]);
            }
        }
        sc.close();
    }
}
        /*References for this method:
        https://stackoverflow.com/questions/9005284/replace-certain-string-in-array-of-strings
        Replace line: https://www.tutorialspoint.com/how-to-overwrite-a-line-in-a-txt-file-using-java*/




