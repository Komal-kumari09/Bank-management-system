/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.awt.*;
//import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;  // class-level declaration
    JButton deposit, back;
    String pinnumber;

    // Constructor
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Label setup
        JLabel text = new JLabel("Enter the amount you want to deposit ");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.white);
        image.add(text);

        // Initialize the instance field 'amount'
        amount = new JTextField();  // Now using the class-level 'amount'
        amount.setBounds(170, 350, 320, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        add(amount);

        // Deposit button setup
        deposit = new JButton("Deposit");
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        // Back button setup
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(350, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // JFrame settings
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();  // Now using the class-level 'amount'
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter amount you want to deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO bank VALUES('" + pinnumber + "','" + date + "','Deposit','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " deposited");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Deposit("");  // Test with an empty PIN
    }
}
