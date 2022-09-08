package NewCode;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 题目描述:编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
   输入描述:输入N个字符，字符在ACSII码范围内。
   输出描述:输出范围在(0~127)字符的个数。

   输入：abc   输出：3
 */
public class Test10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> treeSet = new TreeSet<>();
        while(scanner.hasNext()){
            String str = scanner.next();
            for(int i = 0; i <= str.length()-1; i++){
                treeSet.add(str.substring(i,i+1));
            }
            System.out.println(treeSet.size());
        }
    }
}
