package Api.AuthControllerTest;

public class UserSignIn {
   private String username;
   private String password;
   private boolean success;
   private String token;

   public UserSignIn(){

   }

   public UserSignIn(String username, String password, boolean success, String token) {
      this.username = username;
      this.password = password;
      this.success = success;
      this.token = token;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isSuccess() {
      return success;
   }

   public void setSuccess(boolean success) {
      this.success = success;
   }

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }
}
