package NewCode;

import java.util.Scanner;

/**
 * 题目描述
 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

 输入描述:连续输入字符串(输入2次,每个字符串长度小于100)
 输出描述:输出到长度为8的新字符串数组

 输入:
 abc
 123456789
 输出:
 abc00000
 12345678
 90000000
 */
public class Test4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String a = scanner.next();
            dealStr(a);
            String b = scanner.next();
            dealStr(b);
        }
    }

    public static void dealStr(String str){
        while(str.length()>8){
            String aa = str.substring(0,8);
            System.out.println(aa);
            str = str.substring(8);
        }
        if(str.length()<8){
            int n = 8 - str.length();
            for(int i = 0; i < n; i++){
                str = str + "0";
            }
            System.out.println(str);
        }else{
            System.out.println(str);
        }
    }
}
