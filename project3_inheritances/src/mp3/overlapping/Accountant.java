package mp3.overlapping;

import java.util.Set;

public interface Accountant {
    void addInvoice(String invoice);

    void removeInvoice(String invoice);

    Set<String> getInvoices();
}
