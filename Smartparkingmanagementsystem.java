/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package shella.smartparkingmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 *
 * @author Hp
 */
public class Smartparkingmanagementsystem {

    public static void main(String[] args) {
         new WelcomeScreen();
    }
}

// ================= WELCOME SCREEN =================
class WelcomeScreen extends JFrame implements ActionListener {

    JButton userBtn, adminBtn;

    WelcomeScreen() {

        setTitle("Smart Parking System");
        setSize(750,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(10, 25, 47));

        JLabel title = new JLabel("SMART PARKING MANAGEMENT SYSTEM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setBounds(90,60,600,40);
        add(title);

        JLabel sub = new JLabel("Professional Digital Parking Solution");
        sub.setForeground(new Color(0, 255, 180));
        sub.setFont(new Font("Arial", Font.PLAIN, 18));
        sub.setBounds(220,110,400,30);
        add(sub);

        userBtn = new JButton("USER PORTAL");
        userBtn.setBounds(170,220,180,70);
        userBtn.setBackground(new Color(59,130,246));
        userBtn.setForeground(Color.WHITE);
        userBtn.setFont(new Font("Arial", Font.BOLD, 14));
        add(userBtn);

        adminBtn = new JButton("ADMIN PORTAL");
        adminBtn.setBounds(390,220,180,70);
        adminBtn.setBackground(new Color(168,85,247));
        adminBtn.setForeground(Color.WHITE);
        adminBtn.setFont(new Font("Arial", Font.BOLD, 14));
        add(adminBtn);

        userBtn.addActionListener(this);
        adminBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==userBtn){
            new UserLogin();
            dispose();
        }
        if(e.getSource()==adminBtn){
            new AdminLogin();
            dispose();
        }
    }
}

// ================= USER LOGIN =================
class UserLogin extends JFrame implements ActionListener {

   
    JTextField user;
    JPasswordField pass;
    JButton login, signup, back;

    UserLogin() {

        setTitle("User Login");
        setSize(500, 400);
        setLayout(null);
        getContentPane().setBackground(new Color(15,23,42));

        JLabel t = new JLabel("USER LOGIN");
        t.setForeground(Color.WHITE);
        t.setFont(new Font("Arial", Font.BOLD, 22));
        t.setBounds(170, 30, 200, 30);
        add(t);

        JLabel u1 = new JLabel("Username");
        u1.setForeground(Color.WHITE);
        u1.setBounds(70, 100, 100, 30);
        add(u1);

        user = new JTextField();
        user.setBounds(180, 100, 200, 30);
        add(user);

        JLabel p1 = new JLabel("Password");
        p1.setForeground(Color.WHITE);
        p1.setBounds(70, 150, 100, 30);
        add(p1);

        pass = new JPasswordField();
        pass.setBounds(180, 150, 200, 30);
        add(pass);

        login = new JButton("LOGIN");
        signup = new JButton("SIGNUP");
        back = new JButton("BACK");

        login.setBounds(50, 240, 100, 40);
        signup.setBounds(180, 240, 100, 40);
        back.setBounds(310, 240, 100, 40);

        add(login);
        add(signup);
        add(back);

        login.addActionListener(this);
        signup.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == login) {

                String uName = user.getText();
                String uPass = new String(pass.getPassword());

                if (uName.equals("user") && uPass.equals("123")) {

                    JOptionPane.showMessageDialog(this,
                            "Login Successful");

                    new Dashboard("USER");
                    dispose();

                } else {
                    throw new Exception("Invalid Username or Password");
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
// ================= USER SIGNUP =================
class UserSignup extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;
    JButton reg;

    UserSignup() {

        setTitle("User Signup");
        setSize(450,350);
        setLayout(null);
        getContentPane().setBackground(new Color(14,165,233));

        JLabel t = new JLabel("USER SIGNUP");
        t.setFont(new Font("Arial", Font.BOLD, 20));
        t.setForeground(Color.WHITE);
        t.setBounds(140,30,200,30);
        add(t);

        JLabel u = new JLabel("Username");
        u.setForeground(Color.WHITE);
        u.setBounds(50,100,100,30);
        add(u);

        user = new JTextField();
        user.setBounds(160,100,180,30);
        add(user);

        JLabel p = new JLabel("Password");
        p.setForeground(Color.WHITE);
        p.setBounds(50,150,100,30);
        add(p);

        pass = new JPasswordField();
        pass.setBounds(160,150,180,30);
        add(pass);

        reg = new JButton("REGISTER");
        reg.setBounds(140,230,120,40);
        add(reg);

        reg.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            FileWriter fw = new FileWriter("users.txt",true);
            fw.write(user.getText()+","+pass.getText()+"\n");
            fw.close();
            JOptionPane.showMessageDialog(this,"User Registered");
            dispose();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }
}

// ================= ADMIN LOGIN =================
class AdminLogin extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;
    JButton login, signup, back;

    AdminLogin() {

        setTitle("Admin Login");
        setSize(500,400);
        setLayout(null);
        getContentPane().setBackground(new Color(88,28,135));

        JLabel t = new JLabel("ADMIN LOGIN");
        t.setForeground(Color.WHITE);
        t.setFont(new Font("Arial", Font.BOLD, 22));
        t.setBounds(160,30,200,30);
        add(t);

        user = new JTextField();
        pass = new JPasswordField();

        JLabel u1 = new JLabel("Admin");
        u1.setForeground(Color.WHITE);
        u1.setBounds(70,100,100,30);
        add(u1);

        user.setBounds(180,100,200,30);
        add(user);

        JLabel p1 = new JLabel("Password");
        p1.setForeground(Color.WHITE);
        p1.setBounds(70,150,100,30);
        add(p1);

        pass.setBounds(180,150,200,30);
        add(pass);

        login = new JButton("LOGIN");
        signup = new JButton("SIGNUP");
        back = new JButton("BACK");

        login.setBounds(50,240,100,40);
        signup.setBounds(180,240,100,40);
        back.setBounds(310,240,100,40);

        add(login);
        add(signup);
        add(back);

        login.addActionListener(this);
        signup.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        
if(e.getSource()==login){

    try{

        String uname = user.getText();
        String upass = pass.getText();

        if(uname.equals("admin") && upass.equals("123")){

            JOptionPane.showMessageDialog(this,
                    "Admin Login Success");

            new Dashboard("ADMIN");
            dispose();

        } else {

            throw new Exception("Wrong Credentials");
        }

    } catch(Exception ex){

        JOptionPane.showMessageDialog(this,
                ex.getMessage());
    }
}
            if(user.getText().equals("admin") &&
                    pass.getText().equals("123")){

                JOptionPane.showMessageDialog(this,"Admin Login Success");
                new Dashboard("ADMIN");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Wrong Credentials");
            }
        }

      
}

// ================= ADMIN SIGNUP =================
class AdminSignup extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;
    JButton reg;

    AdminSignup() {

        setTitle("Admin Signup");
        setSize(450,350);
        setLayout(null);
        getContentPane().setBackground(new Color(168,85,247));

        JLabel t = new JLabel("ADMIN SIGNUP");
        t.setFont(new Font("Arial", Font.BOLD, 20));
        t.setForeground(Color.WHITE);
        t.setBounds(140,30,200,30);
        add(t);

        user = new JTextField();
        pass = new JPasswordField();

        JLabel u = new JLabel("Admin");
        u.setForeground(Color.WHITE);
        u.setBounds(50,100,100,30);
        add(u);

        user.setBounds(160,100,180,30);
        add(user);

        JLabel p = new JLabel("Password");
        p.setForeground(Color.WHITE);
        p.setBounds(50,150,100,30);
        add(p);

        pass.setBounds(160,150,180,30);
        add(pass);

        reg = new JButton("REGISTER");
        reg.setBounds(140,230,120,40);
        add(reg);

        reg.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            FileWriter fw = new FileWriter("admins.txt",true);
            fw.write(user.getText()+","+pass.getText()+"\n");
            fw.close();
            JOptionPane.showMessageDialog(this,"Admin Registered");
            dispose();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }
}

// ================= DASHBOARD =================
class Dashboard extends JFrame implements ActionListener {

    JButton vehicle, slot, payment, admin, logout;
    String role;

    Dashboard(String role){

        this.role = role;

        setTitle("Dashboard");
        setSize(800,500);
        setLayout(null);

        getContentPane().setBackground(new Color(17,24,39));

        JLabel t = new JLabel("DASHBOARD - "+role);
        t.setForeground(Color.WHITE);
        t.setFont(new Font("Arial", Font.BOLD, 24));
        t.setBounds(250,30,400,30);
        add(t);

        vehicle = new JButton("Vehicle");
        slot = new JButton("Slots");
        payment = new JButton("Payment");
        admin = new JButton("Analytics");
        logout = new JButton("Logout");

        vehicle.setBounds(100,120,200,80);
        slot.setBounds(450,120,200,80);
        payment.setBounds(100,250,200,80);
        admin.setBounds(450,250,200,80);
        logout.setBounds(320,380,120,40);

        add(vehicle);
        add(slot);
        add(payment);
        add(admin);
        add(logout);

        vehicle.addActionListener(this);
        slot.addActionListener(this);
        payment.addActionListener(this);
        admin.addActionListener(this);
        logout.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==vehicle){
            new VehicleScreen();
        }

        if(e.getSource()==slot){
            new SlotScreen();
        }

        if(e.getSource()==payment){
            new PaymentScreen();
        }

        if(e.getSource()==admin){
            new AdminScreen();
        }

        if(e.getSource()==logout){
            new WelcomeScreen();
            dispose();
        }
    }
}

// ================= VEHICLE SCREEN =================
class VehicleScreen extends JFrame implements ActionListener {

    JTextField v1,v2;
    JButton add,view,back;
    JTextArea area;

    VehicleScreen(){

        setTitle("Vehicle Management");
        setSize(700,500);
        setLayout(null);

        getContentPane().setBackground(new Color(224,242,254));

        JLabel t = new JLabel("VEHICLE MANAGEMENT");
        t.setBounds(200,20,300,30);
        add(t);

        v1 = new JTextField();
        v2 = new JTextField();

        v1.setBounds(200,80,200,30);
        v2.setBounds(200,130,200,30);

        add(v1);
        add(v2);

        add = new JButton("ADD");
        view = new JButton("VIEW");
        back = new JButton("BACK");

        add.setBounds(100,200,120,40);
        view.setBounds(260,200,120,40);
        back.setBounds(420,200,120,40);

        add(add);
        add(view);
        add(back);

        area = new JTextArea();
        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(100,270,450,150);
        add(sp);

        add.addActionListener(this);
        view.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==add){
            try{
                FileWriter fw = new FileWriter("vehicles.txt",true);
                fw.write(v1.getText()+","+v2.getText()+"\n");
                fw.close();
                JOptionPane.showMessageDialog(this,"Added");
            }catch(Exception ex){}
        }

        if(e.getSource()==view){
            try{
                BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"));
                area.setText("");
                String l;
                while((l=br.readLine())!=null){
                    area.append(l+"\n");
                }
                br.close();
            }catch(Exception ex){}
        }

        if(e.getSource()==back){
            new Dashboard("USER");
            dispose();
        }
    }
}

// ================= SLOT SCREEN =================
class SlotScreen extends JFrame implements ActionListener {

    JButton[] slots = new JButton[8];
    JButton back;

    SlotScreen(){

        setTitle("Slots");
        setSize(600,500);
        setLayout(new GridLayout(5,2));

        for(int i=0;i<8;i++){
            slots[i]=new JButton("Available");
            slots[i].setBackground(Color.GREEN);
            slots[i].addActionListener(this);
            add(slots[i]);
        }

        back = new JButton("BACK");
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==back){
            new Dashboard("USER");
            dispose();
        }

        for(int i=0;i<8;i++){
            if(e.getSource()==slots[i]){
                if(slots[i].getBackground()==Color.GREEN){
                    slots[i].setBackground(Color.RED);
                    slots[i].setText("Booked");
                } else {
                    slots[i].setBackground(Color.GREEN);
                    slots[i].setText("Available");
                }
            }
        }
    }
}

// ================= PAYMENT SCREEN =================
class PaymentScreen extends JFrame implements ActionListener {

    JTextField v,a;
    JButton pay,back;

    PaymentScreen(){

        setTitle("Payment");
        setSize(500,400);
        setLayout(null);

        v=new JTextField();
        a=new JTextField();

        v.setBounds(150,100,200,30);
        a.setBounds(150,150,200,30);

        add(v); add(a);

        pay=new JButton("PAY");
        back=new JButton("BACK");

        pay.setBounds(100,220,120,40);
        back.setBounds(250,220,120,40);

        add(pay); add(back);

        pay.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==pay){
            JOptionPane.showMessageDialog(this,"Payment Done");
        }

        if(e.getSource()==back){
            new Dashboard("USER");
            dispose();
        }
    }
}

// ================= ADMIN SCREEN =================
class AdminScreen extends JFrame implements ActionListener {

    JTextArea area;
    JButton viewV,viewP,back;

    AdminScreen(){

        setTitle("Admin");
        setSize(700,500);
        setLayout(null);

        area=new JTextArea();
        JScrollPane sp=new JScrollPane(area);
        sp.setBounds(100,150,500,250);
        add(sp);

        viewV=new JButton("Vehicles");
        viewP=new JButton("Payments");
        back=new JButton("BACK");

        viewV.setBounds(100,80,120,40);
        viewP.setBounds(250,80,120,40);
        back.setBounds(400,80,120,40);

        add(viewV); add(viewP); add(back);

        viewV.addActionListener(this);
        viewP.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==viewV){
            try{
                BufferedReader br=new BufferedReader(new FileReader("vehicles.txt"));
                area.setText("");
                String l;
                while((l=br.readLine())!=null){
                    area.append(l+"\n");
                }
                br.close();
            }catch(Exception ex){}
        }

        if(e.getSource()==viewP){
            try{
                BufferedReader br=new BufferedReader(new FileReader("payments.txt"));
                area.setText("");
                String l;
                while((l=br.readLine())!=null){
                    area.append(l+"\n");
                }
                br.close();
            }catch(Exception ex){}
        }

        if(e.getSource()==back){
            new Dashboard("ADMIN");
            dispose();
        }
    }
}
    


    

