package mlunax;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class FilePicker extends JPanel {
    JFileChooser jfc;
    public FilePicker(){
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select an image");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG, GIF, BMP, JPG images", "png", "gif", "jpg", "bmp");
        jfc.addChoosableFileFilter(filter);
    }

    public File openDialogGetFile(){
        File file = null;
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file= jfc.getSelectedFile();
        }
        return file;
    }

    public String openDialogGetPath(){
        String path = null;
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            path = selectedFile.getAbsolutePath();
        }
        return path;
    }
}
