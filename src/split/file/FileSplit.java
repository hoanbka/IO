package split.file;


import java.io.*;

class FileSplit {

    public static void splitFile(File f) throws IOException {

        int part = 0;
        int sizeOfFile = 1024 * 1024;
        byte[] buffer = new byte[sizeOfFile];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(f));
        int tmp = 0;
        while ((tmp = bufferedInputStream.read(buffer)) > 0) {
            File newFile = new File(f.getParent(), f.getName() + " . " + String.format("%03d", part++));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newFile));
            bufferedOutputStream.write(buffer);
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {

        try {
            splitFile(new File("D:\\Music\\Viet Nam\\Chi la giac mo - Vu Cat Tuong.mp3"));
            System.out.println("Split file successfully");
        } catch (FileNotFoundException ex) {
            System.out.println("No such file");
        }

    }
}