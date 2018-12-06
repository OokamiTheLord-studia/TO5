package com.other;

import tk.arktech.Nazwa;
import tk.arktech.NazwaFactory;
import tk.arktech.Number;

import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class View {

    private NazwaFactory factory = new NazwaFactory();


    public Set<Number> getPhoneNumberSet(String name)
    {

        //TODO: Zrobić implementację
        return null;
    }

    public void addPhoneNumber(String name, String number) throws Exception
    {
        Scanner sc = new Scanner(name);

        Nazwa n = null;
        Number nmb = new Number(number);

        if(new StringTokenizer(name, " ").countTokens() < 2) throw new Exception("Nie można mieć mniej niż dwuczłonową nazwę");

        String s = sc.next();
        n = factory.getNazwa(s);
        s = sc.next();
        while (sc.hasNext())
        {
            n = n.getNazwa(s);
            s = sc.next();
        }

        n.addLastName(s, nmb);
    }



}
