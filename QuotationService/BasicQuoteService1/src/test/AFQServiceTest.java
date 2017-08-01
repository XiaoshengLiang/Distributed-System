package test;

import java.rmi.RemoteException;

import core.ClientInfo;
import core.Quotation;
import impl.AFQService;

public class AFQServiceTest {
	public static void main(String[] args) {
		AFQService service = new AFQService();
		for (ClientInfo info : Main.clients) {
			Quotation quotation;
			try {
				quotation = service.generateQuotation(info);
				System.out.println("Reference: " + quotation.getReference() + " / Price: " + quotation.getPrice());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("Trouble in AFQService: " +e);
			}			
		}
	}
}
