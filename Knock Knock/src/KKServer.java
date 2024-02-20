import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KKServer 
{

	public static void main(String[] args) throws IOException 
	{
		int port = 42;
		ServerSocket server = new ServerSocket(port);
		
		int track = 0;
		
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
						message = message.toLowerCase();
					
						
						if(track == 0)
						{
							if(message.equals("knock knock"))
							{
								out.println("Who's there?");
								track++;
							}
							else
							{
								out.println("I am sorry but I do not understand. Please tell me a knock knock joke");
							}
						}
						else if(track == 1)
						{
							out.println(message + " who?");
							track++;
						}
						else if(track == 2)
						{
							out.println("hahaha! Tell me another!!!");
							track = 0;
						}
						
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
