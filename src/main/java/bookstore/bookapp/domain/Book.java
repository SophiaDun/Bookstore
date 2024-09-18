package bookstore.bookapp.domain;
import jakarta.persistence.*;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String author,title,isbn;
    private double price;
    private int vuosi;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    
    public Book() {}

    public Book( String author, String title,String isbn,double price,int vuosi, Category category) {
		super();

        this.author=author;
        this.title=title;
        this.isbn=isbn;
        this.price=price;
        this.vuosi=vuosi;
        this.category=category;
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
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

    @Override
public String toString() {

    if (this.category != null)
    return "Book [id=" + id + ", author=" + author + ", title=" + title + 
    ", isbn=" + isbn + ", price=" + price + ", year=" + vuosi +", category= " +this.getCategory()+ "]";
  
    else

    return "Book [id=" + id + ", author=" + author + ", title=" + title + 
           ", isbn=" + isbn + ", price=" + price + ", year=" + vuosi + "]";
}

    
}
