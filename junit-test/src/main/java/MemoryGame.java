import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;



/**
 * Created by Bhanger Bhanger on 7/26/2018.
 */
public class MemoryGame {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel score;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JPanel board;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton resetScoreButton;


    Icon xIcon = createIcon("image/x.png");
    Icon oIcon = createIcon("image/o.png");
    Icon aIcon = createIcon("image/A.jpg");
    Icon bIcon = createIcon("image/B.jpg");
    Icon cIcon = createIcon("image/c.jpg");


    JButton[] iconarray = new JButton[2];
    int userscore = 0;
    Icon[] thevalues = new ImageIcon[17];
    int county = 0;


    public MemoryGame() {
        button1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 1);


            }
        });
        button2.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 2);

            }
        });
        button3.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 3);


            }
        });
        button9.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 9);
            }
        });
        button5.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 5);
            }
        });
        button8.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 8);
            }
        });
        button4.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 4);
            }
        });
        button6.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 6);
            }
        });
        button7.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 7);
            }
        });
        button10.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 10);
            }
        });
        button11.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 11);
            }
        });
        button12.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 12);
            }
        });
        button16.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 16);
            }
        });
        button15.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 15);
            }
        });
        button14.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 14);
            }
        });
        button13.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                dealWithButton(e, 13);
            }
        });
        resetScoreButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                userscore = 0;
                scoreset();
            }
        });
    }

    private void dealWithButton(ActionEvent e, int i) {
        thevalues[1] = xIcon;
        thevalues[2] = xIcon;
        thevalues[3] = xIcon;
        thevalues[4] = oIcon;
        thevalues[5] = oIcon;
        thevalues[6] = oIcon;
        thevalues[7] = aIcon;
        thevalues[8] = aIcon;
        thevalues[9] = aIcon;
        thevalues[10] = bIcon;
        thevalues[11] = bIcon;
        thevalues[12] = cIcon;
        thevalues[13] = xIcon;
        thevalues[14] = cIcon;
        thevalues[15] = oIcon;
        thevalues[16] = aIcon;

        JButton source = (JButton) e.getSource();
        source.setIcon(thevalues[i]);
        source.setDisabledIcon(thevalues[i]);
        source.setEnabled(false);

        if (iconarray[0] == null && iconarray[1] == null) {
            iconarray[0] = source;
        } else if (iconarray[0] != null && iconarray[1] == null) {
            iconarray[1] = source;
        } else if (iconarray[0] != null && iconarray[1] != null) {
            if (county == 7) {
                userscore++;
                scoreset();
                iconarray[0].setIcon(null);
                iconarray[1].setIcon(null);
            }
            if (iconarray[0].getIcon() == iconarray[1].getIcon()) {
                userscore++;
                county++;
                scoreset();
                iconarray[0].setIcon(null);
                iconarray[1].setIcon(null);
            } else {
                iconarray[0].setIcon(null);
                iconarray[1].setIcon(null);
                iconarray[0].setEnabled(true);
                iconarray[1].setEnabled(true);
            }
            iconarray[0] = null;
            iconarray[1] = null;
            iconarray[0] = source;

            if (button1.getIcon() == null && button2.getIcon() == null && button3.getIcon() == null && button4.getIcon() == null && button5.getIcon() == null && button6.getIcon() == null && button7.getIcon() == null && button8.getIcon() == null && button9.getIcon() == null && button10.getIcon() == null && button11.getIcon() == null && button12.getIcon() == null && button13.getIcon() == null && button14.getIcon() == null && button15.getIcon() == null && button16.getIcon() == null) {
                JOptionPane.showMessageDialog(mainPanel, "You've Won! Play Again?");
            }
        }

    }


    private Icon createIcon(String s) {
        URL meowUrl = this.getClass().getResource(s);
        if (meowUrl != null) {
            return new ImageIcon(meowUrl);
        } else {
            System.out.println("Cannot find file" + s);
            return null;
        }

    }


    private void scoreset() {
        score.setText("Your Score Is: " + " " + userscore);
    }


    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Tic Tac Toe");
        jFrame.setContentPane(new MemoryGame().mainPanel);
        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
