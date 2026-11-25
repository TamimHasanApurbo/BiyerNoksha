import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BkashPayment4 extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
		JTextField t1,t3,t4,t5,t6;
		JButton b1,b2,b3,b5; 
		JPanel p1,p2;
		JPasswordField t2;
		ButtonGroup bg1;
		JRadioButton c0,c1,c2,c3,c4;
		
		BkashPayment4(){
			
			super(" BiyerNoksha ");
			
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        double scaleX = screen.width / 854.0;
        double scaleY = screen.height / 580.0;

        this.setSize(screen.width,screen.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setVisible(true);
		this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(34,7,15));
		
		
		ImageIcon img = new ImageIcon("Images/BkashPayment.png");
		Image i= img.getImage();
		Image new_img = i.getScaledInstance(screen.width,screen.height,Image.SCALE_SMOOTH);
       	img = new ImageIcon(new_img);
		l1 = new JLabel("",img,JLabel.CENTER);
		l1.setBounds(0,0,screen.width,screen.height);
		
		t1 = new JTextField();
        t1.setBackground(new Color(255,248,240));
        t1.setForeground(new Color(34,7,15));
		t1.setBounds(
            (int)Math.round(410*scaleX-150),
            (int)Math.round(262.5*scaleY-12.5),
            300,25
        );
		this.add(t1);
		t2 = new JPasswordField();
        t2.setBackground(new Color(255,248,240));
        t2.setForeground(new Color(34,7,15));
		t2.setBounds(
            (int)Math.round(410*scaleX-150),
            (int)Math.round(392.5*scaleY-12.5),
            300,25
        );
		this.add(t2);
		
		
		this.add(l1);
		
		b1 = new JButton("Back");
		b1.setFont(new Font("Abadi",Font.BOLD,15));
		b1.setBackground(new Color(128,0,32));
		b1.setForeground(new Color(212,175,55));
		b1.setBounds(
            (int)Math.round(760*scaleX-40),
            (int)Math.round(472.5*scaleY-12.5),
            80,25
        );
		b1.addActionListener(this);
		this.add(b1);
		
		b2 = new JButton("Next");
		b2.setFont(new Font("Abadi",Font.BOLD,15));
		b2.setBackground(new Color(128,0,32));
		b2.setForeground(new Color(212,175,55));
		b2.setBounds(
            (int)Math.round(660*scaleX-40),
            (int)Math.round(472.5*scaleY-12.5),
            80,25
        );
		b2.addActionListener(this);
		this.add(b2);
		
		this.add(l1);
		}
		public void actionPerformed(ActionEvent ae)
		{
			String MobileNumber = t1.getText();
			String Pin = t2.getText();
		
			if(ae.getSource()==b1)
			{
				PaymentPage1 f = new PaymentPage1();
				this.setVisible(false);
				f.setVisible(true);
		}
		else if(ae.getSource()==b2)
			{
				if (MobileNumber.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Phone number ");
				}
				else if (Pin.isEmpty())
				{JOptionPane.showMessageDialog(null, "Invalid  Pin");}
				else{
					
					JOptionPane.showMessageDialog(null, "Payment Confirmed\nThank you For Being With BiyerNoksha");
					WelcomePage T= new WelcomePage();
					this.setVisible(false);
					T.setVisible(true);
				}
		}
		}
		
		public static void main (String args [])
		{
			BkashPayment4 b= new BkashPayment4();
			b.show();
			
		}
}