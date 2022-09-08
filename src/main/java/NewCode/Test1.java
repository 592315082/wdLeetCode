package NewCode;

import java.util.Scanner;

/**
 *
    计算字符串最后一个单词的长度，单词以空格隔开。
    输入描述:一行字符串，非空，长度小于5000。
    输出描述:整数N，最后一个单词的长度。
 */
public class Test1 {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        String aa = null;
        while (scan.hasNextLine()) {
            aa = scan.next();
            System.out.println("输入的数据为：" + aa);
        }
        System.out.println(aa.length());
        scan.close();
    }
}
