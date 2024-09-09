package bookstore.bookapp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import bookstore.bookapp.domain.Book;
import bookstore.bookapp.domain.BookRepository;

@SpringBootApplication
public class BookappApplication {
private static final Logger log = LoggerFactory.getLogger(BookappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

	 
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book( "Tove Jansson", "Taikatalvi","9789510452509",21.95,1961));
			repository.save(new Book("Reetta Niemelä", "Miljan syksy","9789511289692",23.95,2015));	
			
			repository.save(new Book( "Jennifer L Meyer", "Pikku pöllö","9789511470731",7.95,2023));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			

		};

}
}
