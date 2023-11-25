package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DichVuThanhToan_027;

public class DichVuThanhToanDAO_027 extends ConnectDAO_027 {
    public DichVuThanhToanDAO_027() {
        super();
    }

    public List<DichVuThanhToan_027> getListDVTTbyHoaDonid(String maHD) {
        List<DichVuThanhToan_027> li = new ArrayList<>();
        String sql = "SELECT * FROM tbldichvuthanhtoan_027";  // Change table name accordingly
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String idDVTT = resultSet.getString("idDvTT");  // Adjust column names
                String idDV = resultSet.getString("idDV");
                String tenNV = resultSet.getString("tenNV");
                float gia = resultSet.getFloat("gia");
                String maHoaDonDB = resultSet.getString("maHoaDon");
                String idNV = resultSet.getString("idNV");
                if (maHoaDonDB.equals(maHD)) {
                    li.add(new DichVuThanhToan_027(idDVTT, idDV, tenNV, gia, maHoaDonDB,idNV));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
    public void updateDichVuThanhToan(DichVuThanhToan_027 dichVuThanhToan) {
        // Check if the updated price is 0, then delete the record
        if (dichVuThanhToan.getGia() == 0) {
            deleteDichVuThanhToan(dichVuThanhToan.getIdDvTT());
        } else {
            String sql = "UPDATE tbldichvuthanhtoan_027 SET idDV = ?, tenNV = ?, gia = ?, maHoaDon = ? , idNV = ?WHERE idDvTT = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, dichVuThanhToan.getIdDV());
                statement.setString(2, dichVuThanhToan.getTenNV());
                statement.setFloat(3, dichVuThanhToan.getGia());
                statement.setString(4, dichVuThanhToan.getMaHoaDon());
                statement.setString(5, dichVuThanhToan.getIdDvTT());
                statement.setString(6, dichVuThanhToan.getIdNV());
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteDichVuThanhToan(String idDVTT) {
        String sql = "DELETE FROM tbldichvuthanhtoan_027 WHERE idDvTT = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idDVTT);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean insertDichVuThanhToan(DichVuThanhToan_027 dichVuThanhToan) {
        // Check if the record with the same idDvTT already exists
        if (!isDichVuThanhToanExists(dichVuThanhToan.getIdDvTT())) {
            // Check if the combination of idNV and idDV already exists
            if (!isCombinationExists(dichVuThanhToan.getIdNV(), dichVuThanhToan.getIdDV())) {
                String sql = "INSERT INTO tbldichvuthanhtoan_027 (idDvTT, idDV, tenNV, gia, maHoaDon, idNV) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, dichVuThanhToan.getIdDvTT());
                    statement.setString(2, dichVuThanhToan.getIdDV());
                    statement.setString(3, dichVuThanhToan.getTenNV());
                    statement.setFloat(4, dichVuThanhToan.getGia());
                    statement.setString(5, dichVuThanhToan.getMaHoaDon());
                    statement.setString(6, dichVuThanhToan.getIdNV());
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // Combination of idNV and idDV already exists, handle accordingly
                System.out.println("Combination of idNV and idDV already exists.");
                return false;
                // You can throw an exception or log a message here based on your needs.
            }
            return true;
        }
        return false;
    }

    private boolean isCombinationExists(String idNV, String idDV) {
        String sql = "SELECT COUNT(*) AS count FROM tbldichvuthanhtoan_027 WHERE idNV = ? AND idDV = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idNV);
            statement.setString(2, idDV);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    private boolean isDichVuThanhToanExists(String idDVTT) {
        String sql = "SELECT COUNT(*) FROM tbldichvuthanhtoan_027 WHERE idDvTT = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idDVTT);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String generateServiceCode() {
        String latestCode = getLatestServiceCode();
        int nextNumber = extractNumberFromCode(latestCode) + 1;
        return "DVTT" + String.format("%03d", nextNumber);
    }
    private String getLatestServiceCode() {
        String query = "SELECT MAX(idDvTT) AS latestCode FROM tbldichvuthanhtoan_027";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString("latestCode");
            }
    } catch (Exception e) {
        e.printStackTrace(); // Handle the exception according to your application's needs
    }
    return "DVTT000"; // Default if no code is found
}

private static int extractNumberFromCode(String code) {
    try {
        return Integer.parseInt(code.substring(4));
    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
        return 0; // Default if unable to parse the number
    }
}
}
