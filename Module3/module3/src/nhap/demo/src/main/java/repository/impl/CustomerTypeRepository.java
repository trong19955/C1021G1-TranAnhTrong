package repository.impl;

import model.CustomerType;
import repository.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static String SELECT_ALL_CUSTOMER_TYPE = "SELECT * FROM customer_type";
    @Override
    public List<CustomerType> findAll() {
        Connection connection = DBConnection.getConnection();
        List<CustomerType> customerList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idCustomerType = resultSet.getInt("customer_type_id");
                    String nameCustomerType = resultSet.getString("customer_type_name");
                    customerList.add(new CustomerType(idCustomerType, nameCustomerType));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return customerList;
    }
}
