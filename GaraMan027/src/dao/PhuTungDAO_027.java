package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PhuTung_027;

public class PhuTungDAO_027 extends ConnectDAO_027 {
    
    public PhuTungDAO_027() {
        super();
    }

    public List<PhuTung_027> getDataFromTable() throws SQLException {
        List<PhuTung_027> listPT = new ArrayList<>();
        String sql = "SELECT id, name, description, giathanh FROM tblphutung_027";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                float giaThanh = resultSet.getFloat("giathanh");
                listPT.add(new PhuTung_027(id, name, description, giaThanh));
            }
        }

        return listPT;
    }
    public List<PhuTung_027> searchPhuTung(String keyword) {
        List<PhuTung_027> matchingPhuTungList = new ArrayList<>();
        String searchQuery = "SELECT id, name, description, giathanh FROM tblphutung_027 WHERE name LIKE ? OR description LIKE ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String foundName = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    float giaThanh = resultSet.getFloat("giathanh");

                    matchingPhuTungList.add(new PhuTung_027(id, foundName, description, giaThanh));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matchingPhuTungList;
    }
    public String getTenPhuTungById(String id) {
        String selectNhanVienQuery = "SELECT * FROM tblphutung_027 WHERE id = ?";

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

        return "Khong co Dich Vu"; // Trả về null nếu không tìm thấy NhanVien
    }
    public float getGiaPhuTungById(String id) {
        String selectNhanVienQuery = "SELECT * FROM tblphutung_027 WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectNhanVienQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	while (resultSet.next()) {
                    return resultSet.getFloat("giathanh");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // Trả về null nếu không tìm thấy NhanVien
    }
    public PhuTung_027 getPhuTungById(String id) {
        String selectPhuTungQuery = "SELECT * FROM tblphutung_027 WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectPhuTungQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    float giaThanh = resultSet.getFloat("giathanh");

                    return new PhuTung_027(id, name, description, giaThanh);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Trả về null nếu không tìm thấy PhuTung
    }

}
