package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  /**
   * The model argument is what is going to be handed to the view, so we should put the information to be rendered
   * in it, by invoking its addAttribute method.
   * Returns the name of the view to be rendered
   */
  @RequestMapping("/books")
  public String getBooks(Model model) {
    // Add attributes to the model, which will be available in the View
    model.addAttribute("books", bookRepository.findAll());

    // Return the name of the View to be rendered when the request gets mapped to this Controller
    return "books/list";
  }

}
