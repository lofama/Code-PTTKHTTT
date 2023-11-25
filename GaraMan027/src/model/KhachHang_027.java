package model;

import java.util.List;

public class KhachHang_027 extends User_027{
public String id;
public List<Oto_027> ListOto;
public List<Lichhen_027> ListLichhen;

public List<Oto_027> getListOto() {
	return ListOto;
}

public void setListOto(List<Oto_027> listOto) {
	ListOto = listOto;
}

public List<Lichhen_027> getListLichhen() {
	return ListLichhen;
}

public void setListLichhen(List<Lichhen_027> listLichhen) {
	ListLichhen = listLichhen;
}

public KhachHang_027(String id) {
	super();
	this.id = id;
}

public KhachHang_027() {
	super();
	// TODO Auto-generated constructor stub
}
public KhachHang_027(String id,String email, String password, String name, String diachi, String sdt) {
    super(email, password, name, diachi, sdt);
    this.id = id;
}
public KhachHang_027(String email, String password, String name, String diachi, String sdt) {
	super(email, password, name, diachi, sdt);
	// TODO Auto-generated constructor stub
}

public KhachHang_027(String email, String password, String name) {
	super(email, password, name);
	// TODO Auto-generated constructor stub
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

}
