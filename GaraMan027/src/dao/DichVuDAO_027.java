package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DichVu_027;

public class DichVuDAO_027 extends ConnectDAO_027 {
    
    public DichVuDAO_027() {
        super();
    }

    public List<DichVu_027> getDataFromTable() throws SQLException {
        List<DichVu_027> listDV = new ArrayList<>();
        String sql = "SELECT id, name, description, giathanh FROM tbldichvu_027";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                float giaThanh = resultSet.getFloat("giathanh");
                listDV.add(new DichVu_027(id, name, description, giaThanh));
            }
        }

        return listDV;
    }
    public String getTenDichVuById(String id) {
        String selectNhanVienQuery = "SELECT * FROM tblDichVu_027 WHERE id = ?";

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
    public DichVu_027 getDichVuById(String id) {
        String selectNhanVienQuery = "SELECT * FROM tblDichVu_027 WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectNhanVienQuery)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    float giaThanh = resultSet.getFloat("giathanh");
                   return (new DichVu_027(id, name, description, giaThanh));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Trả về null nếu không tìm thấy NhanVien
    }
    public List<DichVu_027> SearchDichVu(String keyword) {
        List<DichVu_027> matchingDichVuList = new ArrayList<>();
        String searchQuery = "SELECT id, name, description, giathanh FROM tbldichvu_027 WHERE name LIKE ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setString(1, "%" + keyword + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String foundName = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    float giaThanh = resultSet.getFloat("giathanh");

                    matchingDichVuList.add(new DichVu_027(id, foundName, description, giaThanh));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matchingDichVuList;
    }
}
