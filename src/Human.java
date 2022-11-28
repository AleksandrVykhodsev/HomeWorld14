public class Human {
    String name;
    private int yearOfBirth;
    private String town;
    String jobTitle;


    public Human(String name, int yearOfBirth, String town, String jobTitle) {
        if (name == null){
            this.name = "Информация не указана";
        }else {
            this.name = name;
        }
        this.town = town;
        this.yearOfBirth = yearOfBirth;

        if (jobTitle == null){
            this.jobTitle = "Информация не указана";
        }else {
            this.jobTitle = jobTitle;
        }

    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + name + ". Я из города " + town + ". Я родился в " + yearOfBirth + " году. Я работаю на должности " + jobTitle + ". Будем знакомы!";
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth < 0 || yearOfBirth == 0){
            this.yearOfBirth = 0;
        }else {
            this.yearOfBirth = yearOfBirth;
        }

    }

    public String getTown() {
        return town;
    }

    public void setTown() {
        if (town == null || !town.isEmpty() || !town.isBlank()){
            this.town = "Информация не указана";
        }else {
            this.town = town;
        }
    }
}
