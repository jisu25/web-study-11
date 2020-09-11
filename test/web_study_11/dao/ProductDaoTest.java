package web_study_11.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_11.dao.impl.ProductDaoImpl;
import web_study_11.ds.JdbcUtil;
import web_study_11.dto.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {

	private static Connection con;
	private static ProductDaoImpl dao;
	
	@BeforeClass
	public static void setUpBeforClass() throws Exception {
		con = JdbcUtil.getConnection(); 
		dao = ProductDaoImpl.getInstance();
		dao.setCon(con);
	}
	
	@Test
	public void testSelectProductAll() {
		System.out.println("SelectProductAll()");
		List<Product> list = dao.selectProductAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectProductByCode() {
		System.out.println("SelectProductByCode()");
		Product pdt = dao.selectProductByCode(1);
		Assert.assertNotNull(pdt);
		System.out.println(pdt);
	}

	@Test
	public void test01InsertProduct() {
		System.out.println("InsertProduct()");
		Product pdt = new Product(10, "ㅎㅇ", 200000, "hi.jpg", "라라랑");
		int res = dao.insertProduct(pdt);
		Assert.assertEquals(1, res);
		System.out.println(pdt);
	}

	@Test
	public void test02UpdateProduct() {
		System.out.println("UpdateProduct()");
		Product pdt = new Product(10, "얼레벌레", 200000, "hi.jpg", "라라랑");
		int res = dao.updateProduct(pdt);
		Assert.assertEquals(1, res);
		System.out.println(pdt);
	}

	@Test
	public void test03DeleteProduct() {
		System.out.println("DeleteProduct()");
		int res = dao.deleteProduct(10);
		Assert.assertEquals(1, res);
		System.out.println("삭제했습니다.");
	}
}
