package model;

import dao.DichVuDAO_027;
import dao.DichVuThanhToanDAO_027;
import dao.UserDAO_027;

public class DichVuThanhToan_027 {
    public String idDvTT;
    public String idDV;
    public String idNV;
    public String tenNV;
    public DichVu_027 dichvu;
    public float gia;
    public String maHoaDon;
    public DichVuThanhToan_027(String idDvTT, String idDV, String tenNV, float gia,String maHoaDon, String idNV) {
        this.idDvTT = idDvTT;
        this.idDV = idDV;
        this.dichvu = new DichVuDAO_027().getDichVuById(idDV);this.dichvu = new DichVuDAO_027().getDichVuById(idDV);
        this.tenNV = tenNV;
        this.gia = gia;
        this.maHoaDon=maHoaDon;
        this.idNV = idNV;
    }

    public DichVuThanhToan_027(String idDV, String idNV, String maHoaDon) {
		this.idDvTT = new DichVuThanhToanDAO_027().generateServiceCode();
		this.idDV = idDV;
		this.idNV = idNV;
		this.dichvu = new DichVuDAO_027().getDichVuById(idDV);
		this.maHoaDon = maHoaDon;
		this.tenNV = new UserDAO_027().getTenVienById(idNV);
		this.gia = (new DichVuDAO_027().getDichVuById(idDV)).getGiaThanh();
	}

	public String getIdNV() {
		return idNV;
	}

	public void setIdNV(String idNV) {
		this.idNV = idNV;
	}

	public String getIdDvTT() {
        return idDvTT;
    }

    public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public void setIdDvTT(String idDvTT) {
        this.idDvTT = idDvTT;
    }

    public String getIdDV() {
        return idDV;
    }

    public void setIdDV(String idDV) {
        this.idDV = idDV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    public String getTenDV() {
    	String tennv = new DichVuDAO_027().getTenDichVuById(idDV);
    	return tennv;
    }
}
