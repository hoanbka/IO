package merge.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMerger2 {

    public static void mergeFiles(List<File> files, File result) throws IOException {

        for (File file : files) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024 * 1024];
            while (bis.read(buffer) > 0) {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(result,true));
                bos.write(buffer);
            }
        }

    }

    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 000"));
        files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 001"));
        files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 002"));
        files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 003"));
        // File result = new File("D:\\Music\\Viet Nam\\SpecialMusic\\mergingFile.mp3");
        File result = new File("mergingFile.mp3");
        try {
            mergeFiles(files, result);
            System.out.println("Merge files successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

