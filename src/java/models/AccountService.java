
package models;

/**
 *
 * @author Sharon
 */
public class AccountService {
        private String username;
        private String password = "password";
       
        
    public class User {
    }
    
    public AccountService(){
        
    }
    
    public String getUsername(){
        return username;
    }
   
    
    public void setUsername(String username){
        this.username = username;
    }
     
     
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public User login(String username, String pasword){
       if (password.equals("password") && username.equals("abe") || username.equals("barb")){
           AccountService user = new User(username,password);
           user.setPassword(null);
           return user;
       } else {
           return null;
       }
    
    
}
}
