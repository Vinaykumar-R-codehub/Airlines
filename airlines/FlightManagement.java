import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FlightManagement extends JFrame {
    private JTextField flightNumberField;
    private JTextField departureField;
    private JTextField destinationField;
    private JTextField timeField;
    private JTextField dateField;
    private JButton addButton;
    private JTable flightTable;
    private DefaultTableModel tableModel;
    private List<Flight> flights;

    public FlightManagement() {
        flights = new ArrayList<>();
        setTitle("Flight Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("background.jpg");
        panel.setLayout(null);
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberLabel.setBounds(10, 20, 100, 25);
        panel.add(flightNumberLabel);

        flightNumberField = new JTextField(20);
        flightNumberField.setBounds(120, 20, 165, 25);
        panel.add(flightNumberField);

        JLabel departureLabel = new JLabel("Departure:");
        departureLabel.setBounds(10, 50, 100, 25);
        panel.add(departureLabel);

        departureField = new JTextField(20);
        departureField.setBounds(120, 50, 165, 25);
        panel.add(departureField);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(10, 80, 100, 25);
        panel.add(destinationLabel);

        destinationField = new JTextField(20);
        destinationField.setBounds(120, 80, 165, 25);
        panel.add(destinationField);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(10, 110, 100, 25);
        panel.add(timeLabel);

        timeField = new JTextField(20);
        timeField.setBounds(120, 110, 165, 25);
        panel.add(timeField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(10, 140, 100, 25);
        panel.add(dateLabel);

        dateField = new JTextField(20);
        dateField.setBounds(120, 140, 165, 25);
        panel.add(dateField);

        addButton = new JButton("Add Flight");
        addButton.setBounds(10, 170, 120, 25);
        panel.add(addButton);

        String[] columnNames = {"Flight Number", "Departure", "Destination", "Time", "Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        flightTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(10, 200, 560, 150);
        panel.add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });
    }

    private void addFlight() {
        String flightNumber = flightNumberField.getText();
        String departure = departureField.getText();
        String destination = destinationField.getText();
        String time = timeField.getText();
        String date = dateField.getText();

        if (flightNumber.isEmpty() || departure.isEmpty() || destination.isEmpty() || time.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Flight flight = new Flight(flightNumber, departure, destination, time, date);
        flights.add(flight);
        tableModel.addRow(new Object[]{flightNumber, departure, destination, time, date});

        // Clear input fields after adding the flight
        flightNumberField.setText("");
        departureField.setText("");
        destinationField.setText("");
        timeField.setText("");
        dateField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlightManagement().setVisible(true);
            }
        });
    }
}

class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private String time;
    private String date;

    public Flight(String flightNumber, String departure, String destination, String time, String date) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.time = time;
        this.date = date;
    }

    // Getters and setters for the fields can be added here if needed
}
