import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Medicine {

    private final int idMedicine;
    private String medicineName;
    private int amountProduced;

    private static Set<Medicine> medicinesExtent = new HashSet<>();

    private static Set<Prescription> allPrescriptions = new HashSet<>();
    private Set<Prescription> prescriptions;
    private Set<MedicineComponent> medicineComponents;

    public Medicine (int idMedicine, String medicineName, int amountProduced){
        this.idMedicine = idMedicine;
        this.medicineName = medicineName;
        this.amountProduced = amountProduced;
        this.prescriptions = new HashSet<>();
        this.medicineComponents = new HashSet<>();
        medicinesExtent.add(this);
    }

    public void addPrescription(Prescription prescription) {
        if (prescription == null) {
            throw new IllegalArgumentException("Provided prescription is null");
        }
        if (prescription.getMedicine() != null) {
            allPrescriptions.add(prescription);
            prescriptions.add(prescription);
        }
    }

    public void deletePrescription(Prescription prescription) {
        if (prescription == null) {
            throw new IllegalArgumentException("Provided prescription is null");
        }
        allPrescriptions.remove(prescription);
        prescriptions.remove(prescription);
        prescription.deleteMedicine();
    }

    //getters
    public String getMedicineName() {
        return medicineName;
    }

    public int getAmountProduced() {
        return amountProduced;
    }

    public Set<Prescription> getPrescriptions() {
        return Collections.unmodifiableSet(prescriptions);
    }

    public static Set<Prescription> getAllPrescriptions() {
        return Collections.unmodifiableSet(allPrescriptions);
    }

    public int getIdMedicine() {
        return idMedicine;
    }

    public Set<MedicineComponent> getMedicineComponents() {
        return Collections.unmodifiableSet(medicineComponents);
    }

    //setters
    public void setMedicineName(String medicineName) {
        if (medicineName == null){
            throw new IllegalArgumentException("Name of medicine is null");
        }
        if (medicineName.isEmpty()){
            throw new IllegalArgumentException("There are no symbols provided");
        }
        this.medicineName = medicineName;
    }

    public void setAmountProduced(int amountProduced) {
        if (amountProduced < 0){
            throw new IllegalArgumentException("Produced amount is negative");
        }
        this.amountProduced = amountProduced;
    }

    //with an attribute
    public void addMedicineComponent(MedicineComponent medicineComponent){
        if (medicineComponent == null){
            throw new IllegalArgumentException("medical component can't be null");
        }
        if (medicineComponent.getMedicine() == null){
            throw  new IllegalArgumentException("invalid medicine");
        }
        this.medicineComponents.add(medicineComponent);
    }

    public void deleteMedicineComponent(MedicineComponent medicineComponent){
        if (this.medicineComponents.contains(medicineComponent)){
            this.medicineComponents.remove(medicineComponent);
            medicineComponent.remove();
        }
    }
}
