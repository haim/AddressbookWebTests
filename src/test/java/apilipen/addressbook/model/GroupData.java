package apilipen.addressbook.model;

public class GroupData {
	

	private String name;
	private String header;
	private String footer;
	
	
	public GroupData(String name, String header, String footer) {
		this.name = name;
		this.header = header;
		this.footer = footer;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public String getHeader() {
		return header;
	}
	public String getFooter() {
		return footer;
	}
	
	
	//  Sourse=> Generate .toString()
	@Override
	public String toString() {
		return "GroupData [name=" + name + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		
		GroupData other = (GroupData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		
		return true;  //  name !=null ? name.equals(other.name)  : other.name ==null;
	}









	

//  Sourse=> Generate .hashCode() and .equals()

	



	
	
	
	
	
}