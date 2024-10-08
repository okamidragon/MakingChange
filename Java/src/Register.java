/* Maddock Davis
Lab 1 - Making Change
Takes an amount of money from the user and shows how man coins or bills makes it. */
import java.util.ArrayList;
import java.util.List;

// Main class for the Register
public class Register {

    // Fills in the Denomination record
    private static final List<Denomination> denominations = List.of(
            new Denomination("Hundred Note", 100.0, "bill", "Images/hundred.jpg"),
            new Denomination("Fifty Dollar Note", 50.0, "bill", "Images/fifty.jpg"),
            new Denomination("Twenty Dollar Note", 20.0, "bill", "Images/twenty.jpg"),
            new Denomination("Ten Dollar Note", 10.0, "bill", "Images/ten.jpg"),
            new Denomination("Five Dollar Note", 5.0, "bill", "Images/five.jpg"),
            new Denomination("One Dollar Note", 1.0, "bill", "Images/one.jpg"),
            new Denomination("Quarter", 0.25, "coin", "Images/quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "Images/dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "Images/nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "Images/penny.jpg")
    );

    // Calculates the money in the purse
    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        for (Denomination denoms : denominations) {
            if (amt >= denoms.amt()) {
                int count = (int) (amt / denoms.amt());
                purse.add(denoms, count);
                amt -= denoms.amt() * count;
                if (amt < 0.0001) break;
            }
        }
        return purse;
    }
}
