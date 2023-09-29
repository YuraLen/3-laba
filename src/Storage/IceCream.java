package Storage;

public class IceCream {
    /** Цей клас створений для того, щоб можна було працювати з продукцією.
     *  Можна задати назву та ціну
     * */

    private String name; // Назва морозива
    private double price; // Ціна за одну одиницю морозива

    public IceCream(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}