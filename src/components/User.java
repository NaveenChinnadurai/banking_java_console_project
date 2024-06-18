package components;

import java.util.HashSet;

import static utils.encrypt.encryptPassword;

public class User {

    private final int id, accountNo;
    private int balance;
    private final String encryptedPassword;
    private final String userName;
    private final HashSet<Giftcard> giftCards = new HashSet<>();

    public User(String name, String password, Bank bk) {
        this.userName = name;
        this.id = bk.getLastUserInfo()[0] + 1;
        this.accountNo = bk.getLastUserInfo()[1] + 11;
        bk.addNewUser(this.id, this.accountNo);
        this.encryptedPassword = encryptPassword(password);
        this.balance = 7000;
    }

    public void createGiftcard(int amount, User user) {
        Giftcard newGiftCard = new Giftcard(1, "gift@143", user);
    }

    public void redeemGiftCard(Giftcard giftCard, String password, User user) {
        giftCard.redeemTo(password, user);
    }

    public int[] getAccountDetails() {
        return new int[]{id, accountNo, balance};
    }

    public int getBalance() {
        return balance;
    }

    public String withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return "Amount Withdrawn!!";
        } else {
            return "Insufficient balance..";
        }
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public HashSet<Giftcard> getGiftCards() {
        return giftCards;
    }

    public int getId() {
        return id;
    }
}
