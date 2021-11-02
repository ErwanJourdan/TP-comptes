
public abstract class Compte {

    protected int idCount;
    protected Double overdraft;
    protected double countPrice;
    protected Carte[] cartes;
    protected double balance;
    protected int interestRate;
    protected static int nbOfCount =0;
    protected static int totalInterest =0;
    protected static int nbOfTransaction =0;

    public Compte() {
        ++nbOfCount;
        idCount=nbOfCount;
    }





    public void initialize(double initialDeposit, Carte[] cartes) throws Exception {
        int totalPriceCard = 0;
        this.cartes = cartes;
        for (Carte carte : cartes) {
            totalPriceCard += carte.getPrice();
            totalInterest += carte.getPrice();
        }
        if (initialDeposit + overdraft <= interestRate + countPrice + totalPriceCard) {
            throw new Exception("Le dépot initial est insuffisant pour ouvrir ce compte");
        } else {
            balance = initialDeposit - interestRate - countPrice - totalPriceCard;
            totalInterest+=interestRate+ countPrice;
            ++nbOfTransaction;
        }
    }


    public void affiche() {
        System.out.println("===============");
        System.out.println("  Numéro de compte : " + idCount);
        System.out.println("   Solde du compte : " + balance + " €");
        System.out.println("    Taux d'intérêt : " + interestRate);
        for (Carte carte : cartes) {
            System.out.println("   Type de cartes : " + carte.name());
        }
        ;
    }

    public void withdraw(double withdrawalAmount) throws Exception {
        if (withdrawalAmount + interestRate >= balance + overdraft) {
            throw new Exception("===============\nDépassement du plafond de retrait pour le compte n°: " + idCount);
        } else {
            balance = balance - withdrawalAmount - interestRate;
            totalInterest+=interestRate;
            ++nbOfTransaction;
            System.out.println("===============");
            System.out.println("Le solde du compte n°: " + idCount + " est de: " + balance + "€ après le retrait " +
                    "de: " + withdrawalAmount + "€");
        }
    }

    public void deposit(double depositAmount) throws Exception {
        if (depositAmount <= interestRate) {
            throw new Exception("===============\nLe montant du dépot est trop faible pour être déposé sur le " +
                    "compte n°: " + idCount);
        } else {
            balance = balance + depositAmount - interestRate;
            totalInterest+=interestRate;
            ++nbOfTransaction;
            System.out.println("===============");
            System.out.println("Le solde du compte n°: " + idCount + " est de: " + balance + "€ après le dépot " +
                    "de: " + depositAmount + "€");
        }
    }

    public void transfer(Compte compte, double transferAmount) throws Exception {
        if (this == compte) {
            throw new Exception("===============\n Virement sur le même compte interdit");
        } else {
            try {
                withdraw(transferAmount);
                compte.deposit(transferAmount);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void bank(){
        System.out.println("===============");
        System.out.println("Les intérêts de la banque sont de: " + totalInterest + "€ pour "+nbOfTransaction+" " +
                "transactions");
    }


}
