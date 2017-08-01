package registry;

import java.util.HashMap;
import java.util.Map;

import core.QuotationService;
import impl.RMIBrokerService;

/**
 * This is a basic service registry implementation that is based on the registry used in
 * RMI systems.
 * 
 * @author Rem
 *
 */
public class ServiceRegistry {
	private static Map<String, QuotationService> services = new HashMap<String, QuotationService>();
	
	public static void bind(String name, QuotationService service) {
		services.put(name, service);
	}
	
	public static void unbind(String name) {
		services.remove(name);
	}

	public static QuotationService lookup(String name) {
		return services.get(name);
	}

	public static String[] list() {
		return services.keySet().toArray(new String[services.size()]);
	}

	
}
