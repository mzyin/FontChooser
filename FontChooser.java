import java.awt.GraphicsEnvironment;

public class FontChooser
{
	   public static void main ( String [] args )
	      {
	      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	      String[] names = ge.getAvailableFontFamilyNames();
	      for ( int i=0; i<names.length; i++ )
	         {
	             System.out.println( names[i] );
	         }
	      

		   //Set<String> styles = getAvailableStyles("Arial");
		      //System.out.println(styles);
	   }
	}



