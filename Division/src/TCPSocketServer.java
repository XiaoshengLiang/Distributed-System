import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

/**
 * A simple class that opens a server socket, receives the random numbers from
 * client and does division.
 */
public class TCPSocketServer {

	/**
	 * Accept this many connections.
	 */
	private int my_backlog = 5;

	/**
	 * The server socket.
	 */
	private ServerSocket my_serverSocket;

	/**
	 * Create the server socket.
	 * 
	 * @param a_port
	 *            the port that the server socket should listen on.
	 */
	public TCPSocketServer(int a_port) {
		try {
			my_serverSocket = new ServerSocket(a_port, my_backlog);
			System.out.println("TCP socket listening on port " + a_port);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Method that listens on the server socket forever and dose division
	 */
	public void listen() {
		while (true) {
			try {
				// Listens for a connection to be made to this socket.
				Socket socket = my_serverSocket.accept();

				// Wrap a buffered reader round the socket input stream.
				// Read the javadoc to understand why we do this rather than
				// dealing
				// with reading from raw sockets.

				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				// Read in the message
				int InNum1 = in.readInt();
				int InNum2 = in.readInt();
				// System.out.println("The two number is: "+InNum1+" "+InNum2);
				float result = division(InNum1, InNum2);
				out.writeFloat(result);
				;

				in.close();
				out.close();
				socket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (SecurityException se) {
				se.printStackTrace();
			}
		}
	}

	/**
	 * The method is division with two random number and reserving two decimal
	 * fractions
	 * 
	 * @param num1
	 *            is the dividend
	 * @param num2
	 *            is the divisor
	 * @return the result
	 */
	public float division(int num1, int num2) {
		// TODO Auto-generated method stub
		float resDiv = 0;
		if (num2 != 0) {
			float res = (float) num1 / num2;
			// reserve two decimal fractions
			DecimalFormat df = new DecimalFormat("0.00");
			resDiv = Float.valueOf(df.format(res));
		} else {
			resDiv = 0;
		}
		return resDiv;
	}

	/**
	 * Parse the arguments to the program and create the server socket.
	 * 
	 * @param args
	 *            the program arguments. Should take the form &lt;port&gt;
	 */
	public static void main(String[] args) {
		int port = 0;

		// Check we have the right number of arguments and parse
		if (args.length == 1) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException nfe) {
				System.err.println("The value provided for the port is not an integer");
				nfe.printStackTrace();
			}
			// Create the server
			TCPSocketServer server = new TCPSocketServer(port);
			// Listen on the server socket. This will run until the program is
			// killed.
			server.listen();
		} else {
			System.out.println("Usage: java TCPSocketServer <port>");
		}

	}
} // end class
