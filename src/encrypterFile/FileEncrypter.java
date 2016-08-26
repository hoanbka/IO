package encrypterFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileEncrypter {

    public static void encodeTextFile(File file) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        List<Byte> bytes = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            for (byte b : line.getBytes()
                    ) {
                bytes.add((byte) (b + 5));
                System.out.println((byte) (b + 5));
            }

        }
        bufferedReader.close();
        File newFile = new File(file.getParent(), file.getName() + "_encrypted2.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newFile));

        for (byte b : bytes
                ) {
            bufferedOutputStream.write(b);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\NguyenDinhLong\\IdeaProjects\\EncodingTextFile\\TextFile.txt");
            encodeTextFile(file);
            System.out.println("A file has been encrypted successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
