package shop.app.model;

public class Customer {
	private int cid;
	 private String cfirstname;
	 private String clastname;
	 private String cemail;
	 private String cpassword;
	 
	
	 
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCfirstname() {
		return cfirstname;
	}
	public void setCfirstname(String cfirstname) {
		this.cfirstname = cfirstname;
	}
	public String getClastname() {
		return clastname;
	}
	public void setClastname(String clastname) {
		this.clastname = clastname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getPassword() {
		return cpassword;
	}
	public void setPassword(String password) {
		this.cpassword = password;
	}
	@Override
	public String toString() {
		return "Costomer_regis [cid="+cid+"cfirstname=" + cfirstname + ", clastname=" + clastname + ", cemail=" + cemail + ", password=" + cpassword + "]\n";
		
	}
	
	
	public Customer() {
		super();
	}
	public Customer(int cid,String cfirstname, String clastname, String cemail, String password) {
		super();
		this.cid=cid;
		this.cfirstname = cfirstname;
		this.clastname = clastname;
		this.cemail = cemail;
		this.cpassword = password;
	}
	
	

}
