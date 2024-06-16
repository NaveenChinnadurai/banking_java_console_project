import java.util.HashSet;
import utils.encrypt;
public class User {

    private final int id, accountNo;
    private int balance;
    private final String encryptedPassword;
    private final String userName;
    private final HashSet<Giftcard> giftCards = new HashSet<>();

    User(String name, String password, Bank bk) {
        this.userName = name;
        this.id = bk.getLastUserInfo()[0] + 1;
        this.accountNo = bk.getLastUserInfo()[1] + 11;
        bk.addNewUser(this.id, this.accountNo);
        this.encryptedPassword = encrypt.encryptPassword(password);
        this.balance = 7000;
    }

    void createGiftcard(int amount, User user) {
        Giftcard newGiftCard = new Giftcard(1, "gift@143", user);
    }

    void redeemGiftCard(Giftcard giftCard, String password, User user) {
        giftCard.redeemTo(password, user);
    }

    int[] getAccountDetails() {
        return new int[]{id, accountNo, balance};
    }

    int getBalance() {
        return balance;
    }

    String withdraw(int amount) {
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

    void setBalance(int balance) {
        this.balance = balance;
    }

    HashSet<Giftcard> getGiftcard() {
        return giftCards;
    }

    public HashSet<Giftcard> getGiftCards() {
        return giftCards;
    }



    int getId() {
        return id;
    }
}
