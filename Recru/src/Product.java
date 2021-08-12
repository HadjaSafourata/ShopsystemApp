import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

 public class  Product {
  //Datenstruktur mit einer Liste von Produkten (Product Objekte)

    protected String productName;
    protected float einkaufPreis;
    protected float verkaufpreis;
    protected String beschreibung;
    protected ArrayList<Review> review = new ArrayList<Review>();
    protected ArrayList<StockUnit> stockUnits= new ArrayList<StockUnit>(); // Wie viele Einheiten auf Lager sind



    public Product(String productName,float einkaufPreis,float verkaufpreis,String beschreibung)
    {
        this.productName=productName;
        this.einkaufPreis=einkaufPreis;
        this.verkaufpreis=verkaufpreis;
        this.beschreibung=beschreibung;
    }



     public String getProductName()
    {
        return productName;
    }

   public  float getEinkaufPreis()
    {
        return einkaufPreis;
    }

    public float getVerkaufpreis()
    {
        return verkaufpreis;
    }

    public String getBeschreibung()
    {
        return beschreibung;
    }

    public void setProductName(String ProductName)
    {
        this.productName=ProductName;
    }
    public void setEinkaufPreis(float einkaufPreis)
    {
        this.einkaufPreis=einkaufPreis;
    }
    public void setVerkaufpreis(float verkaufpreis)
    {
        this.verkaufpreis=verkaufpreis;
    }
    public void setBeschreibung(String beschreibung)
    {
        this.beschreibung=beschreibung;
    }


    //Gewinnmarge pro Stück

    public float profitPerItem()
    {
        float gewinn;
        gewinn=this.verkaufpreis-this.einkaufPreis;
        return gewinn;
    }

    public float valueOfAllItems()
    {

        float count=0;
        float valueOfAllItems;

        for(Integer i=0;i<stockUnits.size();i++)
        {
            count+=stockUnits.get(i).menge;
        }

        valueOfAllItems=count*this.einkaufPreis;

        return valueOfAllItems;
    }

    //Verkaufswert aller vorhandener Stücke des Produkts basierend auf
    // dem Verkaufspreis

    public float salesValueOfAllItems()
    {
        Integer count=0;
        float valueOfAllItems;

        for(Integer i=0;i<stockUnits.size();i++)
        {
            count+=stockUnits.get(i).menge;
        }

        valueOfAllItems=count*this.verkaufpreis;

        return valueOfAllItems;

    }

    //Maximal verfügbare Menge des Produkts.

     public Integer availableItems()
     {
         Integer count=0;

         for(Integer i=0;i<stockUnits.size();i++)
         {
             count+=stockUnits.get(i).menge;
         }

         return count;

     }

     public String toString()
     {
         return (this.productName + " " + this.verkaufpreis + " "+ this.beschreibung);
     }

    //fügt eine weitere Einheit hinzu

    public void addStock(Integer menge,Integer ablaufTagen)
    {
        stockUnits.add(new StockUnit(menge,ablaufTagen));
    }
   // Objekte aus der Liste, bei denen entweder die
   //Menge 0 ist oder das Ablaufdatum erreicht ist

    public void cleanStock ()
    {
        for(Integer i=0;i<stockUnits.size();i++)
        {
            if(stockUnits.get(i).menge==0 || stockUnits.get(i).ablaufTagen==0)
            {
                stockUnits.remove(stockUnits.get(i));
            }
        }
    }

    // genug Stückzahlen
    //auf Lager sind

    public boolean isPreferredQuantityAvailable(Integer preferredQuantity)
    {
        if(availableItems()>=preferredQuantity)
        {
            return true;
        }

        return false;
    }
    public Integer takeItems (Integer preferredQuantity)
    {
        if(!isPreferredQuantityAvailable(preferredQuantity))
        {
            Integer availableItems=availableItems();

            for(Integer i=0;i<stockUnits.size();i++)
            {
                stockUnits.get(i).menge=0;
            }
            return availableItems;
        }
         else
        {

            Collections.sort(stockUnits, new Comparator<StockUnit>() {
                @Override
                public int compare(StockUnit o1, StockUnit o2) {
                    return ((o1.ablaufTagen).compareTo(o2.ablaufTagen));
                }
            });

          Integer quantity = preferredQuantity;
          Integer i=0;

          while (preferredQuantity!=0 && i!=stockUnits.size())
          {
              if(quantity>=stockUnits.get(i).menge)
              {
                  quantity=quantity-stockUnits.get(i).menge;
                  stockUnits.get(i).menge=0;
              }
              if (quantity<stockUnits.get(i).menge)
              {
                  stockUnits.get(i).menge=stockUnits.get(i).menge-quantity;
                  quantity=0;
              }

              i++;

          }


        }

        return preferredQuantity;

    }


}
