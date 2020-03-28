package IFace;

import java.io.File;
import java.util.Properties;

final public class Statistic_class {
    private int hashcode;
    private char symbol;
    private String codeMorse;
    int counter;
    public Statistic_class(char code){
        counter = 1;
        char n_code = Character.toTitleCase(code);
        this.symbol = n_code;
        this.codeMorse = ""+ n_code;
        this.hashcode = n_code;
    }
    public Statistic_class(String code2) {
        counter = 1;
        this.codeMorse = code2;
        this.hashcode = 0;
        for (int i = 0; i < code2.length(); i++) {
            if (code2.charAt(i) == '.') {
                hashcode += pow(3, i);
            } else if (code2.charAt(i) == '-') {
                hashcode += 2 * pow(3, i);
            }
        }
    }
    public int hashCode(){
        return hashcode;
    }
    public boolean equals(Statistic_class obj){
        if(this.hashCode()==obj.hashCode()){
            obj.counter++;
            return true;
        } else{
            return false;
        }
    }
    public boolean equals(Object obj){
        if(obj.getClass() == this.getClass()){
            return equals(((Statistic_class) obj));
        } else{
            return false;
        }

    }
    char getSymbol(){
        return symbol;
    }
    String getcodeMorse(){
        return codeMorse;
    }
    int getCounter(){
        return counter;
    }
    static private int  pow(int number,int  st){
        int y =1;
        for(int i = 0;i<st;i++){
            y = y*number;
        }
        return y;
    }
}
