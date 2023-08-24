package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();


    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {

        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs =st.executeQuery("SELECT DeliveryEmployeeId, Name, Salary, BankAccountNumber, NINumber FROM DeliveryEmployee;");

        List<DeliveryEmployee> deliveryEmployeeList = new ArrayList<>();

        while (rs.next()) {
            DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                    rs.getInt("DeliveryEmployeeId"),
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NINumber")
            );
            deliveryEmployeeList.add(deliveryEmployee);
        }


        return deliveryEmployeeList;


    }

    public DeliveryEmployee getDeliveryEmployeeById(int id) throws SQLException {
        Connection c =databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT DeliveryEmployeeId, Name, Salary, BankAccountNumber, NINumber" + " From DeliveryEmployee where DeliveryEmployeeId = " + id);

        while (rs.next()) {
            return  new DeliveryEmployee (
                    rs.getInt("DeliveryEmployeeId"),
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NINumber")
            );
        }
        return null;
    }


    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO DeliveryEmployee (Name, Salary, BankAccountNumber, NINumber) VALUES (?, ?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, deliveryEmployee.getName());
        st.setDouble(2, deliveryEmployee.getSalary());
        st.setString(3, deliveryEmployee.getBankAcc());
        st.setString(4, deliveryEmployee.getNiNumber());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void updateDeliveryEmployee(int id, DeliveryEmployeeRequest deliveryEmployee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE DeliveryEmployee SET Name = ?, Salary = ?, BankAccountNumber = ?, NINumber = ? WHERE DeliveryEmployeeId = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, deliveryEmployee.getName());
        st.setDouble(2, deliveryEmployee.getSalary());
        st.setString(3, deliveryEmployee.getBankAcc());
        st.setString(4, deliveryEmployee.getNiNumber());
        st.setInt(5, id);

        st.executeUpdate();



    }
    public void deleteDeliveryEmployee(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String deleteStatement = "DELETE FROM DeliveryEmployee WHERE DeliveryEmployeeId = ?";

        PreparedStatement st = c.prepareStatement(deleteStatement);

        st.setInt(1, id);

        st.executeUpdate();

    }

}