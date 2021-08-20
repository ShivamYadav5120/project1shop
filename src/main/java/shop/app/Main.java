package shop.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import shop.app.dao.CustomerRegiServiceDAO;
import shop.app.dao.ProductSearchServiceDAO;
import shop.app.dao.impl.CustomerRegiServiceDAOImpl;
import shop.app.dao.impl.ProductSearchServiceDAOImpl;
import shop.app.excep.BusinessException;
import shop.app.model.Customer;
import shop.app.model.Product;
import shop.app.regiservice.CustomerRegiService;
import shop.app.regiservice.ProductSearchService;
import shop.app.regiserviceimpl.CustomerLoginCheckImpl;
import shop.app.regiserviceimpl.CustomerRegiServiceImpl;
import shop.app.regiserviceimpl.ProductSearchServiceImpl;

public class Main {
	private static Logger log=Logger.getLogger(Main.class);
	public static void main(String[] args) {
		
		
		Scanner scanner=new Scanner(System.in);
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info(" ");
		log.info("@@@@@@=====Wel Come To Online Shop========@@@@@@");
		log.info(" ");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		int ch=0;
		do {
		log.info("==============================================");	
		log.info("                   Main Menu                  ");
		log.info("==============================================");
		log.info("1-> Employee Login");
		log.info("2-> Customer Login");
		log.info("3-> New User,Then Register");
		log.info("4-> Exit");
		log.info("Enter Your Choice Between (1-4)");
		log.info("==============================================");
		try{
			 ch=Integer.parseInt(scanner.nextLine());
		    }catch(NumberFormatException e){}
	switch (ch) {
	       case 1:
			int em=0;
			log.info("======================================================================");
        	log.info("                         Employee Section                             ");
        	log.info("======================================================================");
        	log.info("                  Please Enter Your Account Details                   ");
        	log.info("----------------------------------------------------------------------");
        	log.info("Enter Your Email");
        	String eemail=scanner.nextLine();
        	log.info("Enter Your Password");
            String epassword=scanner.nextLine(); 
            log.info("=======================================================================");
            log.info("                           Hey....Congratulation                       ");
			log.info("                          Logged In successfully                      ");
			log.info("=======================================================================");
		do {
			log.info("-----------------------------");
			log.info("1)View Customer");
    		log.info("2)Delete Product");
    		log.info("3)Add New Product");
    		log.info("4)Update Product Price");
    		log.info("5)Exit");
    		log.info("Enter Your Choice");
    		log.info("------------------------------");
		try{
			 em=Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e){}
		
     switch (em) {
		  case 1: 
			  log.info("===================================================");
			  log.info("           Register Customer Details Are           ");
			  log.info("===================================================");
			  Customer customer=new Customer();
			  ProductSearchServiceImpl productSearchServiceImpl= new ProductSearchServiceImpl();
			  
			  try {
				  log.info(productSearchServiceImpl.getAllCustomerDetails(customer));
			  }catch(BusinessException e) {
			      System.out.println(e.getMessage());
			  }	 
		  break; 
          case 2:
        	  log.info("========================================");
			  log.info("    Which Product You Want To Delete     ");
			  log.info("========================================");
			  log.info("Enter Product Id");
			  int pidd=Integer.parseInt(scanner.nextLine());
			  //product.setPprice(Double.parseDouble(scanner.nextLine()));
				try { 
				  ProductSearchServiceDAO productSearchServiceDAO=new ProductSearchServiceDAOImpl();
				  productSearchServiceDAO.deleteProductById(pidd);
				  System.out.println("Your Product Number-->"+pidd+" Deleted Successfully ");
			    }catch(NumberFormatException e) {
				 log.warn("Product Id should be digit only... Try Again");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}	  
		  break;
          case 3:  	
            log.info("=====================================");
            log.info("            ADD NEW PRODUCT          ");
           	log.info("=====================================");
           	log.info("       Enter Below Product Details    ");
           	log.info("**************************************");
           	Product product=new Product();
           	log.info("1-->Enter New  Product Name");
           	product.setPname(scanner.nextLine());
           	log.info("2-->Enter Product Company");
           	product.setPcompany(scanner.nextLine());
           	log.info("3-->Enter Product Rating");
           	product.setPrating(Float.parseFloat(scanner.nextLine()));
           	log.info("4-->Enter Product Price");
            product.setPprice(Double.parseDouble(scanner.nextLine()));
           	ProductSearchServiceDAO productSearchServiceDAO=new ProductSearchServiceDAOImpl();
   	try {
   		    int h=productSearchServiceDAO.addproduct(product);
            log.info("===============================================");
            log.info("       Your New Product Added Successfully      ");
            log.info("===============================================");
        }catch(BusinessException e) {
            System.out.println(e.getMessage());
            }
   
	        break;
           case 4:
        	   log.info("=====================================");
               log.info("         Update Product Price        ");
              	log.info("=====================================");
              	log.info("Enter Product Id");
                 int pid=Integer.parseInt(scanner.nextLine());
                  log.info("Enter New Product Price");
                 Double pprice=Double.parseDouble(scanner.nextLine());
                 if(pid!=0 && pid<30) {
                ProductSearchServiceDAOImpl productSearchServiceDAOImpl=new ProductSearchServiceDAOImpl();
		try {
			productSearchServiceDAOImpl.updateProductByPrice(pid, pprice);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
              	
              		log.info("Product With Id--> "+pid+"  Updated Succesfully");
                 }else {
                	 log.info("Invalid Product Id--> "+pid+"  Enter correct Product Id Between 1-30");
                 }
            break;
           case 5:
               log.info("Go Back");
               break;

			default:
			log.error("Invalid Choice choice Should Be Only Number Between(1-4)");
			break;
			}
		}while(em!=5);
		
		break;
        case 2:
        	int r=0;
        	log.info("=============================================");
        	log.info("         Wel Come To Customer Login           ");
        	log.info("==============================================");
        	log.info("Please Enter Your Account Details");
        	log.info("------------------------------------");
        	log.info("Enter Your Email");
        	String cemail=scanner.nextLine();
        	log.info("Enter Your Password");
            String cpassword=scanner.nextLine();        	
            Customer customer1=new Customer();
            customer1.setCemail(cemail);
            customer1.setPassword(cpassword);
            CustomerLoginCheckImpl customerLoginCheckImpl=new CustomerLoginCheckImpl();
        	
	try {
			if(customerLoginCheckImpl.customerLogin(cemail, cpassword)) 
			{        		
                log.info("**********************************");
        		log.info("        Hey....Congratulation     ");
        		log.info("       Logged In successfully     ");
       			log.info("*************************************");
     			do {
     			log.info("-----------------------");
       			log.info("1)View Product");
       			log.info("2)Serch Product");
       			log.info("3)Exit");
       			log.info("Enter Your Choice");
       			log.info("-----------------------");
    try{
        	    r=Integer.parseInt(scanner.nextLine());
        		}catch(NumberFormatException e){}
        			
        		switch (r) {
				case 1:
					log.info("=======================================");
			       	log.info("            Products Details           ");
			       	log.info("=======================================");
			       	Product product=new Product();
			       	ProductSearchServiceImpl productSearchServiceImpl= new ProductSearchServiceImpl();
	    	try {
		        	log.info(productSearchServiceImpl.getAllProducts(product));
			      }catch(BusinessException e) {
			        System.out.println(e.getMessage());
			        }
			       	log.info("====================================");
					break; 
                    case 2:
                    	int s=0;
                    	log.info("*********************************");
                    	log.info("       Serach Your Product   ");
                    	log.info("*********************************");
                    	do {
                    		log.info("-----------------------===========");
							log.info("1) Search Product By ID");
							log.info("2) Search Product By CompanyName");
							log.info("3)  Go Back");
							log.info("Please Enter Your Choice");
							log.info("-----------------------------------");
						
                    	try{
           				 s=Integer.parseInt(scanner.nextLine());
           				}catch(NumberFormatException e){}
                    	
                    	switch (s) {
						case 1:
							log.info("Enter Id for Search Product");
							try {
								int pid=Integer.parseInt(scanner.nextLine());
								ProductSearchServiceDAO productSearchServiceDAO=new ProductSearchServiceDAOImpl();
								Product product1=productSearchServiceDAO.getProductById(pid);
								if(product1!=null) {
								log.info("Product with ID "+pid+" found successfully... Below is the details");
								log.info(product1);
							}
							}catch(NumberFormatException e) {
								log.warn("Customer Id should be digit only... Try Again");
							} catch (BusinessException e) {
								log.warn(e.getMessage());
							}						
							break;
                        case 2:log.info("Enter Product Company Name");
                        String pcompany=scanner.nextLine();
                        try {
                        	ProductSearchServiceImpl productSearchServiceImpl2=new ProductSearchServiceImpl();
                        	List <Product> productList= productSearchServiceImpl2.getProductByCompany(pcompany);
                        	if(productList!=null && productList.size()>0) {
                        	log.info("Product with Company "+pcompany+" found successfully... Below is the details");
                        	for(Product i:productList) {
                        	log.info(i);
                        	 }
                        	}
                        }catch(BusinessException e) {
                        	log.info(e.getMessage());
                        }
							
							break;
                        case 3:
                        	log.info("Go Back");
	                        break;

						default:
							break;
						}
                    	
                    	}while (s!=3);
                    	break;
                     case 3:
                    	 log.info("Back To Main Menu");
	
                    break;


					default:
						log.error("Invalid Choice choice Should Be Only Number Between(1-3)");
						break;
        			}
        			
        		}while(r!=3);
				}else {
					log.info("Invalid Email And Password");
				}
		} catch (BusinessException e) {
			log.info("Invalid Email And Password");
			System.out.println(e.getMessage());
		}
		
       break;
       case 3:
        int option=0;
		CustomerRegiService customerRegiService=new CustomerRegiServiceImpl();
	                   log.info("Wel Come To Registration Process");
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
				       log.info("Enter Your Password ");
				       customer.setPassword(scanner.nextLine());
				       CustomerRegiServiceDAO customerRegiServiceDAO=new CustomerRegiServiceDAOImpl();
				       try {
				    	   
				    	int c=customerRegiServiceDAO.createAccount(customer);	   
				    	log.info("Hey Congratulation.......Your Account Created Successfully");
				       }catch(BusinessException e) {
				    	   System.out.println(e);
				       }
		 break;
        case 4:
        	log.info("       Thank You       ");
    	
        break;

		default:
			log.error("Invalid Choice choice Should Be Only Number Between(1-4)");
			break;
		}
		
		
	}while(ch!=4);

}
}
	
