import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

class AnimPane extends JPanel
{
    static String animFName = "src\\gifs\\shllsort.gif";
    Image img = Toolkit.getDefaultToolkit().getImage(animFName);
    int off = 0;          // położenie obrazka w panelu

    public void paintComponent(Graphics g) {
        setForeground(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        off = (off + 1)%(580);
                // this implementuje ImageObserver 
                // i odpowiada za wykreślanie kolejnych ramek animacji
        g.drawImage(img, off, 0, this);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("AnimPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.setLayout(new FlowLayout());
        Icon icon = new ImageIcon(animFName);
        JLabel animLab = new JLabel(icon);
        AnimPane anImage = new AnimPane();
        anImage.setPreferredSize(new Dimension(640, 41));
        cp.add(animLab);
        frame.pack();
        frame.show();
    }
}