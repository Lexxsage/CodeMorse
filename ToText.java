package IFace;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;

final public class ToText implements DoText{//com 1
    public void ShDsh(String file_name1) throws IOException {
        File write_file = new File("donetext.txt");
        if (write_file.exists()) {
            write_file.delete();
        }
        write_file.createNewFile();
        PrintWriter writer = new PrintWriter(write_file);
        Scanner infile = new Scanner(new File(file_name1));
        StringBuilder str = new StringBuilder("");//get and sh symbols
        StringBuilder str_to_write = new StringBuilder();//have str to go to file
        FileInputStream in = new FileInputStream("Text_Morse.txt");// for properties
        Properties properties = new Properties();
        properties.load(in);
        StringBuilder key_str = new StringBuilder("");
        HashSet<StatisticsClass> HS = new HashSet<StatisticsClass>();
        while (infile.hasNextLine()){
            str.replace(0,str.length(),infile.nextLine());
            str_to_write.delete(0, str_to_write.length());
            key_str.delete(0,key_str.length());
            for (int i=0; i<str.length();i++){
                key_str.append(str.charAt(i));
                if(str.charAt(i)==')'){
                    str_to_write.append(properties.get(key_str.toString()));
                    HS.add(new StatisticsClass(key_str.toString()));
                    key_str.delete(0, key_str.length());
                } else if(str.charAt(i)==' ') {
                    str_to_write.append(key_str);
                    HS.add(new StatisticsClass(' '));
                    key_str.delete(0,key_str.length());
                }
            }
            writer.println(str_to_write);
        }
        int index_of_arr = 0;
        for(StatisticsClass tmp:HS){
            index_of_arr++;
            System.out.println(index_of_arr + ")" + tmp.get_CodeMorse() + "=" +properties.getProperty(tmp.get_CodeMorse()) + "---- " + tmp.get_Howmuch());
        }
        in.close();
        writer.close();
    }
}
