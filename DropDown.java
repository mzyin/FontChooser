import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.util.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import javax.swing.JTextArea;
import javax.swing.*;
import javax.swing.text.*;
 import java.awt.*;              
import java.awt.event.*;        



public class DropDown extends JFrame implements ActionListener {
  JTextArea fontLabel = new JTextArea("The quick brown fox jumps over the lazy dog's back. Pack my box with five dozen liquor jugs."
	  + " Jackdaws love my big sphinx of quartz."
      + " Mr. Jock, TV quiz PhD, bags few lynx."
      + " abcdefghijklmnopqrstuvwxyz"
      + " ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      + " 01234567890"
      + " €†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£»®§­¹²³ß×™¨¥"
      + " ÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ"
      + " àáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ"
      + " !#$%&'()*+,-./:;<=>?@[^_z{|}~"
      + " uvw wW gq9 2z 5s il17|!j oO08 `' ;:,. m nn rn {[()]}u");

  private JComboBox fontComboBox;
  private JComboBox size;
  int tsize = 12;
  String tfont = "Arial";
  private JButton Button = new JButton("Foreground Color");
  private JButton BButton = new JButton ("Background Color");
  private JButton bold = new JButton("B");
  private JButton italic = new JButton ("I");
  private JButton underline = new JButton("U");
  private JButton plain = new JButton("P");
 


  public DropDown() { 
    setTitle("Font Chooser");
    setSize(1500, 1000);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    fontLabel.setLineWrap(true);
    fontLabel.setWrapStyleWord(true);
   
    
    //Making a scroll pane-- this does not work!!!!!!!!!!!!!
    JScrollPane scroll = new JScrollPane(fontLabel);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setVisible(true);
  
   
    //Dropdown menu for the font family 
    fontComboBox = new JComboBox();
    fontComboBox.setEditable(true);
    fontComboBox.addActionListener(this);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] names = ge.getAvailableFontFamilyNames();
    for ( int i=0; i<names.length; i++ )
    {
       fontComboBox.addItem(names[i]);
    }

    //dropdown menu for font size
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
   
    //adding action listeners to buttons
    Button.addActionListener(new ButtonListener());
    BButton.addActionListener(new ButtonListener());
    bold.addActionListener(new ButtonListener());
    italic.addActionListener(new ButtonListener());
    underline.addActionListener(new ButtonListener());
    plain.addActionListener(new ButtonListener());
   
    //laying out the buttons and dropdown menus
    setLayout(null);
    JPanel p = new JPanel();
    JPanel s = new JPanel();
    JPanel f = new JPanel();
    JPanel b = new JPanel();
    JPanel B = new JPanel();
    JPanel I = new JPanel();
    JPanel U = new JPanel();
    JPanel P = new JPanel();
    p.add(fontComboBox);
    s.add(size);
    f.add(Button);
    b.add(BButton);
    B.add(bold);
    I.add(italic);
    U.add(underline);
    P.add(plain);
    getContentPane().add(P);
    getContentPane().add(B);  
    getContentPane().add(I);
    getContentPane().add(U);
    getContentPane().add(p);
    getContentPane().add(s);
    getContentPane().add(f);
    getContentPane().add(b);
    getContentPane().add(fontLabel);
    P.setBounds(775,100,65,50);
    B.setBounds(580,100,65,50);
    I.setBounds(645,100,65,50);
    U.setBounds(710,100,65,50);
    p.setBounds(200, 100, 300, 50);
    s.setBounds(350, 100, 350,50);
    f.setBounds(860,100,150,50);
    b.setBounds(1010, 100, 150, 50);
    fontLabel.setBounds(400,200,700,500);
   
  }
  
  //listeners for dropdown menus
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
    	Integer Size = (Integer) source.getSelectedItem();
    	if (Size != null) 
    	{
    		fontLabel.setFont(new Font(tfont,Font.PLAIN,Size));
    		tsize = Size;
    	}
    }
  }
 
  public static void main(String[] args) {
    JFrame frame = new DropDown();
    frame.show();

  }

  
  //listeners for buttons
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
	    	    	fontLabel.setFont(new Font(tfont, Font.BOLD, tsize));
	    	    }
	    	    if (src == italic)
	    	    {
	    	    	fontLabel.setFont(new Font(tfont, Font.ITALIC, tsize));
	    	    }
	    	    if (src == underline)
	    	    {
	    	    	Font font1 = fontLabel.getFont();
	    	    	Map attributes = font1.getAttributes();
	    	    	attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    	    	fontLabel.setFont(font1.deriveFont(attributes));
	    	    }
	    	    if (src == plain)
	    	    {
	    	    	fontLabel.setFont(new Font(tfont, Font.PLAIN, tsize));
	    	    }
	  

  }
}
  }

