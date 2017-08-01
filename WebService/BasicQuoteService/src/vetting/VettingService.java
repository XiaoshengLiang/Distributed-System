package vetting;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import core.ClientInfo;
import core.Quotation;

/**
 * Interface defining the expected behavour of a vetting service.
 * 
 *
 */
@WebService
public interface VettingService  {
	@WebMethod public boolean vetClient(ClientInfo info);

	public List<Quotation> getQuotations(ClientInfo info);
	
}
