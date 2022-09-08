package NewCode;

import java.util.Scanner;

/**
 * 题目描述:将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
           所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
  输入描述:将一个英文语句以单词为单位逆序排放。
  输出描述:得到逆序的句子

  输入:I am a boy  输出:boy a am I
 */
public class Test12 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = strArray.length-1;i>=0;i--){
                sb.append(strArray[i]+" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
