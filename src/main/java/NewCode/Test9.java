package NewCode;

import java.util.Scanner;

/**
 * 题目描述:输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
   输入描述:输入一个int型整数
   输出描述:按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

   示例1 输入:9876673   输出:37689
 */
public class Test9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            String a = str.substring(str.length()-1);
            for(int i = str.length()-2; i>= 0; i--){
                if(!a.contains(str.substring(i, i+1)))
                    a += str.substring(i, i+1);
            }
            System.out.println(a);
        }
    }
}

