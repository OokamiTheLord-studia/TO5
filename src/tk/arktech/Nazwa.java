package tk.arktech;

import java.util.HashMap;

public class Nazwa extends NazwaFactory {
    protected String name;
    private HashMap<String, LastName> nazwiska = null;

    protected void nazwiskaMustExist()
    {
        if (nazwiska == null)
        {
            nazwiska = new HashMap<>();
        }
    }

    public boolean lastNameExists(String lastname)
    {
        if(nazwiska!=null)
        {
            return nazwiska.containsKey(lastname);
        }
        else
        {
            return false;
        }
    }

    public Nazwa(String name) {
        this.name = name;
    }

    public LastName getLastName(String lastname) throws Exception
    {
        nazwiskaMustExist();
        if(lastNameExists(lastname))
        {
            return nazwiska.get(lastname);
        }
        else
        {
            throw new Exception("Podane nazwisko nie istnieje");
        }
    }

    public void addLastName(String lastname, Number number)
    {
        nazwiskaMustExist();
        if(lastNameExists(lastname))
        {
            nazwiska.get(lastname).addNumber(number);
        }
        else
        {
            nazwiska.put(lastname, new LastName(lastname, number));
        }

    }



}
