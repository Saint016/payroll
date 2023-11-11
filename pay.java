import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayrollCalculatorGUI extends JFrame {

    private JTextField nameField, rateField, hoursField, daysField, grossSalaryField, netSalaryField;

    public PayrollCalculatorGUI() {
        // Set frame properties
        setTitle("Payroll Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create and add labels
        JLabel nameLabel = new JLabel("Employee Name (Registration Number):");
        nameLabel.setBounds(20, 20, 250, 20);
        add(nameLabel);

        JLabel rateLabel = new JLabel("Rate per Hour:");
        rateLabel.setBounds(20, 50, 150, 20);
        add(rateLabel);

        JLabel hoursLabel = new JLabel("Hours per Day:");
        hoursLabel.setBounds(20, 80, 150, 20);
        add(hoursLabel);

        JLabel daysLabel = new JLabel("Number of Days Worked:");
        daysLabel.setBounds(20, 110, 200, 20);
        add(daysLabel);

        JLabel grossSalaryLabel = new JLabel("Gross Salary:");
        grossSalaryLabel.setBounds(20, 140, 150, 20);
        add(grossSalaryLabel);

        JLabel netSalaryLabel = new JLabel("Net Salary:");
        netSalaryLabel.setBounds(20, 170, 150, 20);
        add(netSalaryLabel);

        // Create and add editable fields
        nameField = new JTextField("YourRegistrationNumber");
        nameField.setBounds(250, 20, 120, 20);
        nameField.setEditable(false);
        add(nameField);

        rateField = new JTextField();
        rateField.setBounds(250, 50, 120, 20);
        add(rateField);

        hoursField = new JTextField();
        hoursField.setBounds(250, 80, 120, 20);
        add(hoursField);

        daysField = new JTextField();
        daysField.setBounds(250, 110, 120, 20);
        add(daysField);

        grossSalaryField = new JTextField();
        grossSalaryField.setBounds(250, 140, 120, 20);
        grossSalaryField.setEditable(false);
        add(grossSalaryField);

        netSalaryField = new JTextField();
        netSalaryField.setBounds(250, 170, 120, 20);
        netSalaryField.setEditable(false);
        add(netSalaryField);

        // Create and add calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 200, 100, 30);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePayroll();
            }
        });
        add(calculateButton);

        // Set frame visibility
        setVisible(true);
    }

    private void calculatePayroll() {
        // Get input values
        double rate = Double.parseDouble(rateField.getText());
        double hours = Double.parseDouble(hoursField.getText());
        double days = Double.parseDouble(daysField.getText());

        // Calculate gross salary
        double grossSalary = rate * hours * days;
        grossSalaryField.setText(String.valueOf(grossSalary));

        // Calculate net salary with deductions
        double tax = 0.15 * grossSalary;
        double philhealth = 0.05 * grossSalary;
        double sss = 0.02 * grossSalary;
        double netSalary = grossSalary - tax - philhealth - sss;
        netSalaryField.setText(String.valueOf(netSalary));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PayrollCalculatorGUI();
            }
        });
    }
}
