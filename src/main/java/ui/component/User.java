package ui.component;

public class User {
    private String name;
    private String password;

    public User(){

    }

    public String setName(String name){
        return this.name = name;
    }

    public String setPassword(String password){
        return this.password=password;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }
}
