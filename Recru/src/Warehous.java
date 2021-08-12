import java.util.ArrayList;
import java.util.Random;

public class Warehous {

    public ArrayList<Product> product = new ArrayList<Product>();

    public ArrayList<String> productdescription = new ArrayList<String>();

     public void listOfProducts()
     {

         for(Integer i =0;i<product.size();i++)
         {
             System.out.println(product.get(i).toString()+"\n");

         }
     }

     public boolean hasProduct(String nameProduct)
     {
         boolean result=false;
         for (Integer i=0;i<product.size();i++)
         {
            if(product.get(i).productName==nameProduct)
            {
                result=true;
            }
         }

         return result;
     }

     public Product getProductByName(String nameProduct)
     {
         Product p =null;

         for (Integer i=0;i <product.size();i++ )
         {
             if(product.get(i).productName==nameProduct)
             {
                 p=product.get(i);
             }
         }

         return p;

     }

     //fügt ein neues Produkt hinzu im Warehaus

     public void fillWarehouse(String productName,float basePrice,String productDescription,float chargeOnTop,Integer intialStockUnits)
     {
         float einkaufpreis =basePrice*chargeOnTop;
         float verkaufpreis =basePrice+einkaufpreis;
         Integer minimum=1;

         Product neuesProduct = new Product(productName,einkaufpreis,verkaufpreis,productDescription);

         for (Integer i=0;i<intialStockUnits;i++)
         {
             neuesProduct.addStock(minimum+ (int)(Math.random() * 10),minimum+ (int)(Math.random() * 10));
         }

         neuesProduct.review.add(new PlainReview(5));
         neuesProduct.review.add(new LimitedReview(5,"top"));
         neuesProduct.review.add(new SmartReview(4));

         product.add(neuesProduct);

     }



}
