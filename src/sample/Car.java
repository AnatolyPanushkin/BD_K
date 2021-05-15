package sample;

public class Car {
    private String typeOfCar;
    private String numberOfCar;
    private String driver;
    private String numberOfStorage;

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }


    public String getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(String numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getNumberOfStorage() {
        return numberOfStorage;
    }

    public void setNumberOfStorage(String numberOfStorage) {
        this.numberOfStorage = numberOfStorage;
    }

    public Car(String typeOfCar,String numberOfCar,String driver, String numberOfStorage){
        this.typeOfCar=typeOfCar;
        this.numberOfCar=numberOfCar;
        this.driver=driver;
        this.numberOfStorage=numberOfStorage;
    }

    public Car(String ofCar, String typeOfCar) {}






}
