package sample;

public class View {
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    private String driver;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String number;

    public String getNumberStorage() {
        return numberStorage;
    }

    public void setNumberStorage(String numerStorage) {
        this.numberStorage = numerStorage;
    }

    private String numberStorage;


    public View(String driver,String type, String number,String numerStorage) {
        this.driver=driver;
        this.type=type;
        this.number=number;
        this.numberStorage=numerStorage;
    }

    public View() {
    }


}
