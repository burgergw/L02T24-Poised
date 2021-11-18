//Creating the class and assigning attributes
public class Contractor {
    String conName;
    String conTelNum;
    String conEmail;
    String conAddress;
    //Initialising the method of the class
    public Contractor(String con_name, String con_tel_num, String con_e_mail, String con_address) {
        this.conName = con_name;
        this.conTelNum = con_tel_num;
        this.conEmail = con_e_mail;
        this.conAddress = con_address;
    }
    //toString method to print the data out correctly when the method gets called
    public String toString() {
        String output = "Contractor name: " + conName + "\n";
        output += "Contractor tel number: " + conTelNum + "\n";
        output += "Contractor e-mail: " + conEmail + "\n";
        output += "Contractor address: " + conAddress + "\n";
        return output;
    }
}