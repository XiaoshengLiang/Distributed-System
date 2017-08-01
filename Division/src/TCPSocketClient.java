import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

/**
 * A simple class that opens a socket, sends a message to the server, and
 * receives result of division from server.
 */
public class TCPSocketClient {

	/**
	 * The server host name.
	 */
	public String my_serverHost;

	/**
	 * The server port.
	 */
	public int my_serverPort;

	/**
	 * Sets the client up with the server details.
	 * 
	 * @param the_serverHost
	 *            the server host name.
	 * @param the_serverPort
	 *            the server port.
	 */
	public TCPSocketClient(String the_serverHost, int the_serverPort) {
		my_serverHost = the_serverHost;
		my_serverPort = the_serverPort;
	}

	/**
	 * Creates a connection to the server and sends a message and receives the
	 * message from server.
	 * 
	 * @param a_message
	 *            the message to send to the server.
	 */
	public void Communicate(int a, int b) {
		try {
			// Create a connection to the server.
			Socket toServer = new Socket(my_serverHost, my_serverPort);

			DataOutputStream out = new DataOutputStream(toServer.getOutputStream());
			DataInputStream in = new DataInputStream(toServer.getInputStream());
			// System.out.println("The two numbers are "+a+" "+b);

			// Send numbers to Server
			out.writeInt(a);
			out.writeInt(b);

			// Receive the result of division
			float result = in.readFloat();
			System.out.println("The result of " + a + "/" + b + " is: " + result);

			out.close();
			in.close();
			toServer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Parse the arguments to the program, create a socket, and send a message.
	 * 
	 * @param args
	 *            the program arguments. Should take the form &lt;host&gt;
	 *            &lt;port&gt; &lt;message&gt;
	 */
	public static void main(String[] args) {

		String host = null;
		int port = 0;
		// Check we have the right number of arguments and parse
		if (args.length == 2) {
			host = args[0];
			try {
				port = Integer.valueOf(args[1]);
			} catch (NumberFormatException nfe) {
				System.err.println("The value provided for the port is not an integer");
				nfe.printStackTrace();
			}

			// Create two random numbers
			Random rand = new Random();
			int num1 = rand.nextInt(100);
			int num2 = rand.nextInt(100);

			// int num1 = Integer.valueOf(args[2]);
			// int num2 = Integer.valueOf(args[3]);

			// Create the client
			TCPSocketClient client = new TCPSocketClient(host, port);
			// Send a message using the client
			client.Communicate(num1, num2);
		} else {
			System.out.println("Usage: java TCPSocketClient <host> <port>");
		}

	}
} // end class
