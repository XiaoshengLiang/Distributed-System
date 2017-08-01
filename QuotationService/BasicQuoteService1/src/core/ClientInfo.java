package core;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface to define the state to be stored in ClientInfo objects
 * 
 *
 */
public interface ClientInfo extends Remote{
	public static final char MALE				= 'M';
	public static final char FEMALE				= 'F';
	
	public String getName() throws RemoteException;
	public char getSex() throws RemoteException;
	public int getAge() throws RemoteException;
	public int getPoints() throws RemoteException;
	public int getNoClaims() throws RemoteException;
	public String getLicenceNumber() throws RemoteException;
	
}
