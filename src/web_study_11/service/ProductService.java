package web_study_11.service;

import java.util.List;

import web_study_11.dao.ProductDao;
import web_study_11.dao.impl.ProductDaoImpl;
import web_study_11.dto.Product;

public class ProductService {

	private ProductDao dao = ProductDaoImpl.getInstance();
	
	public List<Product> showProducts() {
		return dao.selectProductAll();
	}
	
	public Product getProduct(int code) {
		return dao.selectProductByCode(code);
	}
	
	public int addProduct(Product pdt) {
		return dao.insertProduct(pdt);
	}
	
	public int modifyProduct(Product pdt) {
		return dao.updateProduct(pdt);
	}
	
	public int deleteProduct(int code) {
		return dao.deleteProduct(code);
	}
}
