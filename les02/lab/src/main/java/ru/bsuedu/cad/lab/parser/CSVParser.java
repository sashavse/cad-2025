package ru.bsuedu.cad.lab.parser;

import org.springframework.stereotype.Component;
import ru.bsuedu.cad.lab.model.Product;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVParser implements Parser<Product> {

    @Override
    public List<Product> parse(List<String[]> rawData) {
        List<Product> products = new ArrayList<>();

        int startIndex = 0;
        if (!rawData.isEmpty()) {
            String firstCell = rawData.get(0)[0].toLowerCase();
            if (firstCell.equals("id") || firstCell.equals("id")) {
                startIndex = 1;
            }
        }

        for (int i = startIndex; i < rawData.size(); i++) {
            String[] row = rawData.get(i);
            if (row.length >= 5) {
                try {
                    Product product = new Product();
                    product.setId(row[0].trim());
                    product.setName(row[1].trim());
                    product.setCategory(row[2].trim());
                    product.setPrice(Double.parseDouble(row[3].trim()));
                    product.setQuantity(Integer.parseInt(row[4].trim()));
                    products.add(product);
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка парсинга " + i + ": " + e.getMessage());
                }
            }
        }

        return products;
    }
}