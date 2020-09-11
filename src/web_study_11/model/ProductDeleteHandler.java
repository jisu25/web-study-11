package web_study_11.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import web_study_11.dto.Product;
import web_study_11.service.ProductService;

@WebServlet("/productDelete.do")
public class ProductDeleteHandler extends HttpServlet {
	
	private ProductService service;
	
	@Override
	public void init() throws ServletException {
		service = new ProductService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("ProductDeleteHandler >> GET");

			int code = Integer.parseInt(request.getParameter("code").trim());
			Product pdt = service.getProduct(code);
			
			request.setAttribute("product", pdt);
			request.getRequestDispatcher("product/productDelete.jsp").forward(request, response);
			
		} else {
			System.out.println("ProductDeleteHandler >> POST");

			int code = Integer.parseInt(request.getParameter("code").trim());
			int res = service.deleteProduct(code); 

			request.getRequestDispatcher("productList.do").forward(request, response);
		}
	}
}