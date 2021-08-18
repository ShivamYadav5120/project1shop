package shop.app.dao;

import shop.app.excep.BusinessException;
import shop.app.model.Customer;

public interface CustomerRegiServiceDAO {
	public int createAccount(Customer customer) throws BusinessException; 
}
