import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3,b5;
    JPanel p1,p2;
    ButtonGroup bg1;
    JRadioButton c1,c2,c3,c4;

    WelcomePage()
    {
        super(" BiyerNoksha ");

        this.setSize(854,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        final Image backgroundImage =
            new ImageIcon("Images/Pannel1.png").getImage();

        b1 = new JButton("Next");
        b1.setFont(new Font("Baguet Script",Font.BOLD,20));
        b1.setBackground(new Color(128,0,32));
        b1.setForeground(new Color(212,175,55));
        b1.setOpaque(true);
        b1.addActionListener(this);

        l1 = new JLabel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(
                    RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR
                );

                // Background fills the entire window.
                g2.drawImage(
                    backgroundImage,
                    0,0,
                    getWidth(),getHeight(),
                    this
                );

                g2.dispose();
            }

            @Override
            public void doLayout()
            {
                int width = getWidth();
                int height = getHeight();

                int buttonWidth =
                    Math.max(120,Math.min(180,width / 8));

                int buttonHeight =
                    Math.max(36,Math.min(55,height / 14));

                // Position below the logo on the right.
                int x =
                    (int) Math.round(width * 0.74)
                    - buttonWidth / 2;

                int y =
                    (int) Math.round(height * 0.65);

                b1.setBounds(
                    x,y,
                    buttonWidth,buttonHeight
                );
            }
        };

        l1.setLayout(null);
        l1.setOpaque(true);
        l1.setBackground(Color.BLACK);
        l1.add(b1);

        this.setContentPane(l1);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            Login f = new Login();
            this.setVisible(false);
            f.setVisible(true);
        }
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(() -> {
            WelcomePage w = new WelcomePage();
            w.setVisible(true);
        });
    }
}