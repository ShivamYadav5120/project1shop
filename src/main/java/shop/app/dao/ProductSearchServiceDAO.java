package shop.app.dao;

import java.util.List;

import shop.app.excep.BusinessException;
import shop.app.model.Customer;
import shop.app.model.Product;

public interface ProductSearchServiceDAO {
	 public List<Product> getAllProducts(Product product) throws BusinessException;
	 public Product getProductById(int pid) throws BusinessException;
	 public List<Product> getProductByCompany(String pcompany) throws BusinessException;
	 public int addproduct(Product product) throws BusinessException;
	 public int deleteProductById(int pidd) throws BusinessException;
	 public List<Customer> getAllCustomerDetails(Customer customer) throws BusinessException;
	 public int updateProductByPrice(int pid, double pprice) throws BusinessException; 
	 }
