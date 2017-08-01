package core;

/**
 * Class to define the state to be stored in ClientInfo objects
 * 
 *
 */
public class ClientInfo {
	public static final char MALE				= 'M';
	public static final char FEMALE				= 'F';
	
	public String name;
	public char sex;
	public int age;
	public int points;
	public int noclaims;
	public String licencenumber;
	
	public ClientInfo(String name,char sex,int age,int points,int noclaims, String licencenumber){
		this.name=name;
		this.age=age;
		this.points=points;
		this.noclaims=noclaims;
		this.licencenumber=licencenumber;
	}
	
	public ClientInfo(){}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}


	public char getSex() {
		return sex;
	}
	
	public void setSex(char sex){
	}


	public int getAge() {
		return age;
	}
	
	public void setAge(int age){
		this.age=age;
	}


	public int getPoints() {
		return points;
	}
	
	public void setPoint(int points){
		this.points=points;
	}


	public int getNoClaims() {
		return noclaims;
	}
	
	public void setNoClaims(int noClaims){
		this.noclaims=noClaims;
	}
	

	public String getLicenceNumber() {
		return licencenumber;
	}
	
	public void setLicenceNumber(String licencenumber){
		this.licencenumber=licencenumber;
	}
}
