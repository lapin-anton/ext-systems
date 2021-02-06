package ru.java_project.ext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.java_project.ext.rest.MarriageController;
import ru.java_project.ext.view.MarriageRequest;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"springContext.xml"}
        );

        MarriageController controller = context.getBean(MarriageController.class);
        controller.findMarriageCertificate(new MarriageRequest());
    }
}
