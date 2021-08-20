package shop.app.model;

public class Product {

	private int pid;
	private String pname;
	private String pcompany;
	private float prating; 
	private double pprice;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcompany() {
		return pcompany;
	}
	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public float getPrating() {
		return prating;
	}
	public void setPrating(float prating) {
		this.prating = prating;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
		
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcompany=" + pcompany + ", prating=" + prating+ ", pprice=" + pprice + "]\n";
		
	}
	public Product() {
		super();
	}
	public Product(int pid, String pname, String pcompany, float prating, double pprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcompany = pcompany;
		this.prating = prating;
		this.pprice = pprice;
	}
	
	
}
