package repository.impl;

import model.Customer;
import repository.CustomerRepository;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static String SELECT_ALL_CUSTOMER = "SELECT * FROM customer \n" +
            "join customer_type on customer.id_customer_type = customer_type.id_customer_type;";
    private static String INSERT_CUSTOMER = "INSERT INTO `demo_c1021g1`.`customer` ( `name_customer`, `customer_code`, `birthday`, `gender`, `id_customer_type`) VALUES ( ?, ?, ?,?,?);";
    private static String DELETE_CUSTOMER = "delete from customer where id_customer = ?";


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
                    int idCustomer = resultSet.getInt("id_customer");
                    String nameCustomer = resultSet.getString("name_customer");
                    String customerCode = resultSet.getString("customer_code");
                    String birthday = resultSet.getString("birthday");
                    Boolean gender = resultSet.getBoolean("gender");
                    int idCustomerType = resultSet.getInt("id_customer_type");
                    String nameCustomerType = resultSet.getString("name_customer_type");
                    customerList.add(new Customer(idCustomer, nameCustomer, customerCode, birthday, gender, idCustomerType, nameCustomerType));
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
                preparedStatement.setString(1,customer.getNameCustomer());
                preparedStatement.setString(2,customer.getCustomerCode());
                preparedStatement.setString(3,customer.getBirthday());
                preparedStatement.setBoolean(4,customer.isGender());
                preparedStatement.setInt(5,customer.getIdCustomerType());
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
