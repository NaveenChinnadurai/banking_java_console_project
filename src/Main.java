import components.Bank;
import components.User;

import java.util.Scanner;

import static bankData.data.newBank;
import static modules.bankOfficer.officer;
import static modules.user.userModule;
import static utils.input.newIn;

public class Main {
    static Bank newBank = new Bank();

    public static void main(String[] args) {
        System.out.println("Zween Banking");
        do {
            System.out.println("1.Officer Login \n2.Customer Login \n3.Create Account");
            int choice =newIn.nextInt();
            switch (choice){
                case 1:
                    officer();
                    break;
                case 2:
                    userModule();
                    break;
                case 3:
                    createNewAccount();
                    break;
                case 4:
                    return ;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }

        }while(true);
    }

    static void createNewAccount() {
        System.out.println("Let's Create Account\nEnter Account Holders Name:");
        newIn.hasNextLine();
        String name = newIn.nextLine();
        System.out.print("Enter Password:");
        String password = newIn.nextLine();
        User user1 = new User(name, password, newBank);
        newBank.setUser(user1);
        System.out.println("Account Created Successfully!");
    }
}