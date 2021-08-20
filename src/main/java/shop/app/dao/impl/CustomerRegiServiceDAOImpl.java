package shop.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shop.app.dao.CustomerRegiServiceDAO;
import shop.app.dao.dbutil.MySqlDbConnection;
import shop.app.excep.BusinessException;
import shop.app.model.Customer;

public class CustomerRegiServiceDAOImpl implements CustomerRegiServiceDAO {

	@Override
	public int createAccount(Customer customer) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into shop_project.costomer_regis(cfirstname,clastname,cemail,cpassword) values (?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,customer.getCfirstname());
			preparedStatement.setString(2,customer.getClastname());
			preparedStatement.setString(3,customer.getCemail());
			preparedStatement.setString(4,customer.getPassword());
			
			c=preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Email ID Already Registered.....");
		}
     return c;
	}

}
