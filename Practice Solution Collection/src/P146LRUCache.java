import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class P146LRUCache extends LinkedHashMap<Integer, Integer> {

    public int capacity;

    public P146LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = null;
        if (super.containsKey(key)) {
            result = super.get(key);
            super.remove(key);
            super.put(new Integer(key), result);
        }
        return result;
    }

    public void put(int key, int value) {
        super.put(new Integer(key), new Integer(value));
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> var1) {
        return super.size() >= this.capacity;
    }
}
