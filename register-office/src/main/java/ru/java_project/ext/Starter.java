package ru.java_project.ext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.java_project.ext.rest.MarriageController;
import ru.java_project.ext.view.MarriageRequest;

import java.time.LocalDate;

public class Starter {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[]{"src/main/webapp/WEB-INF/classes/springContext.xml"}
//        );

//        MarriageController controller = context.getBean(MarriageController.class);
//        MarriageRequest request = new MarriageRequest();
//        request.setHusbandSurname("Иванов");
//        request.setHusbandGivenname("Иван");
//        request.setHusbandPatronymic("Иванович");
//        request.setHusbandDateOfBirth(LocalDate.of(1997, 3, 9)); //1997-03-09
//
//        request.setWifeSurname("Иванова");
//        request.setWifeGivenname("Анна");
//        request.setWifePatronymic("Ивановна");
//        request.setWifeDateOfBirth(LocalDate.of(1998, 2, 28));//1998-02-28

        //controller.findMarriageCertificate(request);
    }
}
