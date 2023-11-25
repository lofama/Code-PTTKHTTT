package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HoaDonDAO_027;
import model.HoaDon_027;

/**
 * Servlet implementation class TimHoaDonServlet
 */
@WebServlet("/timhoadon")
public class TimHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimHoaDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");

        // Gọi hàm tìm kiếm dịch vụ và phụ tùng dựa trên keyword
        // Assume có hai danh sách kết quả là services và parts
        // Thực tế, bạn cần thay thế các dòng này bằng logic thực tế của ứng dụng.

        // Giả sử có một hàm tìm kiếmService trả về danh sách dịch vụ
        List<HoaDon_027> hoaDons = null;
		hoaDons = (new HoaDonDAO_027()).timHoaDonByTenKH(keyword);

        // Đưa kết quả vào request để hiển thị trên trang kết quả
        request.setAttribute("hoaDons", hoaDons);
		request.setAttribute("keyword", keyword);
        // Chuyển hướng đến trang kết quả
        request.getRequestDispatcher("view/seller/timhoadon027.jsp").forward(request, response);
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    String keyword = request.getParameter("keyword");
    // Giả sử có một hàm tìm kiếmService trả về danh sách dịch vụ
    List<HoaDon_027> hoaDons = null;
		hoaDons = new HoaDonDAO_027().get20HoaDon();
    // Đưa kết quả vào request để hiển thị trên trang kết quả
    request.setAttribute("hoaDons", hoaDons);
	request.setAttribute("keyword", keyword);
    // Chuyển hướng đến trang kết quả
    request.getRequestDispatcher("view/seller/timhoadon027.jsp").forward(request, response);
}
}
