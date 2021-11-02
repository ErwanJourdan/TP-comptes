public class Main{

    public static void main(String[] args) {



        Compte count1 = new CompteSimple();
        Compte count2 = new ComptePayant();
        Compte count3 = new ComptePremium();



        try {
            count1.initialize(150, new Carte[]{Carte.CB, Carte.MASTERCARD});
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            count2.initialize(500, new Carte[]{Carte.VISA,Carte.CB, Carte.MASTERCARD});
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            count3.initialize(1000, new Carte[]{Carte.MASTERCARD,Carte.MASTERCARD, Carte.MASTERCARD});
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        count1.affiche();
        count2.affiche();
        count3.affiche();
//
        try {
            count1.withdraw(100);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            count2.withdraw(30);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            count3.withdraw(500);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            count3.deposit(50);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            count2.transfer(count1, 25);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Compte.bank();


    }

} 