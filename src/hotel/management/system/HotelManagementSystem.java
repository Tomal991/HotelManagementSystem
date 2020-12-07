package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;

    HotelManagementSystem() {
        setBounds(300, 100, 850, 500);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/12.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 850, 500);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(30, 40, 600, 80);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.BOLD, 40));

        l1.add(l2);

        b2 = new JButton("Receptionist");
        b2.setBackground(Color.magenta);
        b2.setForeground(Color.black);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBounds(520, 350, 170, 55);
        b2.addActionListener(this);
        l1.add(b2);

        setLayout(null);
        setVisible(true);
        while (true) {
            l2.setVisible(false); // lid =  j label
            try {
                Thread.sleep(300); //1000 = 1 second
            } catch (Exception e) {
            }
            l2.setVisible(true);
            try {
                Thread.sleep(700);
            } catch (Exception e) {
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b2) {
            new login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new HotelManagementSystem().setVisible(true);
    }

}
