package bookstore.bookapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookapp.domain.Book;
import bookstore.bookapp.domain.BookRepository;
import bookstore.bookapp.domain.BookUser;
import bookstore.bookapp.domain.BookUserRepository;
import bookstore.bookapp.domain.Category;
import bookstore.bookapp.domain.CategoryRepository;


@SpringBootApplication
public class BookappApplication {
private static final Logger log = LoggerFactory.getLogger(BookappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

	 
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository,BookUserRepository userRepository) {
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
			

			//BookUsers:
			BookUser user1 = new BookUser("user", "$2y$10$GSuaduq1m5dh9WYzj/Uxd.cIwOmDsQF8GVzTgqykveGATXRPSwtt2", "USER","1234@book.fi");
			BookUser user2 = new BookUser("admin", "$2y$10$/EgL8TiEUaYtj4y9Uuqjdua9F/bAF2bDfzVOUM1zHMdIFyLNLBJbS", "ADMIN","1234@book.fi");
			BookUser user3 = new BookUser("cherry", "$2y$10$ITenPiQXn6HV0ECQZNF1kuhlSLuy.P4LOopyLRpnpDVyG3B7y8QqS", "ADMIN","1234@book.fi");
			
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			

		};

}
}
