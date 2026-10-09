package ru.bsuedu.cad.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bsuedu.cad.lab.config.AppConfig;
import ru.bsuedu.cad.lab.provider.ProductProvider;
import ru.bsuedu.cad.lab.renderer.Renderer;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Renderer renderer = ctx.getBean(Renderer.class);

        // Отоброжаем и получаем провайдер с товарами
        ProductProvider provider = ctx.getBean(ProductProvider.class);
        renderer.render(provider.getProducts());
    }
}