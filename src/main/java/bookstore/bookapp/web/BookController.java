package bookstore.bookapp.web;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import bookstore.bookapp.domain.Book;
import bookstore.bookapp.domain.BookRepository;
import bookstore.bookapp.domain.CategoryRepository;

@Controller
public class BookController {
@Autowired
private BookRepository repository;

@Autowired
private CategoryRepository category;

@RequestMapping(value= {"/","/booklist"}) 
public String bookList(Model model) {
model.addAttribute("books", repository.findAll());


return "booklist"; }

  
@RequestMapping(value = "/add")
public String addBook(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("categories", category.findAll());
    return "addbook";
}


 @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {	
        return (List<Book>) repository.findAll();
    }    


    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findStudentRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }  

@GetMapping(value = "/edit/{id}")
public String editBook(@PathVariable("id") long id, Model model) {

    Book book = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book id not found" + id));
    model.addAttribute("categories", category.findAll());
    model.addAttribute("book", book);
    return "editbook";
}

@PostMapping(value = "/save")
    public String save(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }   

      @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
    	repository.deleteById(id);
        return "redirect:../booklist";
    }  
}

