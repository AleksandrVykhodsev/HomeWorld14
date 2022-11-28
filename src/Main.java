import transport.Car;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Human maksim = new Human(null, 1988, "Минск", "бренд-менеджером");
        Human anna = new Human("Аня", -1993, "Москва", "методистом образовательных программ");
        Human katia = new Human("Катя", 1992, "Калининград", "продакт-менеджером");
        Human artem = new Human("Артем", 1995, "Москва", "директором по развитию бизнеса");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int ageVladimir = 21;
        int yearOfBirthVladimir = year - ageVladimir;
        Human vladimir = new Human("Владимир", yearOfBirthVladimir, "Казань", "сейчас нигде не работает");
        System.out.println(maksim);
        System.out.println(anna);
        System.out.println(katia);
        System.out.println(artem);
        System.out.println(vladimir);
        Car lada = new Car(null, "Granta", "1.7", "желтого", 2015, "России");
        lada.setRegNumber("п534ву198");
        lada.setGears("автомат");
        Car audi = new Car("Audi", null, "3,0", "черного", 2020, "Германии");
        Car bmw = new Car("BMW", "Z8", null, "черного" , 2021, "Германии");
        Car kia = new Car("Kia", "Sportage 4-го поколения", "2,4", null, 2018, "Южной Корее");
        Car hyundai = new Car("Hyundai", "Avante", "1,6", "оранжевого", 0, null);
        System.out.println("");
        printInfoCar(lada);
        printInfoCar(audi);
        printInfoCar(bmw);
        printInfoCar(kia);
        printInfoCar(hyundai);
        System.out.println("");
        Flower roza = new Flower(null, "Голандия", 35.59);
        Flower hrizantema = new Flower(null, null, 15);
        hrizantema.lifeSpan = 5;
        Flower pion = new Flower(null, "Англия", 69.9);
        pion.lifeSpan = 1;
        Flower gipsofila = new Flower(null, "Турция", 19.5);
        gipsofila.lifeSpan = 10;
        printInfo(roza);
        printInfo(hrizantema);
        printInfo(pion);
        printInfo(gipsofila);
        printCostOfFlowers(roza,roza,roza,hrizantema,hrizantema,hrizantema,hrizantema,hrizantema,gipsofila);

    }
    private static void printInfo (Flower flower){
        System.out.println("Цвет " + flower.getFlowerColor() + ", страна " + flower.getCountry() + ", стоимость " + flower.getCost() + ", срок стояния " + flower.lifeSpan);
    }
    private static void printCostOfFlowers (Flower... flowers){
        double totalCost = 0;
        int minlifeSpan = Integer.MAX_VALUE;
        for (Flower flower : flowers){
            if (flower.lifeSpan < minlifeSpan){
                minlifeSpan = flower.lifeSpan;
            }
            totalCost += flower.getCost();
            printInfo(flower);
        }
        totalCost = totalCost * 1.1;
        System.out.println("Стоимость букета " + totalCost);
        System.out.println("Срок стояния букета " + minlifeSpan);
    }
    public static void printInfoCar (Car car){
        System.out.println(car.getBrand()
                + " " + car.getModel() +
                ", " + car.getYear() +
                " год выпуска, сборка в " +
                car.getCountry() +
                ", " + car.getColor() +
                " цвет кузов, объем двигателя — " +
                car.getEngineVolume() + " л." + ", коробка передач " +
                car.getGears() + ", тип кузова " +
                car.getTypeOfBody() +
                ", регистрационный номер " +
                car.getRegNumber() +
                ", количество мест " +
                car.getSeatsCount() +
                (car.isSummerTyres() ? "летняя" : "зимняя") + " резина" +
                ", " + (car.getKey().isWithoutKeyAccess() ? "безключевой доступ" : "доступ с ключом") +
                ", " + (car.getKey().isRemoteRunEngine() ? "удаленный запуск" : "обычный запуск") +
                ", номер страховки " + car.getInsurance().getNumber() +
                ", стоимость страховки " + car.getInsurance().getCost() +
                ", срок действия страховки " + car.getInsurance().getExpireDate());

    }
}