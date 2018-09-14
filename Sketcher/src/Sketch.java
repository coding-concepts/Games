import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

public class Sketch {
    private JPanel paintPanel;
    private JPanel rootPanel;
    private JPanel btnPanel;
    private JButton saveButton;
    Point lastPoint = null;

    public Sketch() {
        paintPanel.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                lastPoint = new Point(e.getX(), e.getY());
            }
        });
        paintPanel.addMouseMotionListener(new MouseMotionAdapter() {
            /**
             * Invoked when a mouse button is pressed on a component and then
             * dragged.  Mouse drag events will continue to be delivered to
             * the component where the first originated until the mouse button is
             * released (regardless of whether the mouse position is within the
             * bounds of the component).
             *
             * @param e
             */
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Graphics2D g = (Graphics2D)paintPanel.getGraphics();

                g.setStroke(new BasicStroke(5));
                g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());


            }
        });


        saveButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveFile();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


    }

    private void saveFile() throws Exception {
        String fileName = getFileName();
        BufferedImage img = getScreenShot(paintPanel);
        // write the captured image as a PNG
        ImageIO.write(img, "png", new File(fileName));
    }

    private String getFileName() {
        JFileChooser jFile = new JFileChooser();
        jFile.showSaveDialog(null);
        Path pth = jFile.getSelectedFile().toPath();
        return pth.toString();
    }

    public BufferedImage getScreenShot(Component component) throws Exception {
        Point location = component.getLocation();
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(location.x, location.y, component.getWidth(), component.getHeight()+100));
        return image;
    }



    public static void main(String[] args) {
        JFrame f = new JFrame("S");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setContentPane(new Sketch().rootPanel);
        f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        f.setVisible(true);
    }
}
