package test;

import java.rmi.RemoteException;

import core.ClientInfo;
import impl.RMIVettingService;

public class RMIVettingTest {
	public static void main(String[] args) {
		RMIVettingService vtservice = new RMIVettingService();
		for (ClientInfo info : Main.clients) {
			boolean vet;
			try {
				vet = vtservice.vetClient(info);
				System.out.println("The result of vetting is: " + vet);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("Trouble in Vetting Service: " +e);
			}			
		}
	}
}
