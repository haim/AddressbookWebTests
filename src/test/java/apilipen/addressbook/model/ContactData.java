package apilipen.addressbook.model;

public class ContactData {
	private String fname;
	private String lname;
	private String addr;
	private String phone;
	private String email;
	
	
	
	public ContactData(String fname, String lname, String addr,
			String phone, String email) {
		this.fname = fname;
		this.lname = lname;
		this.addr = addr;
		this.phone = phone;
		this.email = email;
	}

	
	
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getAddr() {
		return addr;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
}