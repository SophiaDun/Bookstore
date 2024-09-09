package bookstore.bookapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import bookstore.bookapp.domain.Book;
import bookstore.bookapp.domain.BookRepository;

@Controller
public class BookController {
@Autowired
private BookRepository repository;

@RequestMapping(value= {"/","/booklist"}) 
public String bookList(Model model) {
model.addAttribute("books", repository.findAll());


return "booklist"; }

  
@RequestMapping(value = "/add")
public String addBook(Model model) {
    model.addAttribute("book", new Book());
    return "addbook";  
}  


@PostMapping(value = "/save")
    public String save(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }   

      @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
    	repository.deleteById(id);
        return "redirect:../booklist";
    }  
}

