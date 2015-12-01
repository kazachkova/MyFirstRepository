import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String DIR_PATH = "D:\\";
    private static final String NAME_TXT = "new_txt_file";
    private static final String TEXT = "bla-bla-bla\n";
    private static final String TEXT_TO_ADD = "this file updated\n";

    public static void main(String[] args) throws IOException {
        File file = new File(DIR_PATH);
        if (file.isDirectory()) {
            String[] fileList = getFileList(file);
            createFile(DIR_PATH+NAME_TXT+".txt", TEXT);
            updateFile(DIR_PATH + NAME_TXT + ".txt", TEXT_TO_ADD);
            deleteFile(DIR_PATH+NAME_TXT+".txt");
        } else {
            System.out.println(DIR_PATH + " is not a directory");
        }
    }

    private static void createFile(String path, String text) {
        try {
            try(FileWriter createdFile = new FileWriter(path)) {
                createdFile.write(text);
                System.out.println("File created\nPath: "+path+"\nText: "+text);
            }
        } catch (IOException e) {
            System.out.println("Error"+e.getMessage()+"\n"+"Try to create file again");
        }
    }
    private static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
        System.out.println("File deleted\nPath: " + path);
    }
    private static void updateFile(String path, String textToUpdate) {
        try {
            try (FileWriter file = new FileWriter(path, true)) {
                file.write(textToUpdate);
            }
            System.out.println("File updated\nPath: "+path+"\nText: "+textToUpdate);
        } catch (IOException e) {
            System.out.println("Error"+e.getMessage()+"\nTry to update file again");
        }
    }

    public static String[] getFileList(File file) {
        String[] fileList = file.list();
        System.out.println("This directory contains files:");
        for (String i : fileList) {
            System.out.println(i);
        }
        System.out.println();
        return fileList;
    }
}
