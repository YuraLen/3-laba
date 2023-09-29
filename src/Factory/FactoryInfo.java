package Factory;

public class FactoryInfo {
    /** Цей клас містить інформацію про холодокомбінат */

    private final String name = "Лімо";
    private final String addreess = "вулиця Повітряна, 2, Львів";
    private final int phoneNumber = 322673466;
    private final String email = "office@limo.ua";

    public String about() {
        System.out.println(" ⎯―――――――――  Про холодокомбінат ⎯――――――――");
        System.out.printf("│ Компанія виробник: %s                         │\n", name);
        System.out.printf("│ Адреса виробництва: %s  │\n", addreess);
        System.out.printf("│ Номер телефону: %d                       │\n", phoneNumber);
        System.out.printf("│ Електронна пошта: %s                │\n", email);
        System.out.println(" ――――――――――――――――――――――――――――――――\n");
        return null;
    }
}