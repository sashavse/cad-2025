package ru.bsuedu.cad.lab.renderer;

import org.springframework.stereotype.Component;
import ru.bsuedu.cad.lab.model.Product;
import java.util.List;

@Component
public class ConsoleTableRenderer implements Renderer {

    private static final String BORDER = "+-----+----------------------+----------------------+------------+----------+";
    private static final String HEADER = "|  ID |        Name          |       Category       |   Price    | Quantity |";

    @Override
    public void render(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Нет товаров для отображения.");
            return;
        }

        printTable(products);
    }

    private void printTable(List<Product> products) {
        System.out.println("\n" + BORDER);
        System.out.println(HEADER);
        System.out.println(BORDER);

        for (Product product : products) {
            System.out.printf("| %-3s | %-20s | %-20s | %8.2f  | %6d   |\n",
                    truncate(product.getId(), 3),
                    truncate(product.getName(), 20),
                    truncate(product.getCategory(), 20),
                    product.getPrice(),
                    product.getQuantity());
        }

        System.out.println(BORDER);
        System.out.printf("Всего товаров: %d\n\n", products.size());
    }

    private String truncate(String str, int length) {
        if (str == null) return "";
        if (str.length() <= length) return str;
        return str.substring(0, length - 3) + "...";
    }
}