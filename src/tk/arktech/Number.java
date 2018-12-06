package tk.arktech;

public class Number {
    private String number;

    public Number(String number) throws Exception {
        if(!number.matches("\\d{9}")) throw new Exception("Numer telefonu został podany w niepoprawnym formacie");
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
