package shop.app.regiservice;

import shop.app.excep.BusinessException;

public interface CustomerLoginCheck {
	public boolean customerLogin(String email, String password) throws BusinessException;
	

}
