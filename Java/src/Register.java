import java.util.ArrayList;
import java.util.List;

public class Register {
    private final List<Denomination> denominations = new ArrayList<>();

    public Register() {
        denominations.add(new Denomination("Hundred Note", 100.0, "bill", "C:/Users/drago/IdeaProjects/Java/src/images/hundred.jpg"));
        denominations.add(new Denomination("Fifty Note", 50.0, "bill", "C:/Users/drago/IdeaProjects/Java/src/images/fifty.jpg"));
        denominations.add(new Denomination("Twenty Note", 20.0, "bill", "C:/Users/drago/IdeaProjects/Java/src/images/twenty.jpg"));
        denominations.add(new Denomination("Ten Note", 10.0, "bill", "C:/Users/drago/IdeaProjects/Java/src/images/ten.jpg"));
        denominations.add(new Denomination("Five Note", 5.0, "bill", "C:/Users/drago/IdeaProjects/Java/src/images/five.jpg"));
        denominations.add(new Denomination("One Note", 1.0, "bill", "one.jpg"));
        denominations.add(new Denomination("Quarter", 0.25, "coin", "C:/Users/drago/IdeaProjects/Java/src/images/quarter.jpg"));
        denominations.add(new Denomination("Dime", 0.10, "coin", "C:/Users/drago/IdeaProjects/Java/src/images/dime.jpg"));
        denominations.add(new Denomination("Nickel", 0.05, "coin", "C:/Users/drago/IdeaProjects/Java/src/images/nickel.jpg"));
        denominations.add(new Denomination("Penny", 0.01, "coin", "C:/Users/drago/IdeaProjects/Java/src/images/penny.jpg"));
    }

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        if (amt <= 0) return purse;

        for (Denomination denom : denominations) {
            while (amt >= denom.amt()) {
                purse.add(denom, 1);
                amt -= denom.amt();
                amt = Math.round(amt * 100.0) / 100.0; // Avoid floating-point precision issues
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Purse change = register.makeChange(69.89);
        System.out.println(change);
    }
}
