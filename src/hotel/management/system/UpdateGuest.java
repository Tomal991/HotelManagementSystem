package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.proteanit.sql.*;

public class UpdateGuest extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l15, l20, l21, l50;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t20;
    JButton b1, b2, b3, b4, b5;
    JRadioButton r1, r2;
    JDateChooser dateChooser1, dateChooser2;
    JSpinner js1, js2;

    JComboBox c1, c2;
    Choice c3, c4;

    UpdateGuest() {

        super("Guest Form");
        SpinnerNumberModel value = new SpinnerNumberModel(0, 0, 30, 1);
        js1 = new JSpinner(value);
        js1.setBounds(470, 440, 80, 30);
        add(js1);
        js1.addChangeListener(new ChangeListner());

        JLabel l15 = new JLabel("Days");
        l15.setForeground(Color.BLACK);
        l15.setFont(new Font("sanserif", Font.BOLD, 15));
        l15.setBounds(400, 440, 100, 26);
        add(l15);

        JLabel l10 = new JLabel(" Check In Date  :");
        l10.setForeground(new Color(105, 105, 105));
        l10.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        l10.setBounds(40, 380, 200, 26);
        add(l10);

        t8 = new JTextField();
        t8.setBounds(220, 380, 100, 30);
        add(t8);

        JLabel l11 = new JLabel(" Check Out Date  :");
        l11.setForeground(new Color(105, 105, 105));
        l11.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        l11.setBounds(400, 380, 200, 26);
        add(l11);

        t9 = new JTextField();
        t9.setBounds(570, 380, 100, 30);
        add(t9);

        l9 = new JLabel("Update Guest Form");
        l9.setBounds(350, 20, 250, 30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("sanserif", Font.BOLD, 20));
        l9.setBackground(Color.DARK_GRAY);
        add(l9);

        l1 = new JLabel("ID Type");
        l1.setBounds(70, 80, 120, 30);
        l1.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l1);
        t1 = new JTextField();
        t1.setBounds(200, 80, 100, 30);
        add(t1);

        l2 = new JLabel("ID Number");
        l2.setBounds(70, 130, 100, 30);
        l2.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l2);
        t2 = new JTextField();
        t2.setBounds(200, 130, 100, 30);
        add(t2);

        l3 = new JLabel("Name");
        l3.setBounds(70, 180, 100, 30);
        l3.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l3);
        t3 = new JTextField();
        t3.setBounds(200, 180, 100, 30);
        add(t3);

        l4 = new JLabel("Gender");
        l4.setBounds(70, 230, 100, 30);
        l4.setFont(new Font("sanserif", Font.BOLD, 15));

        add(l4);

        t4 = new JTextField();
        t4.setBounds(200, 230, 100, 30);
        add(t4);

        l5 = new JLabel("Country");
        l5.setBounds(70, 280, 100, 25);
        l5.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l5);
        t5 = new JTextField();
        t5.setBounds(200, 280, 100, 30);
        add(t5);
        l6 = new JLabel("Allocated Room ");
        l6.setBounds(50, 330, 130, 30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("sanserif", Font.BOLD, 14));

        add(l6);
        c4 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from guest";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c4.add(rs.getString("room"));
            }
            c4.setBounds(200, 330, 150, 30);
            add(c4);

        } catch (Exception e) {
            System.out.println(e);
        }

        l8 = new JLabel("Price");
        l8.setBounds(70, 440, 100, 30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("sanserif", Font.BOLD, 15));

        add(l8);
        t7 = new JTextField();
        t7.setBounds(200, 440, 100, 30);
        add(t7);

        l21 = new JLabel();
        l21.setBounds(220, 485, 100, 30);
        l21.setForeground(Color.RED);

        l21.setFont(new Font("sanserif", Font.BOLD, 20));

        add(l21);

        l50 = new JLabel("driver");
        l50.setBounds(420, 295, 70, 30);

        l50.setFont(new Font("sanserif", Font.BOLD, 13));

        add(l50);
        c3 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from drivers";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c3.add(rs.getString("name"));
            }
            c3.setBounds(500, 300, 150, 30);
            add(c3);

        } catch (Exception e) {
            System.out.println(e);
        }

        b1 = new JButton("Check");
        b1.setBounds(150, 540, 100, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        add(b1);
        b1.addActionListener(new ab());

        b2 = new JButton("Update");
        b2.setBounds(300, 540, 120, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(new ab());
        add(b2);
        b3 = new JButton("Back");
        b3.setBounds(500, 540, 100, 40);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("sanserif", Font.BOLD, 20));
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(new ab());
        add(b3);

        setLayout(null);
        setBounds(250, 30, 900, 650);
        setVisible(true);
    }

    private class ab implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == b1) {

                String s1 = c4.getSelectedItem();

                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from guest where room='" + s1 + "'");
                    while (rs.next()) {

                        t1.setText(rs.getString("id_type"));
                        t2.setText(rs.getString("id"));
                        t3.setText(rs.getString("name"));
                        t4.setText(rs.getString("gender"));
                        t5.setText(rs.getString("country"));

                        t7.setText(rs.getString("price"));
                        l21.setText(rs.getString("total"));
                        t8.setText(rs.getString("check_IN"));
                        t9.setText(rs.getString("check_OUT"));

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
            if (ae.getSource() == b2) {

                String room = c4.getSelectedItem();
                String driver = c3.getSelectedItem();

                String type = t1.getText();
                String name = t3.getText();
                String gender = t4.getText();
                String country = t5.getText();

                String price = t7.getText();
                String checkIN = t8.getText();
                String checkOUT = t9.getText();
                String total = l21.getText();

                conn c = new conn();
                try {
                    String str = "update guest set id_type='" + type + "',name='" + name + "',gender='" + gender + "',country='" + country + "',room='" + room + "',check_IN='" + checkIN + "',check_OUT ='" + checkOUT + "',price='" + price + "',total='" + total + "',dname='" + driver + "' where room='" + room + "'";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Guest Updated successfully");
                    new GuestInfo().setVisible(true);
                    dispose();

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
            if (ae.getSource() == b3) {
                new GuestInfo().setVisible(true);
                dispose();
            }
        }
    }

    private class ChangeListner implements ChangeListener {

        public void stateChanged(ChangeEvent ce) {

            int price = Integer.parseInt(t7.getText());
            int days = Integer.parseInt(js1.getValue().toString());

            price = price * days;

            l21.setText(String.valueOf(price));

        }

    }

    public static void main(String[] args) {
        new UpdateGuest().setVisible(true);
    }
}
