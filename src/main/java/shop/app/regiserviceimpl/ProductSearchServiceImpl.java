package shop.app.regiserviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;


import shop.app.dao.ProductSearchServiceDAO;
import shop.app.dao.impl.ProductSearchServiceDAOImpl;
import shop.app.excep.BusinessException;
import shop.app.model.Customer;
import shop.app.model.Product;
import shop.app.regiservice.ProductSearchService;

public class ProductSearchServiceImpl implements ProductSearchService {
	private static Logger log = Logger.getLogger(ProductSearchServiceImpl.class);
	private ProductSearchServiceDAO productsearchservicedao=new ProductSearchServiceDAOImpl();
@Override
	public List<Product> getAllProducts(Product product) throws BusinessException {
		List<Product> products = null;
		try {
		products = productsearchservicedao.getAllProducts(product);
		System.out.println("Below are the available products");
		}catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		return products;
	}



@Override
	public Product getProductById(int pid) throws BusinessException {
		Product product=null;
		if(pid>0 || pid<30) {
			product=productsearchservicedao.getProductById(pid);
		}else {
			
			log.info("Invalid Product Id");
		}
		return product;
	}



@Override
	public List<Product> getProductByCompany(String pcompany) throws BusinessException {
		List<Product> productlist=null;
		try {
			productlist=productsearchservicedao.getProductByCompany(pcompany);
		}catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		return productlist;
	}


@Override
	public int addproduct(Product product) throws BusinessException {
		try {
			if(productsearchservicedao.addproduct(product)==1) {
				log.info(product);
			}
			
		}catch(BusinessException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact admin");
		}
		return 0;
	}


@Override
	public int deleteProductById(int pidd) throws BusinessException {
		try {
			if(productsearchservicedao.deleteProductById(pidd)==1) {
				log.info(pidd);
			}
		}catch(BusinessException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact admin");
		}
		return 0;
	}


@Override
	public List<Customer> getAllCustomerDetails(Customer customer) throws BusinessException {
		List<Customer> customers = null;
		try {
		customers = productsearchservicedao.getAllCustomerDetails(customer);
		System.out.println("Below are the available products");
		}catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		return customers;
	}


@Override
	public int updateProductByPrice(int pid, double pprice) throws BusinessException {
	if(pid!=0 && pid<30){		
			productsearchservicedao.updateProductByPrice(pid, pprice);
				log.info("Congrats Product Price Update Successfully");
			}
		else {
			log.info("Invalid Product Id");
		}

		return 0;
	}
}
















