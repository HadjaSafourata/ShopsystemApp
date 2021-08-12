public class PlainReview implements Review {

    private double punkte;

    public PlainReview(double punkte)
    {
        this.punkte=punkte;
    }

    @Override
    public double punkten() {
        return punkte;
    }


    @Override
    public String infoKommentar() {
        return "Produkt mit " + punkten() + "Punkten";
    }



}
