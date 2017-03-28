package com.db.javaschool.springdata.jdbc.dao;


import com.db.javaschool.springdata.domain.Employee;
import com.db.javaschool.springdata.jdbc.domain.EmployeeJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcEmployeeDao implements EmployeeDAO{

    @Autowired
    private DataSource dataSource;
    
    public void insert(EmployeeJdbc employee) {
        String sql = "INSERT INTO employee (firstname, lastname) VALUES(?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public EmployeeJdbc findByFirstName(String firstName) {
        String sql = "SELECT * FROM EMPLOYEE WHERE FIRSTNAME = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            EmployeeJdbc employee = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new EmployeeJdbc();
                employee.setId(rs.getLong("ID"));
                employee.setFirstName(rs.getString("FIRSTNAME"));
                employee.setLastName(rs.getString("LASTNAME"));
            }
            rs.close();
            ps.close();
            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }


}
