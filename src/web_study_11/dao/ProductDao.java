package web_study_11.dao;

import java.util.List;

import web_study_11.dto.Product;

public interface ProductDao {

	List<Product> selectProductAll();
	
	Product selectProductByCode(int code);
	
	int insertProduct(Product pdt);
	
	int updateProduct(Product pdt);
	
	int deleteProduct(int code);
	
//	int confirmId(String userId);
	
//	int userCheck(String userId, String pwd);
	
}
