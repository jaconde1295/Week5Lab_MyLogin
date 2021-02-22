/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 631503
 */
public class AccountService {

    public User login(String username, String password) {
        User user = new User(username, null);
        
        if (username.equals("abe") && password.equals("password")) {
            return user;
        } 
        else if (username.equals("barb") && password.equals("password")) {
            return user;
        } 
        else {
            return null;
        }
    }
}
