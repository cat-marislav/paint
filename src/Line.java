import java.awt.*;
import java.util.ArrayList;

public class Line {
    ArrayList<Integer> xs;
    ArrayList<Integer> ys;
    Color curColor;

    public Line(ArrayList<Integer> xs, ArrayList<Integer> ys, Color curColor) {
        this.xs = xs;
        this.ys = ys;
        this.curColor = curColor;
    }

    public void draw(Graphics g) {
        Color previous = g.getColor();
        g.setColor(curColor);
        for (int i = 0; i < xs.size(); ++i) {
            if(i!=0){
                g.drawLine(xs.get(i - 1), ys.get(i - 1), xs.get(i), ys.get(i));
            }
        }
        g.setColor(previous);
    }

}
