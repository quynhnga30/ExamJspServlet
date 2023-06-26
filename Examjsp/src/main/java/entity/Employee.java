package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@ToString
public class Employee {
    private int employeeID;
    private String name;
    private Date birth;
    private String address;
    private String position;
    private String department;

}
