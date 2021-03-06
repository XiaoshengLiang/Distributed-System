package vetting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import core.ClientInfo;
import core.Quotation;

@WebService(name="VettingService")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)

public class LocalVettingService implements VettingService {
	
	Map<String, Integer> pointsDB = new HashMap<String, Integer>();
	{
		pointsDB.put("PQR254/1", 0);
		pointsDB.put("ABC123/4", 2);		pointsDB.put("XYZ567/9", 5);
	}

	@Override
	public boolean vetClient(ClientInfo info) {
		Integer value = pointsDB.get(info.getLicenceNumber());
		return value != null && (value == info.getPoints());
	}

	@Override
	public List<Quotation> getQuotations(ClientInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

}
