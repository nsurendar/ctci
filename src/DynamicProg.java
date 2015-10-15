import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Surendar on 10/14/2015.
 */
public class DynamicProg {
    static Map<String,String> map;
    static void permutation(String prefix,String value,int index,ArrayList<String> strs)

    {
        if(prefix.length()==value.length())
        {
            strs.add(prefix);
            System.out.println(prefix);
            return;
        }

        String c = ""+value.charAt(index);

        for (int i = 0; i < map.get(c).length(); i++) {
            String ss = "" + map.get(c).charAt(i);
            permutation(prefix + ss, value, index + 1, strs);
        }

    }

    static void per()
    {
        map  = new LinkedHashMap<String,String>();
        map.put("1","");
        map.put(
                "2","ABC");
        map.put("3","DEF");
        map.put("4","GHI");
        map.put("5","JKL");
        map.put("6","MNO");
        map.put("7","PQRS");
        map.put("8", "TUV");
        map.put("9", "WXYZ");
        map.put("0", " ");


        ArrayList<String> strs = new ArrayList<String>();
        permutation("","23451258963147435487589".replace("1",""),0,strs);
//        long count=0;
//        for(String s:strs)
//        {
//            count++;
//            System.out.println(s);
//        }
//        System.out.println(count);
    }
}
