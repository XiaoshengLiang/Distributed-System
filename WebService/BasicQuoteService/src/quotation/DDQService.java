package quotation;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

import core.AbstractQuotationService;
import core.ClientInfo;
import core.Quotation;

/**
 * Implementation of Quotation Service for Dodgy Drivers Insurance Company
 *  
 *
 */

@WebService(name="DDQService")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)

public class DDQService extends AbstractQuotationService implements QuotationService {
	
	// All references are to be prefixed with an DD (e.g. DD001000)
	public static final String PREFIX = "DD";
	
	
	/**
	 * Quote generation:
	 * 5% discount per penalty point (3 points required for qualification)
	 * 50% penalty for <= 3 penalty points
	 * 10% discount per year no claims
	 */
	
	@Override
	public Quotation generateQuotation(ClientInfo info) {
		// Create an initial quotation between 800 and 1000
		double price = generatePrice(800, 200);
		
		// 5% discount per penalty point (3 points required for qualification)
		int discount = (info.getPoints() > 3) ? 5*info.getPoints():-50;
		
		// Add a no claims discount
		discount += getNoClaimsDiscount(info);
		
		// Generate the quotation and send it back
//		DDQuotation quotation = new DDQuotation();
		Quotation quotation = new Quotation();
		// Use the reference generator to create a reference
		quotation.reference = generateReference(PREFIX);
		quotation.info = info;
		quotation.price = (price * (100-discount)) / 100;
		
		return quotation;
	}

	private int getNoClaimsDiscount(ClientInfo info) {
		return 10*info.getNoClaims();
	}

}
