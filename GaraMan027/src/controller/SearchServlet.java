package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DichVuDAO_027;
import dao.PhuTungDAO_027;
import model.*;

@WebServlet
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");

        // Gọi hàm tìm kiếm dịch vụ và phụ tùng dựa trên keyword
        // Assume có hai danh sách kết quả là services và parts
        // Thực tế, bạn cần thay thế các dòng này bằng logic thực tế của ứng dụng.

        // Giả sử có một hàm tìm kiếmService trả về danh sách dịch vụ
        List<DichVu_027> services = new DichVuDAO_027().SearchDichVu(keyword);

        // Giả sử có một hàm tìm kiếmPhuTung trả về danh sách phụ tùng
        List<PhuTung_027> parts = new PhuTungDAO_027().searchPhuTung(keyword);

        // Đưa kết quả vào request để hiển thị trên trang kết quả
        request.setAttribute("services", services);
        request.setAttribute("parts", parts);
		request.setAttribute("keyword", keyword);
        // Chuyển hướng đến trang kết quả
        request.getRequestDispatcher("view/client/search027.jsp").forward(request, response);
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    String keyword = "";

    // Gọi hàm tìm kiếm dịch vụ và phụ tùng dựa trên keyword
    // Assume có hai danh sách kết quả là services và parts
    // Thực tế, bạn cần thay thế các dòng này bằng logic thực tế của ứng dụng.

    // Giả sử có một hàm tìm kiếmService trả về danh sách dịch vụ
    List<DichVu_027> services = new DichVuDAO_027().SearchDichVu(keyword);

    // Giả sử có một hàm tìm kiếmPhuTung trả về danh sách phụ tùng
    List<PhuTung_027> parts = new PhuTungDAO_027().searchPhuTung(keyword);

    // Đưa kết quả vào request để hiển thị trên trang kết quả
    request.setAttribute("services", services);
    request.setAttribute("parts", parts);
	request.setAttribute("keyword", keyword);
    // Chuyển hướng đến trang kết quả
    request.getRequestDispatcher("view/client/search027.jsp").forward(request, response);
}
}
