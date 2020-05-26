package mlunax;

import javax.swing.*;

public class Frame {
    JFrame frame;
    public Frame(){
        frame = new JFrame();
        frame.add(new Panel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean vis){
        frame.setVisible(vis);
    }
}
