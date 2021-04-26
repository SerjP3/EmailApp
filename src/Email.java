import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);
        //Cal a method asking for department
        this.department = setDepartment();
        System.out.println("Department is: " + this.department);

        //Cal a method to return a password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }

    //Ask for department
    private String setDepartment() {
        System.out.println("Depatment code: \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none" + "\n" + "Enter the department: ");
        Scanner sc = new Scanner(System.in);
        int departmentChoice = sc.nextInt();
        if (departmentChoice == 1) {
            return "sales";
        } else if (departmentChoice == 2) {
            return "development";
        } else if (departmentChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUVXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName + "\nCompany name: " + "\nDepartment: " + department + "\nEmail: " + email + "\nMail box capacity: " + mailBoxCapacity + "mb";
    }
}
