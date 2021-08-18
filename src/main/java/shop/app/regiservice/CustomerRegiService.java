package shop.app.regiservice;

import shop.app.excep.BusinessException;
import shop.app.model.Customer;

public interface CustomerRegiService {
    
	 public int createAccount(Customer customer) throws BusinessException; 

}
