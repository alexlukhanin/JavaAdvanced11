package ua.uz.alex.dao.impl;

import org.apache.log4j.Logger;
import ua.uz.alex.dao.ProductDao;
import ua.uz.alex.domain.Product;
import ua.uz.alex.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static String READ_ALL = "select * from product";
    private static String READ_ALL_SORTED_BY_NAME = "select * from product order by name";
    private static String CREATE = "insert into product(`name`, `description`, `price`) values (?,?,?)";
    private static String READ_BY_ID = "select * from product where id =?";
    private static String READ_BY_NAME = "select * from product where name =?";
    private static String UPDATE_BY_ID = "update product set name=?, description = ?, price = ? where id = ?";
    private static String DELETE_BY_ID = "delete from product where id=?";

    private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);

    private Connection connection;
    private PreparedStatement preparedStatement;

    public ProductDaoImpl()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        connection = ConnectionUtils.openConnection();
    }


    /// ok
    @Override
    public Product create(Product product) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            product.setId(rs.getInt(1));
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return product;
    }


    @Override
    public Product readById(Integer id) {
        Product product = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer productId = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            Double purchasePrice = result.getDouble("price");
            product = new Product(productId, name, description, purchasePrice);

        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return product;
    }

    @Override
    public Product readByString(String name) {

        throw new IllegalStateException("there is no need to read by name");
    }

    @Override
    public Product update(Product product) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return product;
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Product> readAll() {
        List<Product> productRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL_SORTED_BY_NAME);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer productId = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Double purchasePrice = result.getDouble("price");

                productRecords.add(new Product(productId, name, description, purchasePrice));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return productRecords;
    }
}
