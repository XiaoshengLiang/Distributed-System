package impl;

import java.rmi.RemoteException;
import core.ClientInfo;
import core.VettingService;

/**
 * Implementation of the vetting service.
 * 
 *
 */

public class RMIVettingService implements VettingService {
	@Override
	public boolean vetClient(ClientInfo info) throws RemoteException {
		// TODO Auto-generated method stub
		RMIVettingService vet = new RMIVettingService();
		info.getPoints();
		boolean points = true;
		if (points == true) {
			System.out.println("No problem!");
		} else
			System.out.println("Something wrong!");
		return points;
	}
}
