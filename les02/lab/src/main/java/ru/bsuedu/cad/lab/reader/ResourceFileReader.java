package ru.bsuedu.cad.lab.reader;

import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResourceFileReader implements Reader {

    private static final String FILE_PATH = "products.csv";

    @Override
    public List<String[]> readData() {
        List<String[]> lines = new ArrayList<>();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_PATH)) {
            if (inputStream == null) {
                throw new RuntimeException("Файл не найден: " + FILE_PATH);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) {
                        continue;
                    }
                    lines.add(line.split(","));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка чтения CSV файла: " + e.getMessage(), e);
        }

        return lines;
    }
}