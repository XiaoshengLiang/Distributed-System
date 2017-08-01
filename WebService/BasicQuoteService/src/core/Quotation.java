package core;

/**
 * Class to define the data to be stored in Quotation objects.
 * 
 *
 */
public class Quotation {
	
	public String reference;
	public ClientInfo info;
	public double price;
	
	public Quotation(String reference, ClientInfo info, double price){
		this.reference=reference;
		this.info=info;
		this.price=price;
	} 
	
	public Quotation(){}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference){
		this.reference=reference;
	}

	public ClientInfo getClientInfo() {
		return info;
	}
	
	public void setClientInfo(ClientInfo info){
		this.info=info;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price){
		this.price=price;
	}
}
