package shop.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.app.dao.CustomerLoginCheckDAO;
import shop.app.dao.dbutil.MySqlDbConnection;
import shop.app.excep.BusinessException;


public class CustomerLoginCheckDAOImpl implements CustomerLoginCheckDAO {
    // check;
	@Override
	public boolean customerLogin(String email, String password) throws BusinessException {
		boolean c=false;
		
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select cemail,cpassword from shop_project.costomer_regis where cemail=? and cpassword=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
				
				c = true;
			}
			else {
				throw new BusinessException("Customer not registered");
				
			}
       
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Enternal Errored Occured");
		}
		
		
		
		
		
		
		
		return c;
	}

}
