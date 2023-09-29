import Factory.Accounting;
import Factory.FactoryInfo;
import Factory.Management;
import Storage.IceCream;
import Storage.Storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppBuild {
    /** Тут відбувається побудова всієї програми по виробництву морозива
     *  Виводиться інформація про холодокомбінат та можливість керувати підприємством.
     * */

    public void start() {
        Accounting accounting = new Accounting();
        Management management = new Management(accounting);
        Scanner scanner = new Scanner(System.in);
        FactoryInfo factoryInfo = new FactoryInfo();
        Storage storage = new Storage();

        Map<String, Double> iceCreamPrices = new HashMap<>();
        iceCreamPrices.put("Ванільне", 2.5);
        iceCreamPrices.put("Шоколадне", 3.0);
        iceCreamPrices.put("Полуничне", 3.5);
        iceCreamPrices.put("Карамельне", 3.2);
        iceCreamPrices.put("М'ятне", 3.8);
        storage.setIceCreamPrices(iceCreamPrices);

        System.out.println("           * Вітаємо Вас на підприємстві! *\n");
        factoryInfo.about();

        boolean isProgramActive = true;
        while (isProgramActive) {
            System.out.println("—————————————┝ Оберіть подальшу дію: ┥—————————————");
            System.out.println("1. Виписка з бухгалтерії;");
            System.out.println("2. Інформація про товар на складі;");
            System.out.println("3. Приготувати партію морозива;");
            System.out.println("4. Продати партію морозива;");
            System.out.println("5. Вийти з підприємства.");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    accounting.info();
                    break;
                case 2:
                    management.displayStock();
                    break;
                case 3:
                    System.out.println("Виберіть вид морозива:");

                    Map<String, Double> iceCreams = new HashMap<>();
                    iceCreams.put("Ванільне", 2.5);
                    iceCreams.put("Шоколадне", 3.0);
                    iceCreams.put("Полуничне", 3.5);
                    iceCreams.put("Карамельне", 3.2);
                    iceCreams.put("М'ятне", 3.8);

                    int i = 1;

                    for (Map.Entry<String, Double> entry : iceCreams.entrySet()) {
                        System.out.println(i + ". " + entry.getKey() +
                                " - " + entry.getValue() + " грн");
                        i++;
                    }

                    int iceCreamChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (iceCreamChoice >= 1 && iceCreamChoice <= iceCreams.size()) {
                        String selectedIceCream = (String) iceCreams.keySet().toArray()[iceCreamChoice - 1];
                        System.out.println("Введіть кількість одиниць морозива:");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        double price = iceCreams.get(selectedIceCream);
                        IceCream iceCream = new IceCream(selectedIceCream, price);
                        management.prepareIceCream(iceCream, quantity);
                    } else {
                        System.out.println("❌ | Неправильна команда.");
                    }
                    break;
                case 4:
                    System.out.println("Виберіть вид морозива:");

                    int j = 1;

                    Map<String, Double> iceCreamsToSell = new HashMap<>();
                    for (Map.Entry<String, Double> entry : iceCreamPrices.entrySet()) {
                        System.out.printf("%d. %s - %.2f грн.\n", j, entry.getKey(), entry.getValue()*3);
                        iceCreamsToSell.put(entry.getKey(), entry.getValue() * 3);
                        j++;
                    }
                    int sellChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (sellChoice >= 1 && sellChoice <= iceCreamsToSell.size()) {
                        String selectedIceCream = (String) iceCreamsToSell.keySet().toArray()[sellChoice - 1];
                        System.out.println("Введіть кількість одиниць морозива:");
                        int sellQuantity = scanner.nextInt();
                        scanner.nextLine();
                        double price = iceCreamsToSell.get(selectedIceCream);
                        IceCream sellIceCream = new IceCream(selectedIceCream, price);
                        management.sellIceCream(sellIceCream, sellQuantity);
                    } else {
                        System.out.println("❌ | Неправильна команда.");
                    }
                    break;
                case 5:
                    System.out.println("Ви вийшли з підприєства!");
                    isProgramActive = false;
                    break;
                default:
                    System.out.println("❌ | Неправильна команда.");
                    break;
            }
        }
    }
}