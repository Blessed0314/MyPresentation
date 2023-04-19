package myProject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;


/**
 * This class is used for ...
 * @autor Christian Daniel Villegas christian.villegas@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelActions, containerButtons;
    private JTextArea expectativeText, hintText;
    private JButton myPhoto, myHobby, myExpectation;
    private Listener listener;
    private JLabel imageLabel;
    private Escucha escucha;



    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("My presentation V2");
        this.setSize(600,400);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        /** Se crea la escucha para las acciones del mouse y el teclado*/
        escucha = new Escucha();
        /**Se crea el listener de los botones*/
        listener = new Listener();
        //Set up JComponents

        /** Se crea el header del protecto y sus propiedades  */
        headerProject = new Header("A presentation about me", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        /**Se crea el JPanel de eventos del Mouse y se agregan propiedades*/
        panelActions = new JPanel();
        imageLabel = new JLabel();
        expectativeText = new JTextArea(10,12);
        panelActions.addMouseListener(escucha);
        panelActions.addMouseMotionListener(escucha);
        panelActions.addKeyListener(escucha);
        panelActions.setFocusable(true);
        panelActions.setBackground(Color.blue);
        panelActions.setPreferredSize(new Dimension(600,120));
        panelActions.setBorder(BorderFactory.createTitledBorder(null,"Read the clues to find me", TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,
                new Font(Font.SANS_SERIF, Font.PLAIN, 20), Color.white));
        panelActions.add(imageLabel);
        /**Se agrega el JPanel segun su ubicación*/
        this.add(panelActions, BorderLayout.CENTER);






        /**Se crean los botones y su JPanel con sus propiedades*/
        containerButtons = new JPanel();
        myPhoto  = new JButton("My Photo");
        myHobby = new JButton("My Hobby");
        myExpectation = new JButton("My Expectation");
        /**Se agregan los botones al contenedor*/
        containerButtons.add(myPhoto);
        containerButtons.add(myExpectation);
        containerButtons.add(myHobby);
        /**Se agrega el JPanel de botones a su ubicación*/
        this.add(containerButtons, BorderLayout.SOUTH);
        /**Se agregan los escucha a los botones*/
        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectation.addActionListener(listener);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha  implements MouseListener, MouseMotionListener, KeyListener{
        private ImageIcon image;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            imageLabel.setIcon(null);
            panelActions.remove(expectativeText);
            char key = e.getKeyChar();
            if (key == 'm'){
                 panelActions.add(expectativeText);
                 expectativeText.setText("My expectation is to become a full stack\n " + "    developer and an excellent person.");
                 expectativeText.setBackground(null);
                 expectativeText.setForeground(Color.black);
                 expectativeText.setFont(new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 18));

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            imageLabel.setIcon(null);
            panelActions.remove(expectativeText);
            if (e.getClickCount() == 2) {
                this.image = new ImageIcon(getClass().getResource("/Resource/me.jpg"));
                imageLabel.setIcon(image);
            }
            else if(e.getClickCount() == 1){
                this.image = new ImageIcon(getClass().getResource("/Resource/leer.jpg"));
                imageLabel.setIcon(image);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

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

        @Override
        public void mouseDragged(MouseEvent e) {


        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
    private class Listener implements ActionListener{
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {

            imageLabel.setIcon(null);


            if(e.getSource()== myPhoto){
                JOptionPane.showMessageDialog(null,"Hint: If you press me twice you will see me");

            }
            else if(e.getSource()== myHobby){
                JOptionPane.showMessageDialog(null,"hint: Just once and you'll know that I like it");
            }
            else if(e.getSource()== myExpectation){
                JOptionPane.showMessageDialog(null,"hint: Mi MaMá Me aMa");

            }
            panelActions.requestFocusInWindow();
            revalidate();
            repaint();
        }
    }
}
