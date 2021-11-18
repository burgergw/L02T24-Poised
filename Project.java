import java.util.Date;
//Creating the class and assigning attributes
public class Project {
    int projectNumber;
    String projectName;
    String buildType;
    String address;
    int erfNum;
    int fee;
    int paidTodate;
    Date dueDate;
    //Initialising the method of the class
    public Project(int project_number, String project_name, String build_type, String address, int erf_num, int fee, int paidTodate, Date dueDate){
        this.projectNumber = project_number;
        this.projectName = project_name;
        this.buildType = build_type;
        this.address = address;
        this.erfNum = erf_num;
        this.fee = fee;
        this.paidTodate = paidTodate;
        this.dueDate = dueDate;
    }
    //toString method to print the data out correctly when the method gets called
    public String toString(){
        String output = "Project number: " + projectNumber + "\n";
        output += "Project name: " + projectName + "\n";
        output += "Building type: " + buildType + "\n";
        output += "Address: " + address + "\n";
        output += "ERF number: " + erfNum + "\n";
        output += "Project fee: " + fee + "\n";
        output += "Paid to date: " + paidTodate + "\n";
        output += "Due date: " + dueDate + "\n";
        return output;
    }
}
