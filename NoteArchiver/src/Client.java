
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.util.Scanner;



public class Client {

public static Socket sender;

        public static void sendNote(int op){
		 try
			{	
				ObjectOutputStream s = new ObjectOutputStream(sender.getOutputStream());
				Note n=new Note();
				Scanner b = new Scanner(System.in);
			
					
					if(op==1)
					{
					   System.out.print("Enter your Name: ");
					   String name = b.nextLine();
					   System.out.print("Enter your Note: ");
					   String text = b.nextLine();
					   n.setName(name);
					   n.setText(text);
					   n.setMode("newnote");
					   
					}
					else if(op==2) 
					{
						System.out.print("Enter Name to find notes : ");
						String name = b.nextLine();	 
						n.setName(name);
						n.setText("");
						n.setMode("find");
					}
				 
				   s.writeObject(n);
				  System.out.println("Note Sent\n");
			  }
			catch(Exception e)
			{
				System.out.println("Exception");
				System.out.println(e.getMessage());
			}
		}
		
		public static void ReceiveNote(){
			
				try
				{
				ObjectInputStream r= new ObjectInputStream(sender.getInputStream());
							
					while(true)
							{
									Note n = (Note)r.readObject();
									if(n!=null){
										System.out.println("User Name: "+n.Name);
										System.out.println("Notes: "+n.Text);
									}
									else{
										System.out.println("No notes exist against this user");
										break;
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
        try
        {
				sender = new Socket("localhost",9001);
			
				System.out.print("1- Create New Note \n 2- Find Note \nEnter your choice:");
				Scanner s = new Scanner(System.in);
				int op = Integer.parseInt(s.nextLine());
				
				sendNote(op);
				
				if(op == 2)
				{
					ReceiveNote();
				}
            
            sender.close();   
        }
        catch(Exception e)
        {
            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
    }
    
}
