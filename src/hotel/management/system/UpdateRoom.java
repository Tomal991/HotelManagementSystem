package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4, t5;

    JButton b1, b2, b3;
    JTable tab1;
    Choice c1;

    UpdateRoom() {
        super("Update Room");

        l1 = new JLabel("Update Room");
        l1.setBounds(250, 15, 300, 50);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("sanserif", Font.BOLD, 30));
        l1.setBackground(Color.DARK_GRAY);
        add(l1);

        JLabel room = new JLabel("Room No");
        room.setBounds(100, 60, 100, 100);
        room.setFont(new Font("sanserif", Font.BOLD, 17));
        add(room);

        c1 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from room ";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c1.add(rs.getString("room_no"));
            }
            c1.setBounds(250, 100, 150, 30);
            add(c1);

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel available = new JLabel("Available");
        available.setBounds(100, 110, 100, 100);
        available.setFont(new Font("sanserif", Font.BOLD, 17));
        add(available);

        t1 = new JTextField();
        t1.setBounds(250, 145, 200, 30);
        add(t1);

        JLabel status = new JLabel(" Status");
        status.setBounds(100, 160, 100, 100);
        status.setFont(new Font("sanserif", Font.BOLD, 17));
        add(status);

        t2 = new JTextField();
        t2.setBounds(250, 195, 200, 30);
        add(t2);

        JLabel room_type = new JLabel("Room Type");
        room_type.setBounds(100, 215, 100, 100);
        room_type.setFont(new Font("sanserif", Font.BOLD, 17));
        add(room_type);

        t3 = new JTextField();
        t3.setBounds(250, 250, 200, 30);
        add(t3);

        JLabel price = new JLabel("Price");
        price.setBounds(110, 270, 100, 100);
        price.setFont(new Font("sanserif", Font.BOLD, 17));
        add(price);

        t4 = new JTextField();
        t4.setBounds(250, 300, 200, 30);
        add(t4);

        b1 = new JButton("Check");
        b1.setBounds(200, 370, 100, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 15));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Update ");
        b2.setBounds(100, 420, 100, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 15));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("Back");
        b3.setBounds(300, 420, 100, 40);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("sanserif", Font.BOLD, 15));
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setBounds(350, 70, 700, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String room = null;
            String s1 = c1.getSelectedItem();

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from room where room_no='" + s1 + "'");
                while (rs.next()) {

                    t1.setText(rs.getString("available"));
                    t2.setText(rs.getString("status"));
                    t3.setText(rs.getString("room_type"));
                    t4.setText(rs.getString("price"));

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        if (ae.getSource() == b2) {
            String room = c1.getSelectedItem();
            String available = t1.getText();

            String status = t2.getText();
            String type = t3.getText();
            String price = t4.getText();

            conn c = new conn();
            try {
                String str = "update room set available='" + available + "',status='" + status + "',room_type='" + type + "',price='" + price + "' where room_no='" + room + "'";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Updated successfully");
                new RoomInfo().setVisible(true);
                this.setVisible(false);

            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
        if (ae.getSource() == b3) {
            new RoomInfo().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }
}
