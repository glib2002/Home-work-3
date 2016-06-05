/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkworddetecter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Глеб
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static FileOutputStream fos;
    public static File fileDownload;
    public static int read;
    public static String name;

    public static void main(String[] args) throws IOException {
        write();

    }

    private static void write() throws FileNotFoundException, IOException {
        while (true) {
            Scanner scn = new Scanner(System.in);
            name = scn.nextLine();
            fos = new FileOutputStream("c:\\Users\\Глеб\\Documents\\NetBeansProjects\\HomeWorkWordDetecter\\src\\folder\\file.txt");
            byte[] bytes = name.getBytes();

            fos.write(bytes);
            fos.write('\n'); // write (int)
            fos.close();
            detect(name);
            if (name.equals("end")) {
                break;
            }
        }
    }

    private static void detect(String number) {

        Pattern pattern = Pattern.compile("\\+?(?<country>\\d{3})\\s*\\(?(?<oper>\\d{2})\\)?\\s*(?<number>\\d{3}(\\-?\\d{2}){2})");

        Matcher matcher = pattern.matcher(number);

        while (matcher.find()) {
            String group = matcher.group();
            String country = matcher.group("country");
            String operator = matcher.group("oper");
            String personalNumber = matcher.group("number");

            System.out.println(group);
            System.out.println("Country: " + country);
            System.out.println("Operator: " + operator);
            System.out.println("Number: " + personalNumber);
        }

    }

}
