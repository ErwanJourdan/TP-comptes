public class CompteSimple extends Compte {


    public CompteSimple() {
        interestRate = 5;
        countPrice = 0;
        overdraft = 0d;
    }


    public void affiche() {
        super.affiche();
        System.out.println("Découvert autorisé : " + overdraft + " €");
    }


}
