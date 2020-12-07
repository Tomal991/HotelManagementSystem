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

public class GuestForm extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l15, l20, l21, l50;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t20;
    JButton b1, b2, b3;
    JRadioButton r1, r2;
    JDateChooser dateChooser1, dateChooser2;
    JSpinner js1, js2;

    JComboBox c1;
    Choice c3, c2;

    GuestForm() {

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

        dateChooser1 = new JDateChooser();
        dateChooser1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser1.setForeground(new Color(105, 105, 105));
        dateChooser1.setBounds(200, 380, 120, 29);

        add(dateChooser1);

        JLabel l11 = new JLabel(" Check Out Date  :");
        l11.setForeground(new Color(105, 105, 105));
        l11.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        l11.setBounds(400, 380, 200, 26);
        add(l11);

        dateChooser2 = new JDateChooser();
        dateChooser2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser2.setForeground(new Color(105, 105, 105));
        dateChooser2.setBounds(550, 380, 120, 29);
        add(dateChooser2);

        l9 = new JLabel("New Guest Form");
        l9.setBounds(350, 20, 250, 30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("sanserif", Font.BOLD, 20));
        l9.setBackground(Color.DARK_GRAY);
        add(l9);

        l1 = new JLabel("ID Type");
        l1.setBounds(70, 80, 130, 30);
        l1.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l1);
        c1 = new JComboBox(new String[]{"Select", "Passport", "National ID", "Licence", "Other"});
        c1.setBounds(200, 80, 100, 30);
        add(c1);

        l2 = new JLabel("ID Number");
        l2.setBounds(70, 130, 100, 30);
        l2.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l2);
        t1 = new JTextField();
        t1.setBounds(200, 130, 100, 30);
        add(t1);

        l3 = new JLabel("Name");
        l3.setBounds(70, 180, 100, 30);
        l3.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l3);
        t2 = new JTextField();
        t2.setBounds(200, 180, 100, 30);
        add(t2);

        l4 = new JLabel("Gender");
        l4.setBounds(70, 230, 100, 30);
        l4.setFont(new Font("sanserif", Font.BOLD, 15));

        add(l4);

        r1 = new JRadioButton("Male");
        r1.setBounds(200, 230, 100, 30);
        r1.setFont(new Font("sanserif", Font.BOLD, 15));
        r1.setSelected(true);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setBounds(320, 230, 100, 30);
        r2.setFont(new Font("sanserif", Font.BOLD, 15));
        add(r2);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        l5 = new JLabel("Country");
        l5.setBounds(70, 280, 100, 25);
        l5.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l5);
        t3 = new JTextField();
        t3.setBounds(200, 280, 100, 30);
        add(t3);
        l6 = new JLabel("Allocated Room ");
        l6.setBounds(50, 330, 130, 30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("sanserif", Font.BOLD, 14));

        add(l6);

        c3 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from room ";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c3.add(rs.getString("room_no"));
            }
            c3.setBounds(200, 330, 150, 30);
            add(c3);

        } catch (Exception e) {
            System.out.println(e);
        }

        l8 = new JLabel("Price");
        l8.setBounds(80, 440, 100, 30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("sanserif", Font.BOLD, 15));

        add(l8);
        t5 = new JTextField();
        t5.setBounds(200, 440, 100, 30);
        add(t5);
        l21 = new JLabel();
        l21.setBounds(220, 485, 100, 30);
        l21.setForeground(Color.RED);

        l21.setFont(new Font("sanserif", Font.BOLD, 20));

        add(l21);
        l50 = new JLabel("driver");
        l50.setBounds(470, 265, 70, 30);

        l50.setFont(new Font("sanserif", Font.BOLD, 13));

        add(l50);
        c2 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from drivers";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c2.add(rs.getString("name"));
            }
            c2.setBounds(550, 270, 100, 30);
            add(c2);

        } catch (Exception e) {
            System.out.println(e);
        }

        b1 = new JButton("Add ");
        b1.setBounds(150, 540, 100, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(new ab());
        add(b1);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/b6.png"));
        Image i2 = i1.getImage().getScaledInstance(90, 45, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b2 = new JButton(i3);
        b2.setBounds(310, 542, 80, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(new ab());

        add(b2);
        b3 = new JButton("Find");
        b3.setBounds(400, 330, 70, 30);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("sanserif", Font.BOLD, 13));
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(new ab());
        add(b3);

        setLayout(null);
        setBounds(250, 30, 900, 650);
        setVisible(true);
    }

    private class ab implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == b3) {
                String room = (String) c3.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "select * from room where room_no='" + room + "'";
                    ResultSet rs = c.s.executeQuery(str);
                    while (rs.next()) {
                        t5.setText(rs.getString("price"));

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (ae.getSource() == b1) {
                String id = (String) c1.getSelectedItem();
                String number = t1.getText();
                String name = t2.getText();
                String gender = null;
                if (r1.isSelected()) {
                    gender = "Male";
                } else if (r2.isSelected()) {
                    gender = "Female";
                }

                String country = t3.getText();
                String room = (String) c3.getSelectedItem();
                String price = t5.getText();

                String d1 = ((JTextField) dateChooser1.getDateEditor().getUiComponent()).getText();
                String d2 = ((JTextField) dateChooser2.getDateEditor().getUiComponent()).getText();
                String total = l21.getText();
                String driver = (String) c2.getSelectedItem();

                String str = "INSERT INTO guest values( '" + id + "', '" + number + "', '" + name + "','" + gender + "', '" + country + "', '" + room + "','" + d1 + "','" + d2 + "','" + price + "','" + total + "','" + driver + "')";
                String str2 = "update room set available ='Occupied' where room_no='" + room + "'";
                String str3 = "update drivers set available ='No' where name='" + driver + "'";
                try {
                    conn c = new conn();
                    c.s.executeUpdate(str);
                    c.s.executeUpdate(str2);
                    c.s.executeUpdate(str3);
                    JOptionPane.showMessageDialog(null, "New Customer Added");
                    new Reception().setVisible(true);
                    dispose();

                } catch (Exception ee) {
                    System.out.println(ee);
                }

            }
            if (ae.getSource() == b2) {
                new Reception().setVisible(true);
                dispose();

            }

        }

    }

    private class ChangeListner implements ChangeListener {

        public void stateChanged(ChangeEvent ce) {

            int price = Integer.parseInt(t5.getText());
            int days = Integer.parseInt(js1.getValue().toString());

            price = price * days;

            l21.setText(String.valueOf(price));

        }

    }

    public static void main(String[] args) {
        new GuestForm().setVisible(true);

    }

}
