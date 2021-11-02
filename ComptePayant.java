public class ComptePayant extends Compte {


    public ComptePayant() {
        interestRate = 1;
        countPrice = 50;
        overdraft = 400d;
    }

    public void affiche() {
        super.affiche();
        System.out.println("Découvert autorisé : " + overdraft + " €");
    }

}