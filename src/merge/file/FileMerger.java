package merge.file;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileMerger {

    public static void mergeFiles(List<File> files, File result)
            throws IOException {
        BufferedOutputStream mergingStream = new BufferedOutputStream(
                new FileOutputStream(result));
        for (File f : files) {
            Files.copy(f.toPath(), mergingStream);
        }

    }

    public static void main(String[] args) throws IOException {
        List<File> files = new ArrayList<>();

        try {
            files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 000"));
            files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 001"));
            files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 002"));
            files.add(new File("D:\\Music\\Viet Nam\\SpecialMusic\\Chi la giac mo - Vu Cat Tuong.mp3 . 003"));
            File result = new File("D:\\Music\\Viet Nam\\SpecialMusic\\mergingFile.mp3");

            mergeFiles(files, result);
            System.out.println("Merge files successfully");
        } catch (IOException ex) {
            System.out.println("No such file");
        }


    }
}
