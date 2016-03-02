


public class Note implements java.io.Serializable
{
    public String Name;
    public String Text;
    public String Mode;	//can be 'newnote' or 'find'
	
    public Note()
    {
	
        Name = "" ;
        Text = "";
        Mode ="";
		
    }
    
	
	public void setName(String Name)
    {
        this.Name=Name;
    }
	
	public void setText(String Note)
    {
        this.Text=Note;
    }
	public void setMode(String Mode)
    {
        this.Mode=Mode;
    }
	
}
