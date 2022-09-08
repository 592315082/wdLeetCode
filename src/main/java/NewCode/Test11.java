package NewCode;

import java.util.Scanner;

/**
 * 题目描述:写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
   输入描述:输入N个字符
   输出描述:输出该字符串反转后的字符串

   输入:abcd    输出:dcba
 */
public class Test11 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String a = "";
        for(int i = str.length()-1; i >= 0;i--){
            a = a + str.substring(i,i+1);
        }
        System.out.println(a);
    }
}
