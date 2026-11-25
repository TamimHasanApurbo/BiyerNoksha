import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame implements ActionListener{

    JFrame Login;
    JPanel mainPane;
    JLabel lblUser, lblPass, lblPhoto, lblLogo;
    JTextField ut, pt;
    JButton btnLogin, btnSignup, btnBack, btnAdmin;
    JPasswordField pf;
    public static String Un;

    public Login(){
        super(" BiyerNoksha ");

        this.setSize(860,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
        this.setResizable(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(34,7,15));

        ImageIcon img = new ImageIcon("Images/LoginPage.png");
        Image i = img.getImage();
        Image new_img = i.getScaledInstance(
            854,480,Image.SCALE_SMOOTH
        );
        img = new ImageIcon(new_img);

        lblLogo = new JLabel("",img,JLabel.CENTER);
        lblLogo.setBounds(0,0,854,480);
        this.add(lblLogo);

        lblUser = new JLabel();
        lblUser.setText("User name:");
        lblUser.setFont(new Font("Cambria Math",Font.PLAIN,20));
        lblUser.setOpaque(false);
        lblUser.setForeground(new Color(212,175,55));
        lblUser.setBounds(460,200,300,25);
        this.add(lblUser);

        lblPass = new JLabel();
        lblPass.setText("Password:");
        lblPass.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        lblPass.setForeground(new Color(212,175,55));
        lblPass.setBounds(460,250,300,25);
        this.add(lblPass);

        ut = new JTextField();
        ut.setBackground(new Color(255,248,240));
        ut.setForeground(new Color(34,7,15));
        ut.setBounds(590,200,120,20);
        this.add(ut);

        pf = new JPasswordField();
        pf.setBackground(new Color(255,248,240));
        pf.setForeground(new Color(34,7,15));
        pf.setBounds(590,250,120,20);
        this.add(pf);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        btnLogin.setForeground(new Color(212,175,55));
        btnLogin.setBackground(new Color(128,0,32));
        btnLogin.setBounds(620,420,80,25);
        btnLogin.addActionListener(this);
        this.add(btnLogin);

        btnSignup = new JButton("Sign Up");
        btnSignup.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        btnSignup.setForeground(new Color(212,175,55));
        btnSignup.setBackground(new Color(128,0,32));
        btnSignup.setBounds(720,420,100,25);
        btnSignup.addActionListener(this);
        this.add(btnSignup);

        this.add(lblLogo);

        // Adjust the background and form when the window resizes.
        this.getContentPane().addComponentListener(new ComponentAdapter(){
            @Override
            public void componentResized(ComponentEvent e){
                int width = getContentPane().getWidth();
                int height = getContentPane().getHeight();

                if(width <= 0 || height <= 0){
                    return;
                }

                double scaleX = width / 854.0;
                double scaleY = height / 480.0;

                lblLogo.setBounds(0,0,width,height);
                lblLogo.setIcon(new ImageIcon(
                    i.getScaledInstance(
                        width,height,Image.SCALE_SMOOTH
                    )
                ));

                lblUser.setBounds(
                    (int)(460*scaleX),(int)(200*scaleY),
                    (int)(300*scaleX),(int)(25*scaleY)
                );

                lblPass.setBounds(
                    (int)(460*scaleX),(int)(250*scaleY),
                    (int)(300*scaleX),(int)(25*scaleY)
                );

                ut.setBounds(
                    (int)(590*scaleX),(int)(200*scaleY),
                    (int)(120*scaleX),(int)(20*scaleY)
                );

                pf.setBounds(
                    (int)(590*scaleX),(int)(250*scaleY),
                    (int)(120*scaleX),(int)(20*scaleY)
                );

                btnLogin.setBounds(
                    (int)(620*scaleX),(int)(420*scaleY),
                    (int)(80*scaleX),(int)(25*scaleY)
                );

                btnSignup.setBounds(
                    (int)(720*scaleX),(int)(420*scaleY),
                    (int)(100*scaleX),(int)(25*scaleY)
                );
            }
        });

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnLogin){
            String userName = ut.getText();
            String userPassword = pf.getText();
            CreateUserAccount cua1 = new CreateUserAccount();

            if(cua1.getAccount(userName,userPassword)){
                JOptionPane.showMessageDialog(
                    this,"Login Successful"
                );

                SelectReligion h1 = new SelectReligion();
                //s1.addService(userName);
                this.setVisible(false);
                h1.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(
                    this,
                    "Invalid UserName/Password",
                    "INVALID",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        }
        else if(ae.getSource()==btnSignup){
            this.setVisible(false);
            Signup s = new Signup();
            s.setVisible(true);
        }
    }

    public static void main(String args[])
    {
        Login l = new Login();
        l.show();
    }
}