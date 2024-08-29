import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Register {
    private static final List<Denomination> DENOMINATIONS = Arrays.asList(
            new Denomination("Hundred Note", 100.0, "bill", "hundred.jpg"),
            new Denomination("Fifty Note", 50.0, "bill", "fifty.jpg"),
            new Denomination("Twenty Note", 20.0, "bill", "twenty.jpg"),
            new Denomination("Ten Note", 10.0, "bill", "ten.jpg"),
            new Denomination("Five Note", 5.0, "bill", "five.jpg"),
            new Denomination("One Note", 1.0, "bill", "one.jpg"),
            new Denomination("Quarter", 0.25, "coin", "quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "penny.jpg")
    );

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        for (Denomination denom : DENOMINATIONS) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
                if (amt < 0.01) break; // Avoid floating point issues
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Purse change = register.makeChange(137.57);
        System.out.println(change);
    }
}
