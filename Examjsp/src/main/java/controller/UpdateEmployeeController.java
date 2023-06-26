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


@WebServlet("/edit")
public class UpdateEmployeeController extends HttpServlet {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("employeeUpdate.jsp");
        int employeeID = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeRepository.findOne(employeeID);
        req.setAttribute("employee", employee);
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int EmployeeID = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String birth = req.getParameter("birth");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        Date birthday = Date.valueOf(birth);
        employeeRepository.update(new Employee(EmployeeID, name, birthday, address,position,department ));
        resp.sendRedirect("/employees");
    }
}
