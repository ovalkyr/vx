package vx;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class ImageFileFilter extends FileFilter {
    String[] acceptExtendsions = { "jpg", "jpeg", "gif", "png" };

    public String getDescription() {
        return "QR Code Image files (*.jpg,*.png,*.gif,*.png)";
    }

    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        String extension = getExtension(f);
        if (extension == null)
            return true;
        for (int i = 0; i < acceptExtendsions.length; i++) {
            if (extension.equals(acceptExtendsions[i]))
                return true;
        }
        return false;

    }

    String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
}
