import java.time.LocalDateTime;

public class Schedule {
    private Patient patient;
    private LocalDateTime dateTime;
    private Speciality speciality;
    private boolean obrabotan;

    public Schedule(Patient patient, LocalDateTime dateTime, Speciality speciality, boolean obrabotan) {
        this.patient = patient;
        this.dateTime = dateTime;
        this.speciality = speciality;
        this.obrabotan = obrabotan;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public boolean isObrabotan() {
        return obrabotan;
    }

    public void setObrabotan(boolean obrabotan) {
        this.obrabotan = obrabotan;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "patient=" + patient +
                ", dateTime=" + dateTime +
                ", speciality=" + speciality +
                ", obrabotan=" + obrabotan +
                '}';
    }
}
