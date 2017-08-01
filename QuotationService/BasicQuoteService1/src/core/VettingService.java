package core;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface defining the expected behavour of a vetting service.
 * 
 *
 */
public interface VettingService extends Remote{
	public boolean vetClient(ClientInfo info) throws RemoteException;
}
