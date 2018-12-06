package com.other;

public class Main {

    public static void main(String[] args) {



        View v = new View();

        try {

            //TODO: Dodać lowercase na wszystko
            //TODO: Dodać validatory
            v.addPhoneNumber("Marcin Janusz Janowski", "567890");
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("hello");
    }


}
