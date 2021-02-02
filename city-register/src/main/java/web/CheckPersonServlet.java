package web;

import ru.java_project.ext.dao.PersonCheckDao;
import ru.java_project.ext.domain.PersonRequest;
import ru.java_project.ext.domain.PersonResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {

    private PersonCheckDao dao;

    @Override
    public void init() throws ServletException {
        dao = new PersonCheckDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String surname = req.getParameter("surname");
        PersonRequest request = new PersonRequest();
        request.setSurName(surname);
        request.setGivenName("Иван");
        request.setPatronymic("Иванович");
        request.setDateOfBirth(LocalDate.of(1993, 2, 28));
        request.setDistrictCode(1);
        request.setStreetCode(1);
        request.setBuilding("10");
        request.setExtension("2");
        request.setApartment("121");
        try {
            PersonResponse response = dao.checkPerson(request);
            if(response.isRegistered()) {
                resp.getWriter().println("Registered");
            } else {
                resp.getWriter().println("Not registered");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
