import IFace.DoText;
import IFace.to_code;
import IFace.to_char;
import Parser.Parser;

import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        Parser.Parse();
        HashMap<String, DoText> Stv = new HashMap<String, DoText>();
        to_char DSh = new to_char();
        to_code Sh = new to_code();
        Stv.put("1", DSh);
        Stv.put("0", Sh);
        Stv.get(Parser.get_command()).ShDsh(Parser.get_filename());
        System.out.println(System.currentTimeMillis() - time);
    }
}
