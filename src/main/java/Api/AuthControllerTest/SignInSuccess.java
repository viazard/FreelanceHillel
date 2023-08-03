package Api.AuthControllerTest;

import java.io.Serializable;

public class SignInSuccess implements Serializable {
    private boolean success;
    private String token;
    private String message;

    public SignInSuccess(){

    }

    public SignInSuccess(boolean success, String token, String message) {
        this.success = success;
        this.token = token;
        this.message = message;
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
    public String getMessage(){
        return message;
    }
    public void setMessage(){
        this.message = message;
    }
}
