package mlunax;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Panel extends JPanel {
    public Panel(){
        //set borders of Panel
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //put all objects one above the other
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        add(new JLabel("<html><h1> Image Viewer </h1><br></html>"),gbc);

        //create  buttons panel
        JPanel buttons = new JPanel(new GridBagLayout());
        //create button
        JButton b = new JButton("Choose the image to view.");
        //create open filepicker
        b.addActionListener(actionEvent -> {
            FilePicker fp = new FilePicker();
            String path = fp.openDialogGetPath();
            Viewer viewer = new Viewer(path);
            viewer.setVisible(true);
        });
        //add button to panel
        buttons.add(b, gbc);

        gbc.weighty = 1;
        add(buttons, gbc);
    }
}
