import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        int currentAmount = cash.getOrDefault(type, 0);
        int toRemove = Math.min(currentAmount, num);
        cash.put(type, currentAmount - toRemove);
        return toRemove * type.amt();
    }

    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        cash.forEach((denom, count) -> sb.append(denom.name()).append(": ").append(count).append("\n"));
        return sb.toString();
    }
}
