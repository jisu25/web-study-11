package web_study_11.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import web_study_11.dto.Product;
import web_study_11.service.ProductService;

@WebServlet("/productList.do")
public class ProductListHandler extends HttpServlet {

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
			/*
			List<Product> list = service.showProducts();
			request.setAttribute("productList", list);
			*/
			request.getRequestDispatcher("product/productList.jsp").forward(request, response);
		} else {
			System.out.println("ProductDeleteHandler >> POST");
			
			List<Product> list = service.showProducts();
			request.setAttribute("productList", list);
			
			Gson gson = new Gson();
			String listJson = gson.toJson(list, new TypeToken<List<Product>>(){}.getType());
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("Application/json");
			
			response.getWriter().print(listJson);
		}

	}
}