import java.util.HashSet;
import java.util.Set;

public class Prescription {

    private final int idPrescription;
    private String patientInfo;
    private int amountPerDay;
    private Medicine medicine;

    private static Set<Prescription> prescriptionsExtent = new HashSet<>();

    //composition
    public Prescription(int idPrescription, String patientInfo, int amountPerDay, Medicine medicine) throws Exception {

        if (idPrescription <= 0){
            throw new IllegalArgumentException("Provided prescription ID is less or equal 0");
        }
        if (patientInfo == null){
            throw new IllegalArgumentException("Patient's information is null");
        }
        if (patientInfo.isEmpty()){
            throw new IllegalArgumentException("No patient's information provided");
        }
        if (amountPerDay <= 0){
            throw new IllegalArgumentException("Provided amount is less or equal 0");
        }
        if (medicine == null) {
            throw new Exception("Medicine is null");
        }
        this.idPrescription = idPrescription;
        this.patientInfo = patientInfo;
        this.amountPerDay = amountPerDay;
        medicine.addPrescription(this);
        this.medicine = medicine;
        prescriptionsExtent.add(this);
    }

    public void deleteMedicine() {
        if (medicine == null) {
            return;
        }
        Medicine tmp = this.medicine;
        this.medicine = null;
        tmp.deletePrescription(this);
    }
    //getters
    public String getPatientInfo() {
        return patientInfo;
    }

    public int getAmountPerDay() {
        return amountPerDay;
    }

    public int getIdPrescription() {
        return idPrescription;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    //setters
    public void setPatientInfo(String patientInfo) {
        if (patientInfo == null){
            throw new IllegalArgumentException("Patient info is null");
        }
        if (patientInfo.isEmpty()){
            throw new IllegalArgumentException("There are no symbols provided");
        }
        this.patientInfo = patientInfo;
    }

    public void setAmountPerDay(int amountPerDay) {
        if (amountPerDay < 0){
            throw new IllegalArgumentException("Amount pills per day can't be negative");
        }
        this.amountPerDay = amountPerDay;
    }
}
