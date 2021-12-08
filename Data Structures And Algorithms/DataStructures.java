import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class Whiteboard {
    
    public static void HashSet()
    {
        HashSet<String> names = new HashSet<String>();
        names.add("test1");
        names.add("test2");
        Iterator<String> i = names.iterator();
        while(i.hasNext())
        {
        System.out.println(i.next());
        }
    }

    public static void HashMap()
    {
        HashMap<Integer,String> names = new HashMap<Integer,String>();
        names.put(1, "test1");
        for (Map.Entry entry : names.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        names.forEach((key, value)-> System.out.println(key + " = " + value)); 
    }

    public static void Hashtable()
    {
        Hashtable<Integer,String> names = new Hashtable<Integer,String>();
        names.put(1, "test1");
        for (Map.Entry entry : names.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        names.forEach((key, value)-> System.out.println(key + " = " + value));
    }

    public static int test()
    {
        List<Integer> countlengths = new ArrayList<Integer>();
        int currentlength = 0;
        char[] chars = s.toCharArray();
        List<Character> previouslyseencharacters = new ArrayList<Character>();
        for(int i = 0; i < chars.length;i++ )
        {
           if(previouslyseencharacters.contains(chars[i]))
           {
               previouslyseencharacters = new List();
               previouslyseencharacters.add(chars[i]);
               countlengths.add(chars[i]);
               currentlength = 0;
               continue;
           }
           currentlength = currentlength + 1;
           previouslyseencharacters.add(chars[i]);
        }
        countlengths.add(currentlength);
        int returnanswer = 0;
        for (int x = 0; x < countlengths.size(); x++)
        {
           if (previouslyseencharacters.get(x) > returnanswer)
           {
               returnanswer = previouslyseencharacters.get(x);
           }
            
        }
        return returnanswer;
    }
}
