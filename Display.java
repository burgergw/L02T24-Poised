import java.io.*;
import java.util.*;
import java.text.*;
import java.time.*;

public class Display {
    //Method to view all projects. This method reads the file and creates objects
    public static void viewProjects() throws ParseException, FileNotFoundException {

        File inFile = new File("output.txt");
        Scanner sc = new Scanner(inFile);
        String lines = "";
        while (sc.hasNext()) {
            lines += sc.nextLine();
        }
        sc.close();

        String[] lineArr = lines.split("#");
        //System.out.println(lineArr[1]);
        for (int i = 0; i < lineArr.length; i++) {
            String[] projectInfo = lineArr[i].split(", ");

            //Project
            String projectName = projectInfo[0];
            int projectNumber = Integer.valueOf(projectInfo[1]);
            String buildType = projectInfo[2];
            String address = projectInfo[3];
            int erfNum = Integer.valueOf(projectInfo[4]);
            int fee = Integer.valueOf(projectInfo[5]);
            int paidTodate = Integer.valueOf(projectInfo[6]);
            SimpleDateFormat dateFor = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            Date dueDate = dateFor.parse(projectInfo[7]);

            //Contractor
            String conName = projectInfo[8];
            String conTelNum = projectInfo[9];
            String conEmail = projectInfo[10];
            String conAddress = projectInfo[11];

            //Customer
            String cusFirstName = projectInfo[12];
            String cusSurName = projectInfo[13];
            String cusTelNum = projectInfo[14];
            String cusEmail = projectInfo[15];
            String cusAddress = projectInfo[16];

            //Architect
            String arcName = projectInfo[17];
            String arcTelNum = projectInfo[18];
            String arcEmail = projectInfo[19];
            String arcAddress = projectInfo[20];

            Project newPro = new Project(projectNumber, projectName, buildType, address, erfNum, fee, paidTodate, dueDate);
            System.out.println(newPro);

            Contractor newCon = new Contractor(conName, conTelNum, conEmail, conAddress);
            System.out.println(newCon);

            Customer newCus = new Customer(cusFirstName, cusSurName, cusTelNum, cusEmail, cusAddress);
            System.out.println(newCus);

            Architect newArc = new Architect(arcName, arcTelNum, arcEmail, arcAddress);
            System.out.println(newArc + "===================================\n");
        }
    }
    //Method to display completed projects
    public static void seeunCompleted() throws FileNotFoundException {
        //Creating scanner object and reading the file
        File inFile = new File("output.txt");
        Scanner sc = new Scanner(inFile);
        //Empty string to append the lines of the file to with a while loop
        String lines = "";
        while (sc.hasNext()) {
            lines += sc.nextLine();
        }
        //Creating array by splitting the string by "#" which will be written in when a project is added
        String[] lineArr = lines.split("#");
        //For loop to split array by ", "
        for (int i = 0; i < lineArr.length; i++) {
            String[] projectInfo = lineArr[i].split(", ");
            //If the last index of the line is "not finalise" the project will be printed
            if (projectInfo[21].equals("finalised")) {
                System.out.println("Project name: " + projectInfo[0]);
                System.out.println("Project number: " + projectInfo[1]);
                System.out.println("Build type: " + projectInfo[2]);
                System.out.println("Address: " + projectInfo[3]);
                System.out.println("ERF number: " + projectInfo[4]);
                System.out.println("Fee: " + projectInfo[5]);
                System.out.println("Paid to date: " + projectInfo[6]);
                System.out.println("Due date: " + projectInfo[7] + "\n\n=========================\n");
            }
        }
        sc.close();
    }
    //Method to display overdue projects
    public static void seeOverdue() throws FileNotFoundException, ParseException {
        //Creating scanner object and reading the file
        File inFile = new File("output.txt");
        Scanner sc = new Scanner(inFile);
        //Empty string to append the lines of the file to with a while loop
        String lines = "";
        while (sc.hasNext()) {
            lines += sc.nextLine();
        }
        //Creating array by splitting the string by "#" which will be written in when a project is added
        String[] lineArr = lines.split("#");
        //For loop to split array by ", "
        for (int i = 0; i < lineArr.length; i++) {
            String[] projectInfo = lineArr[i].split(", ");
            //Reading date from the text file and creating date object to get current date
            SimpleDateFormat dateFor = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            Date dueDate = dateFor.parse(projectInfo[7]);
            Date today = new Date();
            //If the current date is passed the due date, the project wll be printed
            if (today.compareTo(dueDate) > 0){
                System.out.println("Project name: " + projectInfo[0]);
                System.out.println("Project number: " + projectInfo[1]);
                System.out.println("Building type: " + projectInfo[2]);
                System.out.println("Address: " + projectInfo[3]);
                System.out.println("ERF number: " + projectInfo[4]);
                System.out.println("Paid to date: " + projectInfo[5]);
                System.out.println("Due date: " + projectInfo[6] + "\n");
            }
        }
    }
}
/*References for date methods: https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java/5175900
                               https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java/5175900*/





