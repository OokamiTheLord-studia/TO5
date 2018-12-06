package tk.arktech;

import java.util.HashMap;

public class NazwaFactory {
    private HashMap<String, Nazwa> nazwy = null;

    protected final void hashMapMustExist()
    {
        if (nazwy == null)
        {
            nazwy = new HashMap<>();
        }
    }

    public final boolean exists(String nazwa)
    {
        if(nazwy!=null) {
            return nazwy.containsKey(nazwa);
        }
        else
        {
            return false;
        }
    }
    public final Nazwa getNazwa(String nazwa)
    {
        hashMapMustExist();
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
