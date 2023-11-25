package model;

public class User_027 {
public String email;
public String password;
public String ngaysinh;
public String getNgaysinh() {
	return ngaysinh;
}

public void setNgaysinh(String ngaysinh) {
	this.ngaysinh = ngaysinh;
}
public String name;
public String diachi;
public String sdt;
public User_027() {
	// TODO Auto-generated constructor stub
}

public User_027(String email, String password, String name) {
	this.email = email;
	this.password = password;
	this.name = name;
}
public User_027(String email, String password, String name,String diachi, String sdt) {
	this.email = email;
	this.password = password;
	this.name = name;
	this.diachi = diachi;
	this.sdt = sdt;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}


}
