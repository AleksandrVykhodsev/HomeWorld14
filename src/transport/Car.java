package transport;

import java.time.LocalDate;

public class Car {
    private final String brand;
    private final String model;
    private String engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String gears;
    private final String typeOfBody;
    private String regNumber;
    private final int seatsCount;
    private boolean summerTyres;
    private Key key;
    private Insurance insurance;

    public Car(String brand,
               String model,
               String engineVolume,
               String color,
               int year,
               String country,
               String gears,
               String typeOfBody,
               String regNumber,
               int seatsCount,
               boolean summerTyres,
               Key key,
               Insurance insurance) {
        if (brand == null){
            this.brand = "default";
        }else {
            this.brand = brand;
        }
        if (model == null){
            this.model = "default";
        }else {
            this.model = model;
        }

        this.engineVolume = engineVolume;

        if (color == null){
            this.color = "белый";
        }else {
            this.color = color;
        }

        this.year = year;

        if (country == null){
            this.country = "default";
        }else {
            this.country = country;
        }
        if (gears == null){
            this.gears = "МКПП";
        }else {
            this.gears = gears;
        }
        if (regNumber == null){
            this.regNumber = "х000хх000";
        }else {
            this.regNumber = regNumber;
        }
        if (typeOfBody == null){
            this.typeOfBody = "седан";
        }else {
            this.typeOfBody = typeOfBody;
        }
        if (key == null){
            this.key= new Key();
        }else {
            this.key = key;
        }
        if (insurance == null){
            this.insurance= new Insurance();
        }else {
            this.insurance = insurance;
        }

        this.seatsCount = seatsCount;
        this.summerTyres = summerTyres;
    }

    public Car (String brand, String model, String engineVolume, String color, int year, String country) {
        this(brand, model, engineVolume, color, year, country, "МКПП", "седан", "х000хх000", 5 , true, new Key(), new Insurance());


    }

    public String getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(String engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGears() {
        return gears;
    }

    public void setGears(String gears) {
        if (gears == null){
            this.gears = "МКПП";
        }else {
            this.gears = gears;
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (regNumber == null){
            this.regNumber = "х000хх000";
        }else {
            this.regNumber = regNumber;
        }
    }

    public boolean isSummerTyres() {
        return summerTyres;
    }

    public void setSummerTyres(boolean summerTyres) {
        this.summerTyres = summerTyres;
    }



    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public int getSeatsCount() {
        return seatsCount;
    }
    public void changeTyres(){
        summerTyres = !summerTyres;
    }


    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean isCorrectRegNumber(){
        if (regNumber.length() != 9){
            return false;
        }
        char [] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])){
            return false;
        }
        if (!Character.isDigit(chars[1]) || Character.isDigit(chars[2]) || Character.isDigit(chars[3]) || Character.isDigit(chars[6]) || Character.isDigit(chars[7]) || Character.isDigit(chars[8])){
            return false;
        }
        return true;
    }
    public static class Key {
        private final boolean remoteRunEngine;
        private final boolean withoutKeyAccess;

        public Key(boolean remoteRunEngine, boolean withoutKeyAccess) {
            this.remoteRunEngine = remoteRunEngine;
            this.withoutKeyAccess = withoutKeyAccess;
        }
        public Key() {
            this(false, false);
        }

        public boolean isRemoteRunEngine() {
            return remoteRunEngine;
        }

        public boolean isWithoutKeyAccess() {
            return withoutKeyAccess;
        }
    }
    public static class Insurance{
        private final LocalDate expireDate;
        private final double cost;
        private final String number;

        public Insurance(LocalDate expireDate, double cost, String number) {
            if (expireDate == null){
                this.expireDate = LocalDate.now().plusDays(365);
            }else{
                this.expireDate = expireDate;
            }

            this.cost = cost;
            if (number == null){
                this.number = "123456789";
            }else {
                this.number = number;
            }

        }

        public Insurance() {
            this(null, 10_0000, null);
        }

        public LocalDate getExpireDate() {
            return expireDate;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }
        public void checkExpireDate(){
            if (expireDate.isBefore(LocalDate.now()) || expireDate.isEqual(LocalDate.now())){
                System.out.println("Нужно ехать оформлять новую страховку.");
            }
        }
        public void checkNumber(){
            if (number.length() != 9){
                System.out.println("Номер страховки некорректный.");
            }
        }
    }

}
