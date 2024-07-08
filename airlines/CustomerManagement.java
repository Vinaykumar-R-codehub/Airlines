import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagement extends JFrame {
    private JTextField customerIdField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton addButton;
    private JTable customerTable;
    private DefaultTableModel tableModel;
    private List<Customer> customers;

    public CustomerManagement() {
        customers = new ArrayList<>();
        setTitle("Customer Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("background.jpg");
        panel.setLayout(null);
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(10, 20, 100, 25);
        panel.add(customerIdLabel);

        customerIdField = new JTextField(20);
        customerIdField.setBounds(120, 20, 165, 25);
        panel.add(customerIdField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 50, 100, 25);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(120, 50, 165, 25);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 80, 100, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(120, 80, 165, 25);
        panel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 110, 100, 25);
        panel.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(120, 110, 165, 25);
        panel.add(phoneField);

        addButton = new JButton("Add Customer");
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        String[] columnNames = {"Customer ID", "Name", "Email", "Phone"};
        tableModel = new DefaultTableModel(columnNames, 0);
        customerTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(customerTable);
        scrollPane.setBounds(10, 170, 560, 150);
        panel.add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });
    }

    private void addCustomer() {
        String customerId = customerIdField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        if (customerId.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Customer customer = new Customer(customerId, name, email, phone);
        customers.add(customer);
        tableModel.addRow(new Object[]{customerId, name, email, phone});

        // Clear input fields after adding the customer
        customerIdField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerManagement().setVisible(true);
            }
        });
    }
}

class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters and setters for the fields can be added here if needed
}
