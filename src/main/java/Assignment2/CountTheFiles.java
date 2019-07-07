package Assignment2;

import java.io.File;
import java.util.Scanner;

public class CountTheFiles {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Drive Letter: ");
        String drive = scanner.nextLine().substring(0,1) + ":\\\\";

        System.out.println("Number of Files in the Drive " + drive + " " + countFiles(drive));
    }

    private static int countFiles(String drive) {
        File file = new File(drive);
        if(file.listFiles() == null) return 0;
        int files = 0;
        for (int i = 0; i < file.listFiles().length; i++) {
            if(file.listFiles()[i].isFile()) files++;
            else if(file.listFiles()[i].isDirectory()) files += countFiles(file.listFiles()[i].toString());
        }
        return files;
    }
}
