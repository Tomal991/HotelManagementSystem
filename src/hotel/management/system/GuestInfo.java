package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class GuestInfo extends JFrame implements ActionListener {

    JTable tab1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11,l12;
    JButton b1, b2, b3, b4;

    GuestInfo() {
        super("Guest Info");

        tab1 = new JTable();
        tab1.setBounds(0, 40, 920, 400);
        add(tab1);

        l1 = new JLabel("Type");
        l1.setBounds(15, 10, 100, 30);
        add(l1);
        l2 = new JLabel("ID");
        l2.setBounds(110, 10, 100, 30);
        add(l2);
        l3 = new JLabel("Name");
        l3.setBounds(170, 10, 100, 30);
        add(l3);
        l4 = new JLabel("Gender");
        l4.setBounds(240, 10, 100, 30);
        add(l4);
        l5 = new JLabel("Country");
        l5.setBounds(320, 10, 100, 30);
        add(l5);
        l6 = new JLabel("Room");
        l6.setBounds(400, 10, 100, 30);
        add(l6);
        l7 = new JLabel("CheckIN");
        l7.setBounds(470, 10, 100, 30);
        add(l7);
        l8 = new JLabel("CheckOUT");
        l8.setBounds(545, 10, 100, 30);
        add(l8);
        l9 = new JLabel("Price");
        l9.setBounds(635, 10, 100, 30);
        add(l9);
        l10 = new JLabel("TOTAL");
        l10.setBounds(707, 10, 100, 30);
        add(l10);
        l11 = new JLabel("driver");
        l11.setBounds(780, 10, 100, 30);
        add(l11);
        l12 = new JLabel("time");
        l12.setBounds(860, 10, 100, 30);
        add(l12);

        b1 = new JButton("Load Data");
        b1.setBounds(150, 485, 130, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Update");
        b2.setBounds(310, 485, 120, 40);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/b6.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b4 = new JButton(i3);
        b4.setBounds(487, 487, 70, 35);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("sanserif", Font.BOLD, 20));
        b4.setBackground(Color.DARK_GRAY);
        b4.addActionListener(this);
        add(b4);

        setLayout(null);
        setBounds(250, 40, 930, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            conn c = new conn();
            String str = "select * from guest";
            try {
                ResultSet rs = c.s.executeQuery(str);
                tab1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                System.out.println();
            }
        }
        if (ae.getSource() == b2) {
            new UpdateGuest().setVisible(true);
            this.setVisible(false);
        }

       
        if (ae.getSource() == b4) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new GuestInfo().setVisible(true);
    }
}
