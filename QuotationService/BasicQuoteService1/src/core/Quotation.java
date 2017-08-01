package core;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface to define the data to be stored in Quotation objects.
 * 
 *
 */
public interface Quotation extends Remote{
	public String getReference() throws RemoteException;
	public ClientInfo getClientInfo() throws RemoteException;
	public double getPrice() throws RemoteException;
}
