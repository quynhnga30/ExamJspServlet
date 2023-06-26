package controller;

import entity.Employee;
import model.EmployeeRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/add")
public class AddEmployeeController extends HttpServlet {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("employeeadd.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String birth = req.getParameter("birth");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        Date birthday = Date.valueOf(birth);
        employeeRepository.save(new Employee(0, name, birthday, address, position, department));
        resp.sendRedirect("/employees");
    }
}
