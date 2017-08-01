package quotation;

import javax.jws.WebMethod;
import javax.jws.WebService;
import core.ClientInfo;
import core.Quotation;

/**
 * Interface to define the behaviour of a quotation service.
 *
 */

@WebService
public interface QuotationService  {
	@WebMethod public Quotation generateQuotation(ClientInfo info);
}
