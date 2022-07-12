import java.util.Scanner;

public class DepositCalculator {
    public static final double yearRate = 0.06;
    public static final int exponent = 2;

    double calculateComplexPercent(double depositSum, int depositPeriod) {
        double depositWithIncome = depositSum * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(depositWithIncome);
    }

    double calculateSimplePercent(double depositSum, int depositPeriod) {
        double depositWithIncome = depositSum + depositSum * yearRate * depositPeriod;
        return round(depositWithIncome);
    }

    double round(double sum) {
        double scale = Math.pow(10, exponent);
        return Math.round(sum * scale) / scale;
    }

    void calculateDepositWithIncome() {
        int depositPeriod;
        int depositType;
        int depositAmount;
        double depositWithIncome = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, "
            + "1 - вклад с обычным процентом, "
            + "2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        if (depositType == 1) {
            depositWithIncome = calculateSimplePercent(depositAmount, depositPeriod);
        } else if (depositType == 2) {
            depositWithIncome = calculateComplexPercent(depositAmount, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + depositWithIncome);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositWithIncome();
    }
}
