package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class bill extends JFrame implements ActionListener {

    JLabel l1;
    JTextArea t1;
    JButton b1, b2, b3;
    Choice c1, c2;
    JPanel p1;

    bill() {

        p1 = new JPanel();
        p1.setBounds(0, 0, 600, 50);
        add(p1);
        l1 = new JLabel("Generate Bill");
        l1.setBounds(70, 40, 200, 30);
        p1.add(l1);

        c1 = new Choice();
        c1.setBounds(300, 50, 200, 30);
        p1.add(c1);
        try {
            conn c = new conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c1.add(rs.getString("room_no"));

            }

        } catch (Exception e) {
            System.out.println();
        }

        t1 = new JTextArea(50, 15);

        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif", Font.ITALIC, 18));
        jsp.setBounds(0, 51, 580, 450);
        add(jsp);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/b6.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        b1 = new JButton("Generate Bill");
        b1.setBounds(200, 500, 150, 40);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton(i3);
        b2.setBounds(420, 503, 70, 35);

        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("print");
        b3.setBounds(50, 500, 100, 40);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setVisible(true);
        setBounds(350, 50, 600, 600);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                conn c = new conn();

                String room = c1.getSelectedItem();

                t1.setText("\n\t\tHotel Paradise\n\tTotal Hotel BILL For Room number " + room + " \n");
                ResultSet rs = c.s.executeQuery("select * from room where room_no= '" + room + "'");
                if (rs.next()) {
                    t1.append("\n    Room Type:                          " + rs.getString("room_type"));
                }
                rs = c.s.executeQuery("select * from guest where room=" + c1.getSelectedItem());

                if (rs.next()) {
                    t1.append("\n\n    Customer ID:                        " + rs.getString("id"));
                    t1.append("\n    Name:                                  " + rs.getString("name"));
                    t1.append("\n    Gender:                               " + rs.getString("gender"));
                    t1.append("\n    Country:                              " + rs.getString("country"));
                    t1.append("\n    Room:                                " + rs.getString("room"));
                    t1.append("\n    CheckIn Date                     " + rs.getString("check_IN"));
                    t1.append("\n    CheckOut Date                  " + rs.getString("check_OUT"));
                    t1.append("\n    Amount per day/night:       " + rs.getString("price"));
                    t1.append("\n    Total Amount:                    " + rs.getString("total"));
                    t1.append("\n    your driver:                        " + rs.getString("dname"));
                    t1.append("         time:   " + rs.getString("time"));
                    t1.append("\n-------------------------------------------------------------");
                    t1.append("\n-------------------------------------------------------------");
                    t1.append("\n         Thank you for using our service");
                    t1.append("\n");

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b3) {
            try {
                t1.print();
            } catch (Exception e) {

            }
            
        }
    }

    public static void main(String[] args) {
        new bill().setVisible(true);
    }
}
/*String driver = rs.getString("dname");
                ResultSet rs3 = c.s.executeQuery("select * from drivers where name= '" + driver + "'");
                if (rs3.next()) {
                    t1.append("\n    Customer ID:                        " + rs3.getString("model"));
                    t1.append("\n    Name:                                  " + rs3.getString("name"));
                    t1.append("\n    Gender:                               " + rs3.getString("age"));
                   t1.append("\n    Country:                              " + rs3.getString("gender"));*/