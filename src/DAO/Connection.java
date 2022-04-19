/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Bike;
import DTO.Brand;
import DTO.User;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ADMIN
 */
public class Connection {

    public static java.sql.Connection openConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=motorcyleManagement";
        java.sql.Connection conn = DriverManager.getConnection(url, "sa", "1234");
        return conn;
    }

    public static int insertBrand(Brand r) throws Exception {
        String sql = "INSERT INTO tblBrand Values(?,?,?,?)";

        try (java.sql.Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, r.getBrandID());
            ps.setString(2, r.getBrandName());
            ps.setString(3, r.getCountry());
            ps.setString(4, r.getDescription());
            return ps.executeUpdate();
        }

    }

    public static List<Brand> getDataBrand() throws Exception {
        List<Brand> list = new ArrayList<>();
        try {
            java.sql.Connection conn = openConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tblBrand");
            while (rs.next()) {
                String brandID = rs.getString("brandID");
                String brandName = rs.getString("brandName");
                String country = rs.getString("country");
                String description = rs.getString("description");
                Brand br = new Brand(brandID, brandName, country, description);
                list.add(br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int insertBike(Bike r) throws Exception {
        String sql = "INSERT INTO tblBike Values(?,?,?,?,?,?,?,?)";

        try (java.sql.Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, r.getMotoID());
            ps.setString(2, r.getModel());
            ps.setString(3, r.getYear());
            ps.setString(4, r.getCondition());
            ps.setFloat(5, r.getPrice());
            ps.setInt(6, r.getQuantity());
            ps.setString(7, r.getWarranty());
            ps.setString(8, r.getBrandID());
            return ps.executeUpdate();
        }

    }

    public static List<Bike> getDataBike() throws Exception {
        List<Bike> list = new ArrayList<>();
        try {
            java.sql.Connection conn = openConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tblBike");
            while (rs.next()) {
                String motoID = rs.getString("motocyleID");
                String model = rs.getString("model");
                String year = rs.getString("year");
                String condition = rs.getString("condition");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String warranty = rs.getString("warranty");
                String brandID = rs.getString("brandID");
                Bike bk = new Bike(motoID, model, year, condition, price, quantity, warranty, brandID);
                list.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static java.sql.Date convertToSQLDate(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public static List<User> getDataUser() throws Exception {
        List<User> list = new ArrayList<>();
        try {
            java.sql.Connection conn = openConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tblUser");
            while (rs.next()) {
                String userID = rs.getString("userID");
                String userName = rs.getString("fullName");
                String password = rs.getString("password");
                boolean status = rs.getBoolean("status");
                User u = new User(userID, userName, password, status);
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static User findByUserID(String userID) throws Exception {
        for (int i = 0; i < getDataUser().size(); i++) {
            if (userID.equalsIgnoreCase(getDataUser().get(i).getUserId())) {
                return getDataUser().get(i);
            }
        }
        return null;
    }

    public static User findByUserPass(String userPass) throws Exception {
        for (int i = 0; i < getDataUser().size(); i++) {
            if (userPass.equalsIgnoreCase(getDataUser().get(i).getPassword())) {
                return getDataUser().get(i);
            }
        }
        return null;
    }

//        try {
//            String sql = "Select * From tblBrand";
//            cnn.ThucThiSql(sql);
//            DefaultComboBoxModel model = new DefaultComboBoxModel();
//
//            if (cnn.rs.next()) {
//                 model.addElement(cnn.rs.getString("TenTG"));
//            }
//            cboTacGia.setModel(model);
//        } catch (SQLException ex) {
//            Logger.getLogger(frmCapNhatSach1.class.getName()).log(Level.SEVERE, null, ex);
//        }
    public static int updateBrand(Brand r) throws Exception {
        String sql = "UPDATE tblBrand SET brandName=?, country=?, description=? WHERE brandID=?";
        try (java.sql.Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, r.getBrandName());
            ps.setString(2, r.getCountry());
            ps.setString(3, r.getDescription());
            ps.setString(4, r.getBrandID());

            return ps.executeUpdate();
        }

    }

    public static int updateBike(Bike r) throws Exception {
        String sql = "UPDATE tblBike SET model=?, year=?, condition=?, price=?, quantity=?, warranty=?, brandID=?    WHERE motocyleID=?";
        try (java.sql.Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, r.getModel());
            ps.setString(2, r.getYear());
            ps.setString(3, r.getCondition());
            ps.setFloat(4, r.getPrice());
            ps.setInt(5, r.getQuantity());
            ps.setString(6, r.getWarranty());
            ps.setString(7, r.getBrandID());
            ps.setString(8, r.getMotoID());

            return ps.executeUpdate();
        }

    }

    public static int deleteBrand(String brandID) throws Exception {
        String sql = " DELETE tblBrand FROM tblBrand WHERE brandID=?";
        try (java.sql.Connection con = openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, brandID);
            return ps.executeUpdate();

        }
    }
    public static int deleteBike(String bikeID) throws Exception {
        String sql = " DELETE tblBike FROM tblBike WHERE motocyleID=?";
        try (java.sql.Connection con = openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bikeID);
            return ps.executeUpdate();

        }
    }

//    public static List<User> findByIdUser(String name) throws SQLException {
//
//        List<User> list = new ArrayList<>();
//        String sql = "SELECT * FROM tbleUser WHERE userID LIKE ?";
//        try {
//            java.sql.Connection con = openConnection();
//            PreparedStatement ps = con.prepareStatement(sql);
//            {
//                ps.setString(1, "%" + name + "%");
//                ResultSet rs = ps.executeQuery();
//                while (rs.next()) {
//                    User rd = new User(rs.getString("userID"), rs.getString("userName"), rs.getString("password"), rs.getBoolean("status"));
//                    list.add(rd);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
