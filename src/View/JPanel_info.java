package View;

import Logic.main_logic;
import Mode.Score;
import View.contents.Province_comboBox;
import View.layouts.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPanel_info extends JPanel {
    private JLabel Label1 = new JLabel("分数");
    private JTextField score = new JTextField(3);

    private JLabel Label2 = new JLabel("查询学校数");
    private JComboBox comboBox1 = new JComboBox();

    private JLabel Label3 = new JLabel("批次");
    private JComboBox comboBox2 = new JComboBox();

    private JLabel Label4 = new JLabel("文理");
    private JComboBox comboBox3 = new JComboBox();

    private JLabel Label5 = new JLabel("算法");
    private JComboBox comboBox4 = new JComboBox();

    private JLabel Label8 = new JLabel("地区");
    private JComboBox Province_comboBox = new Province_comboBox();

//    private JLabel Label6 = new JLabel("学生信息");
    private JLabel Label7 = new JLabel("");

    private JButton jb_sreach = new JButton("查询");
    private Map<String,Object> info = new HashMap<>();


    public JPanel_info()
    {
        comboBox1.addItem("5");
        comboBox1.addItem("10");
        comboBox1.addItem("15");
        comboBox2.addItem("A1");
        comboBox2.addItem("1A");
        comboBox2.addItem("1B");
        comboBox2.addItem("2A");
        comboBox2.addItem("2B");
        comboBox2.addItem("2C");
        comboBox3.addItem("文史");
        comboBox3.addItem("理工");
        comboBox4.addItem("第一算法");
        setSize(400,200);    //设置窗口显示尺寸
        add(Label1);
        add(score);
        add(Label2);
        add(comboBox1);
        add(Label3);
        add(comboBox2);
        add(Label4);
        add(comboBox3);
        add(Label5);
        add(comboBox4);
        add(Label8);
        add(Province_comboBox);
        add(jb_sreach);
//        add(Label6);
        add(Label7);
        score.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

                } else {
                    e.consume();
                }
            }
        });
        jb_sreach.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                do_jb_sreach_actionPerformed(e);
            }
        });
        setLayout(new WrapLayout());
        setVisible(true);    //设置窗口是否可见
    }

    private void do_jb_sreach_actionPerformed(ActionEvent e) {
        main_logic logic = main_logic.getInstance();
        info_pack();
        int algu = 0;
        logic.setInfo_packet(info);
        List<Score> score = logic.show_score();
        Label7.setText("2019年学生信息：分数："+score.get(0).getScore()+". 同分人数:"+score.get(0).getNubmer()+". 总体排名:"+
                score.get(0).getCount_number());
        this.updateUI();
        logic.search_uni((String)comboBox4.getSelectedItem());


    }

    private void info_pack(){
        info.put(Label1.getText(),Integer.parseInt(score.getText()));
        info.put(Label2.getText(),comboBox1.getSelectedItem());
        info.put(Label3.getText(),comboBox2.getSelectedItem());
        info.put(Label4.getText(),comboBox3.getSelectedItem());
        info.put(Label8.getText(),Province_comboBox.getSelectedItem());
    }

    public JTextField getScore() {
        return score;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public JButton getJb_sreach() {
        return jb_sreach;
    }
}
