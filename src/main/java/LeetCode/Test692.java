package LeetCode;

import java.util.*;

public class Test692 {
    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "is"};
        List<String> list = topKFrequent2(words, 4);
        System.out.println(11111);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words);
        for (String word : words) {
            if (!deque.isEmpty() && deque.peekLast().equals(word)) {
                int count = map.getOrDefault(word, 1);
                count = count + 1;
                map.put(word, count);
                continue;
            }
            deque.offerLast(word);
        }

        while (result.size() < k) {
            int max = 0;
            for (Integer value : map.values()) {
                if (value >= max) {
                    max = value;
                }
            }

            Set<String> keys = map.keySet();
            List<String> temp = new ArrayList<>();
            for (String key : keys) {
                Integer value = map.get(key);
                if (value == max) {
                    temp.add(key);
                }
            }
            Collections.sort(temp);
            for (String word : temp) {
                if (result.size() < k) {
                    result.add(word);
                }
            }
            for (String word : temp) {
                map.remove(word);
            }

            if (map.size() == 0) {
                while (result.size() < k) {
                    if (result.contains(deque.peek())) {
                        deque.poll();
                    } else {
                        result.add(deque.poll());
                    }
                }
            }
        }
        return result;
    }

    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0)+1);
        }
        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (cnt.get(o1) == cnt.get(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return cnt.get(o2).compareTo(cnt.get(o1));
                }
            }
        });
        return rec.subList(0,k);
    }
}
