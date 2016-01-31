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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;


public class DropDown extends JFrame implements ActionListener {
  JLabel fontLabel = new JLabel(
      "The quick brown fox jumps over the lazy dog's back.");


  private JComboBox fontComboBox;
  private JComboBox size;
  int tsize = 12;
  String tfont = "Arial";
  private JButton Button = new JButton("Foreground Color");
  private JButton BButton = new JButton ("Background Color");
  private JButton bold = new JButton("B");
  private JButton italic = new JButton ("I");
  private JButton underline = new JButton("U");
 

  public DropDown() { 
    setTitle("Font Chooser");
    setSize(1500, 1000);
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
    BButton.addActionListener(new ButtonListener());
    bold.addActionListener(new ButtonListener());
    italic.addActionListener(new ButtonListener());
    underline.addActionListener(new ButtonListener());
   
    
    setLayout(null);
    JPanel p = new JPanel();
    JPanel s = new JPanel();
    JPanel f = new JPanel();
    JPanel b = new JPanel();
    JPanel B = new JPanel();
    
    JPanel I = new JPanel();
    JPanel U = new JPanel();
    p.add(fontComboBox);
    s.add(size);
    f.add(Button);
    
    b.add(BButton);
    B.add(bold);
    I.add(italic);
    U.add(underline);
    getContentPane().add(B);
    B.setBounds(600,0,100,100);
    getContentPane().add(I);
    getContentPane().add(U);
    
    I.setBounds(350,100,50,50);
    U.setBounds(400,100,50,50);
    getContentPane().add(p);
    p.setBounds(200, 100, 300, 100);
    getContentPane().add(s);
    s.setBounds(380, 100, 300,200);
    getContentPane().add(f);
    f.setBounds(800,100,100,50);
    getContentPane().add(b);
    b.setBounds(1010, 100, 100, 50);
    getContentPane().add(fontLabel);
    fontLabel.setBounds(400,200,700,500);
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
	    	  JButton src = (JButton) e.getSource();

	    	    if (src == Button) 
	    	    {
	    	    	 Color c = JColorChooser.showDialog(null, "Choose Foreground Color", fontLabel.getForeground());
	    		      if (c != null)
	    		        fontLabel.setForeground(c);
	    	    }
	    	    if (src == BButton)
	    	    {
	    	    	 Color b = JColorChooser.showDialog(null, "Choose Background Color", fontLabel.getBackground());
	    		      if (b != null)
	    		    	  fontLabel.setBackground(b);
	    		      	fontLabel.setOpaque(true);
	    	    }
	    	    if (src == bold)
	    	    {
	    	    	fontLabel.setFont(getFont().deriveFont(Font.BOLD));
	    	    }
	  
}
  }
}
           
        
           


