package core;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface for defining the behaviours of the broker service
 * 
 *
 */
public interface BrokerService extends Remote{
	public List<Quotation> getQuotations(ClientInfo info)throws RemoteException;
}
