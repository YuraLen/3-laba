package Factory;

import Storage.Storage;
import Storage.IceCream;

public class Management {
    /** У цьому класі присутні методи для керуванням підприємством.
     *  Тут можна дізнатись про бюджет та відомості по складу.
     *  Можливість виготовити та продати партію певної продукції.
     *  */

    private Accounting accounting; // Об'єкт обліку бюджету
    private Storage storage; // Об'єкт складу для зберігання морозива

    public Management(Accounting accounting) {
        this.accounting = accounting;
        storage = new Storage();
    }

    public void displayStock() {
        storage.displayStock();
    }

    public void prepareIceCream(IceCream iceCream, int quantity) {
        // Перевірка наявності коштів
        double cost = iceCream.getPrice() * quantity;
        if (accounting.getAmountOfMoneyInCash() >= cost) {
            System.out.println("Приготування " + quantity + " одиниць морозива " + iceCream.getName() + "...");
            try {
                for (int progress = 0; progress <= 10; progress++) {
                    Thread.sleep(1000);
                    System.out.print("\rПриготування: " + progress * 10 + "%");
                    System.out.flush();
                }
                storage.addIceCream(iceCream.getName(), quantity);
                accounting.setAmountOfExpenses(accounting.getAmountOfExpenses() + cost);
                accounting.setAmountOfMoneyInCash(accounting.getAmountOfMoneyInCash() - cost);
                System.out.println("\nМорозиво " + iceCream.getName() + " готове!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ | Недостатньо коштів для приготування морозива " + iceCream.getName());
        }
    }

    public void sellIceCream(IceCream iceCream, int quantity) {
        // Перевірка наявності морозива на складі
        if (storage.getStock().getOrDefault(iceCream.getName(), 0) >= quantity) {
            double revenue = quantity * iceCream.getPrice();
            storage.removeIceCream(iceCream.getName(), quantity);
            accounting.setAmountOfIncome(accounting.getAmountOfIncome() + revenue);
            accounting.setAmountOfMoneyInCash(accounting.getAmountOfMoneyInCash() + revenue);
            System.out.printf("Продано %d одиниць морозива %s. Виручка: %.2f₴.\n",
                    quantity, iceCream.getName(), revenue);
        } else {
            System.out.println("❌ | На складі недостатньо морозива " + iceCream.getName());
        }
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}