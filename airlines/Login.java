import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Map<String, String> users;

    public Login() {
        // Initialize user data
        users = new HashMap<>();
        users.put("admin", "admin123");
        users.put("user", "user123");

        setTitle("Airlines Management System - Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("background.jpg");
        panel.setLayout(null);
        add(panel);
        placeComponents(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    // Proceed to the MainDashboard
                    new MainDashboard().setVisible(true);
                    dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
    }

    private void placeComponents(JPanel panel) {
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }

    private boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
