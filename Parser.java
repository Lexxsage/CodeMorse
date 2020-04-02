package Parser;

import java.util.Scanner;

final public class Parser {
    static private String com;
    static private String file_name;

    public static void toParse(){
        Scanner infile  = new Scanner(System.in);
        String str = infile.nextLine();
        String part_of_line[] = new String [2];
        part_of_line= str.split(  " ", 2);
        com = (part_of_line.equals("1")|| part_of_line.equals("0")) ? "Don't know" :part_of_line[0];
        file_name = part_of_line[1];
    }
    public static String get_Com(){
        return com;
    }
    public static String getFile_name(){
        return file_name;
    }
}