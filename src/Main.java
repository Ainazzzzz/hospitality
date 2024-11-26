import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Hospital hospital = new Hospital();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Speciality[] specialities = {
                new Speciality("Кардиология", 1200),
                new Speciality("Неврология", 1000),
                new Speciality("Офтальмология", 900),
                new Speciality("Онкология", 1300),
                new Speciality("Педиатрия", 800),
                new Speciality("Хирургия", 1500),
                new Speciality("Травматология", 1100),
                new Speciality("Гастроэнтерология", 950),
                new Speciality("Дерматология", 850),
                new Speciality("Эндокринология", 1200)
        };
        hospital.setSpeciality(specialities);
        Doctor[] doctors = {
                new Doctor("Иван Иванов", specialities[0], 10, null, "ivan_01", "pass123", 3000, null),
                new Doctor("Анна Смирнова", specialities[1], 8, null, "anna_02", "pass456", 2800, null),
                new Doctor("Олег Петров", specialities[2], 15, null, "oleg_03", "pass789", 3500, null),
                new Doctor("Мария Кузнецова", specialities[3], 12, null, "maria_04", "pass321", 4000, null),
                new Doctor("Сергей Сидоров", specialities[4], 5, null, "sergey_05", "pass654", 2200, null),
                new Doctor("Елена Орлова", specialities[5], 20, null, "elena_06", "pass987", 5000, null),
                new Doctor("Алексей Павлов", specialities[6], 9, null, "alexey_07", "pass111", 3100, null),
                new Doctor("Ирина Васильева", specialities[7], 6, null, "irina_08", "pass222", 2500, null),
                new Doctor("Дмитрий Новиков", specialities[8], 7, null, "dmitry_09", "pass333", 2700, null),
                new Doctor("Ольга Морозова", specialities[9], 10, null, "olga_10", "pass444", 2900, null)
        };

        hospital.setDoctors(doctors);

        Patient[] patients = {
                new Patient("Дмитрий Соколов", 25, "dmitry01", "pass01"),
                new Patient("Екатерина Белова", 30, "ekaterina02", "pass02"),
                new Patient("Максим Орлов", 40, "maxim03", "pass03"),
                new Patient("Ольга Павлова", 22, "olga04", "pass04"),
                new Patient("Алексей Иванов", 35, "alexey05", "pass05")
        };
        Random random = new Random();
        for (Patient patient : patients) {
            Doctor assignedDoctor = doctors[random.nextInt(doctors.length)];
            LocalDateTime appointmentTime = LocalDateTime.now().plusDays(random.nextInt(7));

            Schedule schedule = new Schedule(patient, appointmentTime, assignedDoctor.getSpeciality(), false);
            patient.setSchedules(new Schedule[]{schedule});
            assignedDoctor.setSchedules(new Schedule[]{schedule});
        }
    }
}