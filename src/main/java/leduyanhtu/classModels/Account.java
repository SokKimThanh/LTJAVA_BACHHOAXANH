/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classModels;

/**
 *
 * @author Imac
 */
public class Account {
    //Fields
    private String UserName;
    private String Password;

    //Contructors
    public Account() {
    }
    public Account(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    //Getters & Setters
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    //Methods
    
}
