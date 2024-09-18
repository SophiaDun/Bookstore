package bookstore.bookapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookapp.domain.Book;
import bookstore.bookapp.domain.BookRepository;
import bookstore.bookapp.domain.Category;
import bookstore.bookapp.domain.CategoryRepository;


@SpringBootApplication
public class BookappApplication {
private static final Logger log = LoggerFactory.getLogger(BookappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

	 
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save a couple of books");

			Category category1 = new Category("Children's");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Horror");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);


			repository.save(new Book( "Tove Jansson", "Taikatalvi","9789510452509",21.95,1961,category1));
			repository.save(new Book("Agatha Christie", "And Then There Were None","0062073486",23.95,1939,category3));	
			repository.save(new Book( "J.R.R. Tolkien", "The Hobbit","3608987495",49.99,1937,category2));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			

		};

}
}
