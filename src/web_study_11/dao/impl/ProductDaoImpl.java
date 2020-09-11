package web_study_11.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_study_11.dao.ProductDao;
import web_study_11.ds.JndiDs;
import web_study_11.dto.Product;
import web_study_11.exception.CustomSQLException;

public class ProductDaoImpl implements ProductDao {

	private static final ProductDaoImpl instance = new ProductDaoImpl();
	
	private Connection con;
	
	public void setCon(Connection con) {
		this.con = con;
	}

	public static ProductDaoImpl getInstance() {
		return instance;
	}

	private ProductDaoImpl() {
		this.con = JndiDs.getConnection();
	}
	
	
	
	@Override
	public List<Product> selectProductAll() {
		String sql = "SELECT * FROM PRODUCT ORDER BY CODE";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			if(rs.next()) {
				ArrayList<Product> list = new ArrayList<>();
				do {
					list.add(getProduct(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		//CODE, NAME, PRICE, PICTUREURL, DESCRIPTION
		int code = rs.getInt("CODE");
		String name = rs.getString("NAME");
		int price = rs.getInt("PRICE");
		String pictureUrl = rs.getString("PICTUREURL");
		String description = rs.getString("DESCRIPTION");
		
		return new Product(code, name, price, pictureUrl, description);
	}

	@Override
	public Product selectProductByCode(int code) {
		String sql = "SELECT * FROM PRODUCT WHERE CODE = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, code);
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getProduct(rs);
				}
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	
	@Override
	public int insertProduct(Product pdt) {
		String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			int code = pdt.getCode();
			if(code == 0) {
				pstmt.setString(1, null);
			} else {
				pstmt.setInt(1, pdt.getCode());
			}
			
			pstmt.setString(2, pdt.getName());
			pstmt.setInt(3, pdt.getPrice());
			pstmt.setString(4, pdt.getPictureUrl());
			pstmt.setString(5, pdt.getDescription());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	
	@Override
	public int updateProduct(Product pdt) {
		String sql = "UPDATE PRODUCT SET NAME = ?, PRICE = ?, PICTUREURL = ?, DESCRIPTION = ? WHERE CODE = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, pdt.getName());
			pstmt.setInt(2, pdt.getPrice());
			pstmt.setString(3, pdt.getPictureUrl());
			pstmt.setString(4, pdt.getDescription());
			pstmt.setInt(5, pdt.getCode());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}


	@Override
	public int deleteProduct(int code) {
		//CODE, NAME, PRICE, PICTUREURL, DESCRIPTION
		
		String sql = "DELETE PRODUCT WHERE CODE = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, code);			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}


}
