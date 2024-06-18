package components;

import java.util.Objects;

public class Giftcard {

    private final User ownership;
    private final int giftCardId;
    private final String PASSWORD;
    private int balance;

    public Giftcard(int giftCardId, String password, User user) {
        this.ownership = user;
        this.giftCardId = giftCardId;
        this.PASSWORD = password;
    }

    String[] getGiftCardDetails() {
        return new String[]{String.valueOf(getGiftCardId()), String.valueOf(balance), String.valueOf(ownership.getAccountDetails()[0])};
    }

    public int getGiftCardId() {
        return giftCardId;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String redeemTo(String password, User toUser) {
        if (Objects.equals(this.PASSWORD, password)) {
            toUser.setBalance(toUser.getBalance() + this.getBalance());
            setBalance(0);
            return "Redeem Successfull!!Enjoy";
        } else {
            return "Invalid Cridentials,Try again";
        }
    }

    public String setAmount(int amount) {
        if (ownership.getBalance() >= amount) {
            balance = amount;
            ownership.setBalance(ownership.getBalance() - amount);
            return "Gift Card Recharged!!";
        } else {
            return "Insufficient Balance in account";
        }
    }
}
