package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton b1, b2, b3;
    JComboBox c3, c4;

    JCheckBox c2;
    JTable tab1;

    SearchRoom() {

        tab1 = new JTable();
        tab1.setBounds(0, 160, 910, 300);
        add(tab1);

        l7 = new JLabel("Search Room");
        l7.setBounds(350, 20, 300, 30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("sanserif", Font.BOLD, 25));
        l7.setBackground(Color.DARK_GRAY);
        add(l7);
        l6 = new JLabel("Room Type");
        l6.setBounds(50, 65, 100, 30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("sanserif", Font.BOLD, 15));

        add(l6);

        l1 = new JLabel("Room number");
        l1.setBounds(40, 120, 100, 30);
        add(l1);
        l2 = new JLabel("Available");
        l2.setBounds(250, 120, 100, 30);
        add(l2);
        l3 = new JLabel("status");
        l3.setBounds(430, 120, 100, 30);
        add(l3);
        l4 = new JLabel("Room Type");
        l4.setBounds(590, 120, 100, 30);
        add(l4);
        l5 = new JLabel("Price");
        l5.setBounds(750, 120, 100, 30);
        add(l5);

        c3 = new JComboBox(new String[]{"Single Bed", "Double Bed", "King-size", "Deluxe", "Suite", "Presendintial Suite"});
        c3.setBounds(150, 65, 170, 30);
        c3.addActionListener(this);
        add(c3);

        c2 = new JCheckBox("Only Display Available");
        c2.setBounds(550, 70, 380, 30);
        c2.setForeground(Color.BLACK);
        c2.setFont(new Font("sanserif", Font.BOLD, 15));

        add(c2);

        b2 = new JButton("Submit");
        b2.setBounds(200, 480, 120, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("Back");
        b3.setBounds(400, 480, 120, 40);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("sanserif", Font.BOLD, 20));
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setBounds(250, 40, 920, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            try {
                String s1 = (String) c3.getSelectedItem();
                conn c = new conn();
                String str = "select * from room where room_type='" + s1 + "'";
                String str2 = "select * from room where available='Available'";
                ResultSet rs = c.s.executeQuery(str);
                tab1.setModel(DbUtils.resultSetToTableModel(rs));

                if (c2.isSelected()) {
                    ResultSet rs2 = c.s.executeQuery(str2);
                    tab1.setModel(DbUtils.resultSetToTableModel(rs2));
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ae.getSource() == b3) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}
