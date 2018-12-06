package com.other;

import tk.arktech.Number;

import java.util.Set;

public class Main {

    public static void main(String[] args) {



        View v = new View();

        try {

            v.addPhoneNumber("Marcin Janusz Janowski", "791280966");
            Set<Number> nmb = v.getPhoneNumberSet("Marcin Janusz Janowski");
            nmb.forEach((n) -> System.out.println(n.getNumber()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("hello");
    }


}
