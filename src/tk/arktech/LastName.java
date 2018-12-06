package tk.arktech;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LastName {

    private String lastname;
    private Set<Number> number = new HashSet<Number>();

    public LastName(String lastname, Number phonenumber) throws Exception {
        if(!lastname.matches("[\\p{L}]*")) throw new Exception("Niepoprawna nazwa");
        this.lastname = lastname.toLowerCase();
        this.number.add(phonenumber);
    }

    public boolean numberExists(Number number)
    {
        return this.number.contains(number);
    }

    public void addNumber(Number number)
    {
        this.number.add(number);
    }

    public Set<Number> getNumbers() {
        return number;
    }
}
