import java.util.ArrayList;

public class StockUnit {

    public Integer menge;
    public Integer ablaufTagen;

    public StockUnit(Integer menge, Integer ablaufTagen)
    {

            this.menge = menge;
            this.ablaufTagen = ablaufTagen;
    }


   public Integer getMenge()
    {
        return menge;
    }
    public Integer ablaufTagen()
    {
        return ablaufTagen;
    }

    public void setMenge(Integer menge)
    {
        this.menge=menge;
    }

    public void setAblaufTagen(Integer ablaufTagen)
    {
        this.ablaufTagen=ablaufTagen;
    }

    //ob das Produkt schon expired ist;
    public boolean isExpired()
    {
        if(this.ablaufTagen==0)
        {
            System.out.println("Das Produkt hat schon expiriert");
            return true;
        }
        System.out.println("Das Produkt hat noch nicht expiriert");
        return false;
    }

    public boolean isExpiringSoon()
    {
        if(this.ablaufTagen <=5)
        {
            System.out.println("Das Produkt wird bald expirieren");
            return true;
        }

        System.out.println("Das Produkt wird nicht bald expirieren");

        return false;
    }



}
