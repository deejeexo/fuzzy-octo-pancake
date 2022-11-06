public class LoanCalculator {
    public static class Loan {
        public double lA;
        public int t;
        public double r;
        public double p;

        public Loan (double lA, int t, double r, double p) {
            this.lA = lA;
            this.t = t;
            this.r = r;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        Loan loan = new Loan(500, 2, 2.1, 100);
        LoanCalc(loan);
    }

    public static void LoanCalc(Loan loan){
        do {
            if(loan.lA <= 99){
                System.out.println("Loan amount must be greater than $99\n");
            }
        } while(loan.lA <= 99);

        do {
            if(loan.t <= 0){
                System.out.println("Loan term must be at least one year\n");
            }
            else if(loan.t > 50){
                System.out.println("Loan term cannot exceed 50 years\n");
            }
        } while(loan.t <= 0 || loan.t > 50);

        do {
            if(loan.r < 0){
                System.out.println("Interest rate cannot be negative\n");
            }
        } while(loan.r < 0);

        do {
            if(loan.p < 0){
                System.out.println("Down payment cannot be negative, but can be $0\n");
            }
            else if(loan.p >= loan.lA){
                System.out.println("Down payment cannot equal or exceed your loan amount\n");
            }
        } while(loan.p < 0 || loan.p >= loan.lA);
        System.out.println();

        int terms = loan.t * 12;
        loan.lA -= loan.p;
        //Calculate rate
        double rate = (loan.r / 100.0) / 12;
        double payment = (rate * loan.lA) / (1 - Math.pow((1 + rate), -terms));

        //Calculate interest
        double totalCost = payment * terms;
        double interest = totalCost - loan.lA;

        System.out.println("Monthly Payments: ");
        System.out.print("$");
        System.out.printf("%.2f", payment);
        System.out.println();
        System.out.println("Total Accrued Interest: ");
        System.out.println("$" + (int)Math.round(interest));
    }
}