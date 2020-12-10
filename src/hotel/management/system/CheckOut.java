package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class CheckOut extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton b1, b2, b3, b4;
    Choice c1;

    CheckOut() {
        JLabel l3 = new JLabel("CheckOut Status");
        l3.setBounds(300, 20, 300, 30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("sanserif", Font.BOLD, 25));
        l3.setBackground(Color.DARK_GRAY);
        add(l3);
        l1 = new JLabel("Guest-ID");
        l1.setBounds(80, 95, 100, 30);
        l1.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l1);
        c1 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from guest";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c1.add(rs.getString("id"));
            }
            c1.setBounds(185, 100, 150, 40);
            add(c1);

        } catch (Exception e) {
            System.out.println(e);
        }

        l2 = new JLabel("Room No");
        l2.setBounds(80, 160, 100, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("sanserif", Font.BOLD, 15));
        l2.setBackground(Color.DARK_GRAY);
        add(l2);
        t1 = new JTextField();
        t1.setBounds(194, 160, 150, 35);
        add(t1);
        l3 = new JLabel("driver");
        l3.setBounds(80, 225, 100, 30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("sanserif", Font.BOLD, 13));
        l3.setBackground(Color.DARK_GRAY);
        add(l3);
        t2 = new JTextField();
        t2.setBounds(194, 225, 150, 30);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1 = new JButton(i3);
        b1.setBounds(380, 95, 35, 35);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l5 = new JLabel(i6);
        l5.setBounds(480, 95, 350, 250);

        add(l5);

        b2 = new JButton("CheckOut");
        b2.setBounds(100, 300, 150, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/b6.png"));
        Image i8 = i7.getImage().getScaledInstance(90, 45, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        b3 = new JButton(i9);
        b3.setBounds(300, 300, 80, 40);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("sanserif", Font.BOLD, 20));
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setBounds(250, 100, 870, 520);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            String s1 = c1.getSelectedItem();
            conn c = new conn();
            try {
                String str = "select * from guest where id='" + s1 + "'";
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("dname"));

                }

            } catch (Exception e) {

            }
        }
        if (ae.getSource() == b2) {
            String s1 = c1.getSelectedItem();
            String room = t1.getText();
            String drive = t2.getText();
            String str = "delete from guest where id='" + s1 + "'";
            String str2 = "update room set available='Available' where room_no='" + room + "'";
            String str3 = "update drivers set available ='Yes' where name='" + drive + "'";
            conn c = new conn();
            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                c.s.executeUpdate(str3);
                JOptionPane.showMessageDialog(null, "CheckOut Done");
                new Reception().setVisible(true);
                this.setVisible(false);
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
        new CheckOut().setVisible(true);
    }
}
