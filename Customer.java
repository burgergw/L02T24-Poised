//Creating the class and assigning attributes
public class Customer {
    String cusFirstName;
    String cusSurName;
    String cusTelNum;
    String cusEmail;
    String cusAddress;
    //Initialising the method of the class
    public Customer(String cus_name, String cusSurName, String cus_tel_num, String cus_e_mail, String cus_address) {
        this.cusFirstName = cus_name;
        this.cusSurName = cusSurName;
        this.cusTelNum = cus_tel_num;
        this.cusEmail = cus_e_mail;
        this.cusAddress = cus_address;
    }
    //toString method to print the data out correctly when the method gets called
    public String toString() {
        String output = "Customer name: " + cusFirstName + " " + cusSurName + "\n";
        output += "Customer tel number: " + cusTelNum + "\n";
        output += "Customer e-mail: " + cusEmail + "\n";
        output += "Customer Address: " + cusAddress + "\n";
        return output;
    }
}
























