import java.util.*;

public class Distributor {

    private final int idDistributor;
    private String VAT_number;
    private String distributorName;

    private final Map<String, Component> components;
    private static Set<Distributor> distributorsExtent = new HashSet<>();

    public Distributor(int idDistributor, String VAT_number, String distributorName){
        this.idDistributor = idDistributor;
        this.VAT_number = VAT_number;
        this.distributorName = distributorName;
        this.components = new HashMap<>();

        distributorsExtent.add(this);
    }

    //getters
    public String getVAT_number() {
        return VAT_number;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public int getIdDistributor() {
        return idDistributor;
    }

    public Map<String, Component> getComponents() {
        return Collections.unmodifiableMap(components);
    }

    //setters
    public void setVAT_number(String VAT_number) {
        if (VAT_number == null){
            throw new IllegalArgumentException("VAT number is null");
        }
        if (VAT_number.isEmpty()){
            throw new IllegalArgumentException("There are no symbols provided");
        }
        this.VAT_number = VAT_number;
    }

    public void setDistributorName(String distributorName) {
        if (distributorName == null){
            throw new IllegalArgumentException("Name of distributor is null");
        }
        if (distributorName.isEmpty()){
            throw new IllegalArgumentException("There are no symbols provided");
        }
        this.distributorName = distributorName;
    }

    //qualified
    public void addComponent(Component component) {
        if (component == null){
            return;
        }
        if (component.getDistributor().equals(this)){
            return;
        }
        this.components.put(component.getUniqueName(), component);
        component.setDistributor(this);
    }

    public void deleteComponent(Component component) {
        if(component == null){
            return;
        }
        this.components.remove(component.getUniqueName());
        component.setDistributor(null);
    }
}
