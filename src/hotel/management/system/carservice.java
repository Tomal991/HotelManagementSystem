package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class carservice extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton b1, b2, b3, b4, b5, b7;
    Choice c3;

    JCheckBox c2;
    JTable tab1;

    carservice() {
        super("Car Service");
        tab1 = new JTable();
        tab1.setBounds(0, 160, 810, 300);
        add(tab1);
        JLabel l3 = new JLabel("Car Service");
        l3.setBounds(250, 20, 300, 30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("sanserif", Font.BOLD, 20));
        l3.setBackground(Color.DARK_GRAY);
        add(l3);
        JLabel l1 = new JLabel("name");
        l1.setBounds(10, 120, 100, 30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("sanserif", Font.BOLD, 15));
        l1.setBackground(Color.DARK_GRAY);
        add(l1);
        JLabel l4 = new JLabel("Age");
        l4.setBounds(150, 120, 100, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("sanserif", Font.BOLD, 15));
        l4.setBackground(Color.DARK_GRAY);
        add(l4);
        JLabel l2 = new JLabel("Gender");
        l2.setBounds(290, 120, 100, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("sanserif", Font.BOLD, 15));
        l2.setBackground(Color.DARK_GRAY);
        add(l2);
        JLabel l5 = new JLabel("Company");
        l5.setBounds(420, 120, 100, 30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("sanserif", Font.BOLD, 15));
        l5.setBackground(Color.DARK_GRAY);
        add(l5);
        JLabel l6 = new JLabel("Model");
        l6.setBounds(580, 120, 100, 30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("sanserif", Font.BOLD, 15));
        l6.setBackground(Color.DARK_GRAY);
        add(l6);
        JLabel l7 = new JLabel("Available");
        l7.setBounds(700, 120, 100, 30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("sanserif", Font.BOLD, 15));
        l7.setBackground(Color.DARK_GRAY);
        add(l7);

        c2 = new JCheckBox("Only Display Available");
        c2.setBounds(400, 70, 380, 30);

        c2.setFont(new Font("sanserif", Font.BOLD, 20));

        add(c2);

        b1 = new JButton("Load Data");
        b1.setBounds(225, 500, 130, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Update");
        b2.setBounds(380, 500, 120, 40);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);
        
        b4 = new JButton("Back");
        b4.setBounds(530, 500, 100, 40);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("sanserif", Font.BOLD, 20));
        b4.setBackground(Color.DARK_GRAY);
        b4.addActionListener(this);
        add(b4);
        b5 = new JButton("Add");
        b5.setBounds(100, 500, 100, 40);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("sanserif", Font.BOLD, 20));
        b5.setBackground(Color.DARK_GRAY);
        b5.addActionListener(this);
        add(b5);

        setLayout(null);
        setBounds(400, 40, 800, 610);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {

                conn c = new conn();

                String str = "select * from drivers ";
                String str2 = "select * from drivers where available='Yes'";
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
        if (ae.getSource() == b4) {
            new Reception().setVisible(true);
            dispose();

        }
        
        if (ae.getSource() == b2) {
            new UpdateCarService().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b5) {
            new addDrivers().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new carservice().setVisible(true);
    }
}