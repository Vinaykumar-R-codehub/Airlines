import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BookingManagement extends JFrame {
    private JTextField bookingIdField;
    private JTextField flightNumberField;
    private JTextField customerIdField;
    private JTextField seatNumberField;
    private JButton addButton;
    private JTable bookingTable;
    private DefaultTableModel tableModel;
    private List<Booking> bookings;

    public BookingManagement() {
        bookings = new ArrayList<>();
        setTitle("Booking Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("background.jpg");
        panel.setLayout(null);
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(10, 20, 100, 25);
        panel.add(bookingIdLabel);

        bookingIdField = new JTextField(20);
        bookingIdField.setBounds(120, 20, 165, 25);
        panel.add(bookingIdField);

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberLabel.setBounds(10, 50, 100, 25);
        panel.add(flightNumberLabel);

        flightNumberField = new JTextField(20);
        flightNumberField.setBounds(120, 50, 165, 25);
        panel.add(flightNumberField);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(10, 80, 100, 25);
        panel.add(customerIdLabel);

        customerIdField = new JTextField(20);
        customerIdField.setBounds(120, 80, 165, 25);
        panel.add(customerIdField);

        JLabel seatNumberLabel = new JLabel("Seat Number:");
        seatNumberLabel.setBounds(10, 110, 100, 25);
        panel.add(seatNumberLabel);

        seatNumberField = new JTextField(20);
        seatNumberField.setBounds(120, 110, 165, 25);
        panel.add(seatNumberField);

        addButton = new JButton("Add Booking");
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        String[] columnNames = {"Booking ID", "Flight Number", "Customer ID", "Seat Number"};
        tableModel = new DefaultTableModel(columnNames, 0);
        bookingTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookingTable);
        scrollPane.setBounds(10, 170, 560, 150);
        panel.add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBooking();
            }
        });
    }

    private void addBooking() {
        String bookingId = bookingIdField.getText();
        String flightNumber = flightNumberField.getText();
        String customerId = customerIdField.getText();
        String seatNumber = seatNumberField.getText();

        if (bookingId.isEmpty() || flightNumber.isEmpty() || customerId.isEmpty() || seatNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking booking = new Booking(bookingId, flightNumber, customerId, seatNumber);
        bookings.add(booking);
        tableModel.addRow(new Object[]{bookingId, flightNumber, customerId, seatNumber});

        // Clear input fields after adding the booking
        bookingIdField.setText("");
        flightNumberField.setText("");
        customerIdField.setText("");
        seatNumberField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookingManagement().setVisible(true);
            }
        });
    }
}

class Booking {
    private String bookingId;
    private String flightNumber;
    private String customerId;
    private String seatNumber;

    public Booking(String bookingId, String flightNumber, String customerId, String seatNumber) {
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.customerId = customerId;
        this.seatNumber = seatNumber;
    }

    // Getters and setters for the fields can be added here if needed
}
