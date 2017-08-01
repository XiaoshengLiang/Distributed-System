package test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import core.BrokerService;
import core.ClientInfo;
import core.Quotation;
import impl.AFQService;
import impl.DDQService;
import impl.GPQService;
import registry.ServiceRegistry;

public class Main {
	public static void main(String[] args) {
		try {
			// Create the services and bind them to the registry.
			ServiceRegistry.bind("GirlPowerService", new GPQService());
			ServiceRegistry.bind("AuldFellasService", new AFQService());
			ServiceRegistry.bind("DodgyDriversService", new DDQService());
			
			// Create the broker and run the test data		
			Registry registry = LocateRegistry.getRegistry(1098);
			BrokerService bs = (BrokerService) registry.lookup("RMIBrokerService");		
			for (ClientInfo info : clients) {
				System.out.println("Name: " +info.getName());
				for(Quotation quotation : bs.getQuotations(info)) {
					System.out.println("Reference: " + quotation.getReference() + " / Price: " + quotation.getPrice());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Trouble in main: "+e);
		}
	}

	/**
	 * Test client data
	 */
	public static final ClientInfo[] clients = {
			new ClientInfo() {
				@Override
				public String getName() {
					return "Niki Collier";
				}

				@Override
				public char getSex() {
					return ClientInfo.MALE;
				}

				@Override
				public int getAge() {
					return 41;
				}

				@Override
				public int getPoints() {
					return 0;
				}

				@Override
				public int getNoClaims() {
					return 7;
				}
				
				@Override 
				public String getLicenceNumber() {
					return "PQR254/1";
				}
			},
			new ClientInfo() {
				@Override
				public String getName() {
					return "Old Geeza";
				}

				@Override
				public char getSex() {
					return ClientInfo.MALE;
				}

				@Override
				public int getAge() {
					return 65;
				}

				@Override
				public int getPoints() {
					return 0;
				}

				@Override
				public int getNoClaims() {
					return 2;
				}
				
				@Override 
				public String getLicenceNumber() {
					return "ABC123/4";
				}
			},			
			new ClientInfo() {
				@Override
				public String getName() {
					return "Donald Duck";
				}

				@Override
				public char getSex() {
					return ClientInfo.MALE;
				}

				@Override
				public int getAge() {
					return 35;
				}

				@Override
				public int getPoints() {
					return 5;
				}

				@Override
				public int getNoClaims() {
					return 2;
				}

				@Override 
				public String getLicenceNumber() {
					return "XYZ567/9";
				}
			}			
		};
}
