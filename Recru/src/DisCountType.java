public enum DisCountType {

    SOMMERSCHLUSS (0.20),
    KURZES_MHD (0.10),
    ALLES_MUSS_RAUS (0.50),
    KEIN_RABATT (0);

    private final double rabatt;


     DisCountType(double rabatt)
    {
        this.rabatt=rabatt;
    }

    public double getDiscountype()
    {
        return this.rabatt;
    }


}



