package shop.app.regiserviceimpl;

import shop.app.dao.CustomerLoginCheckDAO;
import shop.app.dao.impl.CustomerLoginCheckDAOImpl;
import shop.app.excep.BusinessException;
import shop.app.regiservice.CustomerLoginCheck;

public class CustomerLoginCheckImpl implements CustomerLoginCheck {
    private CustomerLoginCheckDAO customerLoginCheckDAO=new CustomerLoginCheckDAOImpl();
	@Override
	public boolean customerLogin(String email, String password) throws BusinessException {
	boolean c=false;
	try {
		if (customerLoginCheckDAO.customerLogin(email,password)) {
			c = true;
		}
	}catch(BusinessException e) {
		System.out.println(e.getMessage());
	}
		return c;
	}

}

