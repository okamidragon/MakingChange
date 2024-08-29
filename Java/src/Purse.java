import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        cash.merge(type, num, Integer::sum);
    }

    public double remove(Denomination type, int num) {
        int current = cash.getOrDefault(type, 0);
        int toRemove = Math.min(num, current);
        cash.put(type, current - toRemove);
        return type.amt() * toRemove;
    }

    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(e -> e.getKey().amt() * e.getValue())
                .sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getKey().name())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }

    // Getter for cash
    public Map<Denomination, Integer> getCash() {
        return cash;
    }
}
