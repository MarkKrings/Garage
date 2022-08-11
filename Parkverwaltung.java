package Garage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Parkverwaltung {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void menu(){

        int id = 1;
        int auswahl1;
        boolean quit1 = false;

        do {
            Parkhaus p1 = new Parkhaus(2, 50);   //Anzahl der Etagen und Parkplatze

            System.out.println("\n"+ANSI_BLUE+" ____                                _\n" +
                    "|  _ \\                              (_)\n" +
                    "| |_) | _   _   ___   _ __     __ _  _   ___   _ __  _ __    ___\n" +
                    "|  _ < | | | | / _ \\ | '_ \\   / _` || | / _ \\ | '__|| '_ \\  / _ \\\n" +
                    "| |_) || |_| || (_) || | | | | (_| || || (_) || |   | | | || (_) |\n" +
                    "|____/  \\__,_| \\___/ |_| |_|  \\__, ||_| \\___/ |_|   |_| |_| \\___/\n" +
                    "                               __/ |\n" +
                    "                              |___/!\n\n" +
                    ANSI_BLUE+"Willkommen im Parkhaus 'Die Garage' in der wunderschönen Stadt Vence,"+
                    "\nzur Zeit haben wir " + p1.getEtagen() + " Etagen mit jeweils " + p1.getParkplaetze() +
                    " Parkplätzen.\n\n"+ANSI_RESET);

            System.out.println();
            System.out.println("1: Fahrzeug bringen");
            System.out.println("2: Fahrzeug abholen");
            System.out.println("3: Fahrzeug suchen");
            System.out.println("4: Fahrzeugliste");
            System.out.println("5: Exit");
            Scanner sc = new Scanner(System.in);
            Scanner in = new Scanner(System.in);
            auswahl1 = sc.nextInt();
            Fahrzeug fz1 = new Fahrzeug();


            switch (auswahl1) {
                case 1:
                    System.out.println("Schönen guten Tag, wir brauchen ein paar Informationen.");

                    if (id<=p1.getParkplaetze()) {
                        System.out.println("1 Etage - Parkplatz: " + id + " ist frei");
                        fz1.setId(id);
                    } else if (id>p1.getParkplaetze() || id< p1.getParkplaetze()* p1.getEtagen()){
                        System.out.println("2 Etage - Parkplatz: " + id + " ist frei");
                    } else {
                        System.out.println("Wir sind leider voll - probieren Sie es später nochmal.");
                    }

                    System.out.println("\nHaben Sie ein Auto oder Motorrad?");
                    String typ = in.next();
                    fz1.setFahrzeugtyp(typ);

                    System.out.println("\nKennzeichen: (XXX-X-123)");
                    String kennzeichenID = in.next();
                    fz1.setKennzeichen(kennzeichenID);

                    Parkhaus.check(fz1, kennzeichenID);


                    System.out.println("\nHalter: ");
                    String name = in.next();
                    fz1.setHalter(name);

                    Parkhaus.fahrzeugliste.add(fz1);
                    System.out.println("\nSie haben Ihr " + fz1.getFahrzeugtyp() + " auf dem Parkplatz " + fz1.getId() + " abgestellt\n");
                    id++;
                    break;

                case 2:
                    System.out.println("\nWelches Fahrzeug möchten Sie abholen?\n" +
                            "Kennzeichen: ");
                    String fzId = in.next();
                    p1.fahrzeugAbholen(fz1,fzId);
                    id--;
                    break;

                case 3:
                    System.out.println("\nGeben Sie bitte das Kennzeichen ein: ");
                    String kfz = in.next();
                    p1.suchefahrzeug(fz1, kfz);
                    menu();
                    break;

                case 4:
                    System.out.println("\nFahrzeuge: ");
                    p1.listefahrzeuge();
                    menu();
                    break;

                case 5:
                    quit1 = true;
                    break;
                default:
                    System.out.println("Eingabefehler");
            }
        } while (!quit1);
        System.out.println("Auf Wiedersehen!");
    }
}
