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

    public boolean lastNameExists(String lastname)/* throws Exception */{
        lastname = lastname.toLowerCase();
//        if(!lastname.matches("[\\p{L}]*")) throw new Exception("Niepoprawna nazwa");
        if(nazwiska!=null)
        {
            return nazwiska.containsKey(lastname);
        }
        else
        {
            return false;
        }
    }

    public Nazwa(String name) throws Exception {

        if(!name.matches("[\\p{L}]*")) throw new Exception("Niepoprawna nazwa");
        this.name = name.toLowerCase();

    }

    public LastName getLastName(String lastname) throws Exception
    {
        nazwiskaMustExist();
        lastname = lastname.toLowerCase();
        if(lastNameExists(lastname))
        {
            return nazwiska.get(lastname);
        }
        else
        {
            throw new Exception("Podane nazwisko nie istnieje");
        }
    }

    public void addLastName(String lastname, Number number) throws Exception {
        nazwiskaMustExist();
        lastname = lastname.toLowerCase();
        if(!lastname.matches("[\\p{L}]*")) throw new Exception("Niepoprawna nazwa");
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
