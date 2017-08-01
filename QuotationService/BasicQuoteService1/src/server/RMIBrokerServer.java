package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import core.BrokerService;
import impl.RMIBrokerService;
import registry.ServiceRegistry;

/**
 * Server of Broker service..
 * 
 *
 */

public class RMIBrokerServer {
	public static void main(String ags[]){
		try{
			Registry registry = LocateRegistry.createRegistry(1081);
			BrokerService bk = (BrokerService) UnicastRemoteObject.exportObject(new RMIBrokerService(), 0);
			registry.rebind("rmi://localhost/RMIBrokerService", bk);
//			ServiceRegistry.bind("RMIBrokerService", bk);
			System.out.println("RMI Server running on port: 1081");
		}
		catch (Exception e) {
			System.out.println("Trouble in RMIBserver: " + e);
		}
	}
}
