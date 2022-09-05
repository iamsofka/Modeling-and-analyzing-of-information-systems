import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Component component = new Component(1, 394, "Kyiv", "Magnezium");
        Medicine medicine = new Medicine(3, "Magnez", 230);
        Form form = new Form(1, "pill", "Pill in a shell");

        component.setForm(form);
        System.out.println("Component form ID: " + component.getForm().getIdForm());
        System.out.println("Component form name: " + component.getForm().getFormName());
        System.out.println("Component's description " + component.getForm().getDescription());

        System.out.println("---------------------------------");

        Distributor distributor = new Distributor(1, "2984567409", "Darnytsya");
        component.setDistributor(distributor);
        System.out.println("Distributor ID: " + component.getDistributor().getIdDistributor());
        System.out.println("Distributor name: " + component.getDistributor().getDistributorName());
        System.out.println("Distributor VAT number: " + component.getDistributor().getVAT_number());

        System.out.println("---------------------------------");

        MedicineComponent medicineComponent = new MedicineComponent("Take 2 pills every morning", LocalDate.of(2021, 10, 12), LocalDate.of(2023, 12, 29));
        medicineComponent.setComponent(component);
        medicineComponent.setMedicine(medicine);
        System.out.println("Medicine ID: " + medicineComponent.getMedicine().getIdMedicine());
        //System.out.println(medicineComponent.getComponent().getIdComponent());
        System.out.println("Used component ID: " + component.getMedicineComponents()
                .stream()
                .findFirst()
                .get()
                .getComponent().getIdComponent()
        );
        System.out.println("Medicine instruction: " + medicineComponent.getUsageInstruction());
        System.out.println("Medicine's age: " + (medicineComponent.getExpirationDate().getYear()-medicineComponent.getManufactureDate().getYear()));

        System.out.println("---------------------------------");

        Prescription prescription = new Prescription(23, "40y.o. man, pretty healthy, needs vitamins", 1, medicine);
        medicine.addPrescription(prescription);
        System.out.println("Medicine name: " + medicine.getPrescriptions().stream().findFirst().get().getMedicine().getMedicineName());
        System.out.println("Patient's info: " + prescription.getPatientInfo());

    }
}
