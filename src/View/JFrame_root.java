package View;

import Logic.main_logic;

import javax.swing.*;
import java.awt.*;

public class JFrame_root extends JFrame {

    private JFrame_root root;
    JPanel_info jPanel_info;
    private JPanel_content Jpanel_content;

    public JFrame_root()
    {
        root=this;
        setTitle("生涯规划");    //设置显示窗口标题
        setBounds(100,100,1000,600);    //设置窗口显示尺寸
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
        Jpanel_content = new JPanel_content();
        jPanel_info = new JPanel_info();
        main_logic logic = Logic.main_logic.getInstance();
        logic.setContent(Jpanel_content);
        logic.setInfo(jPanel_info);
        logic.setRoot(root);
        add(jPanel_info,BorderLayout.NORTH);
        add(Jpanel_content,BorderLayout.CENTER);
        Container c=getContentPane();    //获取当前窗口的内容窗格
        setVisible(true);    //设置窗口是否可见
    }
    public static void main(String[] agrs)
    {
        new JFrame_root();    //创建一个实例化对象
    }

}
