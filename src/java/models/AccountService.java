
package models;
import models.User;

/**
 *
 * @author Sharon
 */
public class AccountService {
    //User user = new User();
    public User login(String username, String password){
       if (password.equals("password") && username.equals("abe") || username.equals("barb")){
           User user = new User(username,password);
           user.setPassword(null);
           return user;
       } else {
           return null;
       }
    
    
}
}
