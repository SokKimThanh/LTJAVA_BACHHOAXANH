package model;

/**
 *
 * @author Kieu Oanh date 29/05/2023
 */
public class Account {

    //fields
    private String accountId; // ma so account

    Account() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    private User user;// username la email
    private String password;// nhap mat khau
    private String repassword; // nhap lai mat 

    // test thử nghiệm main
    public Account(User user, String password, String repassword) {
        this.user = user;
        this.password = password;
        this.repassword = repassword;
    }

    public void setRepassword(String repassword) throws RepasswordException {
        if (this.password.compareTo(repassword) == 0) {
            this.repassword = repassword;
        } else {
            throw new RepasswordException();
        }
    }

    //khau constructors
    public Account(User user, String password) {
        this.user = user;
        this.password = password;
    }

    //properties
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordException {
        if (password.length() < 8) {
            throw new PasswordException();
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "user=" + user.toString() + ", password=" + password + '}';
    }

}
