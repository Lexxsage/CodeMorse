package com.company;

import IFace.DoText;
import IFace.ToCode;
import IFace.ToText;
import Parser.Parser;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException{
        Parser.toParse();
        HashMap<String, DoText> STV =  new HashMap<String, DoText>();
        ToText Dsh = new ToText();
        ToCode Sh = new ToCode();
        STV.put("totext", Dsh);
        STV.put("tocode", Sh);
        STV.get(Parser.get_Com()).ShDsh(Parser.getFile_name());
    }
}

