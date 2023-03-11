import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> sales = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию: \n 1. Добавить товар в список\n 2. Показать список покупок\n 3. Удалить товар из списка\n 4. Найти товар в списке");
            String action = scanner.next();

            switch (action) {
                case "1": {
                    System.out.println("Какой товар хотите добавить?");
                    sales.add(scanner.next());
                    break;
                }
                case "2": {
                    shoppingList(sales);
                    break;
                }
                case "3": {
                    shoppingList(sales);
                    System.out.println("Укажите товар, который хотите удалить (номер или название): ");
                    String nameOrNumber = scanner.next();
                    try {
                        int index = Integer.parseInt(nameOrNumber) - 1;
                        sales.remove(index);
                    } catch (Exception e) {
                        sales.remove(nameOrNumber);
                    }
                    shoppingList(sales);
                    break;
                }
                case "4": {
                    findProduct(scanner, sales);
                    break;
                }
                default: {
                    System.out.println("Неизвестная команда.");
                }
            }
        }
    }

    private static void shoppingList(List<String> sales) {
        System.out.println("Список покупок:");
        for (int i = 0; i < sales.size(); i++) {
            int count = i + 1;
            System.out.println(count + ". " + sales.get(i));
        }
    }

    private static void findProduct(Scanner scanner, ArrayList<String> sales) {
        System.out.println("Введите текст для поиска: ");
        String product = scanner.next();
        try {
            String products = null;
            System.out.println("Найдено: " + products + ". " + sales.get(Integer.parseInt(product) - 1));
        } catch (NumberFormatException e) {
            String smallLetter;
            String textLow = product.toLowerCase();
            for (int i = 0; i < sales.size(); i++) {
                smallLetter = sales.get(i).toLowerCase();
                if (smallLetter.contains(textLow)) {
                    System.out.println((sales.indexOf(sales.get(i)) + 1) + ". " + sales.get(i));
                }
            }
        }
    }
}

