public class LoanCalculator {
    final static double MIN_LOAN_AMOUNT = 100;
    final static double MIN_LOAN_TERM = 1;
    final static double MAX_LOAN_TERM = 50;
    final static double MIN_INTEREST_RATE = 0;
    final static double MIN_DOWN_PAYMENT = 0;

    public static class Loan {
        public double loanAmount;
        public int term;
        public double rate;
        public double downPayment;

        public Loan (double loanAmount, int term, double rate, double downPayment) {
            this.loanAmount = loanAmount;
            this.term = term;
            this.rate = rate;
            this.downPayment = downPayment;
        }
    }

    public static void main(String[] args) {
        Loan loan = new Loan(500, 2, 2.1, 100);
        validateLoan(loan);
        loanCalc(loan);
    }

    private static void loanCalc(Loan loan){
        int termsInMonths = loan.term * 12;
        loan.loanAmount -= loan.downPayment;

        double monthlyPayment = calculateMonthlyPayment(loan, termsInMonths);
        double interest = calculateInterest(loan, termsInMonths);

        printCalculationResults(monthlyPayment, interest);
    }

    private static double calculateInterest(Loan loan, int termsInMonths) {
        double totalCost = loan.downPayment * termsInMonths;
        return totalCost - loan.loanAmount;
    }

    private static double calculateMonthlyPayment(Loan loan, int termsInMonths) {
        double monthlyRate = (loan.rate / 100.0) / 12;
        return (monthlyRate * loan.loanAmount) / (1 - Math.pow((1 + monthlyRate), -termsInMonths));
    }

    private static void printCalculationResults(double payment, double interest) {
        System.out.println("Monthly Payments: ");
        System.out.print("$");
        System.out.printf("%.2f", payment);
        System.out.println();
        System.out.println("Total Accrued Interest: ");
        System.out.println("$" + (int)Math.round(interest));
    }

    private static void validateLoan(Loan loan){
        String validationErrors = "";
        if(loan.loanAmount < MIN_LOAN_AMOUNT){
            validationErrors += "Loan amount must be greater than $99;\n";
        }

        if(loan.term < MIN_LOAN_TERM){
            validationErrors += "Loan term must be at least one year;\n";
        }
        else if(loan.term > MAX_LOAN_TERM){
            validationErrors += "Loan term cannot exceed 50 years;\n";
        }

        if(loan.term < MIN_LOAN_TERM){
            validationErrors += "Loan term must be at least one year;\n";
        }
        else if(loan.term > MAX_LOAN_TERM){
            validationErrors += "Loan term cannot exceed 50 years;\n";
        }

        if(loan.rate < MIN_INTEREST_RATE){
            validationErrors += "Interest rate cannot be negative;\n";
        }

        if(loan.downPayment < MIN_DOWN_PAYMENT){
            validationErrors += "Down payment cannot be negative, but can be $0;\n";
        }
        else if(loan.downPayment >= loan.loanAmount){
            validationErrors += "Down payment cannot equal or exceed your loan amount;\n";
        }

        if (!validationErrors.isEmpty()){
            System.out.println(validationErrors);
            System.exit(0);
        }
    }
}