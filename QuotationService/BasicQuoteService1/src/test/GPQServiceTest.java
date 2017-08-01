package test;

import java.rmi.RemoteException;

import core.ClientInfo;
import core.Quotation;
import impl.GPQService;

public class GPQServiceTest {
	public static void main(String[] args) {
		GPQService service = new GPQService();
		for (ClientInfo info : Main.clients) {
			Quotation quotation;
			try {
				quotation = service.generateQuotation(info);
				System.out.println("Reference: " + quotation.getReference() + " / Price: " + quotation.getPrice());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("Trouble in GPQService: "+e);
			}
		}
	}
}
