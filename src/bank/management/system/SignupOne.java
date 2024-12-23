package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, stateTextField, countryTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;  // For Date of Birth

    SignupOne() {
        setLayout(null);

        // Generate a random application form number
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO: " + random);
        formno.setBounds(140, 20, 600, 40);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personalDetails.setBounds(290, 80, 400, 30);
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(personalDetails);

        JLabel name = new JLabel("Name *");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(100, 240, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setFont(new Font("Arial", Font.BOLD, 14));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 120, 30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.white);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setBounds(100, 340, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100, 390, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add(marital);
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.white);
        add(other);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add(address);
        addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 400, 30);
        addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(addressTextField);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 490, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 490, 400, 30);
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(stateTextField);

        JLabel country = new JLabel("Country:");
        country.setBounds(100, 540, 200, 30);
        country.setFont(new Font("Raleway", Font.BOLD, 20));
        add(country);
        countryTextField = new JTextField();
        countryTextField.setBounds(300, 540, 400, 30);
        countryTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(countryTextField);

        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(800, 800);  
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        
        // Getting date of birth from the dateChooser
        java.util.Date date = dateChooser.getDate();
        String dob = (date != null) ? new SimpleDateFormat("yyyy-MM-dd").format(date) : "";

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String state = stateTextField.getText();
        String country = countryTextField.getText();

        // Validation for all required fields
        try {
            if (name.equals("") || fname.equals("") || dob.equals("") || gender == null || email.equals("") || marital == null || address.equals("") || state.equals("") || country.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
            } else {
                // Assuming Conn is a custom class for DB connection
                Conn c = new Conn();
                String query = "INSERT INTO signup (formno, name, dob, gender, email, marital_status, address, state, country) " +
                               "VALUES ('" + formno + "','" + name + "','" + dob + "','" + gender + "','" + email + "','" + marital+ "','" + address + "','" + state + "','" + country + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully!");
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
