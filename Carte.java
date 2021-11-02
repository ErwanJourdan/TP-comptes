public enum Carte {
    CB(0), VISA(5), MASTERCARD(10);

    private int price;

    Carte(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
