
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class Server {

  public static ArrayList<Note> list;
  public static Socket socket ;
  
	  public static void Receive(){
		 try
			{		
			 ObjectOutputStream  sending = new ObjectOutputStream(socket.getOutputStream ());
			 ObjectInputStream receiving = new ObjectInputStream(socket.getInputStream());
			
			 Note n=(Note)receiving.readObject();
	//		 System.out.println(n.Name+ " received data");
                       
			 String mode=n.Mode;
					
					
					if(mode.equals("newnote")){
						list.add(n);
					}
					else if(mode.equals("find"))
					{
						String NameToFind=n.Name;
					   for(int i = 0; i < list.size();i++)
						{
							String currName=list.get(i).Name;
							
							if(currName.equals(NameToFind))
							{
								Note n1=list.get(i);
								sending.writeObject(n1);
								
							}
						}
												
					}				
	    }
			catch(Exception e)
			{
				System.out.println("Exception");
				System.out.println(e.getMessage());
			}
	  
	  
	  }
  
    public static void main(String[] args)
    {
		list = new ArrayList<Note>();
			
        try{
			
            ServerSocket listener = new ServerSocket(9001);
			
            while(true)
            {
                socket = listener.accept();   
				System.out.println("Server Started");
				Receive();  
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
