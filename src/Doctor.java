import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Doctor {
    private String fullName;
    private int age;
    private Speciality speciality;
    private int experience;
    private Schedule[] schedules;
    private String username;
    private String password;
    private int salary;
    private BankAccount bankAccount;

    public Doctor(String fullName, int age, Speciality speciality, int experience, Schedule[] schedules, String username, String password, int salary, BankAccount bankAccount) {
        this.fullName = fullName;
        this.age = age;
        this.speciality = speciality;
        this.experience = experience;
        this.schedules = schedules;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.bankAccount = bankAccount;
    }
    public Doctor(String fullName, Speciality speciality, int experience, Schedule[] schedules,  int salary) {
        this.fullName = fullName;
        this.speciality = speciality;
        this.experience = experience;
        this.schedules = schedules;
        this.salary = salary;
    }
    public Doctor(String fullName, Speciality speciality, int experience, Schedule[] schedules, String username, String password, int salary, BankAccount bankAccount) {
        this.fullName = fullName;
        this.speciality = speciality;
        this.experience = experience;
        this.schedules = schedules;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.bankAccount = bankAccount;
    }


    public Schedule[] getAllSchedules(Boolean obrabotan) {
        int counter=0;
        int index=0;
        if(obrabotan) {
            for (int i = 0; i < schedules.length; i++) {
                if(schedules[i].isObrabotan()){
                    counter++;
                }
            }
            Schedule[] allSchedules = new Schedule[counter];
            for (int i = 0; i < schedules.length; i++) {
                if(schedules[i].isObrabotan()){
                    allSchedules[index]=schedules[i];
                    index++;
                }
            }
            return allSchedules;
        }else if(!obrabotan){
            for (int i = 0; i < schedules.length; i++) {
                if(!schedules[i].isObrabotan()){
                    counter++;
                }
            }
            Schedule[] allSchedules = new Schedule[counter];
            for (int i = 0; i < schedules.length; i++) {
                if(!schedules[i].isObrabotan()){
                    allSchedules[index]=schedules[i];
                    index++;
                }
            }
            return allSchedules;
        }
            return schedules;
    }

    public Schedule[] getAllSchedulesByDate(LocalDate date) {
        int counter=0;
        for (Schedule schedule : schedules) {
            if(schedule.getDateTime().toLocalDate().equals(date)){
                counter++;
            }
        }
        Schedule[] allSchedules = new Schedule[counter];
        int index =0;
        for (Schedule schedule : schedules) {
            if(schedule.getDateTime().toLocalDate().equals(date)){
                allSchedules[index] = schedule;
                index++;
            }
        }
        return allSchedules;
    }
    public String addNewSchedule(Patient patient, LocalDateTime localDateTime){
        Schedule schedule = new Schedule(patient, localDateTime, speciality, false);
        Schedule[] allSchedules = Arrays.copyOf(schedules, schedules.length+1);
        allSchedules[allSchedules.length -1] = schedule;
        schedules = allSchedules;
        patient.addNewSchedule(schedule);
        return "Успешно добавлена запись!";
    }

    public String cancelSchedule(String fio, LocalDateTime localDateTime){
        Schedule[] allSchedules = Arrays.copyOf(schedules, schedules.length-1);
        boolean found = false;
        for (int i = 0; i < schedules.length; i++) {
            if(schedules[i].getDateTime().equals(localDateTime) && schedules[i].getPatient().getFullName().equalsIgnoreCase(fio)){
                found = true;
                continue;
            }

            if(!found){
                allSchedules[i] =schedules[i];
            }else {
                i--;
                allSchedules[i] = schedules[i];
            }
        }
        schedules = allSchedules;
        return "Запись успешно отменена!";
    }

    public String reschedule(String fio, LocalDateTime localDateTime, LocalDateTime newDateTime){
        for (Schedule schedule : schedules) {
            if(schedule.getDateTime().equals(localDateTime) && schedule.getPatient().getFullName().equalsIgnoreCase(fio)){
                schedule.setDateTime(newDateTime);
            }
        }
        return "Успешно перенесли запись";
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Schedule[] getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedule[] schedules) {
        this.schedules = schedules;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", speciality=" + speciality +
                ", experience=" + experience +
                ", schedules=" + Arrays.toString(schedules) +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
