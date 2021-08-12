import java.util.ArrayList;

public class ShoppingCart {

    //Datenstruktur mit einer Liste von Paaren. Jedes Paar besteht aus einem
    //Product und einem Int Objekt, um das Produkt und die bestellte Menge anzugeben

    ArrayList<Pair> paare = new ArrayList<Pair>();


    //Liste mit Paaren von Produkten und Produkmengen
    public void productAndQuantityList()
    {
        for (Integer i=0;i<paare.size();i++)
        {
            System.out.println(paare.get(i).getProduct() + " " + paare.get(i).getAnzahl());
        }
    }
   // wenn alle Produkte im ShoppingCart in ausreichender Menge vorhanden sind

    public boolean allProductsAvailable()
    {
        Integer anzahlMenge=0;
        Integer MengeStock=0;

        for(Integer i=0;i<paare.size();i++)
        {
          anzahlMenge+=paare.get(i).getAnzahl();
        }

        for(Integer i=0;i<paare.size();i++)
        {
            MengeStock+=paare.get(i).getProduct().availableItems();
        }

        if(MengeStock>=anzahlMenge)
        {
            return true;
        }

        return false;
    }

    //Gesamtpreis aller Produkte unter Berücksichtigung der Mengenangaben

    public float totalPrice()
    {
        float totalPreis=0;

        for(Integer i=0;i<paare.size();i++)
        {
            totalPreis+=paare.get(i).getProduct().verkaufpreis*paare.get(i).getAnzahl();
        }

        return totalPreis;

    }
    // entfernt alle Produkte aus dem ShoppingCart, ohne sie zu kaufen

    public void clear()
    {

        paare.clear();

        System.out.println("Der Shoppingcart ist leer");
    }

    public float buyEverything()
    {
        float boughtItems=0;


        for(Integer i=0;i<paare.size();i++)
        {
            Integer menge=0;
            menge = paare.get(i).getProduct().takeItems(paare.get(i).getAnzahl());
            boughtItems+=menge*paare.get(i).getProduct().verkaufpreis;
        }
        paare.clear();
        return boughtItems;
    }







}
