package shop.app.dao;

import shop.app.excep.BusinessException;

public interface CustomerLoginCheckDAO {
	public boolean customerLogin(String email, String password) throws BusinessException;

}
