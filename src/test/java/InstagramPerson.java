
public class InstagramPerson {

	String personName;
	String personUrl;
	boolean response;
	
	public InstagramPerson(String personName,String personUrl,boolean response) {
		this.personName=personName;
		this.personUrl=personUrl;
		this.response=response;
	}
	public String toString() {
		return this.personName+" "+this.personUrl+" "+Boolean.toString(this.response);
	}
}
