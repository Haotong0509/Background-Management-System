package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LoginJFrame extends JFrame{
    private JPanel contentPane;
    private JTextField userName;
    private JPasswordField userPassword;
    private JTextField adminName;
    private JPasswordField adminPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginJFrame frame = new LoginJFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginJFrame() {
        setTitle("电子商务网站后台管理系统");
//        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        CardLayout cardLayout=new CardLayout();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu landingOptions = new JMenu("登录选项");
        menuBar.add(landingOptions);

        JMenuItem adminOption = new JMenuItem("管理员登录");
        adminOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.last(contentPane);
            }
        });
        landingOptions.add(adminOption);

        JMenuItem userOption = new JMenuItem("商家登录");
        userOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.first(contentPane);
            }
        });
        landingOptions.add(userOption);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(cardLayout);

        JPanel userPanel = new JPanel();
        contentPane.add(userPanel, "name_5600414879778");
        userPanel.setLayout(null);

        userName = new JTextField();
        userName.setBounds(148, 55, 122, 21);
        userPanel.add(userName);
        userName.setColumns(10);

        userPassword = new JPasswordField();
        userPassword.setBounds(148, 96, 122, 21);
        userPanel.add(userPassword);

        JButton userButton1 = new JButton("登录");
        userButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                userLoginActionPerformed(event);
            }
        });
        userButton1.setBounds(72, 159, 93, 23);
        userPanel.add(userButton1);

        JButton userButton2 = new JButton("注册");
        userButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                userRegisterActionPerformed(event);
            }
        });
        userButton2.setBounds(220, 159, 93, 23);
        userPanel.add(userButton2);

        JLabel lbll = new JLabel("商家ID");
        lbll.setBounds(72, 58, 54, 15);
        userPanel.add(lbll);

        JLabel label = new JLabel("密码");
        label.setBounds(72, 99, 54, 15);
        userPanel.add(label);

        JPanel adminPanel = new JPanel();
        contentPane.add(adminPanel, "name_5642638031832");
        adminPanel.setLayout(null);

        adminName = new JTextField();
        adminName.setBounds(148, 55, 122, 21);
        adminPanel.add(adminName);
        adminName.setColumns(10);

        adminPassword = new JPasswordField();
        adminPassword.setBounds(148, 96, 122, 21);
        adminPanel.add(adminPassword);

        JButton adminButton = new JButton("登录");
        adminButton.setBounds(152, 151, 93, 23);
        adminPanel.add(adminButton);

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                adminLoginActionPerformed(event);
            }
        });

        JLabel lblNewLabel = new JLabel("管理员ID");
        lblNewLabel.setBounds(72, 58, 54, 15);
        adminPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("密码");
        lblNewLabel_1.setBounds(72, 99, 54, 15);
        adminPanel.add(lblNewLabel_1);

    }

    private void userLoginActionPerformed(ActionEvent event) {
        int uID=Integer.parseInt(userName.getText());
        String upassword=userPassword.getText();
        LoginVerify loginVerify=new LoginVerify();
        if(loginVerify.businessVerify(uID, upassword))
        {
            JOptionPane.showMessageDialog(this, "登录成功");
            BusinessJFrame businessJFrame=new BusinessJFrame(uID);
            businessJFrame.setLocationRelativeTo(null);
            businessJFrame.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "登录失败，账号或密码错误！","消息",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adminLoginActionPerformed(ActionEvent event) {
        int aID=Integer.parseInt(adminName.getText());
        String apassword=adminPassword.getText();
        LoginVerify loginVerify=new LoginVerify();
        if(loginVerify.adminVerify(aID, apassword))
        {
            JOptionPane.showMessageDialog(this, "登录成功");
            AdminJFrame adminJFrame=new AdminJFrame();
            adminJFrame.setLocationRelativeTo(null);
            adminJFrame.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "登录失败，账号或密码错误！","消息",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void userRegisterActionPerformed(ActionEvent event) {
//		String uname=userName.getText();
//	     String upassword=userPassword.getText();
//	     User use r = new User(uname,upassword);
//	     UserDaoImpl userDaoImpl=new UserDaoImpl();
//	     if(userDaoImpl.addUser(user)) {
//	    	 JOptionPane.showMessageDialog(this, "注册成功");
//	     }
//	     else {
//	    	 JOptionPane.showMessageDialog(this, "注册失败!","注册学生管理系统",JOptionPane.ERROR_MESSAGE);
//	     }
        System.out.println("功能待开发");
    }

}
