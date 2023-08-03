package Api.AuthControllerTest;

public class UserSignUp {
    private String username;
    private String password;
    private String confirmPassword;
    private String message;

    public UserSignUp(){

    }

    public UserSignUp(String username, String password, String confirmPassword, String message) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.message = message;

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

    public String getConfirmPassword() {

        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {

        this.confirmPassword = confirmPassword;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
