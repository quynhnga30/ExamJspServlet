package model;

import entity.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends dbconnect {
    private final String SELECT_ALL = "SELECT * FROM employee;";
    private final String INSERT_EMPLOYEE = "INSERT INTO employee(name,birth,address,position,derpartment) value (?,?,?,?,?);";
    private final String SELECT_BY_ID = "SELECT * FROM employee where employeeID = ?;";
    private final String UPDATE_EMPLOYEE = "UPDATE employee SET name=?,birth=?,address=?,position=?,derpartment=? where employeeID=?;";
    private final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employeeID = ?;";


    public List<Employee> findAll(){
        List<Employee> list = new ArrayList<Employee>();
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement =  connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int employeeId = rs.getInt("employeeID");
                String name = rs.getString("name");
                Date birth = rs.getDate("birth");
                String address = rs.getString("address");
                String position = rs.getString("position");
                String department = rs.getString("derpartment");

                list.add( new Employee(employeeId, name, birth, address,position,department));
            }
            rs.close();
            return list;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void save(Employee employee){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDate(2,employee.getBirth());
            preparedStatement.setString(3,employee.getAddress());
            preparedStatement.setString(4,employee.getPosition());
            preparedStatement.setString(5,employee.getDepartment());

            preparedStatement.executeUpdate();
        }catch (Exception  e){
            e.printStackTrace();
        }

   }

    public Employee findOne(int id) {
        Employee employee = null;
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement =  connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int employeeID = rs.getInt("employeeID");
                String name = rs.getString("name");
                Date birth = rs.getDate("birth");
                String address = rs.getString("address");
                String position = rs.getString("position");
                String department = rs.getString("derpartment");

                employee = new Employee(employeeID, name, birth, address,position,department);
            }
            rs.close();
            return employee;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void update(Employee employee){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDate(2,employee.getBirth());
            preparedStatement.setString(3,employee.getAddress());
            preparedStatement.setString(4,employee.getPosition());
            preparedStatement.setString(5,employee.getDepartment());
            preparedStatement.setInt(6,employee.getEmployeeID());
            preparedStatement.executeUpdate();

        }catch (Exception  e){
            e.printStackTrace();

        }

    }
    public void delete(int employeeId) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1,employeeId);

            preparedStatement.executeUpdate();
        }catch (Exception  e){
            e.printStackTrace();
        }
    }


}
