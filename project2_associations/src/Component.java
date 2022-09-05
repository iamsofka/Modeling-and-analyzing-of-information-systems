import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Component {

    private int idComponent;
    private int neededAmount;
    private String productionPlace;
    private String uniqueName;
    private Form form;
    private Distributor distributor;

    private static Set<Component> componentsExtent = new HashSet<>();
    private Set<MedicineComponent> medicineComponents;

    public Component(int idComponent, int neededAmount, String productionPlace, String uniqueName){
        this.idComponent = idComponent;
        this.neededAmount = neededAmount;
        this.productionPlace = productionPlace;
        this.uniqueName = uniqueName;
        this.medicineComponents = new HashSet<>();

        componentsExtent.add(this);
    }

    //getters
    public int getNeededAmount() {
        return neededAmount;
    }

    public String getProductionPlace() {
        return productionPlace;
    }

    public int getIdComponent() {
        return idComponent;
    }

    public Form getForm() {
        return form;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public Set<MedicineComponent> getMedicineComponents() {
        return Collections.unmodifiableSet(medicineComponents);
    }

    //setters
    public void setNeededAmount(int neededAmount) {
        if (neededAmount < 0){
            throw new IllegalArgumentException("Needed amount of components can't be negative");
        }
        this.neededAmount = neededAmount;
    }

    public static void setComponentsExtent(Set<Component> componentsExtent) {
        if (componentsExtent == null){
            throw new IllegalArgumentException("Component set is null");
        }
        //check for uniqueness :(
        Component.componentsExtent = componentsExtent;
    }

    public void setProductionPlace(String productionPlace) {
        if (productionPlace == null){
            throw new IllegalArgumentException("Production place is null");
        }
        if (productionPlace.isEmpty()){
            throw new IllegalArgumentException("Production place is empty");
        }
        this.productionPlace = productionPlace;
    }

    private void setUniqueName(String uniqueName){
        if (uniqueName == null){
            throw new IllegalArgumentException("The name is null");
        }
        if (uniqueName.isEmpty()){
            throw new IllegalArgumentException("The name is empty");
        }
        this.uniqueName = uniqueName;
    }

    public void setForm(Form form){
        if (this.form != null && this.form.equals(form)){
            return;
        }
        if (this.form == null && form != null){
            this.form = form;
            form.addComponent(this);
        }
        if (this.form != null && form == null){
            Form tmp = this.form;
            this.form = null;
            tmp.deleteComponent(this);
        }
        if (this.form != null && form != null){
            Form tmp = this.form;
            this.form = null;
            tmp.deleteComponent(this);
            this.form = form;
            this.form.addComponent(this);
        }
    }

    public void setDistributor(Distributor distributor){
        if (this.distributor != null && this.distributor.equals(distributor)){
            return;
        }
        if (this.distributor == null && distributor != null){
            this.distributor = distributor;
            distributor.addComponent(this);
        }
        if (this.distributor != null && distributor == null){
            Distributor tmp = this.distributor;
            this.distributor = null;
            tmp.deleteComponent(this);
        }
        if (this.distributor != null && distributor != null){
            Distributor tmp = this.distributor;
            this.distributor = null;
            tmp.deleteComponent(this);
            this.distributor = distributor;
            this.distributor.addComponent(this);
        }
    }

    public void addMedicineComponent(MedicineComponent medicineComponent){
        if (medicineComponent == null){
            throw new IllegalArgumentException("Medical component can't be null");
        }
        if (medicineComponent.getComponent() == null){
            throw new IllegalArgumentException("Invalid medicine");
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
