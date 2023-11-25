package model;

public class DichVu_027 {
    public String id;
    public String name;
    public String description;
    public float giathanh;

    public DichVu_027(String id, String name, String description, float giathanh) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.giathanh = giathanh;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getGiaThanh() {
        return giathanh;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
}
