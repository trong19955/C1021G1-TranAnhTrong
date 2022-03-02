package repository.impl;

import model.Product;
import repository.DBConnection;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static String SELECT_ALL_PRODUCT = "SELECT* FROM product join category ON product.id_category = category.id_category;";

    private static String INSERT_PRODUCT = " INSERT INTO `management_product`.`product`(`name`,`price`,`quantity`,`color`,`id_category`) VALUES( ?, ?, ?, ?, ?);";
    private static String DELETE_PRODUCT = "delete from product where id = ?;";

    private static final String SEARCH_PRODUCT = "select * from product join  category ON product.id_category = category.id_category" +
            " where `name` like ? ;";
    private static final String SEARCH_PRODUCT_BY_ID = "select * from product join category on product.id_category = category.id_category" +
            " where id = ?;";
    private DBConnection dbConnection = new DBConnection();

    @Override
    public List<Product> findAll() {
        Connection connection = dbConnection.getConnection();
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet = preparedStatement.executeQuery();
                Product product;
                while (resultSet.next()) {
                    product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setQuantity(resultSet.getString("quantity"));
                    product.setColor(resultSet.getString("color"));
                    product.setNameCategory(resultSet.getString("name_category"));
                    productList.add(product);
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
        return productList;
    }

    @Override
    public void create(Product product) {

        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
                preparedStatement.setString(1, product.getName());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setString(4, product.getColor());
                preparedStatement.setString(3, product.getQuantity());
                preparedStatement.setInt(5, product.getIdCategory());
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
                preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
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
    public List<Product> search(String name) {
        Connection connection = DBConnection.getConnection();
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            Product product;
            preparedStatement = connection.prepareStatement(SEARCH_PRODUCT);
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getString("quantity"));
                product.setColor(resultSet.getString("color"));
                product.setIdCategory(resultSet.getInt("id_category"));
                product.setNameCategory(resultSet.getString("name_category"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchById(int id) {
        Connection connection = DBConnection.getConnection();
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            Product product;
            preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getString("quantity"));
                product.setColor(resultSet.getString("color"));
                product.setIdCategory(resultSet.getInt("id_category"));
                product.setNameCategory(resultSet.getString("name_category"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }
}

