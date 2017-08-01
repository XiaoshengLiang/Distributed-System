package test;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import core.BrokerService;
import core.ClientInfo;
import core.Quotation;

public class Main {
	public static void main(String[] args) throws Exception {
		URL wsdlVet = new URL("http://localhost:9000/VettingService/vetClient?wsdl");
		QName qnameVet = new QName("http://quote/", "AFQService");
		Service serviceVet = Service.create(wsdlVet, qnameVet);

		URL wsdlAFQ = new URL("http://localhost:9001/ASQService/generateQuotation?wsdl");
		QName qnameAFQ = new QName("http://quote/", "AFQService");
		Service serviceAFQ = Service.create(wsdlAFQ, qnameAFQ);

		URL wsdlDDQ = new URL("http://localhost:9002/DDQService/generateQuotation?wsdl");
		QName qnameDDQ = new QName("http://quote/", "DDQService");
		Service serviceDDQ = Service.create(wsdlDDQ, qnameDDQ);

		URL wsdlGPQ = new URL("http://localhost:9003/GPQService/generateQuotation?wsdl");
		QName qnameGPQ = new QName("http://quote/", "GPQService");
		Service serviceGPQ = Service.create(wsdlGPQ, qnameGPQ);

		BrokerService broker = serviceVet.getPort(BrokerService.class);

		for (ClientInfo info : clients) {
			System.out.println("Name: " + info.getName());
			for (Quotation quotation : broker.getQuotations(info)) {
				System.out.println("Reference: " + quotation.getReference() + " / Price: " + quotation.getPrice());
			}
		}
	}

	/**
	 * Test client data
	 */
	public static final ClientInfo[] clients = { new ClientInfo() {
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
			}, new ClientInfo() {
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
			} };
}
