package ui.services;

import ui.component.User;
import java.util.Properties;

public class UserService {
    PropertiesService prop = new PropertiesService();
    Properties p;
    User user = new User();

    public User setUserData(){
        p = prop.getProperties();
        user.setName(p.get("user.name").toString());
        user.setPassword(p.get("user.password").toString());
        return user;
    }

}
