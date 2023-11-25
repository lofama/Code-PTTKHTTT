package model;

public class PhuTung_027 {
	public String id;
	public String name;
	public String description;
	public float giathanh;

    public PhuTung_027(String id, String name, String description, float giathanh) {
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

	public float getGiathanh() {
		return giathanh;
	}

	public void setGiathanh(float giathanh) {
		this.giathanh = giathanh;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
