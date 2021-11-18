//Importing scanner utility to get user input
/*For the refactoring of task 21 I added 2 try/catch blocks, in the projQuestions method and in my main.
  I formatted */
import java.io.*;
import java.text.*;
import java.util.*;
//Initialising method to prompt the user for all the date that is required by the program
//If the method gets called in the main, the questions will be printed in the terminal
public class Info {
    public static void projQuestions() throws ParseException {
        //Creating scanner object
        Scanner sc = new Scanner(System.in);
        //This section prompts the user fot the details of the project and stores the values to variables
            //Project details
            System.out.println("Enter project name: ");
            String projectName = sc.next();

            System.out.println("Enter project number (10 numbers or less): ");
            int projectNumber = sc.nextInt();

            System.out.println("Enter building type: ");
            String buildType = sc.next();

            System.out.println("Enter address: ");
            String address = sc.next();

            System.out.println("Enter ERF number: ");
            int erfNumber = sc.nextInt();

            System.out.println("Enter fee: ");
            int fee = sc.nextInt();

            System.out.println("Enter amount paid to date: ");
            int paidTodate = sc.nextInt();

            System.out.println("Enter due date(dd/MM/yyyy): ");
            String date1 = sc.next();

            String patt = "dd/MM/yyyy";
            SimpleDateFormat datefor = new SimpleDateFormat(patt);
            Date dueDate = datefor.parse(date1);

            //Contractor
            //This section prompts the user for the details of the contractor and stores the values to variables
            System.out.println("Enter contractor name: ");
            String conName = sc.next();
            System.out.println("Enter contractor tel number: ");
            String conTelNum = sc.next();
            System.out.println("Enter contractor email: ");
            String conEmail = sc.next();
            System.out.println("Enter contractor address: ");
            String conAddress = sc.next();

            //Customer
            //This section prompts the user for the details of the customer and stores the values to variables
            System.out.println("Enter customer first  name: ");
            String cusFirstName = sc.next();
            System.out.println("Enter customer surname: ");
            String cusSurName = sc.next();
            System.out.println("Enter customer tel number: ");
            String cusTelNum = sc.next();
            System.out.println("Enter customer email: ");
            String cusEmail = sc.next();
            System.out.println("Enter customer address: ");
            String cusAddress = sc.next();
            //Architect
            //This section prompts the user for the details of the architect and stores the values to variables
            System.out.println("Enter architect name: ");
            String arcName = sc.next();
            System.out.println("Enter architect tel number: ");
            String arcTelNum = sc.next();
            System.out.println("Enter architect email: ");
            String arcEmail = sc.next();
            System.out.println("Enter architect address: ");
            String arcAddress = sc.next();
            //toString methods to print the information out
            //Project
            Project new_proj = new Project(projectNumber, projectName, buildType, address, erfNumber, fee, paidTodate, dueDate);
            System.out.print("\nNew project: \n" + new_proj.toString());
            //Contractor
            Contractor new_con = new Contractor(conName, conTelNum, conEmail, conAddress);
            System.out.println("\nNew contractor: \n" + new_con.toString());
            //Customer
            Customer new_cus = new Customer(cusFirstName, cusSurName, cusTelNum, cusEmail, cusAddress);
            System.out.println("New customer: \n" + new_cus.toString());
            //Architect
            Architect new_arc = new Architect(arcName, arcTelNum, arcEmail, arcAddress);
            System.out.println("New architect: \n" + new_arc.toString());
            //Writing net project to file
            try {
                FileWriter f = new FileWriter("output.txt", true);
            f.write(projectName + ", " + projectNumber + ", " + buildType + ", " + address + ", " + erfNumber + ", " + fee + ", " + paidTodate + ", " + dueDate + ", " + conName +
                    ", " + conTelNum + ", " + conEmail + ", " + conAddress + ", " + cusFirstName + ", " + cusSurName + ", " + cusTelNum + ", " + cusEmail + ", " + cusAddress + ", " + arcName +
                    ", " + arcTelNum + ", " + arcEmail + ", " + arcAddress + ", " + "not finalised" + "#");
            System.out.println("New project has been written to the file");
            f.close();
        }
        //catch block added
        catch (Exception e){
            System.out.println("Something went wrong");
        }
    }
}
//With this task I have received help from Wesley and Nizaam
// I also referred back to my previous task to remind myself of the correct syntax


