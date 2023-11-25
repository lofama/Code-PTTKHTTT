package model;

import java.util.Date;
import java.util.List;

import dao.DichVuThanhToanDAO_027;
import dao.PhuTungThanhToanDAO_027;
import dao.UserDAO_027;

public class HoaDon_027 {
	    public String maHoaDon;
	    public String maKhachHang;
	    public String maNhanVien;
	    public boolean tinhtrang;
	    public List<DichVuThanhToan_027> ldvtt;
	    public List<PhuTungThanhToan_027> lpttt;
	    public Date ngayHoaDon;
	    public String tenKhachHang;
	    public String thongTinKhacHoaDon;
	    public String trangThaiThanhToan;  // Thêm trạng thái thanh toán
	    public float tongGiaDichVu;  // Thêm tổng giá dịch vụ
	    public float tongGiaPhuTung;  // Thêm tổng giá phụ tùng
	    public float chietKhauPhanTram;  // Thêm chiết khấu (%)
	    public float chietKhauTien;  // Thêm chiết khấu tiền
	    public float thanhTien;  // Thêm thành tiền
	public HoaDon_027(String maHoaDon2, String maKhachHang2, String maNhanVien2, boolean tinhtrang, List<DichVuThanhToan_027> ldvtt,
			List<PhuTungThanhToan_027> lpttt, Date ngayHoaDon, String tenKhachHang, String thongTinKhacHoaDon,
			String trangThaiThanhToan, float tongGiaDichVu, float tongGiaPhuTung, float chietKhauPhanTram,
			float chietKhauTien, float thanhTien) {
		super();
		this.maHoaDon = maHoaDon2;
		this.maKhachHang = maKhachHang2;
		this.maNhanVien = maNhanVien2;
		this.tinhtrang = tinhtrang;
		this.ldvtt = ldvtt;
		this.lpttt = lpttt;
		this.ngayHoaDon = ngayHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.thongTinKhacHoaDon = thongTinKhacHoaDon;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.tongGiaDichVu = tongGiaDichVu;
		this.tongGiaPhuTung = tongGiaPhuTung;
		this.chietKhauPhanTram = chietKhauPhanTram;
		this.chietKhauTien = chietKhauTien;
		this.thanhTien = thanhTien;
	}

	public HoaDon_027(String maHoaDon, String maKhachHang, String maNhanVien, boolean tinhtrang, 
			String tenKhachHang, String thongTinKhacHoaDon, float tongGiaDichVu,
			float tongGiaPhuTung, float chietKhauPhanTram, float chietKhauTien, float thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.ldvtt = new DichVuThanhToanDAO_027().getListDVTTbyHoaDonid(maHoaDon);
		this.lpttt = new PhuTungThanhToanDAO_027().getListPTTTbyHoaDonid(maHoaDon);
		this.tinhtrang = tinhtrang;
		this.tenKhachHang = tenKhachHang;
		this.thongTinKhacHoaDon = thongTinKhacHoaDon;
		this.trangThaiThanhToan = tinhtrang?"Đã Thanh Toán":"Chưa Thanh Toán";
		this.tongGiaDichVu = tongGiaDichVu;
		this.tongGiaPhuTung = tongGiaPhuTung;
		this.chietKhauPhanTram = chietKhauPhanTram;
		this.chietKhauTien = chietKhauTien;
		this.thanhTien = thanhTien;
	}

	public HoaDon_027() {
		super();
	}

	public List<PhuTungThanhToan_027> getLpttt() {
		return lpttt;
	}

	public void setLpttt(List<PhuTungThanhToan_027> lpttt) {
		this.lpttt = lpttt;
	}

	public String getMaHoaDon() {
        return maHoaDon;
    }

    public List<DichVuThanhToan_027> getLdvtt() {
		return ldvtt;
	}

	public void setLdvtt(List<DichVuThanhToan_027> ldvtt) {
		this.ldvtt = ldvtt;
	}

	public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public java.sql.Date getNgayHoaDon() {
        return (java.sql.Date) ngayHoaDon;
    }
    public int getNgayHoaDonInt() {
        long timeInMilliseconds = ngayHoaDon.getTime();
        int ngayHoaDonInt = (int) (timeInMilliseconds / 1000);
        System.out.println(ngayHoaDonInt);
        return ngayHoaDonInt;
    }

    public void setNgayHoaDon(Date ngayHoaDon) {
        this.ngayHoaDon = ngayHoaDon;
    }
    
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getThongTinKhacHoaDon() {
        return thongTinKhacHoaDon;
    }

    public void setThongTinKhacHoaDon(String thongTinKhacHoaDon) {
        this.thongTinKhacHoaDon = thongTinKhacHoaDon;
    }

	public boolean isTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public float getTongGiaDichVu() {
        return tongGiaDichVu;
    }

    public void setTongGiaDichVu(float tongGiaDichVu) {
        this.tongGiaDichVu = tongGiaDichVu;
    }

    public float getTongGiaPhuTung() {
        return tongGiaPhuTung;
    }

    public void setTongGiaPhuTung(float tongGiaPhuTung) {
        this.tongGiaPhuTung = tongGiaPhuTung;
    }

    public float getChietKhauPhanTram() {
        return chietKhauPhanTram;
    }

    public void setChietKhauPhanTram(float chietKhauPhanTram) {
        this.chietKhauPhanTram = chietKhauPhanTram;
    }

    public float getChietKhauTien() {
        return chietKhauTien;
    }

    public void setChietKhauTien(float chietKhauTien) {
        this.chietKhauTien = chietKhauTien;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
	 public float calculateTongGiaDichVu() {
	        float tongGiaDichVu = 0;
	        if (ldvtt != null) {
	            for (DichVuThanhToan_027 dichVuThanhToan : ldvtt) {
	                tongGiaDichVu += dichVuThanhToan.getGia();
	            }
	        }
	        return tongGiaDichVu;
	    }

	    // Cập nhật phương thức tính tổng giá phụ tùng
	    public float calculateTongGiaPhuTung() {
	        float tongGiaPhuTung = 0;
	        if (lpttt != null) {
	            for (PhuTungThanhToan_027 phuTungThanhToan : lpttt) {
	                tongGiaPhuTung += phuTungThanhToan.getThanhTien();
	            }
	        }
	        return tongGiaPhuTung;
	    }

	    // Cập nhật phương thức tính thành tiền
	    public void calculateThanhTien() {
	        float tongGiaDichVu = calculateTongGiaDichVu();
	        float tongGiaPhuTung = calculateTongGiaPhuTung();
	        float chietKhauTien = getChietKhauTien();
	        float chietKhauPhanTram = getChietKhauPhanTram();

	        float thanhTien = tongGiaDichVu + tongGiaPhuTung - chietKhauTien;
	        float chietKhauTienTuongDuong = (thanhTien * chietKhauPhanTram) / 100;

	        setTongGiaDichVu(tongGiaDichVu);
	        setTongGiaPhuTung(tongGiaPhuTung);
	        setThanhTien(thanhTien - chietKhauTienTuongDuong);
	    }
	    public String getTenNV(String maNhanVien) {
	    	String tennv = new UserDAO_027().getTenVienById(maNhanVien);
	    	return tennv;
	    }
}
