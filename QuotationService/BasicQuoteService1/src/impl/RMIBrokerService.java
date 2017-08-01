package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import core.BrokerService;
import core.ClientInfo;
import core.Quotation;
import core.QuotationService;
import registry.ServiceRegistry;

/**
 * Implementation of the broker service.
 * 
 *
 */
public class RMIBrokerService implements BrokerService{

	public List<Quotation> getQuotations(ClientInfo info) throws RemoteException {
		List<Quotation> quotations = new LinkedList<Quotation>();
		for (String name : ServiceRegistry.list()) {
			QuotationService service = ServiceRegistry.lookup(name);
			quotations.add(service.generateQuotation(info));
		}
		return quotations;
	}
}
