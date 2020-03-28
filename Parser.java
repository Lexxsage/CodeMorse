package Parser;

import java.util.Scanner;

public class Parser {
    static private String command;
    static private String file_name;

    public static void Parse(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String part_of_line[] = new String[2];
        part_of_line = str.split(" ", 2);
     //   if(part_of_line[0].equals("0")||part_of_line[0].equals("1")){
//            command = part_of_line[0];
//        } else{
//            command = "Неопознанная команда"; }
        //command = (part_of_line.equals("1"))||part_of_line.equals("0")) ? "Don't know command":part_of_line[0];
        file_name = part_of_line[1];
    }

    public static String get_command(){
        return command;
    }

    public static String get_filename(){
        return file_name;
    }
}
