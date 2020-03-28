package IFace;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;

final public class to_char implements DoText{///com1

    @Override
    public void ShDsh(String file_name1) throws IOException {
        File write_file = new File("result.txt");
        if (write_file.exists()) {
            //System.out.println("It exist. Change?");
            // Scanner fast_scan = new Scanner(System.in)
            write_file.delete();
        }
        write_file.createNewFile();
        PrintWriter writer = new PrintWriter(write_file);
        Scanner input = new Scanner(new File(file_name1));
        StringBuilder str = new StringBuilder("");//get and sh symbols
        StringBuilder str_for_write = new StringBuilder(); //save str which will go to file
        FileInputStream in = new FileInputStream("Char-Morze.txt");//for properties
        Properties properties = new Properties();
        properties.load(in);
        StringBuilder my_key_string = new StringBuilder("");
        HashSet<Statistic_class> HS = new HashSet<Statistic_class>();
        while(input.hasNextLine()){
            str.replace(0,str.length(), input.nextLine());
            str_for_write.delete(0,str_for_write.length());
            my_key_string.delete(0,my_key_string.length());
            for(int i=0;i<str.length();i++){
                my_key_string.append(str.charAt(i));
                if(str.charAt(i)==')'){
                    str_for_write.append(properties.get(my_key_string.toString()));
                    HS.add(new Statistic_class(my_key_string.toString()));
                    //   System.out.println(properties.getProperty(my_key_string.toString()).charAt(0));
                    my_key_string.delete(0,my_key_string.length());
                    //System.out.print(1);
                }
                else if(str.charAt(i)==' '){
                    str_for_write.append(my_key_string);
                    HS.add(new Statistic_class(' '));

                    my_key_string.delete(0,my_key_string.length());
                    // System.out.print(0);
                }
            }
            // System.out.println();
            writer.println(str_for_write);
        }
        int index_of_arr = 0;
        for(Statistic_class tmp:HS){
            index_of_arr++;
            System.out.println(index_of_arr + ") " + tmp.getcodeMorse() + "=" + properties.getProperty(tmp.getcodeMorse()) +"---- " + tmp.getCounter());
        }
        in.close();
        writer.close();
    }
}
