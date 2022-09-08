package NewCode;

import java.util.Scanner;

/**
 * 题目描述:输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
   输入描述:输入一个整数（int类型）
   输出描述:这个数转换成2进制后，输出1的个数
   输入:5   输出:2
 */
public class Test13 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String binary = Integer.toBinaryString(number);
        int index = 0;
        for(int i = 0;i < binary.length();i++){
            if(String.valueOf(binary.charAt(i)).equals("1"))
                index++;
        }
        System.out.println(index);
    }
}
