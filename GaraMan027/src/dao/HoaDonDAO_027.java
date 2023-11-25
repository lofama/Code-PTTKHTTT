package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DichVuThanhToan_027;
import model.HoaDon_027;
import model.PhuTungThanhToan_027;

public class HoaDonDAO_027 extends ConnectDAO_027 {
    public HoaDonDAO_027() {
        super();
    }
    public List<HoaDon_027> getAllHoaDon() {
        List<HoaDon_027> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM tblhoadon_027";  // Adjust table name
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
            	String maHoaDon = resultSet.getString("maHoaDon");
            	String maKhachHang = resultSet.getString("maKhachHang");
            	String maNhanVien = resultSet.getString("maNhanVien");
                boolean tinhTrang = resultSet.getBoolean("tinhtrang");
                Date ngayHoaDon = resultSet.getDate("ngayHoaDon");
                String tenKhachHang = resultSet.getString("tenKhachHang");
                String thongTinKhacHoaDon = resultSet.getString("thongTinKhacHoaDon");
                String trangThaiThanhToan = resultSet.getString("trangThaiThanhToan");
                float tongGiaDichVu = resultSet.getFloat("tongGiaDichVu");
                float tongGiaPhuTung = resultSet.getFloat("tongGiaPhuTung");
                float chietKhauPhanTram = resultSet.getFloat("chietKhauPhanTram");
                float chietKhauTien = resultSet.getFloat("chietKhauTien");
                float thanhTien = resultSet.getFloat("thanhTien");

                // Retrieve and set the lists
                List<DichVuThanhToan_027> ldvtt = new DichVuThanhToanDAO_027().getListDVTTbyHoaDonid(String.valueOf(maHoaDon));
                List<PhuTungThanhToan_027> lpttt = new PhuTungThanhToanDAO_027().getListPTTTbyHoaDonid(String.valueOf(maHoaDon));

                HoaDon_027 hoaDon = new HoaDon_027(maHoaDon, maKhachHang, maNhanVien, tinhTrang, ldvtt, lpttt, ngayHoaDon,
                        tenKhachHang, thongTinKhacHoaDon, trangThaiThanhToan, tongGiaDichVu, tongGiaPhuTung,
                        chietKhauPhanTram, chietKhauTien, thanhTien);
                hoaDonList.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDonList;
    }
    public List<HoaDon_027> get20HoaDon() {
        List<HoaDon_027> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM tblhoadon_027";  // Adjust table name
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
            	String maHoaDon = resultSet.getString("maHoaDon");
            	String maKhachHang = resultSet.getString("maKhachHang");
            	String maNhanVien = resultSet.getString("maNhanVien");
                boolean tinhTrang = resultSet.getBoolean("tinhtrang");
                Date ngayHoaDon = resultSet.getDate("ngayHoaDon");
                String tenKhachHang = resultSet.getString("tenKhachHang");
                String thongTinKhacHoaDon = resultSet.getString("thongTinKhacHoaDon");
                String trangThaiThanhToan = resultSet.getString("trangThaiThanhToan");
                float tongGiaDichVu = resultSet.getFloat("tongGiaDichVu");
                float tongGiaPhuTung = resultSet.getFloat("tongGiaPhuTung");
                float chietKhauPhanTram = resultSet.getFloat("chietKhauPhanTram");
                float chietKhauTien = resultSet.getFloat("chietKhauTien");
                float thanhTien = resultSet.getFloat("thanhTien");

                // Retrieve and set the lists
                List<DichVuThanhToan_027> ldvtt = new DichVuThanhToanDAO_027().getListDVTTbyHoaDonid(String.valueOf(maHoaDon));
                List<PhuTungThanhToan_027> lpttt = new PhuTungThanhToanDAO_027().getListPTTTbyHoaDonid(String.valueOf(maHoaDon));

                HoaDon_027 hoaDon = new HoaDon_027(maHoaDon, maKhachHang, maNhanVien, tinhTrang, ldvtt, lpttt, ngayHoaDon,
                        tenKhachHang, thongTinKhacHoaDon, trangThaiThanhToan, tongGiaDichVu, tongGiaPhuTung,
                        chietKhauPhanTram, chietKhauTien, thanhTien);
                hoaDonList.add(hoaDon);
                if(hoaDonList.size()==20) return hoaDonList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDonList;
    }
    public HoaDon_027 getHoaDonByID(String string) {
        HoaDon_027 hoaDon = null;
        String sql = "SELECT * FROM tblhoadon_027 WHERE maHoaDon = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, string);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	String maKhachHang = resultSet.getString("maKhachHang");
                	String maNhanVien = resultSet.getString("maNhanVien");
                    boolean tinhTrang = resultSet.getBoolean("tinhtrang");
                    Date ngayHoaDon = resultSet.getDate("ngayHoaDon");
                    String tenKhachHang = resultSet.getString("tenKhachHang");
                    String thongTinKhacHoaDon = resultSet.getString("ThongTinKhacHoaDon");
                    String trangThaiThanhToan = resultSet.getString("trangThaiThanhToan");
                    float tongGiaDichVu = resultSet.getFloat("tongGiaDichVu");
                    float tongGiaPhuTung = resultSet.getFloat("tongGiaPhuTung");
                    float chietKhauPhanTram = resultSet.getFloat("chietKhauPhanTram");
                    float chietKhauTien = resultSet.getFloat("chietKhauTien");
                    float thanhTien = resultSet.getFloat("thanhTien");

                    // Retrieve and set the lists
                    List<DichVuThanhToan_027> ldvtt = new DichVuThanhToanDAO_027().getListDVTTbyHoaDonid(string);
                    List<PhuTungThanhToan_027> lpttt = new PhuTungThanhToanDAO_027().getListPTTTbyHoaDonid(string);

                    hoaDon = new HoaDon_027(string, maKhachHang, maNhanVien, tinhTrang, ldvtt, lpttt, ngayHoaDon,
                            tenKhachHang, thongTinKhacHoaDon, trangThaiThanhToan, tongGiaDichVu, tongGiaPhuTung,
                            chietKhauPhanTram, chietKhauTien, thanhTien);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
}
    public void updateHoaDon(HoaDon_027 hoaDon) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE tblHoaDon_027 SET maNhanVien=?, tinhtrang=?," +
                        "tenKhachHang=?, ThongTinKhacHoaDon=?, trangThaiThanhToan=?, tongGiaDichVu=?, " +
                        "tongGiaPhuTung=?, chietKhauPhanTram=?, chietKhauTien=?, thanhTien=? " +
                        "WHERE maHoaDon=?")) {
            statement.setString(1, hoaDon.getMaNhanVien());
            statement.setBoolean(2, hoaDon.isTinhtrang());
            statement.setString(3, hoaDon.getTenKhachHang());
            statement.setString(4, hoaDon.getThongTinKhacHoaDon());
            statement.setString(5, hoaDon.getTrangThaiThanhToan());
            statement.setFloat(6, hoaDon.getTongGiaDichVu());
            System.out.println(hoaDon.getTongGiaDichVu());
            statement.setFloat(7, hoaDon.getTongGiaPhuTung());
            statement.setFloat(8, hoaDon.getChietKhauPhanTram());
            statement.setFloat(9, hoaDon.getChietKhauTien());
            statement.setFloat(10, hoaDon.getThanhTien());
            statement.setString(11, hoaDon.getMaHoaDon());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public List<HoaDon_027> timHoaDonByTenKH(String keyword) {
    List<HoaDon_027> hoaDonList = new ArrayList<>();
    String sql = "SELECT * FROM tblhoadon_027 WHERE tenKhachHang LIKE ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, "%" + keyword + "%");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String maHoaDon = resultSet.getString("maHoaDon");
                String maKhachHang = resultSet.getString("maKhachHang");
                String maNhanVien = resultSet.getString("maNhanVien");
                boolean tinhTrang = resultSet.getBoolean("tinhtrang");
                Date ngayHoaDon = resultSet.getDate("ngayHoaDon");
                String tenKhachHang = resultSet.getString("tenKhachHang");
                String thongTinKhacHoaDon = resultSet.getString("thongTinKhacHoaDon");
                String trangThaiThanhToan = resultSet.getString("trangThaiThanhToan");
                float tongGiaDichVu = resultSet.getFloat("tongGiaDichVu");
                float tongGiaPhuTung = resultSet.getFloat("tongGiaPhuTung");
                float chietKhauPhanTram = resultSet.getFloat("chietKhauPhanTram");
                float chietKhauTien = resultSet.getFloat("chietKhauTien");
                float thanhTien = resultSet.getFloat("thanhTien");

                // Retrieve and set the lists
                List<DichVuThanhToan_027> ldvtt = new DichVuThanhToanDAO_027().getListDVTTbyHoaDonid(maHoaDon);
                List<PhuTungThanhToan_027> lpttt = new PhuTungThanhToanDAO_027().getListPTTTbyHoaDonid(maHoaDon);

                HoaDon_027 hoaDon = new HoaDon_027(maHoaDon, maKhachHang, maNhanVien, tinhTrang, ldvtt, lpttt, ngayHoaDon,
                        tenKhachHang, thongTinKhacHoaDon, trangThaiThanhToan, tongGiaDichVu, tongGiaPhuTung,
                        chietKhauPhanTram, chietKhauTien, thanhTien);
                hoaDonList.add(hoaDon);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return hoaDonList;
}
}
