package mlunax;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FullScreenViewer extends JFrame {
    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public FullScreenViewer(ImageIcon ii){
        Image resizedImage = ((ii.getImage()).getScaledInstance(device.getDisplayModes()[1].getWidth(),
                device.getDisplayModes()[1].getHeight(), java.awt.Image.SCALE_SMOOTH));
        ii.setImage(resizedImage);
        JLabel label = new JLabel(ii);
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(label)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(label)
        );

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        pack();
        device.setFullScreenWindow(this);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){
                    killFullScreen();
                }
            }
        });
    }

    public void killFullScreen(){
        device.setFullScreenWindow(null);
        dispose();
    }
}
