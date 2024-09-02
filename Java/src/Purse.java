import java.util.HashMap;
import java.util.Map;

// Main class for the Purse
public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    // Gets the money in the purse
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    // Adds money to the purse
    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    // Removes money from the purse
    public double remove(Denomination type, int num) {
        int currentAmount = cash.getOrDefault(type, 0);
        int toRemove = Math.min(currentAmount, num);
        cash.put(type, currentAmount - toRemove);
        return toRemove * type.amt();
    }

    // Gets the value of the cash
    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    // Creates the amount of each coin as a string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cash.forEach((denom, count) -> sb.append(denom.name()).append(": ").append(count).append("\n"));
        return sb.toString();
    }
}
