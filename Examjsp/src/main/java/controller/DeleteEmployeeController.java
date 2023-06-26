package controller;

import model.EmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete")
public class DeleteEmployeeController extends HttpServlet {

    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeID = Integer.parseInt(req.getParameter("employeeID"));
        employeeRepository.delete(employeeID);
        resp.sendRedirect("/employees");
    }
}

