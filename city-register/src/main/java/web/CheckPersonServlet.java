package web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.java_project.ext.dao.PersonCheckDao;
import ru.java_project.ext.dao.PoolConnectionBuilder;
import ru.java_project.ext.domain.PersonRequest;
import ru.java_project.ext.domain.PersonResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);

    private PersonCheckDao dao;

    @Override
    public void init() throws ServletException {
        logger.info("Servlet is created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        PersonRequest request = new PersonRequest();
        request.setSurName(req.getParameter("surname"));
        request.setGivenName(req.getParameter("givenname"));
        request.setPatronymic(req.getParameter("patronymic"));
        LocalDate date = LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        request.setDateOfBirth(date);
        request.setDistrictCode(Integer.parseInt(req.getParameter("districtCode")));
        request.setStreetCode(Integer.parseInt(req.getParameter("streetCode")));
        request.setBuilding(req.getParameter("building"));
        request.setExtension(req.getParameter("extension"));
        request.setApartment(req.getParameter("apartment"));
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
