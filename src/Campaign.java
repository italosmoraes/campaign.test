/**
 * 
 */

/**
 * @author Italo S. Moraes
 *
 */
public class Campaign {
	String cname = null;
	int id = 0; //may serve as the index in a list
	int[] seglist = null;
	int numberOfMatches = 0; // to record the matches in an input set and help decide which one to show
	
	public Campaign(String name, int id){
		this.id = id;
		this.cname = name;
		
	}

	public String getCname() {
		return cname;
		
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getSlist() {
		return seglist;
	}

	public void setSlist(int[] slist) {
		this.seglist = slist;
	}
	
	
	
	
}
