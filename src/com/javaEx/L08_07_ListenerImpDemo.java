package com.javaEx;

/**
 * @author 风亦未止
 * @date 2022/7/15 21:17
 */
import java.awt.*;import java.awt.event.*;

public class L08_07_ListenerImpDemo implements MouseMotionListener, MouseListener, WindowListener {
    private Frame frm;
    private TextField tf;

    public static void main(String[] args) {
        L08_07_ListenerImpDemo three = new L08_07_ListenerImpDemo();
        three.go();
    }

    public void go() {
        frm = new Frame("三个监听器");
        frm.add(new Label("拖拽鼠标"), "North");
        tf = new TextField(30);
        frm.add(tf, "South");
        frm.addMouseMotionListener((MouseMotionListener) this);
        frm.addMouseListener((MouseListener) this);
        frm.addWindowListener(this);
        frm.setSize(300, 200);
        frm.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        String s = "拖拽鼠标，坐标:X=" + e.getX() + "\tY=" + e.getY();
        tf.setText(s);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String s = "鼠标进入了";
        tf.setText(s);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String s = "鼠标离开了";
        tf.setText(s);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(1);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
