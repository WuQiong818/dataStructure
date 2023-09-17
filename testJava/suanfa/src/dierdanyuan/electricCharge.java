package dierdanyuan;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class electricCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float expense = sc.nextFloat();
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
        float cost;
        if (expense <= 150) {
            cost = Float.parseFloat(df.format(expense * 0.4463));
        }else if (expense<=400){
            cost = Float.parseFloat(df.format(150 * 0.4463+(expense-150)*0.4663));
        }else{
            cost = Float.parseFloat(df.format(150 * 0.4463+(400-150)*0.4663+(expense-400)*0.5663));
        }
        System.out.print(cost);
    }
}
