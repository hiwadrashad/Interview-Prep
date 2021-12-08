import java.util.HashSet;
import java.util.Iterator;
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
}
