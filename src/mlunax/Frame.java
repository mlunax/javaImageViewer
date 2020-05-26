package mlunax;

import javax.swing.*;

public class Frame extends JFrame{
    public Frame(){
        add(new Panel());
        pack();
        setLocationRelativeTo(null);
        //set exit program when exit this frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
