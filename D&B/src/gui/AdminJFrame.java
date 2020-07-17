package gui;

import function.Business;
import function.Commodity;
import function.Order;
import function.User;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminJFrame extends JFrame{
    private JPanel contentPane;

    public AdminJFrame() {
        setTitle("管理员后台管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 170, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(5, 5));
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel label1 = new JLabel("用户管理");
        JButton button11 = new JButton("当前用户");
        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button11ActionPerformed(event);
            }
        });
        JButton button12 = new JButton("增加用户");
        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button12ActionPerformed(event);
            }
        });
        JButton button13 = new JButton("删除用户");
        button13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button13ActionPerformed(event);
            }
        });
        JButton button14 = new JButton("更改用户");
        button14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button14ActionPerformed(event);
            }
        });

        JLabel label2 = new JLabel("商家管理");
        JButton button21 = new JButton("当前商家");
        button21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button21ActionPerformed(event);
            }
        });
        JButton button22 = new JButton("增加商家");
        button22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button22ActionPerformed(event);
            }
        });
        JButton button23 = new JButton("删除商家");
        button23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button23ActionPerformed(event);
            }
        });
        JButton button24 = new JButton("更改商家");
        button24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button24ActionPerformed(event);
            }
        });

        JLabel label3 = new JLabel("订单管理");
        JButton button31 = new JButton("全部订单");
        button31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button31ActionPerformed(event);
            }
        });


        JLabel label4 = new JLabel("统计查询");
        JButton button41 = new JButton("所有订单");
        button41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button41ActionPerformed(event);
            }
        });
        JButton button42 = new JButton("某类商品");
        button42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button42ActionPerformed(event);
            }
        });
        JButton button43 = new JButton("热销前十");
        button43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button43ActionPerformed(event);
            }
        });
        JButton button44 = new JButton("商家订单");
        button44.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button44ActionPerformed(event);
            }
        });
        JButton button45 = new JButton("商家前十");
        button45.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button45ActionPerformed(event);
            }
        });
        JButton button46 = new JButton("用户前十");
        button46.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button46ActionPerformed(event);
            }
        });
        JButton button47 = new JButton("月订单统计");
        button47.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button47ActionPerformed(event);
            }
        });

        getContentPane().add(label1);
        getContentPane().add(button11);
        getContentPane().add(button12);
        getContentPane().add(button13);
        getContentPane().add(button14);
        getContentPane().add(label2);
        getContentPane().add(button21);
        getContentPane().add(button22);
        getContentPane().add(button23);
        getContentPane().add(button24);
        getContentPane().add(label3);
        getContentPane().add(button31);
        getContentPane().add(new JLabel(""));
        getContentPane().add(new JLabel(""));
        getContentPane().add(new JLabel(""));
        getContentPane().add(label4);
        getContentPane().add(button41);
        getContentPane().add(button42);
        getContentPane().add(button43);
        getContentPane().add(button44);
        getContentPane().add(new JLabel(""));
        getContentPane().add(button45);
        getContentPane().add(button46);
        getContentPane().add(button47);
    }


    private void button11ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("用户管理-当前用户");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(500, 300, 600, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel(new BorderLayout());
        newJFrame.add(newJPanel);
         
        User user = new User();
        user.QueryUser(newJPanel);
    }

    private void button12ActionPerformed(ActionEvent event) {
    	 JFrame newJFrame = new JFrame();
         newJFrame.setTitle("用户管理-增加用户");
         newJFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         newJFrame.setBounds(300, 170, 300, 300);
         newJFrame.setLocationRelativeTo(null);
         newJFrame.setVisible(true);
         
         JPanel newJPanel = new JPanel();
         newJPanel.setLayout(new BorderLayout());
         newJFrame.add(newJPanel);
         newJPanel.add(new JLabel(" "), BorderLayout.NORTH);

         JPanel button12JPanel = new JPanel();
         button12JPanel.setLayout(new GridLayout(4,1));
         newJPanel.add(button12JPanel, BorderLayout.CENTER);
          
         JPanel button12JPanel1 = new JPanel();
         button12JPanel1.setLayout(new FlowLayout());
         button12JPanel.add(button12JPanel1);
         JPanel button12JPanel2 = new JPanel();
         button12JPanel2.setLayout(new FlowLayout());
         button12JPanel.add(button12JPanel2);
         JPanel button12JPanel3 = new JPanel();
         button12JPanel3.setLayout(new FlowLayout());
         button12JPanel.add(button12JPanel3);
         JPanel button12JPanel6 = new JPanel();
         button12JPanel6.setLayout(new FlowLayout());
         button12JPanel.add(button12JPanel6);

         button12JPanel1.add(new JLabel("用户ID"));
         JTextField userIDJTextField = new JTextField(10);
         button12JPanel1.add(userIDJTextField);

         button12JPanel2.add(new JLabel("用户名"));
         JTextField userNameJTextField = new JTextField(10);
         button12JPanel2.add(userNameJTextField);

         button12JPanel3.add(new JLabel("用户密码"));
         JTextField userPasswordJTextField = new JTextField(10);
         button12JPanel3.add(userPasswordJTextField);

         JButton confirmButton = new JButton("确认");
         button12JPanel6.add(confirmButton);
         
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                User user = new User();
                user.AddUser(userIDJTextField, userNameJTextField, userPasswordJTextField);
            }
        });
    }

    private void button13ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("用户管理-删除用户");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 200, 150);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);
        
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);
        newJPanel.add(new JLabel(" "), BorderLayout.NORTH);       

        JPanel button13JPanel = new JPanel();
        button13JPanel.setLayout(new GridLayout(2,1));
        newJPanel.add(button13JPanel, BorderLayout.CENTER);
        
        JPanel button13JPanel1 = new JPanel();
        button13JPanel1.setLayout(new FlowLayout());
        button13JPanel.add(button13JPanel1);
        JPanel button13JPanel2 = new JPanel();
        button13JPanel2.setLayout(new FlowLayout());
        button13JPanel.add(button13JPanel2);

        button13JPanel1.add(new JLabel("用户ID"));
        JTextField userIDJTextField = new JTextField(10);
        button13JPanel1.add(userIDJTextField);

        JButton confirmButton = new JButton("确认");
        button13JPanel2.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                User user = new User();
                user.DeleteUser(userIDJTextField);
            }
        });
    }

    private void button14ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("用户管理-更改用户");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 300, 250);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);
        
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);
        newJPanel.add(new JLabel(" "), BorderLayout.NORTH);

        JPanel button12JPanel = new JPanel();
        button12JPanel.setLayout(new GridLayout(4,1));
        newJPanel.add(button12JPanel, BorderLayout.CENTER);
         
        JPanel button12JPanel1 = new JPanel();
        button12JPanel1.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel1);
        JPanel button12JPanel2 = new JPanel();
        button12JPanel2.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel2);
        JPanel button12JPanel3 = new JPanel();
        button12JPanel3.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel3);
        JPanel button12JPanel7 = new JPanel();
        button12JPanel7.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel7);

        button12JPanel1.add(new JLabel("用户ID"));
        JTextField userIDJTextField = new JTextField(10);
        button12JPanel1.add(userIDJTextField);

        button12JPanel2.add(new JLabel("用户名"));
        JTextField userNameJTextField = new JTextField(10);
        button12JPanel2.add(userNameJTextField);

        button12JPanel3.add(new JLabel("用户密码"));
        JTextField userPasswordJTextField = new JTextField(10);
        button12JPanel3.add(userPasswordJTextField);

        JButton confirmButton = new JButton("确认");
        button12JPanel7.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                User user = new User();
                user.UpdateUser(userIDJTextField, userNameJTextField, userPasswordJTextField);
            }
        });
    }

    private void button21ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商家管理-当前商家");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(500, 300, 600, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel(new BorderLayout());
        newJFrame.add(newJPanel);
        
        Business business = new Business();
        business.QueryBusiness(newJPanel);
    }

    private void button22ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商家管理-增加商家");
        newJFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 300, 300);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);
        
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);
        newJPanel.add(new JLabel(" "), BorderLayout.NORTH);

        JPanel button12JPanel = new JPanel();
        button12JPanel.setLayout(new GridLayout(4,1));
        newJPanel.add(button12JPanel, BorderLayout.CENTER);
         
        JPanel button12JPanel1 = new JPanel();
        button12JPanel1.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel1);
        JPanel button12JPanel2 = new JPanel();
        button12JPanel2.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel2);
        JPanel button12JPanel3 = new JPanel();
        button12JPanel3.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel3);
        JPanel button12JPanel6 = new JPanel();
        button12JPanel6.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel6);

        button12JPanel1.add(new JLabel("商家ID"));
        JTextField businessIDJTextField = new JTextField(10);
        button12JPanel1.add(businessIDJTextField);

        button12JPanel2.add(new JLabel("商家名"));
        JTextField businessNameJTextField = new JTextField(10);
        button12JPanel2.add(businessNameJTextField);

        button12JPanel3.add(new JLabel("商家密码"));
        JTextField businessPasswordJTextField = new JTextField(10);
        button12JPanel3.add(businessPasswordJTextField);

        JButton confirmButton = new JButton("确认");
        button12JPanel6.add(confirmButton);
        

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Business business = new Business();
                business.AddBusiness(businessIDJTextField, businessNameJTextField, businessPasswordJTextField);
            }
        });
    }
    private void button23ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商家管理-删除商家");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 200, 150);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);
        
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);
        newJPanel.add(new JLabel(" "), BorderLayout.NORTH);       

        JPanel button13JPanel = new JPanel();
        button13JPanel.setLayout(new GridLayout(2,1));
        newJPanel.add(button13JPanel, BorderLayout.CENTER);
        
        JPanel button13JPanel1 = new JPanel();
        button13JPanel1.setLayout(new FlowLayout());
        button13JPanel.add(button13JPanel1);
        JPanel button13JPanel2 = new JPanel();
        button13JPanel2.setLayout(new FlowLayout());
        button13JPanel.add(button13JPanel2);

        button13JPanel1.add(new JLabel("商家ID"));
        JTextField businessIDJTextField = new JTextField(10);
        button13JPanel1.add(businessIDJTextField);

        JButton confirmButton = new JButton("确认");
        button13JPanel2.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Business business = new Business();
                business.DeleteBusiness(businessIDJTextField);
            }
        });
    }
    private void button24ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商家管理-更改商家");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 300, 250);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);
        
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);
        newJPanel.add(new JLabel(" "), BorderLayout.NORTH);

        JPanel button12JPanel = new JPanel();
        button12JPanel.setLayout(new GridLayout(4,1));
        newJPanel.add(button12JPanel, BorderLayout.CENTER);
         
        JPanel button12JPanel1 = new JPanel();
        button12JPanel1.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel1);
        JPanel button12JPanel2 = new JPanel();
        button12JPanel2.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel2);
        JPanel button12JPanel3 = new JPanel();
        button12JPanel3.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel3);
        JPanel button12JPanel7 = new JPanel();
        button12JPanel7.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel7);

        button12JPanel1.add(new JLabel("商家ID"));
        JTextField businessIDJTextField = new JTextField(10);
        button12JPanel1.add(businessIDJTextField);

        button12JPanel2.add(new JLabel("商家名"));
        JTextField businessNameJTextField = new JTextField(10);
        button12JPanel2.add(businessNameJTextField);

        button12JPanel3.add(new JLabel("商家密码"));
        JTextField businessPasswordJTextField = new JTextField(10);
        button12JPanel3.add(businessPasswordJTextField);

        JButton confirmButton = new JButton("确认");
        button12JPanel7.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Business business = new Business();
                business.AddBusiness(businessIDJTextField, businessNameJTextField, businessPasswordJTextField);
            }
        });
    }

    private void button31ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("订单管理-查询所有订单");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(500, 300, 700, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel(new BorderLayout());
        newJFrame.add(newJPanel);
        
        Order order = new Order();
        order.QueryOrder(newJPanel);
    }

    private void button41ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("统计查询-某个时间段所有订单的单数和总金额");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 550, 150);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);

        JPanel northJPanel = new JPanel();
        newJPanel.add(northJPanel,BorderLayout.NORTH);

        JPanel newJPanel1 = new JPanel();
        newJPanel1.setLayout(new FlowLayout());
        northJPanel.add(newJPanel1);
        JPanel newJPanel2 = new JPanel();
        newJPanel2.setLayout(new FlowLayout());
        northJPanel.add(newJPanel2);
        JPanel newJPanel3 = new JPanel();
        newJPanel3.setLayout(new FlowLayout());
        northJPanel.add(newJPanel3);

        newJPanel1.add(new JLabel("开始时间"));
        JTextField newJTextField1 = new JTextField(10);
        newJPanel1.add(newJTextField1);
        newJPanel2.add(new JLabel("结束时间"));
        JTextField newJTextField2 = new JTextField(10);
        newJPanel2.add(newJTextField2);

        JButton confirmButton = new JButton("确认");
        newJPanel3.add(confirmButton);

        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new FlowLayout());
        newJPanel.add(centerJPanel,BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Order order = new Order();
                order.AdminQueryOrder1(newJTextField1.getText(), newJTextField2.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
    }

    private void button42ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("统计查询-某个类别商品的订单数和总金额");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 550, 150);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);

        JPanel northJPanel = new JPanel();
        newJPanel.add(northJPanel,BorderLayout.NORTH);

        JPanel newJPanel1 = new JPanel();
        newJPanel1.setLayout(new FlowLayout());
        northJPanel.add(newJPanel1);
        JPanel newJPanel3 = new JPanel();
        newJPanel3.setLayout(new FlowLayout());
        northJPanel.add(newJPanel3);

        newJPanel1.add(new JLabel("商品类别"));
        JTextField newJTextField1 = new JTextField(10);
        newJPanel1.add(newJTextField1);

        JButton confirmButton = new JButton("确认");
        newJPanel3.add(confirmButton);

        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new FlowLayout());
        newJPanel.add(centerJPanel,BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Order order = new Order();
                order.AdminQueryOrder2(newJTextField1.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
        
    }

    private void button43ActionPerformed(ActionEvent event) {
    	JFrame newJFrame = new JFrame();
        newJFrame.setTitle("统计查询-某个时间段内前十名热销的商品");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 450, 290);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);

        JPanel northJPanel = new JPanel();
        newJPanel.add(northJPanel,BorderLayout.NORTH);

        JPanel newJPanel1 = new JPanel();
        newJPanel1.setLayout(new FlowLayout());
        northJPanel.add(newJPanel1);
        JPanel newJPanel2 = new JPanel();
        newJPanel2.setLayout(new FlowLayout());
        northJPanel.add(newJPanel2);
        JPanel newJPanel3 = new JPanel();
        newJPanel3.setLayout(new FlowLayout());
        northJPanel.add(newJPanel3);

        newJPanel1.add(new JLabel("开始时间"));
        JTextField newJTextField1 = new JTextField(10);
        newJPanel1.add(newJTextField1);
        newJPanel2.add(new JLabel("结束时间"));
        JTextField newJTextField2 = new JTextField(10);
        newJPanel2.add(newJTextField2);

        JButton confirmButton = new JButton("确认");
        newJPanel3.add(confirmButton);

        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new BorderLayout());
        newJPanel.add(centerJPanel,BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Order order = new Order();
                order.AdminQueryOrder3(newJTextField1.getText(), newJTextField2.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
    }

    private void button44ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("统计查询-按照商家统计某段时间的订单数和总金额");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 450, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);

        JPanel northJPanel = new JPanel();
        newJPanel.add(northJPanel,BorderLayout.NORTH);

        JPanel newJPanel1 = new JPanel();
        newJPanel1.setLayout(new FlowLayout());
        northJPanel.add(newJPanel1);
        JPanel newJPanel2 = new JPanel();
        newJPanel2.setLayout(new FlowLayout());
        northJPanel.add(newJPanel2);
        JPanel newJPanel3 = new JPanel();
        newJPanel3.setLayout(new FlowLayout());
        northJPanel.add(newJPanel3);

        newJPanel1.add(new JLabel("开始时间"));
        JTextField newJTextField1 = new JTextField(10);
        newJPanel1.add(newJTextField1);
        newJPanel2.add(new JLabel("结束时间"));
        JTextField newJTextField2 = new JTextField(10);
        newJPanel2.add(newJTextField2);

        JButton confirmButton = new JButton("确认");
        newJPanel3.add(confirmButton);

        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new BorderLayout());
        newJPanel.add(centerJPanel,BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Order order = new Order();
                order.AdminQueryOrder4(newJTextField1.getText(), newJTextField2.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
    }
    private void button45ActionPerformed(ActionEvent event) {

        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("统计查询-某个时间段内销量排名前十名的商家");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 450, 290);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);

        JPanel northJPanel = new JPanel();
        newJPanel.add(northJPanel,BorderLayout.NORTH);

        JPanel newJPanel1 = new JPanel();
        newJPanel1.setLayout(new FlowLayout());
        northJPanel.add(newJPanel1);
        JPanel newJPanel2 = new JPanel();
        newJPanel2.setLayout(new FlowLayout());
        northJPanel.add(newJPanel2);
        JPanel newJPanel3 = new JPanel();
        newJPanel3.setLayout(new FlowLayout());
        northJPanel.add(newJPanel3);

        newJPanel1.add(new JLabel("开始时间"));
        JTextField newJTextField1 = new JTextField(10);
        newJPanel1.add(newJTextField1);
        newJPanel2.add(new JLabel("结束时间"));
        JTextField newJTextField2 = new JTextField(10);
        newJPanel2.add(newJTextField2);

        JButton confirmButton = new JButton("确认");
        newJPanel3.add(confirmButton);

        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new BorderLayout());
        newJPanel.add(centerJPanel,BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Order order = new Order();
                order.AdminQueryOrder5(newJTextField1.getText(), newJTextField2.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
    }

    private void button46ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("统计查询-某个时间段成功下单金额前十名的用户");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 450, 290);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);

        JPanel northJPanel = new JPanel();
        newJPanel.add(northJPanel,BorderLayout.NORTH);

        JPanel newJPanel1 = new JPanel();
        newJPanel1.setLayout(new FlowLayout());
        northJPanel.add(newJPanel1);
        JPanel newJPanel2 = new JPanel();
        newJPanel2.setLayout(new FlowLayout());
        northJPanel.add(newJPanel2);
        JPanel newJPanel3 = new JPanel();
        newJPanel3.setLayout(new FlowLayout());
        northJPanel.add(newJPanel3);

        newJPanel1.add(new JLabel("开始时间"));
        JTextField newJTextField1 = new JTextField(10);
        newJPanel1.add(newJTextField1);
        newJPanel2.add(new JLabel("结束时间"));
        JTextField newJTextField2 = new JTextField(10);
        newJPanel2.add(newJTextField2);

        JButton confirmButton = new JButton("确认");
        newJPanel3.add(confirmButton);

        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new BorderLayout());
        newJPanel.add(centerJPanel,BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Order order = new Order();
                order.AdminQueryOrder6(newJTextField1.getText(), newJTextField2.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
    }

    private void button47ActionPerformed(ActionEvent event) {

        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("统计查询-每个月的订单数量和金额情况统计");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(500, 300, 450, 350);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel(new BorderLayout());
        newJFrame.add(newJPanel);
        
        Order order = new Order();
        order.AdminQueryOrder7(newJPanel);
    }
}
