package NewCode;

import java.util.Scanner;

/**
 * 题目描述:写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
   输入描述: 输入一个十六进制的数值字符串。
   输出描述: 输出该数值的十进制字符串。
   输入：0xA  输出：10
 */
public class Test5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String n = scanner.next().substring(2);
            System.out.println(Integer.parseInt(n, 16));
        }
    }

    public void test(){
        String aa = "1234567890";
        System.out.println(aa.substring(8));

        int i = 18;
        String a = Integer.toBinaryString(i);//10进制转2进制
        String b = Integer.toOctalString(i);//10进制转8进制
        String c = Integer.toHexString(i);//10进制转16进制
        String d = Integer.toString(i, 16);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        String e = "0xA";
        int f = Integer.parseInt("A",16); //16进制转10进制
        System.out.println(f);
    }

}
