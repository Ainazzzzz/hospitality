import java.util.Arrays;

public class Patient {
    private String fullName;
    private int age;
    private String username;
    private String password;
    private BankAccount bankAccount;
    private Hospital hospital;
    private Schedule[] schedules;

    public Patient(String fullName, int age, String username, String password, BankAccount bankAccount, Hospital hospital, Schedule[] schedules) {
        this.fullName = fullName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.bankAccount = bankAccount;
        this.hospital = hospital;
        this.schedules = schedules;
    }

    public Patient(String fullName,  int age, String password, String username ) {
        this.password = password;
        this.username = username;
        this.age = age;
        this.fullName = fullName;
    }

    public void addNewSchedule(Schedule schedule) {
        Schedule[] allSchedules = Arrays.copyOf(schedules, schedules.length+1);
        allSchedules[allSchedules.length -1] = schedule;
        schedules = allSchedules;
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Schedule[] getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedule[] schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bankAccount=" + bankAccount +
                ", hospital=" + hospital +
                ", schedules=" + Arrays.toString(schedules) +
                '}';
    }

}
