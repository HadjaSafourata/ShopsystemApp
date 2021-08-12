import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);
        String wahl; // Zum Hinzufuegen von Produkte im Einkaufswagen
        String choix; // Zum entscheiden ob man noch andere Optionen auswählen möchten;
        String s; // Zum Hinzufuegen von Optionen;





        Warehous Lager = new Warehous();
        Lager.fillWarehouse("Milch",10,"trägt sich gut", (float) 0.20,5);
        Lager.fillWarehouse("Orange",11,"trägt sich gut", (float) 0.30,6);
        Lager.fillWarehouse("Mango",12,"trägt sich gut", (float) 0.40,3);
        Lager.fillWarehouse("Zucker",10,"trägt sich gut", (float) 0.10,2);
        Lager.fillWarehouse("oil",8,"trägt sich gut", (float) 0.25,4);
        Lager.fillWarehouse("gummi",3,"trägt sich gut", (float) 0.13,3);
        System.out.println("Folgende Produkte sind verfügbar");
        Lager.listOfProducts();

        ShoppingCart Einkaufswagen = new ShoppingCart();



        // Optionen;

        System.out.println("Liebe Kunden sie haben folgende Optionen");

        System.out.println("H Hinzufügen");
        System.out.println("K Alles kaufen ");
        System.out.println("I Info");
        System.out.println("Z Einkaufs-Liste zeigen");
        System.out.println("L Liste leeren");
        System.out.println("E Exit");


        do{

            System.out.println("Geben Sie ihr Wahl ein");

             s = in.nextLine();
            switch (s)
            {

                case "H":

                    do {

                        System.out.println("Produktname Eingeben");
                        String nameProdukt = in.nextLine();
                        System.out.println("Anzahl angeben");
                        Integer anzahlProdukt = in.nextInt();
                        for (Integer i = 0; i < Lager.product.size(); i++) {
                            if ( nameProdukt == Lager.product.get(i).productName)
                                Einkaufswagen.paare.add(new Pair(Lager.product.get(i), anzahlProdukt));
                        }
                        System.out.println("Wollen sie noch andere produkte hinzufuegen?");

                        wahl="";

                        wahl = in.nextLine();


                    }while(wahl!="n" || wahl=="j");

                    break;


            }

          //  System.out.println("Wollen sie noch andere Optionen auswählen");

            choix = in.nextLine();

        }while (choix!="n" && choix=="j");




    }
}
