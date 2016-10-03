package myclass.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Радочка on 03.10.2016.
 */
public class Collections {

    public static void main (String [] args){
        String[] langs = {"Java", "C#", "Python", "PhP"};
       // langs[0] = "Java";
        // langs[1] = "C#";
       // langs[2] = "Python";
       // langs[3] = "PHP";

      //  List<String> languages = new ArrayList<String>();
        List<String> languages = Arrays.asList("Java", "C#", "Python", "PhP");
      /*  languages.add("Java");
        languages.add("Python");
        languages.add("C#");
      */

      /*  вспомогательная переменная для массива
      for(int i = 0; i< langs.length; i++){
            System.out.println("Я хочу выучить " + langs[i]);
        } */
      /*  вспомогательная переменная для списка
      for(int i = 0; i< languages.size(); i++){
            System.out.println("Я хочу выучить " + languages.get(i);
        } */

      for (String l : languages) {
          System.out.println("Я хочу выучить " + l);
      }
    }
}
