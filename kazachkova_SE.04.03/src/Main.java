import java.io.*;

public class Main {

    private static final String PATH_IN = "D:\\new_utf8.txt";
    private static final String PATH_OUT = "D:\\new_utf16.txt";


    public static void main(String[] args) throws IOException {

        StringBuilder sbContent = new StringBuilder("");
        try(FileInputStream inFile = new FileInputStream(PATH_IN)) {
            InputStreamReader in = new InputStreamReader(inFile, "UTF-8");
            int content;
            while ((content = in.read()) != -1) {
                sbContent.append((char) content);
            }
        }

        try(FileOutputStream outFile = new FileOutputStream(PATH_OUT)) {
            outFile.write(sbContent.toString().getBytes("UTF-16"));
        }
    }
}
