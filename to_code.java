package IFace;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

final public class to_code implements DoText{

    public void ShDsh(String file_name1) throws IOException {
        File write_file = new File("result.txt"); // запись результата
        if (write_file.exists()){
            //System.out.println("Exist,change?");
            //Scanner fast_scan = new Scanner(System.in);
            write_file.delete();//delete old file
        }
        write_file.createNewFile();
        PrintWriter writer = new PrintWriter(write_file);//class to write in new file
        Scanner input = new Scanner(new File(file_name1));
        StringBuilder str = new StringBuilder();// string ro get and sh symbols
        StringBuilder str_for_write = new StringBuilder(); // save str which will go to file
        FileInputStream in = new FileInputStream("Char-Morze.txt");//for properties
        Properties properties = new Properties();
        properties.load(in);

        HashSet<Statistic_class> HS = new HashSet<Statistic_class>();

        while (input.hasNextLine()) {
            str_for_write.delete(0, str_for_write.length());//clear past str
            str.replace(0, str.length(), input.nextLine());//change str for next
            StringBuilder my_key = new StringBuilder("");
            for (int k = 0; k < str.length(); k++) {
                my_key.delete(0, my_key.length());
                my_key.append(str.charAt(k));
                HS.add(new Statistic_class(str.charAt(k)));
                if (my_key.toString().equals(" ")) {// help for " "
                    str_for_write.append(" ");
                    my_key.append(str.charAt(k));
                    //System.out.print("0");
                } else if (properties.containsKey(my_key.toString())) {
                    str_for_write.append(properties.getProperty(my_key.toString()));
                    //System.out.print("1"); // change sey symbol
                }
            }
            writer.println(str_for_write);
            //System.out.println(str);
        }

        int index_of_arr = 0;
        for (Statistic_class tmp:HS) {
            index_of_arr++;
            System.out.println(index_of_arr + ")" + tmp.getSymbol()+"=" + properties.getProperty(""+tmp.getSymbol()) + "---- " + tmp.getCounter());
        }

        in.close();
        writer.close();
    }
}
