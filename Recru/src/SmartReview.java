
public class SmartReview implements Review{


    private double punkte;

    public SmartReview(double punkte)
    {
        this.punkte=punkte;
    }

    @Override
    public double punkten() {
        return this.punkte;
    }
    @Override
    public String infoKommentar() {
        switch ((int) punkten()) {
            case 0:
                return "Schlechtes Produkt";
            case 1:
                return "Mäßiges Produkt";
            case 2:
                return "Durchschnittliches Produkt";
            case 3:
                return "Brauchbares Produkt";
            case 4:
                return "Gutes Produkt";
            case 5:
                return "Exzellentes Produkt";

            default:
                return "Andere werte nicht sinnvoll";


        }
    }



}
