package ua.com.alevel.slide14;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slide14 {
    public static void main(String[] args) {
        File project = new File("C:\\Users\\Admin\\Desktop\\A-level\\ДЗ\\homework.18\\src");
        String prefix = "  ";

        List<File> files = createSortedFileList(project);

        explore(files, prefix);
    }

    private static List<File> createSortedFileList(File file) {
        List<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
        files.sort(new FileComparator());

        return files;
    }

   /* private static void explore(List<File> files, String prefix) {
        for (File item : files) {
            if (item.isFile()) {
                System.out.println(prefix + item.getName());
            } else {
                System.out.println(prefix + "*" + item.getName());
                explore(createSortedFileList(item), prefix + "  ");
            }
        }
    }*/

    private static void explore(List<File> files, String prefix){
        for (int index = 0; index < files.size(); index++) {
            if (files.get(index).isFile()) {
                System.out.println(prefix + files.get(index).getName());
            } else {
                System.out.println( "*" + files.get(index).getName());
                files.addAll(createSortedFileList(files.get(index)));
            }
        }
    }
}
