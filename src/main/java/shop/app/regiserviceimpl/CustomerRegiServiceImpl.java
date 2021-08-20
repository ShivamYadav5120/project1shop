package shop.app.regiserviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import shop.app.excep.BusinessException;
import shop.app.model.Customer;
import shop.app.regiservice.CustomerRegiService;
import shop.app.dao.CustomerRegiServiceDAO;
import shop.app.dao.dbutil.MySqlDbConnection;
import shop.app.dao.impl.CustomerRegiServiceDAOImpl;

public class CustomerRegiServiceImpl implements CustomerRegiService  {
	private static Logger log = Logger.getLogger(CustomerRegiServiceImpl.class);
	CustomerRegiServiceDAO customerregiSericeDAO=new CustomerRegiServiceDAOImpl();
	
	@Override
	public int createAccount(Customer customer) throws BusinessException {
			try {
				if(customerregiSericeDAO.createAccount(customer)==1) {
					//log.info("Congrats! Your Account Has been Created Successfully");
					log.info(customer);
				}
				}catch(BusinessException e) {
					log.error(e);
					throw new BusinessException("Internal error occured, please contact admin");
				}
				return 0;
			
		}
	}

	
