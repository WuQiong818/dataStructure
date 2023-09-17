package dierdanyuan;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class peiProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float kg = sc.nextFloat();
        float height = sc.nextFloat();
        float BMI = kg / (height * height);
        if (BMI < 18.5) {
            System.out.print("Underweight");
        } else if (BMI >= 18.5 && BMI < 24) {
            System.out.print("Normal");
        } else {
            DecimalFormat df = new DecimalFormat("#.######");
            df.setRoundingMode(RoundingMode.CEILING);
            String result = df.format(BMI);
            String process = result;
            for (int i = result.length() - 1; i < 1; i++) {
                if (result.charAt(i) == '0') {
                    process = String.format("%." + i + "f", result);
                }
            }
            System.out.println(process);
            System.out.print("Overweight");
        }
    }
}
