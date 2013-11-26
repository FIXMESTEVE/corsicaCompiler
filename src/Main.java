import java.io.FileReader;
import java_cup.runtime.Symbol;

public class Main {

        /**
         * @param args
         */
        public static void main(String[] args) {
                try {
                        FileReader  myFile = new FileReader(args[0]);
                        CalculetteLexer myLex = new CalculetteLexer(myFile);
                        CalculetteParser myParser = new CalculetteParser(myLex);
                        try {
                                Symbol result=myParser.parse();
                        }
                        catch (Exception e) {
                                System.out.println("parse error");
                        }
                }
                catch (Exception e){
                        System.out.println("invalid file");
                }
        }
}
