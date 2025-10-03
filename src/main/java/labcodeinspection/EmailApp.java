package labcodeinspection;

import java.util.Scanner;
import java.util.logging.Logger;

public class EmailApp {

    private static final Logger LOG = Logger.getLogger(EmailApp.class.getName());

    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            LOG.info("Enter your first name: ");
            String firstName = sc.nextLine();

            LOG.info("Enter your last name: ");
            String lastName = sc.nextLine();

            LOG.info("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");
           
            int depChoice = Integer.parseInt(sc.nextLine());

            Email email = new Email(firstName, lastName);
            email.setDepartment(depChoice);    
            email.generateEmail();

            
            LOG.info(email.showInfo());
        }
    }
}
