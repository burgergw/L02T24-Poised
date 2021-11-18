//Importing scanner utility to get input from user
import java.io.*;
import java.text.*;
import java.util.*;
public class Task_7_main {
    public static void main(String[] args) throws ParseException, IOException {
        try {
            Scanner sc = new Scanner(System.in);

            /*Displaying the main menu and calling the appropriate method*/

            System.out.println("Select an option from the menu: \n");
            System.out.println("1 ~  Add new project\n2 ~ View projects\n3 ~ Search project\n4 ~ Edit project\n5 ~ Finalise\n6 ~ See completed\n7 ~ See Overdue tasks\n0 ~ Exit");
            String menu_op = sc.next();

            if (menu_op.equals("1")) {
                Info.projQuestions();
            }
            else if (menu_op.equals("2")){
                Display.viewProjects();
            }
            else if (menu_op.equals("3")){
                Search.search();
            }
            else if (menu_op.equals("4")){
                Edit.editTask();
            }
            else if (menu_op.equals("5")){
                Finalizing.finalise();
            }
            else if (menu_op.equals("6")){
                Display.seeunCompleted();
            }
            else if (menu_op.equals("7")){
                Display.seeOverdue();
            }
            else if(menu_op.equals("0")){
                System.out.println("Program has ended");
            }
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
