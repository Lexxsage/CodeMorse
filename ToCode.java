package IFace;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;
import java.util.HashSet;

final public class ToCode implements DoText {
    public void ShDsh(String file_name1) throws IOException {
        File write_file = new File("donecode.txt");
        if (write_file.exists()){
            write_file.delete();
        }
        write_file.createNewFile();
        PrintWriter writer = new PrintWriter(write_file);//class to write in file
        Scanner infile = new Scanner(new File(file_name1));
        StringBuilder str = new StringBuilder();//get and sh symbols
        StringBuilder str_to_write = new StringBuilder();//have str to file
        FileInputStream in = new FileInputStream("Text_Morse.txt");
        Properties properties = new Properties();
        properties.load(in);
        HashSet<StatisticsClass> HS = new HashSet<StatisticsClass>();
        while (infile.hasNextLine()){
            str_to_write.delete(0, str_to_write.length());//clean past line
            str.replace(0,str.length(), infile.nextLine());//change str for reading next str
            StringBuilder key = new StringBuilder("");
            for (int i = 0; i < str.length();i++){
                key.delete(0, key.length());
                key.append(str.charAt(i));
                if (key.toString().equals(" ")){// for space
                    str_to_write.append(" ");
                    key.append((str.charAt(i)));
                } else if (properties.containsKey(key.toString())){
                    str_to_write.append((properties.getProperty(key.toString())));
                    //change key symbol for code Morse and + in str for write
                }
            }
            writer.println(str_to_write);
        }
        int index_of_arr = 0;
        for(StatisticsClass tmp:HS){
            index_of_arr++;
            System.out.println(index_of_arr + ") " + tmp.get_Symbol()+"=" + properties.getProperty(""+tmp.get_Symbol()) +"---- " + tmp.get_Howmuch());
        }
        in.close();
        writer.close();
    }
}