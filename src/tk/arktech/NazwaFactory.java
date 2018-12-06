package tk.arktech;

import java.util.HashMap;

public class NazwaFactory {
    protected HashMap<String, Nazwa> nazwy = null;

    public void ls()
    {
        ls("");
    }

    public void ls(String prompt)
    {
        if(nazwy!=null)
        {
            nazwy.forEach((k,v) -> {
                System.out.println(prompt + k);
                v.ls(prompt + "    ");
            });
        }
        else
        {
            System.out.println(prompt + "null");
        }
    }

    protected final void hashMapMustExist()
    {
        if (nazwy == null)
        {
            nazwy = new HashMap<>();
        }
    }

    public final boolean exists(String nazwa)
    {
        nazwa = nazwa.toLowerCase();
        if(nazwy!=null) {
            return nazwy.containsKey(nazwa);
        }
        else
        {
            return false;
        }
    }
    public final Nazwa getNazwa(String nazwa) throws Exception {
        hashMapMustExist();
        nazwa = nazwa.toLowerCase();
        if(!nazwa.matches("[\\p{L}]*")) throw new Exception("Niepoprawna nazwa");
        if(exists(nazwa))
        {
            return nazwy.get(nazwa);
        }
        else
        {
            Nazwa n = new Nazwa(nazwa);
            nazwy.put(nazwa, n);
            return n;
        }
    }



}
