package Storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    /** Цей клас імітує склад підприємства, де зберігається продукція
     *  Тут продукція вноситься в список, виноситься та відображається весь товар в наясності.
     *  */

    private final Map<String, Integer> stock; // Мапа для зберігання морозива на складі
    private Map<String, Double> iceCreamPrices; // Мапа для зберігання цін на морозиво

    public Storage() {
        stock = new HashMap<>();
        iceCreamPrices = new HashMap<>();
    }

    public void addIceCream(String iceCreamName, int quantity) {
        stock.put(iceCreamName, stock.getOrDefault(iceCreamName, 0) + quantity);
    }

    public void removeIceCream(String iceCreamName, int quantity) {
        int currentQuantity = stock.getOrDefault(iceCreamName, 0);

        if (currentQuantity >= quantity) {
            stock.put(iceCreamName, currentQuantity - quantity);
        } else {
            System.out.println("На складі недостатньо морозива " + iceCreamName);
        }
    }

    public void displayStock() {
        if (stock.isEmpty()) {
            System.out.println("Склад пустий.");
        } else {
            System.out.println("Морозиво на складі:");
            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                String iceCreamName = entry.getKey();
                int quantity = entry.getValue();

                System.out.println(iceCreamName + ": " + quantity + " шт.");
            }
        }
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public void setIceCreamPrices(Map<String, Double> prices) {
        iceCreamPrices = prices;
    }
}