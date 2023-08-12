package Banking_Sysyem;

import java.util.HashMap;
import java.util.Map;



public class Bank {
    private final Map<Integer, User> users;
    public int accno=1002;


    public Bank() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getAccountNumber(), user);
    }

    public User getUserByAccountNumber(int accountNumber) {
        return users.get(accountNumber);
    }

    public void updateUser(User user) {
        users.put(user.getAccountNumber(), user);
    }


    public int getNextAccountNumber() {
        return accno+=1;
    }
}
