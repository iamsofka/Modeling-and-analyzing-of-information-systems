import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MedicineComponent {

    private String usageInstruction;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private Component component;
    private Medicine medicine;

    private static Set<MedicineComponent> medicineComponentsExtent = new HashSet<>();

    public  MedicineComponent (String usageInstruction, LocalDate manufactureDate, LocalDate expirationDate) {
        this.usageInstruction = usageInstruction;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;

        medicineComponentsExtent.add(this);
    }

    //getter
    public String getUsageInstruction() {
        return usageInstruction;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Component getComponent() {
        return component;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    //setters
    public void setUsageInstruction(String usageInstruction) {
        if (usageInstruction == null){
            throw new IllegalArgumentException("Usage instructions are null");
        }
        if (usageInstruction.isEmpty()){
            throw new IllegalArgumentException("There are no symbols provided");
        }
        this.usageInstruction = usageInstruction;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        if (manufactureDate == null) {
            throw new IllegalArgumentException("Given manufactureDate is null");
        }
        if (manufactureDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Manufacture date is incorrect");
        }
        this.manufactureDate = manufactureDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) {
            throw new IllegalArgumentException("Given expiration date is null");
        }
        if (expirationDate.isBefore(LocalDate.now()) || expirationDate.isBefore(manufactureDate)) {
            throw new IllegalArgumentException("Given expiration date is invalid");
        }
        this.expirationDate = expirationDate;
    }

    public void setComponent(Component component) {
        if (component == null){
            throw new IllegalArgumentException("Component can't be null");
        }
        this.component = component;
        this.component.addMedicineComponent(this);
    }

    public void setMedicine(Medicine medicine) {
        if (medicine == null){
            throw new IllegalArgumentException("Medicine can't be null");
        }
        this.medicine = medicine;
        this.medicine.addMedicineComponent(this);
    }

    //with an attribute
    public void remove() {
        if (this.medicine != null){
            Medicine tmp = this.medicine;
            this.medicine = null;
            tmp.deleteMedicineComponent(this);
        }
        if (this.component != null){
            Component tmp = this.component;
            this.component = null;
            tmp.deleteMedicineComponent(this);
        }
    }
}
