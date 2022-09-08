package NewCode;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 题目描述:数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
   输入描述:先输入键值对的个数,然后输入成对的index和value值，以空格隔开
   输出描述:输出合并后的键值对（多行）

  输入:         输出：
     4          0 3
     0 1        1 2
     0 2        3 4
     1 2
     3 4
 */
public class Test8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        while(i > 0){
            Integer keyIn = scanner.nextInt();
            if(treeMap.containsKey(keyIn)){
                treeMap.put(keyIn,scanner.nextInt() + treeMap.get(keyIn));
            }else{
                treeMap.put(keyIn, scanner.nextInt());
            }
            i--;
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> en = iterator.next();
            Integer key = en.getKey();
            Integer value = en.getValue();
            System.out.println(key+" "+value);
        }
    }
}
