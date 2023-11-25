package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DichVuDAO_027;
import dao.PhuTungDAO_027;
import model.*;

/**
 * Servlet implementation class XemDVPTServlet
 */
@WebServlet("/xemchitiet")
public class XemDVPTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public XemDVPTServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		// Get the ID parameter from the request
		String id = request.getParameter("id");
		// Set the detailed information as an attribute in the request
		// request.setAttribute("detailedInfo", detailedInfo);
		DichVu_027 services = new DichVuDAO_027().getDichVuById(id);
		PhuTung_027 phutungs = new PhuTungDAO_027().getPhuTungById(id);
		if (services.getId().equals(id)) {
			request.setAttribute("service", services);
			request.setAttribute("id", id);
		}
		if (phutungs.getId().equals(id)) {
			request.setAttribute("service", phutungs);
			request.setAttribute("id", id);
		}
		request.setAttribute("keyword", keyword);
		// Forward the request to the JSP page for displaying details
		request.getRequestDispatcher("/view/client/xemchitiet027.jsp").forward(request, response);
	}
}