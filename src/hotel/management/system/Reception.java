package hotel.management.system;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b20, b30, b42;
    JLabel l1, l2;

    Reception() {

        super("Reception");
        l1 = new JLabel("Dashboard");
        l1.setBounds(310, 20, 200, 40);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("sanserif", Font.BOLD, 27));

        add(l1);

        b1 = new JButton("New Guest Form");
        b1.setBounds(50, 100, 200, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Room Info");
        b2.setBounds(50, 170, 200, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);

        b4 = new JButton("Employee Info");
        b4.setBounds(50, 310, 200, 40);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("sanserif", Font.BOLD, 20));
        b4.setBackground(Color.DARK_GRAY);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Guest Info");
        b5.setBounds(50, 240, 200, 40);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("sanserif", Font.BOLD, 20));
        b5.setBackground(Color.DARK_GRAY);
        b5.addActionListener(this);
        add(b5);

        b7 = new JButton("Check Out");
        b7.setBounds(500, 170, 200, 40);
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("sanserif", Font.BOLD, 20));
        b7.setBackground(Color.DARK_GRAY);
        b7.addActionListener(this);
        add(b7);

        b10 = new JButton("Search Room");
        b10.setBounds(500, 100, 200, 45);
        b10.setForeground(Color.WHITE);
        b10.setFont(new Font("sanserif", Font.BOLD, 20));
        b10.setBackground(Color.DARK_GRAY);
        b10.addActionListener(this);
        add(b10);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/log.jpg"));
        Image i2 = i1.getImage().getScaledInstance(60, 55, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        b12 = new JButton(i3);
        b12.setBounds(590, 420, 60, 50);
        b12.setForeground(Color.WHITE);
        b12.setFont(new Font("sanserif", Font.BOLD, 20));
        b12.setBackground(Color.DARK_GRAY);
        b12.addActionListener(this);
        add(b12);

        b30 = new JButton("other service");
        b30.setBounds(500, 310, 200, 40);
        b30.setForeground(Color.WHITE);
        b30.setFont(new Font("sanserif", Font.BOLD, 20));
        b30.setBackground(Color.DARK_GRAY);
        b30.addActionListener(this);
        add(b30);

        b42 = new JButton("Bill");
        b42.setBounds(500, 240, 200, 40);
        b42.setForeground(Color.WHITE);
        b42.setFont(new Font("sanserif", Font.BOLD, 20));
        b42.setBackground(Color.DARK_GRAY);
        b42.addActionListener(this);
        add(b42);

        setLayout(null);
        setBounds(300, 80, 800, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            new GuestForm().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b2) {
            new RoomInfo().setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b4) {
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b5) {
            new GuestInfo().setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b7) {
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b10) {
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b12) {
            new login().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b30) {
            new carservice().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b42) {
            new bill().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
}
