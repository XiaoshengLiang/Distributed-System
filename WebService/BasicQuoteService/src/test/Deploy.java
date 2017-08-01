package test;

import javax.xml.ws.Endpoint;

import quotation.AFQService;
import quotation.DDQService;
import quotation.GPQService;
import vetting.LocalVettingService;

public class Deploy {
	public static void main(String args[]){		
		Endpoint.publish("http:localhost://9001/ASQService/generateQuotation", new AFQService());
		Endpoint.publish("http:localhost://9002/DDQService/generateQuotation", new DDQService());
		Endpoint.publish("http:localhost://9003/GPQService/generateQuotation", new GPQService());
		Endpoint.publish("http://localhost:9000/VettingService/vetClient", new LocalVettingService());
	}
}
