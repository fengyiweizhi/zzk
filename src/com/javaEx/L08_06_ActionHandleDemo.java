package com.javaEx;

/**
 * @author 风亦未止
 * @date 2022/7/15 21:19
 */
import java.awt.*;import java.awt.event.*;

public class L08_06_ActionHandleDemo extends Frame implements ActionListener {
    static L08_06_ActionHandleDemo frm = new L08_06_ActionHandleDemo();
    static Button btn = new Button("清单击!");

    public static void main(String args[]) {
        btn.addActionListener(frm);
        frm.setLayout(new FlowLayout());
        frm.setTitle("事件测试窗口");
        frm.setSiza(200, 300);
        frm.add(btn);
        frm.setVisible(true);
    }

    private void setSiza(int i, int i1) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frm.setBackground(Color.blue);
    }
}
