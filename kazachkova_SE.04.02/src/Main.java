import java.io.*;

public class Main {
    private static final String PATH_IN = "D:\\test.java";
    private static final String PATH_OUT = "D:\\test.txt";

    public static void main(String[] args) throws IOException {
        StringBuilder result = getWords(PATH_IN);
        writeWords(result, PATH_OUT);
    }

    private static void writeWords(StringBuilder result, String fileName) throws IOException {
        try(FileWriter outFile = new FileWriter(fileName)) {
            outFile.write(result.toString());
        }
    }

    private static StringBuilder getWords(String fileName) {
        String[]  keywords = {"abstract", "continue", "for", "new", "switch", "assert", "default", "package",
                "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected",
                "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return",
                "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void",
                "class", "finally", "long", "strictfp", "volatile", "float", "native", "super", "while"};
        StringBuilder result = new StringBuilder("");
        try (FileReader inFile = new FileReader(fileName)) {
            BufferedReader br = new BufferedReader(inFile);
            StringBuilder sbContent = new StringBuilder("");
            String content;
            while ((content = br.readLine()) != null) {
                sbContent.append(content);
            }
            String[] contentArray = sbContent.toString().split("[\\s,.\n(]+");
            int count = 0;
            for (String i : contentArray) {
                for (String j : keywords) {
                    if (i.equals(j)) {
                        result.append(i+" ");
                        count++;
                    }
                }
            }
            result.append("count = " + count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
