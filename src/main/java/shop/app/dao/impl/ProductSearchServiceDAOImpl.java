package shop.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import shop.app.dao.ProductSearchServiceDAO;
import shop.app.dao.dbutil.MySqlDbConnection;
import shop.app.excep.BusinessException;
import shop.app.model.Customer;
import shop.app.model.Product;

public class ProductSearchServiceDAOImpl implements ProductSearchServiceDAO {
	private static Logger log = Logger.getLogger(ProductSearchServiceDAOImpl.class);
	
	
@Override
	 public List<Product> getAllProducts(Product product) throws BusinessException{
		List<Product> products=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select pid,pname,pcompany,prating,pprice from shop_project.product_details";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				product=new Product();
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setPcompany(resultSet.getString("pcompany"));
				product.setPrating(resultSet.getFloat("prating"));
				product.setPprice(resultSet.getDouble("pprice"));
				products.add(product);
				
		
		}
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Errored Occured");
		}
		
		return products;
	}


@Override
	public Product getProductById(int pid) throws BusinessException {
		Product product=null;
		try(Connection connection=MySqlDbConnection.getConnection()) {
			String sql="select pid,pname,pcompany,prating,pprice from shop_project.product_details where pid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, pid);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				product=new Product();
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setPcompany(resultSet.getString("pcompany"));
				product.setPrating(resultSet.getFloat("prating"));
				product.setPprice(resultSet.getDouble("pprice"));	
			}else {
				throw new BusinessException("Sorry This Product id " + pid + " Not Found");
			}
			
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Errored Occured");
		}
		
		return product;
	}


@Override
	public List<Product> getProductByCompany(String pcompany) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()) {
			String sql="select pid,pname,pcompany,prating,pprice from shop_project.product_details where pcompany=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, pcompany);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Product product=new Product();
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setPcompany(resultSet.getString("pcompany"));
				product.setPrating(resultSet.getFloat("prating"));
				product.setPprice(resultSet.getDouble("pprice"));
				productList.add(product);
			}else {
				throw new BusinessException("Sorry... This Product Company " + pcompany + " Not Found");
			}
			
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Errored Occured");
		}
		return productList;
	}



@Override
	public int addproduct(Product product) throws BusinessException {
		int h=0;
		try(Connection connection=MySqlDbConnection.getConnection()) {
			String sql="insert into shop_project.product_details(pname,pcompany,prating,pprice) values (?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1,product.getPname());
			preparedStatement.setString(2,product.getPcompany());
			preparedStatement.setFloat(3,product.getPrating());
			preparedStatement.setDouble(4,product.getPprice());
			
			h=preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Errored Occured");
		}
		return h;
	}
 

@Override
   public int deleteProductById(int pidd) throws BusinessException {
	int c=0;	
	try(Connection connection=MySqlDbConnection.getConnection()) {
		String sql="delete from shop_project.product_details where pid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,pidd);
		c=preparedStatement.executeUpdate();
	}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Errored Occured");
		}
		return c;
	}


@Override
	public List<Customer> getAllCustomerDetails(Customer customer) throws BusinessException {
		List<Customer> customers=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
	    String sql="select cid,cfirstname,clastname,cemail,cpassword from shop_project.costomer_regis";	
	    PreparedStatement preparedStatement=connection.prepareStatement(sql);
	    
	    ResultSet resultSet=preparedStatement.executeQuery();
	    
	    while(resultSet.next()) {
	    	customer=new Customer();
	    	customer.setCid(resultSet.getInt("cid"));
	    	customer.setCfirstname(resultSet.getString("cfirstname"));
	    	customer.setClastname(resultSet.getString("clastname"));
	    	customer.setCemail(resultSet.getString("cemail"));
	    	customer.setPassword(resultSet.getString("cpassword"));
	    	customers.add(customer);
	     }
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Errored Occured");
		}
		return customers;
	}


@Override
public int updateProductByPrice(int pid, double pprice) throws BusinessException {
	int u=0;
	try(Connection connection=MySqlDbConnection.getConnection()){
		String sql="update shop_project.product_details set pprice=? where pid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setDouble(1, pprice);
		preparedStatement.setInt(2, pid);
		
		u=preparedStatement.executeUpdate();
	}catch(ClassNotFoundException | SQLException e) {
		System.out.println(e);
		throw new BusinessException("Internal Errored Occured");
	}
	
	return u;
}

}




































