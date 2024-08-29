import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        int currentAmount = cash.getOrDefault(type, 0);
        int amountToRemove = Math.min(num, currentAmount);
        cash.put(type, currentAmount - amountToRemove);
        return amountToRemove * type.amt();
    }

    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Purse contains:\n");
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getKey().name())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
