public class Pair {

   private Product product;
   private  Integer anzahl;

    Pair(Product product, Integer anzahl) {
        this.product = product;
        this.anzahl = anzahl;
    }

    Product getProduct() {
        return product;
    }

    Integer getAnzahl() {
        return anzahl;
    }

}


