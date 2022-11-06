import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LoanCalculator {
    public static void main(String[] args) throws IOException {
        InputStreamReader rdr = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader i = new BufferedReader(rdr);

        double l;
        do {
            System.out.println("Loan amount: ");
            String lAmnt = i.readLine();
            l = Double.parseDouble(lAmnt);
            if(l <= 99){
                System.out.println("Loan amount must be greater than $99\n");
            }
        } while(l <= 99);

        int t;
        do {
            System.out.println("Loan term in years: ");
            String termInYears = i.readLine();
            t = Integer.parseInt(termInYears);
            if(t <= 0){
                System.out.println("Loan term must be at least one year\n");
            }
            else if(t > 50){
                System.out.println("Loan term cannot exceed 50 years\n");
            }
        } while(t <=0 || t > 50);

        double r;
        do {
            System.out.println("Interest rate per year: ");
            String rate = i.readLine();
            r = Double.parseDouble(rate);
            if(r < 0){
                System.out.println("Interest rate cannot be negative\n");
            }
        } while(r < 0);

        double pay;
        do {
            System.out.println("Down payment: ");
            String downPayment = i.readLine();
            pay = Double.parseDouble(downPayment);
            if(pay < 0){
                System.out.println("Down payment cannot be negative, but can be $0\n");
            }
            else if(pay >= l){
                System.out.println("Down payment cannot equal or exceed your loan amount\n");
            }
        } while(pay < 0 || pay >= l);
        System.out.println();

        int terms = t * 12;
        l -= pay;
        //Calculate rate
        double rate = (r/100.0) / 12;
        double payment = (rate * l)/(1-Math.pow((1+rate), -terms));

        //Calculate interest
        double totalCost = payment * terms;
        double interest = totalCost - l;

        System.out.println("Monthly Payments: ");
        System.out.print("$");
        System.out.printf("%.2f", payment);
        System.out.println();
        System.out.println("Total Accrued Interest: ");
        System.out.println("$" + (int)Math.round(interest));
    }
}