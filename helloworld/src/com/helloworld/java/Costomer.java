package com.helloworld.java;

class Costomer {

    String name;
    int age;
    boolean isMale;

    public void eat() {
        System.out.println("he is eating");
    }

    public void sleep(int hour) {
        System.out.println("sleep " + hour + " hours");
        System.out.println(getNation("china"));
    }

    public String getName() {
        return name;
    }

    public String getNation(String nation) {
        return "I am from " + nation;
    }
}