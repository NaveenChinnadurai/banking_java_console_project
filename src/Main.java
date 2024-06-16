import java.util.Scanner;

public class Main {
    static Bank newBank = new Bank();
    static Scanner newIn=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zween Banking");
        while (true) {
            System.out.println("1-Create Bank Account \n2-Add Amount \n3.Withdraw Amount \n4-Get Account details \n5-Add Gift card \n6-Redeem Gift Card");
            int action = newIn.nextInt();
            newIn.nextLine();
            switch (action) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    addAmount();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    getAccountDetails();
                    break;
                case 5:
                    addGiftCard();
                    break;
                case 6:
                    redeemGiftCard();
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    }

    static void createNewAccount() {
        System.out.println("Let's Create Account\nEnter Account Holders Name:");
        String name = newIn.nextLine();
        System.out.print("Enter Password:");
        String password = newIn.nextLine();
        User user1 = new User(name, password, newBank);
        newBank.setUser(user1);
        System.out.println("Account Created Successfully!");
    }

    static void addAmount() {
        System.out.println("Enter User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Enter amount to add:");
        int amount = newIn.nextInt();
        user.setBalance(user.getBalance() + amount);
        System.out.println("Amount added successfully! Current balance: " + user.getBalance());
    }
    static void withdraw() {
        System.out.println("Enter User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Enter amount to withdraw:");
        int amount = newIn.nextInt();
        System.out.println("Enter Password:");
        String pass = newIn.nextLine();
        if(!utils.encrypt.encryptPassword(pass).equals(user.getEncryptedPassword())){
            System.out.println("Unauthorized Action, Inavlid Password!!");
            return ;
        }
        String result = user.withdraw(amount);
        System.out.println(result);
    }

    static void getAccountDetails() {
        System.out.println("Enter User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        int[] details = user.getAccountDetails();
        System.out.println("User ID: " + details[0]);
        System.out.println("Account Number: " + details[1]);
        System.out.println("Balance: " + details[2]);
    }

    public static void addGiftCard() {
        System.out.println("Enter User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Enter gift card amount:");
        int amount = newIn.nextInt();
        Giftcard giftCard = new Giftcard(user.getGiftCards().size() + 1, "gift@143", user);
        giftCard.setAmount(amount);
        user.getGiftCards().add(giftCard);
        System.out.println("Gift card added successfully!");
    }

    static void redeemGiftCard() {
        System.out.println("Enter User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Enter gift card ID:");
        int giftCardId = newIn.nextInt();
        Giftcard giftCard = null;
        for (Giftcard gc : user.getGiftCards()) {
            if (gc.getGiftCardId() == giftCardId) {
                giftCard = gc;
                break;
            }
        }
        if (giftCard == null) {
            System.out.println("Gift card not found.");
            return;
        }
        System.out.println("Enter gift card password:");
        String password = newIn.next();
        String result = giftCard.redeemTo(password, user);
        System.out.println(result);
    }
}