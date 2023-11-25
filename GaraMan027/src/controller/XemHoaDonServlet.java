package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.*;

/**
 * Servlet implementation class XemHoaDon
 */
@WebServlet("/XemHoaDon")
public class XemHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemHoaDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		String maHoaDon = request.getParameter("maHoaDon");
        String keyword = request.getParameter("keyword");
        request.setAttribute("keyword", keyword);
	    if (maHoaDon == null || maHoaDon.isEmpty()) {
	        // Chuyển hướng đến servlet timhoadon với phương thức POST và truyền từ khóa
	        response.sendRedirect(request.getContextPath() + "/timhoadon");
	        return; // Kết thúc phương thức để ngăn tiếp tục xử lý
	    }
		HoaDon_027 hoaDon = new HoaDon_027();
		PhuTungThanhToanDAO_027 ptttDAO = new PhuTungThanhToanDAO_027();
		List<PhuTungThanhToan_027> lipttt = ptttDAO.getListPTTTbyHoaDonid(maHoaDon);
		float tongpt = 0;
		for(PhuTungThanhToan_027 i : lipttt) {
			tongpt+=i.getThanhTien();
		}
		request.setAttribute("parts", lipttt);
		DichVuThanhToanDAO_027 dvttDAO = new DichVuThanhToanDAO_027();
		List<DichVuThanhToan_027> lidvtt = dvttDAO.getListDVTTbyHoaDonid(maHoaDon);
		float tongdv = 0;
		for(DichVuThanhToan_027 i : lidvtt) {
			tongdv += i.gia;
		}
		request.setAttribute("services", lidvtt);
		HoaDonDAO_027 hdDAO = new HoaDonDAO_027();
		hoaDon = hdDAO.getHoaDonByID(maHoaDon);
		hoaDon.setTongGiaDichVu(tongdv);
		hoaDon.setTongGiaPhuTung(tongpt);
		hoaDon.setThanhTien((float)((1.0-hoaDon.chietKhauPhanTram/100)*(tongdv+tongpt)));
		request.setAttribute("hoaDon", hoaDon);
		List<NhanVien_027> listnv = new UserDAO_027().getNhanVien();
		request.setAttribute("listNV", listnv);
		List<DichVu_027> lidv = new ArrayList<DichVu_027>();
		try {
			lidv = new DichVuDAO_027().getDataFromTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listDV", lidv);
		List<PhuTung_027> lipt = new ArrayList<>();
		try {
			lipt = new PhuTungDAO_027().getDataFromTable();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listPT", lipt);
		request.getRequestDispatcher("view/seller/xemchitiethoadon027.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		String maHoaDon = request.getParameter("maHoaDon");
        String keyword = request.getParameter("keyword");
        request.setAttribute("keyword", keyword);
	    if (maHoaDon == null || maHoaDon.isEmpty()) {
	        // Chuyển hướng đến servlet timhoadon với phương thức POST và truyền từ khóa
	        response.sendRedirect(request.getContextPath() + "/timhoadon");
	        return; // Kết thúc phương thức để ngăn tiếp tục xử lý
	    }
		HoaDon_027 hoaDon = new HoaDon_027();
		PhuTungThanhToanDAO_027 ptttDAO = new PhuTungThanhToanDAO_027();
		List<PhuTungThanhToan_027> lipttt = ptttDAO.getListPTTTbyHoaDonid(maHoaDon);
		float tongpt = 0;
		for(PhuTungThanhToan_027 i : lipttt) {
			tongpt+=i.getThanhTien();
		}
		request.setAttribute("parts", lipttt);
		DichVuThanhToanDAO_027 dvttDAO = new DichVuThanhToanDAO_027();
		List<DichVuThanhToan_027> lidvtt = dvttDAO.getListDVTTbyHoaDonid(maHoaDon);
		float tongdv = 0;
		for(DichVuThanhToan_027 i : lidvtt) {
			tongdv += i.gia;
		}
		request.setAttribute("services", lidvtt);
		HoaDonDAO_027 hdDAO = new HoaDonDAO_027();
		hoaDon = hdDAO.getHoaDonByID(maHoaDon);
		hoaDon.setTongGiaDichVu(tongdv);
		hoaDon.setTongGiaPhuTung(tongpt);
		request.setAttribute("hoaDon", hoaDon);
		List<NhanVien_027> listnv = new UserDAO_027().getNhanVien();
		request.setAttribute("listNV", listnv);
		List<DichVu_027> lidv = new ArrayList<DichVu_027>();
		try {
			lidv = new DichVuDAO_027().getDataFromTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listDV", lidv);
		List<PhuTung_027> lipt = new ArrayList<>();
		try {
			lipt = new PhuTungDAO_027().getDataFromTable();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listPT", lipt);
		request.getRequestDispatcher("view/seller/xemchitiethoadon027.jsp").forward(request, response);
	}
}
