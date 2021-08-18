package shop.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import shop.app.dao.CustomerRegiServiceDAO;
import shop.app.dao.impl.CustomerRegiServiceDAOImpl;
import shop.app.excep.BusinessException;
import shop.app.model.Customer;
import shop.app.regiservice.CustomerRegiService;
import shop.app.regiserviceimpl.CustomerRegiServiceImpl;

public class Main {
	private static Logger log=Logger.getLogger(Main.class);
	public static void main(String[] args) {
		
		
		Scanner scanner=new Scanner(System.in);
		log.info("*******************************************");
		log.info("     Well Come To Online Shop             ");
		log.info("********************************************");
		int ch=0;
		do {
		log.info("1-> Create Customer Account");
		log.info("2-> Customer Login");
		log.info("3-> You Are Developer ");
		log.info("4-> Exit");
		log.info("Enter Your Choice Between (1-3)");
		log.info("==============================================");
		try{
			 ch=Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e){}
		switch (ch) {
		case 1:int option=0;
		CustomerRegiService customerRegiService=new CustomerRegiServiceImpl();
		do {
			   log.info("Ready For Registration Process...Please Select Below Option ");
		       log.info("1->   Go For Registration----) ");
		       log.info("2->   Go Back  ");
		       log.info("Enter Your Choice");
		       log.info("=============================================");
		       try{
		  		 option=Integer.parseInt(scanner.nextLine());
		  		}catch(NumberFormatException e){
		  	  }
		       switch (option) {
				case 1:
					
					   log.info("===================================");
				       log.info("         Enter Below Details       ");
				       log.info("===================================");
				       Customer customer=new Customer();
				       log.info("Enter Your First Name");
				           customer.setCfirstname(scanner.nextLine());
				       log.info("Enter Your Last Name");
				       customer.setClastname(scanner.nextLine());
				       log.info("Enter Your Email Name");
				       customer.setCemail(scanner.nextLine());
				       log.info("Enter Your Password Name");
				       customer.setPassword(scanner.nextLine());
				       CustomerRegiServiceDAO customerRegiServiceDAO=new CustomerRegiServiceDAOImpl();
				       try {
				    	   
				    	int c=customerRegiServiceDAO.createAccount(customer);	   
				       }catch(BusinessException e) {
				    	   System.out.println(e);
				       }
				       
				      log.info("Hey Congratulation.......Your Account Created Successfully");
				           
				 case 2:
		            	log.info("******Thank You******");
		            	log.info("=============================================================");
						
						break;

					default:
						log.error("Invalid Option...Option Should Be Only Number Between 1 To 2");
						break;
					}
		}while(option!=2);
		break;
        case 2:log.info("HELLO ");
			
			break; 
        case 3:log.info("Under Construction");
	
	        break;
        case 4:log.info("******Thank You******");
	
	        break;


		default:
			log.error("Invalid Choice choice Should Be Only Number Between(1-4)");
			break;
		}
		
		
	}while(ch!=4);
	}

}
