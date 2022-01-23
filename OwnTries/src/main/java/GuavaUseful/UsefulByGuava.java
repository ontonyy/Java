package GuavaUseful;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.*;

import java.util.HashSet;

public class UsefulByGuava {
    public static void main(String[] args){
        ImmutableList<String> list = ImmutableList.of("makasin", "arbuz", "zasha");
        ImmutableMap<Integer, String> map = ImmutableMap.of(1, "shest", 2, "three", 15, "ten");
        System.out.println(list + "\n" + map);
        System.out.println(Strings.commonSuffix("kukuruza", "babaruka"));
        System.out.println(Strings.padEnd("kukuritsa", 20, '_'));
        System.out.println(Strings.repeat("WTF ", 20));

        ImmutableList.of("John", "Whick", "Anton", "A").stream().
                map(name -> Strings.padStart(name, 15, '_')).forEach(System.out::println);
        System.out.println(Joiner.on("arividerchi").join(
                Splitter.on("text").split("here text is, mamin text, ladno text")));

        HashSet<Integer> nums = Sets.newHashSet(1, 2, 3, 4);
        HashSet<Integer> nums2 = Sets.newHashSet(3, 4, 5, 6);
        System.out.println(Sets.difference(nums, nums2));
        System.out.println(Sets.difference(nums2, nums));
        System.out.println(Sets.intersection(nums2, nums));

        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("kaka");
        multiset.add("sibul", 3);
        multiset.add("kaka");
        multiset.add("durak");
        System.out.println(multiset);

        HashMultimap<String, String> multimap = HashMultimap.create();
        multimap.put("murka", "durka");
        multimap.putAll("books", Lists.newArrayList("book1", "book2"));
        System.out.println(multimap);

        HashBiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("kaka", 3);
        biMap.put("uff", 4);
        biMap.put("graz", 1);
        System.out.println(biMap + "\n" + biMap.inverse());

        HashBasedTable<String, String, Double> table = HashBasedTable.create();
        table.put("Maria", "19-05-2016", 200.0);
        table.put("Andrei", "11-07-2012", 2350.0);
        table.put("Sasha", "19-05-2016", 350.0);
        table.put("Andrei", "30-12-2021", 10.0);
        table.put("Andrei", "19-05-2016", 2002.0);
        table.put("Gera", "19-08-2015", 205.0);
        table.put("Vadim", "20-01-2018", 275.0);
        System.out.println(table);
        System.out.println(table.get("Maria", "19-05-2016"));
        System.out.println(table.column("19-05-2016"));
        System.out.println(table.row("Andrei"));

    }
}
