import java.util.ArrayList;
import java.util.HashSet;

public class Bank {

    private HashSet<Integer> userId = new HashSet<>();
    private HashSet<Integer> accountNo = new HashSet<>();

    private HashSet<User> users = new HashSet<>();

    private HashSet<Integer> giftCards = new HashSet<>();


    Bank() {
        userId.add(1);
        accountNo.add(11011);
    }

    HashSet<Integer> getUserId() {
        return userId;
    }

    HashSet<Integer> getAccountNumbers() {
        return accountNo;
    }

    void setUser(User user) {
        this.users.add(user);
    }


    void addNewUser(int id, int accNo) {
        userId.add(id);
        accountNo.add(accNo);
    }

    int[] getLastUserInfo() {
        return new int[]{new ArrayList<>(userId).getLast(), new ArrayList<>(accountNo).getLast()};
    }

    User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
