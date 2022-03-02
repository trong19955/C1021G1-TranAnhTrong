package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static String SELECT_ALL_CUSTOMER = "SELECT* FROM customer \n" +
            "JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id;";
    private static String INSERT_CUSTOMER = " INSERT INTO `demo5`.`customer` (`customer_code`,`customer_type_id`,`customer_name`,`customer_birthday`,`customer_gender`,`customer_id_card`,`customer_phone`,`customer_email`,`customer_address`) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static String DELETE_CUSTOMER = "delete from customer where customer_id = ?";

    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Customer> customerList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idCustomer = resultSet.getInt("customer_id");
                    String codeCustomer = resultSet.getString("customer_code");
                    String nameCustomer = resultSet.getString("customer_name");
                    String birthdayCustomer = resultSet.getString("customer_birthday");
                    String genderCustomer = resultSet.getString("customer_gender");
                    String idCardCustomer = resultSet.getString("customer_id_card");
                    String phoneCustomer = resultSet.getString("customer_phone");
                    String emailCustomer = resultSet.getString("customer_email");
                    String addressCustomer = resultSet.getString("customer_address");
                    int idCustomerType = resultSet.getInt("customer_type_id");
                    String nameCustomerType = resultSet.getString("customer_type_name");
                    customerList.add(new Customer(idCustomer, codeCustomer, nameCustomer, birthdayCustomer, genderCustomer, idCardCustomer, phoneCustomer, emailCustomer,
                            addressCustomer, idCustomerType, nameCustomerType));
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

    @Override
    public void create(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                preparedStatement.setString(1, customer.getCodeCustomer());
                preparedStatement.setInt(2, customer.getIdCustomerType());
                preparedStatement.setString(3, customer.getNameCustomer());
                preparedStatement.setString(4, customer.getBirthdayCustomer());
                preparedStatement.setString(5, customer.getGenderCustomer());
                preparedStatement.setString(6, customer.getIdCardCustomer());
                preparedStatement.setString(7, customer.getPhoneCustomer());
                preparedStatement.setString(8, customer.getEmailCustomer());
                preparedStatement.setString(9, customer.getAddressCustomer());
                preparedStatement.executeUpdate();
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
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
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
    }

    @Override
    public void updateCustomer(Customer customer) {

    }
}
