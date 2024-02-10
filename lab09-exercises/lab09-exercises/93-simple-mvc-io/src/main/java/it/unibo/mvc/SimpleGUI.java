package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first Java graphical interface");

    public SimpleGUI(final Controller controller){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea area = new JTextArea();
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");

        // GUI assemblage
        panel1.add(text, BorderLayout.CENTER);
        panel1.add(save, BorderLayout.SOUTH);
        frame.setContentPane(panel1);
        // Frame size and location
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(){
                try{
                    controller.save(area.getText());
                }
                catch(IOException e){
                    JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void display(){
        frame.setVisible(true);
    }

    public static void main(final String... s){
        final SimpleGUI gui = new SimpleGUI();
        gui.display();
    }

}
