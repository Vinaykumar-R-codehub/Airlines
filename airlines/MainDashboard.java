import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDashboard extends JFrame {
    private JButton flightManagementButton;
    private JButton customerManagementButton;
    private JButton bookingManagementButton;

    public MainDashboard() {
        setTitle("Airlines Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("background.jpg");
        panel.setLayout(new GridBagLayout());
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        flightManagementButton = new JButton("Flight Management");
        panel.add(flightManagementButton, gbc);

        customerManagementButton = new JButton("Customer Management");
        panel.add(customerManagementButton, gbc);

        bookingManagementButton = new JButton("Booking Management");
        panel.add(bookingManagementButton, gbc);

        flightManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FlightManagement().setVisible(true);
            }
        });

        customerManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerManagement().setVisible(true);
            }
        });

        bookingManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookingManagement().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainDashboard().setVisible(true);
            }
        });
    }
}
