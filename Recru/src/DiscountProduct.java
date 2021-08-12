public class DiscountProduct extends Product{

    String rabattart;

    public DiscountProduct(String productName,float einkaufPreis,float verkaufpreis,String beschreibung,String rabattart)
    {
        super(productName,einkaufPreis,verkaufpreis,beschreibung);
        this.rabattart=rabattart;
    }

    public void salesPrice()
    {
        switch(this.rabattart){
            case "SOMMERSCHLUSS":setVerkaufpreis(this.verkaufpreis-this.verkaufpreis*(float)DisCountType.SOMMERSCHLUSS.getDiscountype());break;
            case "KurzesMHD": setVerkaufpreis(this.verkaufpreis-this.verkaufpreis*(float)DisCountType.KURZES_MHD.getDiscountype());break;
            case "AllesMussRaus":setVerkaufpreis(this.verkaufpreis-this.verkaufpreis*(float)DisCountType.ALLES_MUSS_RAUS.getDiscountype());break;
            case "KeinRabatt":setVerkaufpreis(this.verkaufpreis);break;

        default:
              break;

        }

    }

}
