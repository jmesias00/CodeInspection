package labcodeinspection;

import java.util.logging.Logger;


public class Email {

    private static final Logger LOG = Logger.getLogger(Email.class.getName());

    private String firstName;                  
    private String lastName;                   
    private String password;                   
    private String department;                 
    private static final int DEFAULT_PASSWORD_LENGTH = 8;  
    private String email;

 
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    public String showInfo() {
        String info = "FIRST NAME= " + firstName + " | LAST NAME= " + lastName
                    + " | DEPARTMENT= " + department + " | EMAIL= " + email
                    + " | PASSWORD= " + password;
        LOG.info(info);
        return info;
    }

 
    public void setDepartment(int depChoice) {
        switch (depChoice) {
            case 1: this.department = "sales"; break;
            case 2: this.department = "dev";   break;
            case 3: this.department = "acct";  break;
            default: this.department = "";
        }
    }

    
    private String randomPassword(int length) {
        final String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
        final char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * charset.length());
            chars[i] = charset.charAt(rand);
        }
        return new String(chars);
    }

   
    public void generateEmail() {
        this.password = randomPassword(DEFAULT_PASSWORD_LENGTH);
        this.email = this.firstName.toLowerCase()
                   + this.lastName.toLowerCase()
                   + "@" + this.department + ".espol.edu.ec";
    }
}
