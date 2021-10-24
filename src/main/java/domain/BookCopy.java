package domain;
import java.util.ArrayList;
import java.util.logging.Logger;

public class BookCopy {
    private static Logger logger = Logger.getLogger(BookCopy.class.getName());
    String edition;
    int cantidad;

    ArrayList<Students> subscribers;

    public BookCopy(String edition, int cantidad) {
        this.edition = edition;
        this.cantidad = cantidad;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void notifysubscribers(){
        for (Students st:subscribers) {
            logger.info("Usuario notificado");
        }
    }

    public ArrayList<Students> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<Students> subscribers) {
        this.subscribers = subscribers;
    }
}
