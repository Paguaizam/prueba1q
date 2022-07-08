/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicapaul;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import com.mycompany.practicapaul.Figure;

public class DrawPanel extends JPanel implements MouseListener {

    private final int LINE1 = 0;
    private final int LINE2 = 1;
    private final int LINE3 = 2;

    private final Figure figura;
    private Point point1 = new Point(-10, -10);
    private Point point2 = new Point(-10, -10);
    private int numClicks = 0;

    public DrawPanel(Figure figura) {
        this.figura = figura;
        this.addMouseListener(this);
    }

    public Figure getFigura() {
        return figura;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(figura.getColor());

        switch (figura.getFigura()) {
            case LINE1:
                g.drawLine(point1.x, point1.y, point2.x, point2.y);
                break;
            case LINE2:
                g.drawLine(point1.x, point1.y, point2.x, point2.y);
                break;
            case LINE3:
                g.drawLine(point1.x, point1.y, point2.x, point2.y);
                break;    
                default:
                break;
        }

    }

    public Point getPoint() {
        return point1;

    }

    public void setPoint(Point point) {
        this.point1 = point;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getPoint());
        this.numClicks++;

        System.out.println(e.getClickCount());
        if (this.numClicks == 1) {
            point1 = e.getPoint();
        }
        if (this.numClicks == 2) {
            point2 = e.getPoint();
            numClicks = 0;
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println("pressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
