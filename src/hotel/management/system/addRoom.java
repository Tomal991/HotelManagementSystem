package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.*;

public class addRoom extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JComboBox c1, c2, c3, c4;
    JButton b1, b2;
    JTable tab1;

    addRoom() {
        super("Add Room");

        l1 = new JLabel("Add Rooms");
        l1.setBounds(300, 15, 300, 50);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("sanserif", Font.BOLD, 30));
        l1.setBackground(Color.DARK_GRAY);
        add(l1);

        JLabel room = new JLabel("Room No");
        room.setBounds(100, 65, 100, 100);
        room.setFont(new Font("sanserif", Font.BOLD, 17));
        add(room);

        t1 = new JTextField();
        t1.setBounds(250, 100, 200, 30);
        add(t1);

        JLabel available = new JLabel("Available");
        available.setBounds(100, 115, 100, 100);
        available.setFont(new Font("sanserif", Font.BOLD, 17));
        add(available);

        c1 = new JComboBox(new String[]{"Available", "Occupied"});
        c1.setBounds(250, 150, 120, 30);
        add(c1);

        JLabel status = new JLabel(" Status");
        status.setBounds(100, 165, 100, 100);
        status.setFont(new Font("sanserif", Font.BOLD, 17));
        add(status);

        c2 = new JComboBox(new String[]{"Clean", "Dirty"});
        c2.setBounds(250, 200, 120, 30);

        add(c2);

        JLabel room_type = new JLabel("Room Type");
        room_type.setBounds(100, 220, 100, 100);
        room_type.setFont(new Font("sanserif", Font.BOLD, 17));
        add(room_type);

        c3 = new JComboBox(new String[]{"Single Bed", "Double Bed", "King-size", "Deluxe", "Suite", "Presendintial Suite"});
        c3.setBounds(250, 255, 200, 30);
        add(c3);

        JLabel price = new JLabel("Price");
        price.setBounds(100, 270, 100, 100);
        price.setFont(new Font("sanserif", Font.BOLD, 17));
        add(price);

        t2 = new JTextField();
        t2.setBounds(250, 310, 200, 30);
        add(t2);

        b1 = new JButton("Add");
        b1.setBounds(170, 380, 100, 50);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(350, 380, 100, 50);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);

        setBounds(350, 100, 700, 550);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String room = t1.getText();
            String available = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();

            conn c = new conn();
            try {
                String str = "insert into room values('" + room + "','" + available + "','" + status + "','" + type + "','" + price + "')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New room added");
                new RoomInfo().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {
            new RoomInfo().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addRoom().setVisible(true);
    }

}
