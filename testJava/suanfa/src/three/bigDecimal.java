package three;

import java.math.BigDecimal;

public class bigDecimal {
    public static void main(String[] args) {
        BigDecimal a =new BigDecimal(0.1);
        //使用double类型的源作为操作时，其结果往往就有不可预知性，因此，我们首先考虑使用String作用源，使用BigDecimal进行操作；
        System.out.println("a values is:"+a);
        System.out.println("=====================");
        BigDecimal b =new BigDecimal("0.1");
        System.out.println("b values is:"+b);
        System.out.println("=====================");
        BigDecimal c =new BigDecimal(Double.toString(0.1));
        System.out.println("b values is:"+c);
//        +++++++++++++++++++++++++++++++++
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.2");
        System.out.println(num1.add(num2));
    }

}
