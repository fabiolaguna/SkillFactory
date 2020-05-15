package net.skillfactory.repository;

import net.skillfactory.connection.ConnectionClass;
import net.skillfactory.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private Connection con;

    public ProductRepository(){
        con = ConnectionClass.obtain();
    }

    public void addProduct(Product p) {

        try {
            PreparedStatement st = con.prepareStatement("insert into products (name_product,price,brand,unit,quantity,discount)" +
                                                        "values (?,?,?,?,?,?)");
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setString(3, p.getBrand());
            st.setInt(4, p.getUnit());
            st.setInt(5, p.getQuantity());
            st.setDouble(6, p.getDiscount());
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from products");

            while(rs.next()){
                products.add(new Product.Builder().id(rs.getInt("id_product")).name(rs.getString("name_product")).price(rs.getDouble("price")).brand(rs.getString("brand")).unit(rs.getInt("unit")).quantity(rs.getInt("quantity")).discount(rs.getDouble("discount")).build());
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product findById(Integer id){

        Product p = null;
        try {
            PreparedStatement st = con.prepareStatement("select * from products where id_product = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                p = new Product.Builder().id(rs.getInt("id_product")).name(rs.getString("name_product")).price(rs.getDouble("price")).brand(rs.getString("brand")).unit(rs.getInt("unit")).quantity(rs.getInt("quantity")).discount(rs.getDouble("discount")).build();
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public Integer delete(Integer id){

        Integer rowsAffected = 0;
        try {
            PreparedStatement st = con.prepareStatement("delete from products where id_product = ?");
            st.setInt(1, id);
            rowsAffected = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    public Integer update(Product p, Integer id){

        Integer rowsAffected = 0;
        try {
            PreparedStatement st = con.prepareStatement("update products set name_product = ?, price = ?, brand = ?, unit = ?" +
                    ", quantity = ?, discount = ? where id_product = ?");
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setString(3, p.getBrand());
            st.setInt(4, p.getUnit());
            st.setInt(5, p.getQuantity());
            st.setDouble(6, p.getDiscount());
            st.setInt(7, id);
            rowsAffected = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }
}
