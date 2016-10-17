/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasurgical.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sasurgical.dto.Category;
import sasurgical.dto.Item;

/**
 *
 * @author em000001
 */
public class SASurgicalCatalogDataAccess {

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sasurgical_db?"
                + "user=root&password=Il0vesteakchicken!!&serverTimezone=America/New_York");
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser("root");
//        dataSource.setPassword("");
//        dataSource.setServerName("localhost");
//        dataSource.setPort(3306);
//        dataSource.setDatabaseName("sasurgical_db");
        //conn = dataSource.getConnection();

        return conn;
    }

    private void close_conn(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SASurgicalCatalogDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> getAllItemsInSub(int category_id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Item> items = new ArrayList<Item>();

        try {
            conn = getConnection();
            String query = "select\n"
                    + "	oc_p.*,\n"
                    + "    oc_pd.*\n"
                    + "from\n"
                    + "	oc_product oc_p,\n"
                    + "    oc_product_description oc_pd\n"
                    + "where\n"
                    + "	oc_p.product_id = oc_pd.product_id and\n"
                    + "    oc_pd.category = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,category_id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Item item = new Item();
                item.setDescription(rs.getString("description"));
                item.setId(rs.getInt("product_id"));
                item.setImg_path(rs.getString("image"));
                item.setModel(rs.getString("model"));
                item.setName(rs.getString("name"));
                items.add(item);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SASurgicalCatalogDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SASurgicalCatalogDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close_conn(rs, pstmt, conn);
        }
        return items;
    }

    public List<Category> getSubCategories(int parent_category) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Category> sub_categories = new ArrayList<Category>();
        try {
            conn = getConnection();
            String query = "select * from oc_category_description where parent_id = ? order by name asc";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, parent_category);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Category cat = new Category();
                cat.setId(rs.getInt("category_id"));
                cat.setName(rs.getString("name"));
                sub_categories.add(cat);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SASurgicalCatalogDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SASurgicalCatalogDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close_conn(rs, pstmt, conn);
        }

        return sub_categories;
    }

//    public static void main(String args[]){
//        List<Category> sub_categories = getSubCategories(59);
//        for (int i = 0; i < sub_categories.size(); i ++){
//            System.out.println("id: " + sub_categories.get(i).getId() + " Name: " + sub_categories.get(i).getName());
//        }
//        System.out.println("FOO");
//    }
}
