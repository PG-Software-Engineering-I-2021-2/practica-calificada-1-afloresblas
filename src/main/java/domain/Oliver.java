package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Oliver {
    private static Logger logger = Logger.getLogger(Oliver.class.getName());
    private static Oliver instance = null;
    private Map<Integer, BookTitle> books = new HashMap<>();




    private Oliver(){
       //Empty constructor
    }

    private void registerBook(Integer idBook, String name, String year, Author author){
        books.put(idBook, new BookTitle(name, year, author));
    }

    private void registerBookEdition(Integer idBook, String edition, int cantidad){
        BookTitle book =  books.get(idBook);
        book.getCopies().add(new BookCopy(edition,cantidad));
    }

    private void modifyBookEditionQuantity(Integer idBook, String edition, int cantidad){
        List<BookCopy> bookCopies= books.get(idBook).getCopies();
        for (BookCopy editions:bookCopies) {
            if (editions.getEdition().equals(edition)){
                editions.setCantidad(cantidad);
            }
        }
    }

    private void registerStudent(Integer idBook, String edition, String name, String email, String phoneNumber){
        List<BookCopy> bookCopies= books.get(idBook).getCopies();
        boolean flag = false;
        for (BookCopy editions:bookCopies) {
            if (editions.getEdition().equals(edition)){
                editions.getSubscribers().add(new Students(email, name, phoneNumber));
                flag= true;
            }
        }
        if (!flag) logger.info("No existe edicion en base de datos");
    }

    private void deregisterStudent(Integer idBook, String edition, String phoneNumber){
        List<BookCopy> bookCopies= books.get(idBook).getCopies();
        for (BookCopy editions:bookCopies) {
            if (editions.getEdition().equals(edition)){
                ArrayList<Students> subscribers = editions.getSubscribers();
                int i=0;
                for (Students st:subscribers) {
                    i++;
                    if (st.getPhoneNumber().equals(phoneNumber)){
                        subscribers.remove(i);
                        break;
                    }

                }
            }
        }

    }
    public static Oliver getInstance(){
        if(instance==null){
            synchronized (Oliver.class){
                if(instance==null){
                    instance = new Oliver();
                }
            }
        }
        return instance;
    }

}
