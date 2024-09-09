package bookstore.bookapp.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String author,title,isbn;
    private double price;
    private int vuosi;
    
    public Book() {}

    public Book( String author, String title,String isbn,double price,int vuosi) {
		super();

        this.author=author;
        this.title=title;
        this.isbn=isbn;
        this.price=price;
        this.vuosi=vuosi;
}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getVuosi() {
        return vuosi;
    }
    public void setVuosi(Integer vuosi) {
        this.vuosi = vuosi;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
public String toString() {
    return "Book [id=" + id + ", author=" + author + ", title=" + title + 
           ", isbn=" + isbn + ", price=" + price + ", year=" + vuosi + "]";
}

    
}
