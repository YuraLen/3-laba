package Factory;

public class Accounting {
    /** Цей клас імітує бухгалтерію.
     *  Тут можна дізнатись дані про затрати, надходження та бюджет підприємства */

    private double amountOfMoneyInCash = 100000;
    private double amountOfExpenses;
    private double amountOfIncome;

    public String info() {
        System.out.println("⎯―――――――  Виписка з бухгалтерії ⎯――――――");
        System.out.printf("Бюджет підприємства: %.2f₴.\n", getAmountOfMoneyInCash());
        System.out.printf("Сума витрат підприємства: %.2f₴.\n", getAmountOfExpenses());
        System.out.printf("Сума надходжень підприємства: %.2f₴.\n", getAmountOfIncome());
        System.out.println("――――――――――――――――――――――――――――――\n");
        return null;
    }

    public double getAmountOfMoneyInCash() {
        return amountOfMoneyInCash;
    }

    public void setAmountOfMoneyInCash(double budget) {
        this.amountOfMoneyInCash = budget;
    }

    public double getAmountOfExpenses() {
        return amountOfExpenses;
    }

    public void setAmountOfExpenses(double amountOfExpenses) {
        this.amountOfExpenses = amountOfExpenses;
    }

    public double getAmountOfIncome() {
        return amountOfIncome;
    }

    public void setAmountOfIncome(double amountOfIncome) {
        this.amountOfIncome = amountOfIncome;
    }
}