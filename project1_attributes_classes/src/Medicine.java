import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Medicine implements Serializable {
    private int id; //mandatory
    private String name;
    private LocalDate manufactureDate; //complex
    private LocalDate expirationDate;
    private Boolean needsPrescription; //optional
    private final List<Form> availableForms; //multi-value


    private static List<Medicine> medicines = new ArrayList<>(); //class extent
    private static final Integer minimalAmountProduced = 10; //class attribute

    public Medicine(int id,
                    String name,
                    LocalDate manufactureDate,
                    LocalDate expirationDate,
                    Boolean needsPrescription,
                    List<Form> availableForms) {
        setId(id);
        setName(name);
        setManufactureDate(manufactureDate);
        setExpirationDate(expirationDate);
        setNeedsPrescription(needsPrescription);

        this.availableForms = new ArrayList<>();
        for (Form form : availableForms) {
            if (form != null) {
                this.availableForms.add(form);
            }
        }
        if (availableForms.isEmpty()){
            throw new IllegalArgumentException("The form is null");
        }

        medicines.add(this);
    }

    public Medicine(int id,
                    String name,
                    LocalDate manufactureDate,
                    LocalDate expirationDate,
                    List<Form> availableForms) {
        this(id, name, manufactureDate, expirationDate, null, availableForms);
    }

    public Integer getAge() { //derived attribute
        return LocalDate.now().getYear() - manufactureDate.getYear(); //may be year/month/day
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Given ID is negative");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Given name is null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("There are no symbols in the name");
        }
        this.name = name;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
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

    public Boolean getNeedsPrescription() {
        return needsPrescription;
    }

    public void setNeedsPrescription(Boolean needsPrescription) {
        this.needsPrescription = needsPrescription;
    }

    public List<Form> getAvailableForms() {
        return Collections.unmodifiableList(availableForms);
    }

    public void addAvailableForm(Form form) {
        if (form == null) {
            throw new IllegalArgumentException("The form is null");
        }
        this.availableForms.add(form);
    }

    public void deleteAvailableForm(Form form) {
        if (form == null) {
            throw new IllegalArgumentException("The form is null");
        }
        this.availableForms.remove(form);
    }

    public static List<Medicine> getMedicines() {
        return Collections.unmodifiableList(medicines);
    }

    //class method
    public static List<Medicine> findExpiredMedicine() {
        return medicines
                .stream()
                .filter(med -> med.expirationDate.isBefore(LocalDate.now())).collect(Collectors.toList());
    }

    //methods overriding
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Medicine: \nid: " + id
                + "\nname: " + name
                + "\nmanufacture date: " + manufactureDate
                + "\namount produced: " + minimalAmountProduced
                + "\nage: " + getAge();
    }

    //persistance
    public static void readAll(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            medicines = (List<Medicine>) ois.readObject();
            fis.close();
            ois.close(); 
        } catch (EOFException e) {
            System.out.println("No objects to read");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeAll(String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(medicines);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Medicine.readAll("file.txt");
        List<Medicine> meds = new ArrayList<>();
        if (Medicine.getMedicines().isEmpty()) {
            meds.addAll(List.of(
                            new Medicine(1, "Ibuprofen", LocalDate.of(2020, 3, 3), LocalDate.of(2023, 9, 10), List.of(Form.SYRUP, Form.OINTMENT, Form.PILL)),
                            new Medicine(2, "Paracetamol", LocalDate.now(), LocalDate.MAX, List.of(Form.PILL, Form.AMPULE)),
                            new Medicine(3, "Diclofenac", LocalDate.now(), LocalDate.MAX, List.of(Form.OINTMENT, Form.JELL))
                    )
            );
        }
        for (Medicine m : meds) {
            System.out.println(m);
        }
        System.out.println("----------");
        Medicine.writeAll("file.txt");
        Medicine.readAll("file.txt");
        for (Medicine m : Medicine.getMedicines()) {
            System.out.println(m);
        }
    }
}
