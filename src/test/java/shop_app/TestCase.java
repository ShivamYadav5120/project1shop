package shop_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import shop.app.dao.CustomerLoginCheckDAO;
import shop.app.dao.CustomerRegiServiceDAO;
import shop.app.dao.ProductSearchServiceDAO;
import shop.app.dao.impl.CustomerLoginCheckDAOImpl;
import shop.app.dao.impl.CustomerRegiServiceDAOImpl;
import shop.app.dao.impl.ProductSearchServiceDAOImpl;
import shop.app.excep.BusinessException;
import shop.app.model.Customer;
import shop.app.model.Product;
import shop.app.regiservice.CustomerRegiService;
import shop.app.regiservice.ProductSearchService;
import shop.app.regiserviceimpl.CustomerRegiServiceImpl;
import shop.app.regiserviceimpl.ProductSearchServiceImpl;

public class TestCase {
	CustomerLoginCheckDAO customerLoginCheckDAO=new CustomerLoginCheckDAOImpl();
	CustomerRegiServiceDAO customerRegiServiceDAO=new CustomerRegiServiceDAOImpl();
	ProductSearchServiceDAO productSearchServiceDAO = new ProductSearchServiceDAOImpl();
	
	//Test For Get Product By COMPANY  
	//@Test
	/*public void test1() throws BusinessException {
		
		assertNotNull(productSearchServiceDAO .getProductByCompany("VOLTAS"));
	}*/
	//Test For Get Product By ID
	@Test
	public void test2() throws BusinessException {
		assertNotNull(productSearchServiceDAO .getProductById(8));
	}
	
	//Test For Update Product Price 
	@Test
	public void test3() throws BusinessException {
		assertNotNull(productSearchServiceDAO .updateProductByPrice(8, 222222));
	}
	
	//Test For Delete Product By ID
	@Test
	public void test4() throws BusinessException {
		assertNotNull(productSearchServiceDAO .deleteProductById(7));
		
	}
	
	//Test For Add Product In Database
	@Test
	public void test5() throws BusinessException {
		Product product=new Product(9,"Keyboard", "Dell", 4.8f, 800);
		assertEquals(1,productSearchServiceDAO.addproduct(product));
	}
	
	//Test For Create Account
	//@Test
	/*public void test6() throws BusinessException {
		Customer customer=new Customer(3, "Sangam","Umbarkar","Sangam@gmail.com","sangam123");
		assertEquals(1,customerRegiServiceDAO.createAccount(customer));
	}*/
	//
	@Test
	public void test7() throws BusinessException {
		assertNotNull(customerLoginCheckDAO.customerLogin("shivam@gmail.com","shivam123"));
	}
	
 
   

}
