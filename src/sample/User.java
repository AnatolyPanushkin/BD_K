package sample;

public class User {
    private String login;
    private String password;
    private String status;

    public User(String login,String password,String status){
        this.login=login;
        this.password=password;
        this.status=status;
    }

    public User() {}


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
