package View;

import Mode.Uni;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class JPanel_content extends JPanel {
    JTable table;

    public JPanel_content()
    {
        JPanel_content contentPane=this;
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        JScrollPane scrollPane=new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);
        table=new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(table);

        DefaultTableModel tableModel=(DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);    //清空表格中的数据
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型
    }
    public void show_data(List<Uni> list){
        DefaultTableModel tableModel=(DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);    //清空表格中的数据
        Object[] labels = new Object[9];
        Uni unid = new Uni();
        int i = 0;
        for (String st: unid.getLabel()
             ) {
            labels[i] = st;
            i++;
        }
        tableModel.setColumnIdentifiers(labels);    //设置表头
        for (Uni uni:list
        ) {
            tableModel.addRow(new Object[]{uni.getId(),uni.getUniId(),uni.getName(),uni.getProvince(),
                    uni.getMax_score(),uni.getMin_score(),uni.getHigh_position(),
                    uni.getLow_position(),uni.getNumber()});
        }
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型

    }
}
