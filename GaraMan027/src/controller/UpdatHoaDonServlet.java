package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HoaDonDAO_027;
import model.HoaDon_027;

/**
 * Servlet implementation class UpdatHoaDonServlet
 */
@WebServlet("/updatehoadon")
public class UpdatHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatHoaDonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// Lấy thông tin từ request
		String keyword = request.getParameter("keyword");
		String maHoaDon = request.getParameter("maHoaDon");
		String maNhanVien = request.getParameter("maNhanVien");
		String tinhTrangParam = request.getParameter("tinhtrang");
String ThongTinKhacHoaDon = request.getParameter("ghichu");
		boolean tinhtrang;

		// Kiểm tra giá trị của "Tình trạng" và đặt giá trị cho trangThaiThanhToan
		if ("Đã Thanh toán".equals(tinhTrangParam)) {
			tinhtrang = true;
		} else if ("Chưa Thanh Toán".equals(tinhTrangParam)) {
			tinhtrang = false;
		} else {
			// Xử lý trường hợp giá trị không hợp lệ nếu cần
			tinhtrang = false; // hoặc có thể gán giá trị mặc định khác
		}
		String tenKhachHang = request.getParameter("tenKhachHang");
		float tongGiaDichVu = Float.parseFloat(request.getParameter("tongGiaDichVu"));
		float tongGiaPhuTung = Float.parseFloat(request.getParameter("tongGiaPhuTung"));
		float chietKhauPhanTram = Float.parseFloat(request.getParameter("chietKhauPhanTram"));
//		System.out.println("Tình trạng: " +chietKhauPhanTram);
		// Tính các giá trị khác dựa trên thông tin mới
		float chietKhauTien = (chietKhauPhanTram / 100) * (tongGiaDichVu + tongGiaPhuTung);
		float thanhTien = (float) ((1.0 - chietKhauPhanTram / 100) * (tongGiaDichVu + tongGiaPhuTung));

		// Tạo đối tượng HoaDon và set thông tin mới
		HoaDon_027 hoaDon = new HoaDon_027();
		hoaDon.setMaHoaDon(maHoaDon);
		hoaDon.setTinhtrang(tinhtrang);
		hoaDon.setMaNhanVien(maNhanVien);
		hoaDon.setTenKhachHang(tenKhachHang);
		hoaDon.setTongGiaDichVu(tongGiaDichVu);
		hoaDon.setTrangThaiThanhToan(tinhTrangParam);
//		hoaDon.setNgayHoaDon(ngayHoaDon);
		hoaDon.setThongTinKhacHoaDon(ThongTinKhacHoaDon);
		hoaDon.setTongGiaPhuTung(tongGiaPhuTung);
		hoaDon.setChietKhauPhanTram(chietKhauPhanTram);
		hoaDon.setChietKhauTien(chietKhauTien);
		hoaDon.setThanhTien(thanhTien);
		// Gọi DAO để cập nhật hóa đơn trong cơ sở dữ liệu
		HoaDonDAO_027 hdDAO = new HoaDonDAO_027();
		hdDAO.updateHoaDon(hoaDon);
		String url = "XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword;
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
//		// Nếu cập nhật thành công, có thể thực hiện các hành động khác, ví dụ: chuyển
//request.getRequestDispatcher(url).forward(request, response);
//				response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<script type=\"text/javascript\">");
//		out.println("function showResultAndRedirect() {");
//		out.println("  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
//		out.println("  alert('Đã lưu hóa đơn thành công');");
//		out.println("}");
//		out.println("</script>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<script type=\"text/javascript\">");
//		out.println("showResultAndRedirect();");
//		out.println("</script>");
//		out.println("</body>");
//		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// Lấy thông tin từ request
		String keyword = request.getParameter("keyword");
		String maHoaDon = request.getParameter("maHoaDon");
		String maNhanVien = request.getParameter("maNhanVien");
		String tinhTrangParam = request.getParameter("tinhtrang");
String ThongTinKhacHoaDon = request.getParameter("ghichu");
		boolean tinhtrang;

		// Kiểm tra giá trị của "Tình trạng" và đặt giá trị cho trangThaiThanhToan
		if ("Đã Thanh toán".equals(tinhTrangParam)) {
			tinhtrang = true;
		} else if ("Chưa Thanh Toán".equals(tinhTrangParam)) {
			tinhtrang = false;
		} else {
			// Xử lý trường hợp giá trị không hợp lệ nếu cần
			tinhtrang = false; // hoặc có thể gán giá trị mặc định khác
		}
		String tenKhachHang = request.getParameter("tenKhachHang");
		float tongGiaDichVu = Float.parseFloat(request.getParameter("tongGiaDichVu"));
		float tongGiaPhuTung = Float.parseFloat(request.getParameter("tongGiaPhuTung"));
		float chietKhauPhanTram = Float.parseFloat(request.getParameter("chietKhauPhanTram"));
//		System.out.println("Tình trạng: " +chietKhauPhanTram);
		// Tính các giá trị khác dựa trên thông tin mới
		float chietKhauTien = (chietKhauPhanTram / 100) * (tongGiaDichVu + tongGiaPhuTung);
		float thanhTien = (float) ((1.0 - chietKhauPhanTram / 100) * (tongGiaDichVu + tongGiaPhuTung));

		// Tạo đối tượng HoaDon và set thông tin mới
		HoaDon_027 hoaDon = new HoaDon_027();
		hoaDon.setMaHoaDon(maHoaDon);
		hoaDon.setTinhtrang(tinhtrang);
		hoaDon.setTenKhachHang(tenKhachHang);
		hoaDon.setMaNhanVien(maNhanVien);
		hoaDon.setTongGiaDichVu(tongGiaDichVu);
		hoaDon.setTrangThaiThanhToan(tinhTrangParam);
//		hoaDon.setNgayHoaDon(ngayHoaDon);
		hoaDon.setThongTinKhacHoaDon(ThongTinKhacHoaDon);
		hoaDon.setTongGiaPhuTung(tongGiaPhuTung);
		hoaDon.setChietKhauPhanTram(chietKhauPhanTram);
		hoaDon.setChietKhauTien(chietKhauTien);
		hoaDon.setThanhTien(thanhTien);
		// Gọi DAO để cập nhật hóa đơn trong cơ sở dữ liệu
		HoaDonDAO_027 hdDAO = new HoaDonDAO_027();
		hdDAO.updateHoaDon(hoaDon);
		String url = "XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword;
		System.out.println("Key: "+keyword+" ủl"+url);
		request.getRequestDispatcher(url).forward(request, response);
//		// Nếu cập nhật thành công, có thể thực hiện các hành động khác, ví dụ: chuyển
//request.getRequestDispatcher(url).forward(request, response);
//				response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<script type=\"text/javascript\">");
//		out.println("function showResultAndRedirect() {");
//		out.println("  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
//		out.println("  alert('Đã lưu hóa đơn thành công');");
//		out.println("}");
//		out.println("</script>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<script type=\"text/javascript\">");
//		out.println("showResultAndRedirect();");
//		out.println("</script>");
//		out.println("</body>");
//		out.println("</html>");
	}
}
