The project is an insurance quotation system for a broker.

The class RMIBrokerServer in server package is the server of RMIBrokerService. It creates a registry and bind the remote object to RMI server.

The class RMIBrokerService in impl package is to implement the service of broker and invoke the remote object by using lookup.

