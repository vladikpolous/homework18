package ua.com.alevel.user;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    String email;
    String phone;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    User(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    User(String name ){
        this.name = name;

    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
