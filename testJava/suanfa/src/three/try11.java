package three;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class try11 {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String x = valueOf(N);
        StringBuilder y = new StringBuilder(x);
        System.out.println(Integer.valueOf("0000111"));*/
        System.out.println(-10>>2);
        System.out.println(-10>>>2);

    }
}
/*
*-10>>2 用符号位去补溢出的高位
* 原码：10000000 00000000 00000000 00001010
* 反码：11111111 11111111 11111111 11110101
* 补码：11111111 11111111 11111111 11110110
* 运算>>>: 11111111 11111111 11111111 11111101   10
* 二反: 11111111 11111111 11111111 11111100
* 二原: 11000000 00000000 00000000 00000011
* */

/*
 *-10>>>2 高位仅仅用0去补，这叫逻辑右移或者无符号右移;
 * 原码：10000000 00000000 00000000 00001010
 * 反码：11111111 11111111 11111111 11110101
 * 补码：11111111 11111111 11111111 11110110
 * 运算>>>: 00111111 11111111 11111111 11111101   10
 * 二反: 一旦使用逻辑运算，便不在需要原码的操作
 * 二原:
 * */