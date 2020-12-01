import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class MainFrame extends JFrame implements MouseListener, MouseMotionListener {
    ArrayList<Line> lines = new ArrayList<>();
    ArrayList<Integer> xs = new ArrayList<>();
    ArrayList<Integer> ys = new ArrayList<>();
    Color curColor = new Color(255, 0, 0);
    ColorChoice red = new ColorChoice(new Color(255, 0, 0), 520, 50, 50, 50);
    ColorChoice green = new ColorChoice(new Color(0, 255, 0), 520, 110, 50, 50);
    ColorChoice blu = new ColorChoice(new Color(0, 0, 255), 520, 170, 50, 50);
    ColorChoice yellow = new ColorChoice(new Color(255, 223, 8, 255), 520, 230, 50, 50);

    public MainFrame(int width, int height) {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }
        g = bufferStrategy.getDrawGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        red.draw(g);
        green.draw(g);
        blu.draw(g);
        yellow.draw(g);
        g.setColor(this.curColor);
        for (int i = 0; i < xs.size(); ++i) {
            if (i != 0) {
                g.drawLine(xs.get(i - 1), ys.get(i - 1), xs.get(i), ys.get(i));
            }
        }
        for (Line line : lines) {
            line.draw(g);
        }
        g.dispose();
        bufferStrategy.show();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (red.isInside(e.getX(), e.getY())) {
            this.curColor = red.color;
        } else if (blu.isInside(e.getX(), e.getY())) {
            this.curColor = blu.color;
        } else if (green.isInside(e.getX(), e.getY())) {
            this.curColor = green.color;
        } else if (yellow.isInside(e.getX(), e.getY())) {
            this.curColor = yellow.color;
        }
        lines.add(new Line(xs, ys, curColor));
        xs = new ArrayList<>();
        ys = new ArrayList<>();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!(red.isInside(e.getX(), e.getY()) || green.isInside(e.getX(), e.getY()) || blu.isInside(e.getX(), e.getY()))) {
            xs.add(e.getX());
            ys.add(e.getY());
        }
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
