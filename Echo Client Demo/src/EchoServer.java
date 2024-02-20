import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer 
{

	public static void main(String[] args) throws IOException 
	{
		int port = 9999;
		ServerSocket server = new ServerSocket(port);
		
		while(true)//for(;;)
		{
			try
			{
				System.out.println("Server listening...");
				Socket client = server.accept();
				System.out.println("server accepted client");
				
				
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				
				String message;
				
							
				while((message = in.readLine()) != null)
				{
					System.out.println("Message recieved: " + message);
					message = message.toUpperCase();
					out.println(message);
				}
				client.close();
			}
			catch(Exception e)
			{
				System.out.println("there was an issue");
			}
		}

	}

}
