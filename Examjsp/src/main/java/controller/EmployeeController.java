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
import java.util.List;
@WebServlet(value = "/employees")
public class EmployeeController extends HttpServlet {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeRepository.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("employeelist.jsp");
        req.setAttribute("employees", employees );
        dispatcher.forward(req, resp);
    }
}
