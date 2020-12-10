package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class UpdateCarService extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8,t50;
    JButton b1, b2, b3, b4;
    Choice c1;

    UpdateCarService() {

        l5 = new JLabel("Update Pickup Status");
        l5.setBounds(230, 20, 300, 30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("sanserif", Font.BOLD, 20));
        l5.setBackground(Color.DARK_GRAY);
        add(l5);

        l1 = new JLabel("Car Model");
        l1.setBounds(80, 95, 100, 30);
        l1.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l1);
        c1 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from drivers";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c1.add(rs.getString("model"));
            }
            c1.setBounds(200, 100, 120, 100);
            add(c1);

        } catch (Exception e) {
            System.out.println(e);
        }

        l2 = new JLabel("Name");
        l2.setBounds(90, 160, 100, 30);
        l2.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l2);
        t2 = new JTextField();
        t2.setBounds(194, 160, 156, 30);
        add(t2);
        l3 = new JLabel("Available");
        l3.setBounds(90, 210, 100, 30);
        l3.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l3);
        t3 = new JTextField();
        t3.setBounds(194, 210, 156, 30);
        add(t3);
        l4 = new JLabel("Company");
        l4.setBounds(90, 260, 100, 30);
        l4.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l4);
        t4 = new JTextField();
        t4.setBounds(194, 260, 156, 30);
        add(t4);
       
        b1 = new JButton("Check");
        b1.setBounds(100, 350, 100, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Update");
        b2.setBounds(240, 350, 120, 40);
        b2.setForeground(Color.white);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("Back");
        b3.setBounds(550, 350, 100, 40);
        b3.setForeground(Color.white);
        b3.setFont(new Font("sanserif", Font.BOLD, 20));
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(this);
        add(b3);
        b4 = new JButton("Delete");
        b4.setBounds(400, 350, 100, 40);
        b4.setFont(new Font("sanserif", Font.BOLD, 20));
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.DARK_GRAY);
        b4.addActionListener(this);
        add(b4);

        setLayout(null);
        setBounds(450, 80, 700, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            String s1 = c1.getSelectedItem();

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from drivers where model='" + s1 + "'");
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("available"));
                    t4.setText(rs.getString("company"));

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        if (ae.getSource() == b2) {
            String model = c1.getSelectedItem();
            String name = t2.getText();

            String available = t3.getText();
            String company = t4.getText();

            conn c = new conn();
            try {
                String str = "update drivers set available='" + available + "',company='" + company + "',name='" + name + "' where model='" + model + "'";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, " Updated successfully");
                new carservice().setVisible(true);
                this.setVisible(false);

            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
        if (ae.getSource() == b3) {
            new carservice().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b4) {

            String delete = t2.getText();

            String sql = "delete from drivers where name = '" + delete+ "'";
            String sql2 = "update guest set dname='null' where dname = '" + delete+ "'";
            try {
                conn c = new conn();
                c.s.executeUpdate(sql);
                c.s.executeUpdate(sql2);
                JOptionPane.showMessageDialog(null, "The Row is Deleted !!");
                new carservice().setVisible(true);
                dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

    }

    public static void main(String[] args) {
        new UpdateCarService().setVisible(true);
    }
}
