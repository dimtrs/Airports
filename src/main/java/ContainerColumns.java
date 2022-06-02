public class ContainerColumns implements Comparable<ContainerColumns> {
    private String ID;
    private String FULL_NAME_AIRPORT;
    private String NAME_AIRPORT;
    private String COUNTRY;
    private String THREE_LETTERS;
    private String FOUR_LETTERS;
    private String COORDINATES1;
    private String COORDINATES2;
    private String COORDINATES3;
    private String COORDINATES4;
    private String POLE;
    private String OCEAN;
    private String AIRPORT = "airport";
    private String OUR_AIRPORTS = "OurAirports";


    @Override
    //Переопределенный метод toString для корректного отображения вывода
    public String toString() {
        return
                ID +
                        ", " + FULL_NAME_AIRPORT +
                        ", " + NAME_AIRPORT +
                        ", " + COUNTRY +
                        ", " + THREE_LETTERS +
                        ", " + FOUR_LETTERS +
                        ", " + COORDINATES1 + "," + COORDINATES2 + "," + COORDINATES3 + "," + COORDINATES4 +
                        ", " + POLE +
                        ", " + OCEAN +
                        ", " + AIRPORT +
                        ", " + OUR_AIRPORTS
                ;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFULL_NAME_AIRPORT(String FULL_NAME_AIRPORT) {
        this.FULL_NAME_AIRPORT = FULL_NAME_AIRPORT;
    }

    public void setNAME_AIRPORT(String NAME_AIRPORT) {
        this.NAME_AIRPORT = NAME_AIRPORT;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public void setTHREE_LETTERS(String THREE_LETTERS) {
        this.THREE_LETTERS = THREE_LETTERS;
    }

    public void setFOUR_LETTERS(String FOUR_LETTERS) {
        this.FOUR_LETTERS = FOUR_LETTERS;
    }

    public void setCOORDINATES1(String COORDINATES1) {
        this.COORDINATES1 = COORDINATES1;
    }

    public void setCOORDINATES2(String COORDINATES2) {
        this.COORDINATES2 = COORDINATES2;
    }

    public void setCOORDINATES3(String COORDINATES3) {
        this.COORDINATES3 = COORDINATES3;
    }

    public void setCOORDINATES4(String COORDINATES4) {
        this.COORDINATES4 = COORDINATES4;
    }

    public void setPOLE(String POLE) {
        this.POLE = POLE;
    }

    public void setOCEAN(String OCEAN) {
        this.OCEAN = OCEAN;
    }

    public void setAIRPORT(String AIRPORT) {
        this.AIRPORT = AIRPORT;
    }

    public void setOUR_AIRPORTS(String OUR_AIRPORTS) {
        this.OUR_AIRPORTS = OUR_AIRPORTS;
    }

    @Override
    // Переопределенный метод compareTo для сравнения, и последующей сортировки list в лексикографическом порядке
    public int compareTo(ContainerColumns o) {
        return FULL_NAME_AIRPORT.compareTo(o.getFULL_NAME_AIRPORT());
    }

    public String getFULL_NAME_AIRPORT() {
        return FULL_NAME_AIRPORT;
    }

   /* public int getID() {
        return ID;
    }



    public String getNAME_AIRPORT() {
        return NAME_AIRPORT;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public String getTHREE_LETTERS() {
        return THREE_LETTERS;
    }

    public String getFOUR_LETTERS() {
        return FOUR_LETTERS;
    }

    public String getCOORDINATES1() {
        return COORDINATES1;
    }
    public String getCOORDINATES2() {
        return COORDINATES2;
    }
    public String getCOORDINATES3() {
        return COORDINATES3;
    }
    public String getCOORDINATES4() {
        return COORDINATES4;
    }

    public String getPOLE() {
        return POLE;
    }

    public String getOCEAN() {
        return OCEAN;
    }

    public String getAIRPORT() {
        return AIRPORT;
    }

    public String getOUR_AIRPORTS() {
        return OUR_AIRPORTS;
    }


    public int getId() {
        return ID;
    }
*/

}