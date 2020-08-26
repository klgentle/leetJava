package com.klgentle.pojo;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;

    public User(int aId, String aName, String aPwd) {
        id = aId;
        name = aName;
        pwd = aPwd;
    }
}
