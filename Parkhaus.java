package Garage;

import java.util.ArrayList;
import java.util.Iterator;

public class Parkhaus {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    static ArrayList<Fahrzeug> fahrzeugliste = new ArrayList<>();

    private int etagen;
    private int parkplaetze;

    public Parkhaus(int etagen, int parkplaetze) {
        this.etagen = etagen;
        this.parkplaetze = parkplaetze;
    }

    //Check ob Kennzeichen bereits in der fahrzeugliste existiert
    public static void check(Fahrzeug fz1, String fzCheck){
        for (Fahrzeug checkfz : fahrzeugliste){
            if (checkfz.getKennzeichen().equals(fzCheck)){
                System.out.println(ANSI_RED + "Das muss ein Fehler sein, dass Fahrzeug mit dem Kennzeichen "
                        + checkfz.getKennzeichen() + "steht hier bereits. Bitte prüfen Sie die Eingabe" + ANSI_RESET);
                Parkverwaltung.menu();
            }
        }
    }

    //checkt jedes Objekt in der fahrzeugliste ob die fzID identisch ist, falls ja wird es aus der Arraylist entfernt
    public void fahrzeugAbholen(Fahrzeug fz1, String fzId){
        for (Iterator<Fahrzeug> itlfz = fahrzeugliste.iterator(); itlfz.hasNext(); ){
            fz1 = itlfz.next();
            if (fz1.getKennzeichen().equals(fzId)) {
                itlfz.remove();
                System.out.println(ANSI_BLUE+"\nDanke für den Besuch " + fz1.getHalter() + " " +
                        "in 'der Garage' in Vence - einen schönen Tag noch"+ANSI_RESET);
            }
        }
    }

    //prüft anhand des Kennzeichen ob das Fahrzeug in der fahrzeugliste vorhanden ist
    public void suchefahrzeug(Fahrzeug fz1, String kfz) {
        for (Fahrzeug kennz : fahrzeugliste) {
            if (kennz.getKennzeichen().equals(kfz)) {
                System.out.println(ANSI_BLUE + "Parkplatz: " +kennz.getId() + "\nHalter: " + kennz.getHalter() +
                        "\nKennzeichen: " + kennz.getKennzeichen() + "\nFahrzeug: " +  kennz.getFahrzeugtyp() +
                        "\n" + ANSI_RESET);
            }
        }
    }

    //zeigt die fahrzeuglist an
    public void listefahrzeuge() {
        Iterator<Fahrzeug> fliste = fahrzeugliste.iterator();
        while (fliste.hasNext()){
            System.out.println(fliste.next());
        }
    }

    public int getEtagen() {
        return etagen;
    }

    public void setEtagen(int etagen) {
        this.etagen = etagen;
        System.out.println("Das Parkhaus hat "+getEtagen()+" Etagen");
    }

    public int getParkplaetze() {
        return parkplaetze;
    }

    public void setParkplaetze(int parkplaetze) {
        this.parkplaetze = parkplaetze;
        System.out.println("Die Etage hat "+getParkplaetze()+ " Parkplätze");
    }
}
