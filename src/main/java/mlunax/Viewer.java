package mlunax;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Viewer extends JFrame {
    FullScreenViewer fsv;
    public Viewer(String path){
        if (path == null) return;

        ImageIcon ii = new ImageIcon(path);
        ImageIcon iiOriginal = ii;
        JLabel label = new JLabel(ii);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        if(ii.getIconHeight() > screenSize.height || ii.getIconWidth() > screenSize.width){
            Image resizedImage = ((ii.getImage()).getScaledInstance(ii.getIconHeight(), screenSize.height, java.awt.Image.SCALE_SMOOTH));
            ii.setImage(resizedImage);
        }

        //create place for label
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

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){
                    toggleFullscreen(iiOriginal);
                }
            }
        });

//        setPreferredSize(new Dimension(screenSize.width, screenSize.width));
        setTitle(path);
        setLocationRelativeTo(null);
        pack();
    }

    void toggleFullscreen(ImageIcon ii){
        fsv = new FullScreenViewer(ii);
        fsv.setVisible(true);
    }

}
