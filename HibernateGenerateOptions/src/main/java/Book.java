import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table ( name="Book_Details")
public class Book {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // Will generate Auto Values Based on Dialect Sequence Option
    //@GeneratedValue(strategy = GenerationType.IDENTITY)   // AutoIncrement Option
    //@SequenceGenerator(name="book-seq",sequenceName = "books",initialValue = 150,allocationSize = 100)
    //@GeneratedValue(generator = "book-seq")
    int book_id;
    @Column(name = "BookName",unique = true)
    String book_name;

    public Book(String book_name) {
        this.book_name = book_name;
    }

    public Book() {
    }

    public Book(int book_id, String book_name) {
        this.book_id = book_id;
        this.book_name = book_name;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
}
