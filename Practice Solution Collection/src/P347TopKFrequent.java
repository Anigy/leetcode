import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class P347TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        Map<Integer, Element> map = new HashMap<>();
        for(int i : nums) {
            Element e = map.get(i);
            if(Objects.isNull(e)) {
                Element el = new Element(i);
                map.put(i, el);
            } else {
                e.add();
                map.put(i, e);
            }
        }
        for(Map.Entry<Integer, Element> entry : map.entrySet()) {
            Element e = entry.getValue();
            pq.offer(e);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k; i++) {
            result.add(pq.poll().value);
        }
        return result;
    }

    public static class Element{
        int value;
        int count;
        public Element(int val) {
            this.value = val;
            this.count = 1;
        }
        public void add(){
            this.count++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        List<Integer> re = topKFrequent(nums, 2);
        for(int i : re)
        System.out.println(i);
    }

}
