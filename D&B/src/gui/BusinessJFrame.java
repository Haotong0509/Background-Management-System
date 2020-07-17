package gui;

import function.Commodity;
import function.Order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BusinessJFrame extends JFrame{

    private JPanel contentPane;
    private int businessID = 0;

    public BusinessJFrame(int businessID) {
        this.businessID = businessID;
        setTitle("商家后台管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 170, 500, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(3, 5));
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel label1 = new JLabel("商品管理");
        JButton button11 = new JButton("当前商品");
        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button11ActionPerformed(event);
            }
        });
        JButton button12 = new JButton("增加商品");
        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button12ActionPerformed(event);
            }
        });
        JButton button13 = new JButton("删除商品");
        button13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button13ActionPerformed(event);
            }
        });
        JButton button14 = new JButton("更改商品");
        button14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button14ActionPerformed(event);
            }
        });

        JLabel label2 = new JLabel("订单管理");
        JButton button21 = new JButton("查询订单");
        button21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button21ActionPerformed(event);
            }
        });
        JButton button22 = new JButton("订单发货");
        button22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button22ActionPerformed(event);
            }
        });

        JLabel label3 = new JLabel("统计查询");
        JButton button31 = new JButton("所有订单");
        button31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button31ActionPerformed(event);
            }
        });
        JButton button32 = new JButton("某类商品");
        button32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button32ActionPerformed(event);
            }
        });
        JButton button33 = new JButton("热销前十");
        button33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                button33ActionPerformed(event);
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
        getContentPane().add(new JLabel(""));
        getContentPane().add(new JLabel(""));
        getContentPane().add(label3);
        getContentPane().add(button31);
        getContentPane().add(button32);
        getContentPane().add(button33);
    }


    private void button11ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商品管理-当前商品");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(500, 300, 500, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel(new BorderLayout());
        newJFrame.add(newJPanel);
        
        Commodity commodity = new Commodity();
        commodity.BusinessQueryCommodity(newJPanel,businessID);
    }

    private void button12ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商品管理-增加商品");
        newJFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 300, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);
        
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);
        newJPanel.add(new JLabel(" "), BorderLayout.NORTH);

        JPanel button12JPanel = new JPanel();
        button12JPanel.setLayout(new GridLayout(6,1));
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
        JPanel button12JPanel4 = new JPanel();
        button12JPanel4.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel4);
        JPanel button12JPanel5 = new JPanel();
        button12JPanel5.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel5);
        JPanel button12JPanel6 = new JPanel();
        button12JPanel6.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel6);

        button12JPanel1.add(new JLabel("商品ID"));
        JTextField commodityIDJTextField = new JTextField(10);
        button12JPanel1.add(commodityIDJTextField);

        button12JPanel2.add(new JLabel("商品名"));
        JTextField commodityNameJTextField = new JTextField(10);
        button12JPanel2.add(commodityNameJTextField);

        button12JPanel3.add(new JLabel("商品价格"));
        JTextField commodityPriceJTextField = new JTextField(10);
        button12JPanel3.add(commodityPriceJTextField);

        button12JPanel4.add(new JLabel("商品大类"));
        JTextField commodityCCJTextField = new JTextField(10);
        button12JPanel4.add(commodityCCJTextField);

        button12JPanel5.add(new JLabel("商品小类"));
        JTextField commodityFCJTextField = new JTextField(10);
        button12JPanel5.add(commodityFCJTextField);

        JButton confirmButton = new JButton("确认");
        button12JPanel6.add(confirmButton);
//        newJPanel.add(button12JPanel6, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Commodity commodity = new Commodity();
                commodity.BusinessAddCommodity(commodityIDJTextField, commodityNameJTextField, commodityPriceJTextField,
                        commodityCCJTextField, commodityFCJTextField, businessID);
            }
        });
    }

    private void button13ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商品管理-删除商品");
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

        button13JPanel1.add(new JLabel("商品ID"));
        JTextField commodityIDJTextField = new JTextField(10);
        button13JPanel1.add(commodityIDJTextField);

        JButton confirmButton = new JButton("确认");
        button13JPanel2.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Commodity commodity = new Commodity();
                commodity.DeleteCommodity(commodityIDJTextField);
            }
        });
    }

    private void button14ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("商品管理-更改商品");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(300, 170, 300, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);
        
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        newJFrame.add(newJPanel);
        newJPanel.add(new JLabel(" "), BorderLayout.NORTH);

        JPanel button12JPanel = new JPanel();
        button12JPanel.setLayout(new GridLayout(7,1));
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
        JPanel button12JPanel4 = new JPanel();
        button12JPanel4.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel4);
        JPanel button12JPanel5 = new JPanel();
        button12JPanel5.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel5);
        JPanel button12JPanel6 = new JPanel();
        button12JPanel6.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel6);
        JPanel button12JPanel7 = new JPanel();
        button12JPanel7.setLayout(new FlowLayout());
        button12JPanel.add(button12JPanel7);

        button12JPanel1.add(new JLabel("商品ID"));
        JTextField commodityIDJTextField = new JTextField(10);
        button12JPanel1.add(commodityIDJTextField);

        button12JPanel2.add(new JLabel("商品名"));
        JTextField commodityNameJTextField = new JTextField(10);
        button12JPanel2.add(commodityNameJTextField);

        button12JPanel3.add(new JLabel("商品价格"));
        JTextField commodityPriceJTextField = new JTextField(10);
        button12JPanel3.add(commodityPriceJTextField);

        button12JPanel4.add(new JLabel("商品大类"));
        JTextField commodityCCJTextField = new JTextField(10);
        button12JPanel4.add(commodityCCJTextField);

        button12JPanel5.add(new JLabel("商品小类"));
        JTextField commodityFCJTextField = new JTextField(10);
        button12JPanel5.add(commodityFCJTextField);
        
        button12JPanel6.add(new JLabel("商家ID"));
        JTextField commodityBIDJTextField = new JTextField(10);
        button12JPanel6.add(commodityBIDJTextField);

        JButton confirmButton = new JButton("确认");
        button12JPanel7.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Commodity commodity = new Commodity();
                commodity.UpdateCommodity(commodityIDJTextField, commodityNameJTextField, commodityPriceJTextField,
                        commodityCCJTextField, commodityFCJTextField, commodityBIDJTextField);
            }
        });
    }

    private void button21ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("订单管理-查询订单");
        newJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newJFrame.setBounds(500, 300, 800, 500);
        newJFrame.setLocationRelativeTo(null);
        newJFrame.setVisible(true);

        JPanel newJPanel = new JPanel(new BorderLayout());
        newJFrame.add(newJPanel);
        
        Order order = new Order();
        order.BusinessQueryOrder(businessID, newJPanel);
    }

    private void button22ActionPerformed(ActionEvent event) {
        JFrame newJFrame = new JFrame();
        newJFrame.setTitle("订单管理-订单发货");
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

        button13JPanel1.add(new JLabel("订单ID"));
        JTextField commodityIDJTextField = new JTextField(10);
        button13JPanel1.add(commodityIDJTextField);

        JButton confirmButton = new JButton("确认");
        button13JPanel2.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Order order = new Order();
                order.BusinessOrderManagement(commodityIDJTextField);
            }
        });
    }

    private void button31ActionPerformed(ActionEvent event) {
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
                order.BusinessQueryOrder1(businessID, newJTextField1.getText(), newJTextField2.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });

    }

    private void button32ActionPerformed(ActionEvent event) {
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
                order.BusinessQueryOrder2(businessID, newJTextField1.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
    }

    private void button33ActionPerformed(ActionEvent event) {
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
                order.BusinessQueryOrder3(businessID, newJTextField1.getText(), newJTextField2.getText(), centerJPanel);
                newJFrame.setVisible(false);
                newJFrame.setVisible(true);
            }
        });
    }
}
