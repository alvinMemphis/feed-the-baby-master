package com.example.alvin.feedthebaby;

public class Diet {

    String age;
    String food;
    String quantity;

    public Diet(String age, String food, String quantity) {
        this.age = age;
        this.food = food;
        this.quantity = quantity;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
