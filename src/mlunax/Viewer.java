package mlunax;

import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    public Viewer(String path){
        ImageIcon ii = new ImageIcon(path);
        JLabel label = new JLabel(ii);

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(label)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(label)
        );
        pack();

        setTitle(path);
        setLocationRelativeTo(null);
    }
}
