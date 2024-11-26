import java.util.Arrays;

public class Hospital {
    private String hospitalName;
    private String hospitalAddress;
    private String email;
    private Speciality[] speciality;
    private Doctor[] doctors;
    private BankAccount bankAccount;

    public Hospital() {
    }

    public Hospital(String hospitalName, String hospitalAddress, String email, Speciality[] speciality, Doctor[] doctors, BankAccount bankAccount) {
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.email = email;
        this.speciality = speciality;
        this.doctors = doctors;
        this.bankAccount = bankAccount;
    }

    public Doctor[] getAllDoctorsBySpeciality(String speciality) {
        int counter =0;
        for (Doctor doctor : doctors) {
            if (doctor.getSpeciality().getSpeciality().equalsIgnoreCase(speciality)) {
                counter++;
            }
        }
        Doctor [] doctorsToReturn = new Doctor[counter];
        int index = 0;
        for (Doctor doctor : this.doctors){
            if (doctor.getSpeciality().getSpeciality().equalsIgnoreCase(speciality)){
                doctorsToReturn[index] = doctor;
                index++;
            }
        }
        return doctorsToReturn;

    }

    public Doctor getDoctorByFIO(String fio){
        for (Doctor doctor : doctors) {
            if(doctor.getFullName().equalsIgnoreCase(fio)){
                return doctor;
            }
        }
        return null;
    }


    public String[] getAllDoctorsAndPatientsQuantity(){
        int doctorsQuantity = doctors.length;
        int patientQuantity = 0;
        for (Doctor doctor : doctors) {
            patientQuantity += doctor.getSchedules().length;
        }
        return new String[]{
                "Количество докторов больницы :" + doctorsQuantity,
                "Количество пациентов больницы :" + patientQuantity,

        };
    }

    public Schedule[] getAllSchedulesOfDoctorByFIO(int doctorIndex) {
        for (int i = 0; i < doctors.length; i++) {
            if(i == doctorIndex){
                return doctors[i].getSchedules();
            }
        }
        return null;
    }
    public String deleteDoctor(int doctorIndex) {
        Doctor[] newDoctors = new Doctor[doctors.length -1];
        boolean found = false;
        for (int i = 0; i < doctors.length; i++) {
            if(i == doctorIndex){
                found = true;
                continue;
            }
            if(found){
                i--;
                newDoctors[i] = doctors[i];
            }else {
                newDoctors[i] = doctors[i];
            }
        }
        doctors = newDoctors;
        return "Успешно удален доктор!";
    }
    public String addNewDoctor(Doctor doctor) {
        Doctor[] newDoctors = Arrays.copyOf(doctors, doctors.length + 1);
        newDoctors[newDoctors.length - 1] = doctor;
        doctors = newDoctors;
        return "Успешно добавили доктора!";
    }
    public String updateDoctor(int doctorIndex, int salary, String speciality){
        Doctor doctor = doctors[doctorIndex];
        doctor.setSalary(salary);
        if(speciality != null) {
            for (Speciality speciality1 : this.speciality) {
                if (speciality1.getSpeciality().equalsIgnoreCase(speciality)) {
                    doctor.setSpeciality(speciality1);
                }
            }
        }
        doctors[doctorIndex] = doctor;
        return "Успешно обновлен доктор по фио: " + doctor.getFullName();
    }

    public String transferSalary(){
        for (int i = 0; i < doctors.length; i++) {
            doctors[i].getBankAccount().deposit(doctors[i].getSalary());
            System.out.println(bankAccount.withdraw(doctors[i].getSalary(), this.bankAccount.getCvv()));
        }
        return "Успешно начислены зарплаты!";
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Speciality[] getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality[] speciality) {
        this.speciality = speciality;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                ", email='" + email + '\'' +
                ", speciality=" + Arrays.toString(speciality) +
                ", doctors=" + Arrays.toString(doctors) +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
