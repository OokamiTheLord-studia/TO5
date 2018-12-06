package com.other;

import tk.arktech.LastName;
import tk.arktech.Nazwa;
import tk.arktech.NazwaFactory;
import tk.arktech.Number;

import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;


public class View {

    private NazwaFactory factory = new NazwaFactory();


    public Set<Number> getPhoneNumberSet(String name) throws Exception {
        if(!name.matches("[\\p{L}\\s]*")) throw new Exception("nazwa zawiera niewłaściwe znaki");

        Scanner sc = new Scanner(name);

        Nazwa n = null;
//        Number nmb = new Number(number);

        if(new StringTokenizer(name, " ").countTokens() < 2) throw new Exception("Nie można mieć mniej niż dwuczłonową nazwę");

        String s = sc.next();
        if(factory.exists(s)) {
            n = factory.getNazwa(s);
            s = sc.next();
            while (sc.hasNext() && n.exists(s)) {
                n = n.getNazwa(s);
                s = sc.next();
            }
            if (!sc.hasNext()) {
//                s = sc.next();

                if (n.lastNameExists(s)) {
                    return n.getLastName(s).getNumbers();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        else
        {
            return null;
        }

    }

    public void addPhoneNumber(String name, String number) throws Exception
    {
        if(!name.matches("[\\p{L}\\s]*")) throw new Exception("nazwa zawiera niewłaściwe znaki");
        if(!number.matches("\\d{9}")) throw new Exception("Numer telefonu został podany w niepoprawnym formacie");
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
