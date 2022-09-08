package NewCode;

import java.util.Scanner;

/**
 *  写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
    输入描述:第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
    输出描述:输出输入字符串中含有该字符的个数。
 */
public class Test2 {
    public static void main(String[] arg){
        int count=0;

        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toUpperCase();
        char target  = in.nextLine().toUpperCase().toCharArray()[0];

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == target){
                count++;
            }
        }
        System.out.println(count);
    }
}

