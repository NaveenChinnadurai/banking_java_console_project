package modules;

import components.Giftcard;
import components.User;

import static bankData.data.newBank;
import static utils.input.newIn;

public class user {
    public static void userModule() {
        while (true) {
            System.out.println(
                    "1-Add Amount \n" +
                    "2.Withdraw Amount \n" +
                    "3-Get Account details \n" +
                    "4-Add Gift card \n" +
                    "5-Redeem Gift Card \n" +
                    "6-Exit"
            );
            int action = newIn.nextInt();
            newIn.nextLine();
            switch (action) {
                case 1:
                    addAmount();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    getAccountDetails();
                    break;
                case 4:
                    addGiftCard();
                    break;
                case 5:
                    redeemGiftCard();
                    break;
                case 6:
                    return ;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    }

    static void addAmount() {
        System.out.println("Enter components.User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("components.User not found.");
            return;
        }
        System.out.println("Enter amount to add:");
        int amount = newIn.nextInt();
        user.setBalance(user.getBalance() + amount);
        System.out.println("Amount added successfully! Current balance: " + user.getBalance());
    }
    static void withdraw() {
        System.out.println("Enter components.User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("components.User not found.");
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
        System.out.println("Enter components.User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("components.User not found.");
            return;
        }
        int[] details = user.getAccountDetails();
        System.out.println("components.User ID: " + details[0]);
        System.out.println("Account Number: " + details[1]);
        System.out.println("Balance: " + details[2]);
    }

    public static void addGiftCard() {
        System.out.println("Enter components.User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("components.User not found.");
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
        System.out.println("Enter components.User ID:");
        int userId = newIn.nextInt();
        User user = newBank.findUserById(userId);
        if (user == null) {
            System.out.println("components.User not found.");
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
