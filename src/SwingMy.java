import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMy {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame jfrm = new JFrame("My program");
                jfrm.setSize(300, 200);
                jfrm.setLocation(100, 200);
                jfrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                JButton button = new JButton("press");

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DATABASE d = new DATABASE();
                        d.data();
                    }
                });
                JPanel jpan = new JPanel();
                jpan.setLayout(new BorderLayout());
                jpan.add(button, BorderLayout.CENTER);
                jfrm.add(jpan);
                jfrm.setVisible(true);
            }
        });
    }
}