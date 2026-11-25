import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class ConfirmPaymentPage2 extends JFrame implements ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
		JTextField t1,t3,t4,t5,t6;
		JButton b1,b2,b3,b5; 
		JPanel p1,p2;
		JPasswordField t2;
		ButtonGroup bg1;
		JRadioButton c1,c2,c3,c4;

    ConfirmPaymentPage2() {
        	super(" BiyerNoksha ");
			
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        double scaleX = screen.width / 854.0;
        double scaleY = screen.height / 480.0;

        this.setSize(screen.width,screen.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setVisible(true);
		this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(34,7,15));
		
		ImageIcon img = new ImageIcon("Images/ConfirmPaymentPage.png");
		Image i= img.getImage();
		Image new_img = i.getScaledInstance(screen.width,screen.height,Image.SCALE_SMOOTH);
       	img = new ImageIcon(new_img);
		l1 = new JLabel("",img,JLabel.CENTER);
		l1.setBounds(0,0,screen.width,screen.height);
			
			
		
		        b1 = new JButton("Back");
		b1.setFont(new Font("Abadi",Font.BOLD,15));
		b1.setBackground(new Color(128,0,32));
		b1.setForeground(new Color(212,175,55));
		b1.setBounds(
            (int)Math.round(760*scaleX-40),
            (int)Math.round(432.5*scaleY-12.5),
            80,25
        );
		b1.addActionListener(this);
		this.add(b1);
		
		b2 = new JButton("Confirm");
		b2.setFont(new Font("Abadi",Font.BOLD,15));
		b2.setBackground(new Color(128,0,32));
		b2.setForeground(new Color(212,175,55));
		b2.setBounds(
            (int)Math.round(650*scaleX-50),
            (int)Math.round(432.5*scaleY-12.5),
            100,25
        );
		b2.addActionListener(this);
		this.add(b2);
			
			
			
	this.add(l1);	
	}
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				SelectReligion f = new SelectReligion();
				this.setVisible(false);
				f.setVisible(true);
		}
		else if(ae.getSource()==b2)
			{
				PaymentPage2 f = new PaymentPage2();
				this.setVisible(false);
				f.setVisible(true);
		}
		
		}
	public static void main (String args [])
	{
		
		ConfirmPaymentPage2 c = new ConfirmPaymentPage2();
		c.show();
		
	}
}