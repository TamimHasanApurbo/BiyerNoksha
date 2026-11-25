import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Start {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomePage f = new WelcomePage();

            f.setResizable(true);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);

            f.setTitle("BiyerNoksha");

            f.setVisible(true);
        });
    }
}