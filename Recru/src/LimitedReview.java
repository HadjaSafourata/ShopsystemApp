public class LimitedReview implements Review{

    private double punkte;
    private String kommentar;

    public LimitedReview(double punkte,String kommentar)
    {
        this.punkte=punkte;
        this.kommentar=kommentar;
    }

    @Override
    public double punkten() {
        if(this.punkte<0)
        {
            this.punkte=0;
        }
        if(this.punkte>5)
        {
            this.punkte=5;
        }

        return this.punkte;
    }
    @Override
    public String infoKommentar() {
        return this.kommentar;
    }





}
