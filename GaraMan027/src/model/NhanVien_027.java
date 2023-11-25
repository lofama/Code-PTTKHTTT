package model;

public class NhanVien_027 extends User_027 {
    public String id;
    public String chucvu;

    public NhanVien_027() {
    }

    public NhanVien_027(String id,String email, String password, String name, String diachi, String sdt, String chucvu) {
        super(email, password, name, diachi, sdt);
        this.id = id;
        this.chucvu = chucvu;
    }

    public NhanVien_027(String email, String password, String name) {
        super(email, password, name);
    }

    public String getChucvu() {
        return chucvu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
