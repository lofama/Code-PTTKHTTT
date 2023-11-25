package model;

import dao.PhuTungDAO_027;
import dao.PhuTungThanhToanDAO_027;

public class PhuTungThanhToan_027 {
    public String idPhuTungTT;
    public int soLuong;
    public PhuTung_027 phutung;
    public float thanhTien;
    public String maHoaDon;  // Thêm trường liên kết với HoaDon
    public String maPhuTung; // Thêm trường liên kết với PhuTung

    public PhuTungThanhToan_027() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor
    public PhuTungThanhToan_027(String idPhuTungTT, int soLuong, String maHoaDon, String maPhuTung) {
        this.idPhuTungTT = idPhuTungTT;
        this.soLuong = soLuong;
        this.phutung = new PhuTungDAO_027().getPhuTungById(maPhuTung);
        this.maHoaDon = maHoaDon;  // Gán giá trị cho trường maHoaDon
        this.maPhuTung = maPhuTung;  // Gán giá trị cho trường maPhuTung
        this.thanhTien = calculateThanhTien(soLuong);
    }
    public PhuTungThanhToan_027(String idPhuTungTT, int soLuong,float thanhTien, String maHoaDon, String maPhuTung) {
        this.idPhuTungTT = idPhuTungTT;
        this.soLuong = soLuong;
        this.maHoaDon = maHoaDon;  // Gán giá trị cho trường maHoaDon
        this.maPhuTung = maPhuTung;  // Gán giá trị cho trường maPhuTung
        this.thanhTien = thanhTien;
    }
    public PhuTungThanhToan_027(String maPhuTung,int soLuong, String maHoaDon) {
        this.idPhuTungTT = new PhuTungThanhToanDAO_027().generateServiceCode();
        this.soLuong = soLuong;
        this.maHoaDon = maHoaDon;  // Gán giá trị cho trường maHoaDon
        this.maPhuTung = maPhuTung;  // Gán giá trị cho trường maPhuTung
        this.thanhTien = calculateThanhTien(soLuong);
    }
    // Getter và Setter
    public String getIdPhuTungTT() {
        return idPhuTungTT;
    }

    public void setIdPhuTungTT(String idPhuTungTT) {
        this.idPhuTungTT = idPhuTungTT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = calculateThanhTien(soLuong);
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaPhuTung() {
        return maPhuTung;
    }

    public void setMaPhuTung(String maPhuTung) {
        this.maPhuTung = maPhuTung;
    }
    public String getTenPT() {
    	String tenPT = new PhuTungDAO_027().getTenPhuTungById(maPhuTung);
    	return tenPT;
    }
    // Phương thức tính thành tiền
    private float calculateThanhTien(int soluong) {
      float tt = (new PhuTungDAO_027().getGiaPhuTungById(maPhuTung))*soluong;
      return tt; // Replace with your calculation logic
    }
}
