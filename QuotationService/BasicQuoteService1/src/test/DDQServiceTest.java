package test;

import java.rmi.RemoteException;

import core.ClientInfo;
import core.Quotation;
import impl.DDQService;

public class DDQServiceTest {

	public static void main(String[] args) {
		DDQService service = new DDQService();

		for (ClientInfo info : Main.clients) {
			Quotation quotation;
			try {
				quotation = service.generateQuotation(info);
				System.out.println("Reference: " + quotation.getReference() + " / Price: " + quotation.getPrice());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("Trouble in DDQService: " + e);
			}
		}
	}
}
