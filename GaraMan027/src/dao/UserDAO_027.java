package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang_027;
import model.NhanVien_027;
import model.User_027;

public class UserDAO_027 extends ConnectDAO_027 {

    public UserDAO_027() {
        super();
    }
    public String checkUser(String email, String password) {
        String checkUserQuery = "SELECT 'US' AS userType FROM tbluser_027 WHERE email = ? AND password = ? " +
                               "UNION " +
                               "SELECT 'KH' AS userType FROM tblKhachHang_027 WHERE email = ? AND password = ? " +
                               "UNION " +
                               "SELECT 'NV' AS userType FROM tblNhanVien_027 WHERE email = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(checkUserQuery)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	while (resultSet.next()) {
                    // Nếu có dữ liệu, trả về loại user (US, KH, NV)
                    return resultSet.getString("userType");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "NO"; // Trả về null nếu không tìm thấy user
    }
    
    public User_027 getUserByEmailAndPassword(String email, String password) {
        String selectQuery = "SELECT * FROM tbluser_027 WHERE email = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    // Nếu có dữ liệu, tạo đối tượng User_027 và trả về
                    User_027 user = new User_027(
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("diachi"),
                        resultSet.getString("sdt")
                    );
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Trả về null nếu không tìm thấy user
    }
    public boolean insertUser(String email, String password, String name, String diachi, String sdt) {
        String insertQuery = "INSERT INTO tbluser_027 (email, password, name, diachi, sdt) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, diachi);
            preparedStatement.setString(5, sdt);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public KhachHang_027 getKhachHangByEmail(String email) {
        String selectKhachHangQuery = "SELECT * FROM tblKhachHang_027 WHERE email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectKhachHangQuery)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	while (resultSet.next()) {
                    // Nếu có dữ liệu, tạo đối tượng KhachHang_027 và trả về
                    KhachHang_027 khachHang = new KhachHang_027(
                    		resultSet.getString("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("diachi"),
                        resultSet.getString("sdt")
                        
                    );
                    return khachHang;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Trả về null nếu không tìm thấy KhachHang
    }

    public NhanVien_027 getNhanVienByEmail(String email) {
        String selectNhanVienQuery = "SELECT * FROM tblNhanVien_027 WHERE email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectNhanVienQuery)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	while (resultSet.next()) {
                    // Nếu có dữ liệu, tạo đối tượng NhanVien_027 và trả về
                    NhanVien_027 nhanVien = new NhanVien_027(
                    		resultSet.getString("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("diachi"),
                        resultSet.getString("sdt"),
                        resultSet.getString("chucvu")
                    );
                    return nhanVien;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Trả về null nếu không tìm thấy NhanVien
    }
    public String getTenVienById(String id) {
        String selectNhanVienQuery = "SELECT * FROM tblNhanVien_027 WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectNhanVienQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	while (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Khong co nhan vien"; // Trả về null nếu không tìm thấy NhanVien
    }
    public List<NhanVien_027> getNhanVien() {
        List<NhanVien_027> listNhanVien = new ArrayList<>();

        String selectNhanVienQuery = "SELECT * FROM tblNhanVien_027";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectNhanVienQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Nếu có dữ liệu, tạo đối tượng NhanVien_027 và thêm vào danh sách
                    NhanVien_027 nhanVien = new NhanVien_027(
                        resultSet.getString("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("diachi"),
                        resultSet.getString("sdt"),
                        resultSet.getString("chucvu")
                    );
                    listNhanVien.add(nhanVien);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }
}
