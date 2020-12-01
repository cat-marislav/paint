import java.awt.*;

public class ColorChoice {
    public Color color;
    public int x;
    public int y;
    public int width;
    public int height;
    public ColorChoice(Color color, int x, int y, int width, int height){
        this.color=color;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
    public boolean isInside(int x, int y){
        if(x>=this.x && x<=this.x+this.width && y>=this.y && y<=this.y+this.height){
            return true;
        }
        return false;
    }
}
