package apilipen.addressbook.model;

public class GroupData {
	
	private int id;
	private String name;
	private String header;
	private String footer;
	
	
	public GroupData(int id, String name, String header, String footer) {
		this.id = id;
		this.name = name;
		this.header = header;
		this.footer = footer;
	}
	
	public GroupData( String name, String header, String footer) {
		this.id = 0;
		this.name = name;
		this.header = header;
		this.footer = footer;
	}
	
	public int getId() {
		return id;
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
	
	
	@Override
	public String toString() {
		return "GroupData [id=" + id + ", name=" + name + "]";
	}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupData other = (GroupData) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setId(int ide) {
		// TODO Auto-generated method stub
		this.id = ide;
	}









	



	



	
	
	
	
	
}