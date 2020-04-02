package IFace;

import java.io.File;
import java.util.Properties;

final public class StatisticsClass {
    private int hashcode;
    private char symbol;
    private String codeMorse;
    int howmuch;
    public StatisticsClass(char code){
        howmuch = 1;
        char ncode = Character.toTitleCase(code);
        this.symbol = ncode;
        this.codeMorse = ""+ ncode;
        this.hashcode = ncode;
    }
    public StatisticsClass(String codeMorse){
        howmuch = 1;
        this.codeMorse = codeMorse;
        this.hashcode = 0;
        for (int i = 0; i < codeMorse.length();i++) {
            if (codeMorse.charAt(i) == '.') {
                hashcode += pow(3, i);
            } else if (codeMorse.charAt(i) == '-') {
                hashcode += 2 * pow(3, i);
            }
        }
    }
    public int HashCode(){
        return hashcode;
    }
    public boolean equals(StatisticsClass obj){
        if(this.HashCode()==obj.HashCode()){
            obj.howmuch++;
            return true;
        } else {
            return false;
        }
    }
    public boolean equals(Object obj){
        if(obj.getClass()==this.getClass()){
            return equals(((StatisticsClass) obj));
        }else {
            return false;
        }
    }
    char get_Symbol(){
        return symbol;
    }
    String get_CodeMorse(){
        return codeMorse;
    }
    int get_Howmuch(){
        return howmuch;
    }
    static private int pow(int number,int st){
        int k = 1;
        for(int i = 0;i < st;i++){
            k=k*number;
        }
        return k;
    }
}
