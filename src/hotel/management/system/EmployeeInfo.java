package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {

    JTable tab1;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;

    EmployeeInfo() {

        super("Employee Info");
        tab1 = new JTable();
        tab1.setBounds(0, 40, 900, 400);
        add(tab1);

        l1 = new JLabel("Name");
        l1.setBounds(20, 10, 100, 30);
        add(l1);
        l2 = new JLabel("Age");
        l2.setBounds(150, 10, 100, 30);
        add(l2);
        l3 = new JLabel("Gender");
        l3.setBounds(250, 10, 100, 30);
        add(l3);
        l4 = new JLabel("Job");
        l4.setBounds(370, 10, 100, 30);
        add(l4);
        l5 = new JLabel("Salary");
        l5.setBounds(470, 10, 100, 30);
        add(l5);
        l6 = new JLabel("Phone");
        l6.setBounds(590, 10, 100, 30);
        add(l6);
        l7 = new JLabel("NID");
        l7.setBounds(710, 10, 100, 30);
        add(l7);
        l8 = new JLabel("Email");
        l8.setBounds(830, 10, 100, 30);
        add(l8);

        b1 = new JButton("Load Data");
        b1.setBounds(225, 485, 130, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Update");
        b2.setBounds(380, 485, 120, 40);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("Delete");
        b3.setBounds(525, 485, 100, 40);
        b3.setFont(new Font("sanserif", Font.BOLD, 20));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(this);
        add(b3);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/b6.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b4 = new JButton(i3);
        b4.setBounds(655, 487, 70, 35);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("sanserif", Font.BOLD, 20));
        b4.setBackground(Color.DARK_GRAY);
        b4.addActionListener(this);
        add(b4);
        b5 = new JButton("Add");
        b5.setBounds(100, 485, 100, 40);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("sanserif", Font.BOLD, 20));
        b5.setBackground(Color.DARK_GRAY);
        b5.addActionListener(this);
        add(b5);

        setLayout(null);
        setBounds(250, 40, 920, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            conn c = new conn();
            String str = "select * from employee";
            try {
                ResultSet rs = c.s.executeQuery(str);
                tab1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                System.out.println();
            }
        }
        if (ae.getSource() == b2) {
            new UpdateEmployee().setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b3) {

            int row = tab1.getSelectedRow();
            String cell = tab1.getModel().getValueAt(row, 0).toString();

            String sql = "delete from employee where name = '" + cell + "'";
            try {
                conn c = new conn();
                c.s.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "The Row is Deleted !!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
        if (ae.getSource() == b4) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b5) {
            new addEmployee().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EmployeeInfo().setVisible(true);
    }
}
