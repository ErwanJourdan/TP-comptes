public class ComptePremium extends Compte {


    public ComptePremium() {
        interestRate = 0;
        countPrice = 150;
        overdraft = null;

    }

    @Override
    public void initialize(double initialDeposit, Carte[] cartes) throws Exception {
        int totalPriceCard = 0;
        this.cartes = cartes;
        for (Carte carte : cartes) {
            totalPriceCard += carte.getPrice();
            totalInterest += carte.getPrice();
        }
        if (initialDeposit < 1000) {
            throw new Exception("Le dépot initial est insuffisant pour ouvrir un compte premium");
        } else {
            balance = initialDeposit - interestRate - countPrice - totalPriceCard;
            totalInterest+=interestRate+countPrice;
            ++nbOfTransaction;
            comptes.add(this);
        }
    }

    @Override
    public void withdraw(double withdrawalAmount) throws Exception {
        balance = balance - withdrawalAmount - interestRate;
        totalInterest+=interestRate;
        ++nbOfTransaction;
        System.out.println("===============");
        System.out.println("Le solde du compte n°: " + idCount + " est de: " + balance + "€ après le retrait " +
                "de: " + withdrawalAmount + "€");
    }

    public void affiche() {
        super.affiche();
        System.out.println("Découvert autorisé : illimité");
    }


}