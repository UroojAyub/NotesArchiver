import static org.junit.Assert.*;

import org.junit.Test;

public class NoteTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	   @Test
	    public void NameStorage() {
		   	Note nt = new Note();
		   	nt.Name="urooj";
		   	nt.Text="HELLO WORLD";
		   	nt.Mode="newnote";
	        assertEquals("urooj", nt.Name);
	    
	    }

	    /**
	     * Test of getNotes method, of class Record.
	     */
	    @Test
	    public void ModeStorage() {
	    	Note nt = new Note();
		   	nt.Name="urooj";
		   	nt.Text="";
		   	nt.Mode="find";
	        assertEquals("find", nt.Mode);
	    }

}
