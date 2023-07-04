
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ConcurrencyMapRunner {
    public static void main(String[] args) {
        String str = "ABCD ABCD  ABCD";
        byHashTable(str);
        byConcurrentHashMap(str);
     }

     private static void byHashTable(String str)
     {
         Map<Character, LongAdder> occurances = new Hashtable<>();

         for(char character: str.toCharArray())
         {
             LongAdder longAdder = occurances.get(character);
             if(longAdder == null) {
                 longAdder = new LongAdder();
             }
             longAdder.increment();
             occurances.put(character, longAdder);
         }
         System.out.println(occurances);
     }

    private static void byConcurrentHashMap(String str)
    {
        ConcurrentHashMap<Character, LongAdder> occurances = new ConcurrentHashMap<>();

        for(char character: str.toCharArray())
        {
            occurances.computeIfAbsent(character, ch->new LongAdder()).increment();
        }

        System.out.println(occurances);
    }
}