package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.PhuTungThanhToan_027;

public class PhuTungThanhToanDAO_027 extends ConnectDAO_027 {
    public PhuTungThanhToanDAO_027() {
        super();
    }

    public List<PhuTungThanhToan_027> getListPTTTbyHoaDonid(String maHD) {
        List<PhuTungThanhToan_027> li = new ArrayList<>();
        String sql = "SELECT * FROM tblphutungthanhtoan_027";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String idPhuTungTT = resultSet.getString("idPhuTungTT");
                int soLuong = resultSet.getInt("soLuong");
                float thanhTien = resultSet.getFloat("thanhTien");
                String maHoaDonDB = resultSet.getString("maHoaDon");  // Retrieve the actual column name
                String maPhuTung = resultSet.getString("maPhuTung");
                if (maHoaDonDB.equals(maHD)) {
                    li.add(new PhuTungThanhToan_027(idPhuTungTT, soLuong, thanhTien, maHD, maPhuTung));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
    public boolean addPhuTungThanhToan(PhuTungThanhToan_027 phuTungThanhToan) {
        String sql = "INSERT INTO tblphutungthanhtoan_027 (idPhuTungTT, soLuong, thanhTien, maHoaDon, maPhuTung) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, generateServiceCode());
            statement.setInt(2, phuTungThanhToan.getSoLuong());
            statement.setFloat(3, phuTungThanhToan.getThanhTien());
            statement.setString(4, phuTungThanhToan.getMaHoaDon());
            statement.setString(5, phuTungThanhToan.getMaPhuTung());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
        public void updatePhuTungThanhToan(PhuTungThanhToan_027 phuTungThanhToan) {
            // Check if the updated quantity is 0, then delete the record
            if (phuTungThanhToan.getSoLuong() == 0) {
                deletePhuTungThanhToan(phuTungThanhToan.getIdPhuTungTT());
            } else {
                String sql = "UPDATE tblphutungthanhtoan_027 SET soLuong = ?, thanhTien = ?, maHoaDon = ?, maPhuTung = ? WHERE idPhuTungTT = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, phuTungThanhToan.getSoLuong());
                    statement.setFloat(2, phuTungThanhToan.getThanhTien());
                    statement.setString(3, phuTungThanhToan.getMaHoaDon());
                    statement.setString(4, phuTungThanhToan.getMaPhuTung());
                    statement.setString(5, phuTungThanhToan.getIdPhuTungTT());
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void deletePhuTungThanhToan(String idPhuTungTT) {
            String sql = "DELETE FROM tblphutungthanhtoan_027 WHERE idPhuTungTT = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, idPhuTungTT);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public String generateServiceCode() {
        String latestCode = getLatestServiceCode();
        int nextNumber = extractNumberFromCode(latestCode) + 1;
        return "PTTT" + String.format("%03d", nextNumber);
    }
    private String getLatestServiceCode() {
            String query = "SELECT MAX(idPhuTungTT) AS latestCode FROM tblphutungthanhtoan_027 WHERE idPhuTungTT LIKE 'PTTT%'";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("latestCode");
                }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
        return "PTTT000"; // Default if no code is found
    }

    private static int extractNumberFromCode(String code) {
        try {
            return Integer.parseInt(code.substring(4));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            return 0; // Default if unable to parse the number
        }
    }
}
