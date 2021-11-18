//Creating the class and assigning attributes
public class Architect {
    String arcName;
    String arcTelNum;
    String arcEmail;
    String arcAddress;
    //Initialising the method of the class
    public Architect(String arc_name, String arc_tel_num, String arc_e_mail, String arc_address){
        this.arcName = arc_name;
        this.arcTelNum = arc_tel_num;
        this.arcEmail = arc_e_mail;
        this.arcAddress = arc_address;
    }
    //toString method to print the data out correctly when the method gets called
    public String toString(){
        String output = "Architect name: " + arcName + "\n";
        output += "Architect tel number: " + arcTelNum + "\n";
        output += "Archicect e-mail: " +  arcEmail + "\n";
        output += "Architect address: " + arcAddress + "\n";
        return output;
    }
}
