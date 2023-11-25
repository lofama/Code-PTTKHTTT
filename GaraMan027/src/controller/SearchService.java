package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import model.*;

public class SearchService {
    // Giả sử có một lớp DichVu_027 và PhuTung_027 để thể hiện dịch vụ và phụ tùng


    // Hàm tìm kiếm dịch vụ
    public static List<DichVu_027> searchService(String keyword) {
    	DichVuDAO_027 x = new DichVuDAO_027();
    	List<DichVu_027> services = new ArrayList<>();
        List<DichVu_027> parts = new ArrayList<>();
		try {
			parts = x.getDataFromTable();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Kiểm tra xem keyword có giá trị là null hay không
		keyword = processKeyword(keyword);

        // Thực hiện logic tìm kiếm thực tế nếu cần
		for(DichVu_027 pt: parts) {
			if(pt.getId().toLowerCase().contains(keyword)||pt.getName().toLowerCase().contains(keyword)) {
				services.add(pt);
			}
		}

        return services;
    }

    public static List<PhuTung_027> searchPhuTung(String keyword) {
    	PhuTungDAO_027 x = new PhuTungDAO_027();
    	List<PhuTung_027> li = new ArrayList<>();
        List<PhuTung_027> parts = new ArrayList<>();
		try {
			parts = x.getDataFromTable();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyword = processKeyword(keyword);
        // Thực hiện logic tìm kiếm thực tế nếu cần
		for(PhuTung_027 pt: parts) {
			if(pt.getId().toLowerCase().contains(keyword.toLowerCase())||pt.getName().toLowerCase().contains(keyword.toLowerCase())) {
				li.add(pt);
			}
		}
		return li;
    }
    public static List<HoaDon_027> searchHoaDon(String keyword) throws SQLException {
        HoaDonDAO_027 hoaDonDAO = new HoaDonDAO_027();
        List<HoaDon_027> allHoaDon = hoaDonDAO.getAllHoaDon();
        List<HoaDon_027> matchingHoaDon = new ArrayList<>();

        keyword = processKeyword(keyword);

        for (HoaDon_027 hoaDon : allHoaDon) {
            if (hoaDon.getTenKhachHang().toLowerCase().contains(keyword.toLowerCase())) {
                matchingHoaDon.add(hoaDon);
            }
        }

        return matchingHoaDon;
    }

    // If needed, implement the processKeyword method

    private static String processKeyword(String keyword) {
        if (keyword == null) {
            return "";
        }
        return keyword.toLowerCase();
    }

}
