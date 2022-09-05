import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Form {

    private int idForm;
    private String formName;
    private String description;
    private Set<Component> components;
    private static Set<Form> formsExtent = new HashSet<>();

    public Form (int idForm, String formName, String description){
        this.idForm = idForm;
        this.formName = formName;
        this.description = description;
        this.components = new HashSet<>();
        formsExtent.add(this);
    }

    //getters
    public String getFormName() {
        return formName;
    }

    public String getDescription() {
        return description;
    }

    public int getIdForm() {
        return idForm;
    }

    public Set<Component> getComponents() {
        return Collections.unmodifiableSet(components);
    }

    //setters
    public void setFormName(String formName) {
        if (formName == null){
            throw new IllegalArgumentException("Name of form is null");
        }
        if (formName.isEmpty()){
            throw new IllegalArgumentException("There are no symbols provided");
        }
        this.formName = formName;
    }

    public void setDescription(String description) {
        if (description == null){
            throw new IllegalArgumentException("Description is null");
        }
        if (description.isEmpty()){
            throw new IllegalArgumentException("There are no symbols provided");
        }
        this.description = description;
    }

    //basic
    public void addComponent(Component component) {
        if (component == null){
            return;
        }
        if (component.getForm().equals(this)){
            return;
        }
        this.components.add(component);
        component.setForm(this);
    }

    public void deleteComponent(Component component) {
        if (component == null) {
            return;
        }
        this.components.remove(component);
        component.setForm(null);
    }
}
