package com.example.alvin.feedthebaby;

/**
 * Created by okker on 8/20/2017.
 */

public class Baby {
    String name,ID;
    String age;

    public Baby(){}

    public Baby(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
}
