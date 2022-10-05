
package models;

/**
 *
 * @author Sharon
 */
public class AccountService {
     
    public User login(String username, String password){
       if (password.equals("password") && username.equals("abe") || username.equals("barb")){
           return new User(username,null);
       } else {
           return null;
       }
    
    
}
}
