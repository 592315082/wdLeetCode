package LeetCode;

import java.util.*;

public class Test2 {
    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name", "lxj");
        map.put("age", "24");
        map.put("sex", "女");
        String name = map.getOrDefault("name", "test");
        System.out.println(name);// lxj，map中存在name,获得name对应的value
        String address = map.getOrDefault("address", "北京");
        System.out.println(address);// 北京，map中不存在address,使用默认值“北京”

        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"ZhangSan");
        map1.put(2,"LiSi");
        map1.putIfAbsent(1,"WangWu");
        map1.forEach((key,value) ->{
            System.out.println("key : " + key + " , value : " + value);
        });

        List<List<Integer>> nums = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        nums.add(list1);

        List<Integer> list2 = new LinkedList<>();
        list2.add(4);
        nums.add(list2);

        List<Integer> list3 = new LinkedList<>();
        list3.add(5);
        list3.add(6);
        list3.add(7);
        nums.add(list3);

        List<Integer> list4 = new LinkedList<>();
        list4.add(8);
        nums.add(list4);

        List<Integer> list5 = new LinkedList<>();
        list5.add(9);
        list5.add(10);
        list5.add(11);
        nums.add(list5);

        Solution2 solution2 = new Solution2();
        int[] result = solution2.findDiagonalOrder(nums);
        System.out.println(result);

    }
}

class Solution2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int length = 0;
        //根据对角线i+j唯一且相同，LinkedHashMap保持插入排序。效率是最优的
        Map<Integer,List<Integer>> map =new LinkedHashMap<>();
        for(int i = 0;i < nums.size();i++) {
            length += nums.get(i).size();
            for(int j = 0;j < nums.get(i).size();j++) {
                List<Integer> orDefault = map.getOrDefault(i + j, new ArrayList<>());
                orDefault.add(nums.get(i).get(j));
                map.put(i+j,orDefault);
            }
        }
        int[] result = new int[length];
        int index = 0;
        //遍历map，得到结果。
        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(int j = list.size() - 1;j >= 0;j--) {
                result[index] = list.get(j);
                index++;
            }
        }
        return result;
    }
}
