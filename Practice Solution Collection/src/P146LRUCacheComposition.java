import java.util.LinkedHashMap;
import java.util.Map;

public class P146LRUCacheComposition {

    public int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public P146LRUCacheComposition(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>((int)Math.round(capacity / 0.75) + 1, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> var1) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}
