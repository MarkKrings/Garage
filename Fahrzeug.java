package Garage;

public class Fahrzeug {

    private int parkplatz;
    private String kennzeichen;
    private String fahrzeugtyp;
    private String halter;


    public Fahrzeug(int parkplatz, String kennzeichen, String fahrzeugtyp, String halter) {
        this.parkplatz = parkplatz;
        this.kennzeichen = kennzeichen;
        this.fahrzeugtyp = fahrzeugtyp;
        this.halter = halter;;
    }

    @Override
    public String toString() {
        return  "\nParkplatz: " + parkplatz +
                "\nKennzeichen:  " + kennzeichen +
                "\nFahrzeugtyp: " + fahrzeugtyp +
                "\nHalter: " + halter+"\n";
    }

    public Fahrzeug(){

    }

    public int getId() {

        return parkplatz;
    }
    public void setId(int parkplatz) {

        this.parkplatz = parkplatz;
    }

    public String getHalter() {

        return halter;
    }

    public void setHalter(String halter) {

        this.halter = halter;
    }

    public String getKennzeichen() {

        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {

        this.kennzeichen = kennzeichen;
    }

    public String getFahrzeugtyp() {

        return fahrzeugtyp;
    }

    public void setFahrzeugtyp(String fahrzeugtyp) {

        this.fahrzeugtyp = fahrzeugtyp;
    }
}
