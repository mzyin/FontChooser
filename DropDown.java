import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class DropDown extends JFrame implements ActionListener {
  JLabel fontLabel = new JLabel(
      "The quick brown fox jumps over the lazy dog's back.");

  private JComboBox fontComboBox;
  private JComboBox size;
  int tsize = 12;
  String tfont = "Arial";
  private JButton Button = new JButton("Foreground Color");


  public DropDown() { 
    setTitle("ComboBoxTest");
    setSize(400, 300);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    fontComboBox = new JComboBox();
    fontComboBox.setEditable(true);
    fontComboBox.addActionListener(this);
    
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] names = ge.getAvailableFontFamilyNames();
    for ( int i=0; i<names.length; i++ )
    {
       fontComboBox.addItem(names[i]);
    }

    size = new JComboBox();
    size.setEditable(true);
    size.addActionListener(this);
    
    size.addItem(8);
    size.addItem(9);
    size.addItem(10);
    size.addItem(12);
    size.addItem(14);
    size.addItem(16);
    size.addItem(18);
    size.addItem(20);
    size.addItem(22);
    size.addItem(24);
    size.addItem(28);
    size.addItem(36);
    size.addItem(48);
    size.addItem(72);
   
    Button.addActionListener(new ButtonListener());
    
    JPanel p = new JPanel();
    JPanel s = new JPanel();
    JPanel f = new JPanel();
    p.add(fontComboBox);
    s.add(size);
    f.add(Button);
    getContentPane().add(p, "West");
    getContentPane().add(s, "East");
    getContentPane().add(f, "North");
    getContentPane().add(fontLabel, "Center");
  }

  public void actionPerformed(ActionEvent evt) {
    JComboBox source = (JComboBox) evt.getSource();

    if (source == fontComboBox) 
    {
    	String font = (String) source.getSelectedItem();
    	fontLabel.setFont(new Font(font, Font.PLAIN, tsize));
    	tfont = font;
    }
    if (source == size)
    {
    	int Size = (int) source.getSelectedItem();
    	fontLabel.setFont(new Font(tfont,Font.PLAIN,Size));
    	tsize = Size;
    }
  }
 
  public static void main(String[] args) {
    JFrame frame = new DropDown();
    frame.show();
  }

  private class ButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      Color c = JColorChooser.showDialog(null, "Choose a Color", fontLabel.getForeground());
	      if (c != null)
	        fontLabel.setForeground(c);
}
  }
}
           
        
           


