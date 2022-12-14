import java.net.URI;
import java.util.Scanner;
import java.io.IOException;

public class DepositCalculator {

    public static void main(String[] args) {
        new calculate_deposit().do_important_job();
    }

    double calculateComplexPercent(double a, double year, int day) {
        double pay = a * Math.pow((1 + year / 12), 12 * day);
        return exponentiate(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return exponentiate(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double exponentiate(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void makeContribution() {
        int period;
        int action;
        Scanner abcdef = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = abcdef.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = abcdef.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();
        double out = 0;

        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
}
