package decryptFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodeFile {


    public static void decodeFile(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        List<Byte> list = new ArrayList<>();
        byte[] bytes = new byte[1024];

        while (bufferedInputStream.read(bytes) > 0) {
            for (byte b : bytes
                    ) {
                if (b != 0) {
                    System.out.print((char) (byte) (b - 5));
                    list.add((byte) (b - 5));
                }
            }
        }
        bufferedInputStream.close();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\NguyenDinhLong\\IdeaProjects\\EncodingTextFile\\TextFile.txt_encrypted2.txt");
        try {
            decodeFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
