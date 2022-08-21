package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                       PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) {
    Publisher pub1 = new Publisher("Vertigo", "155 9th Street",
      "New Jersey", "New York", "55555");
    publisherRepository.save(pub1);

    System.out.println("Number of Publishers: " + publisherRepository.count());

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    ddd.setPublisher(pub1);

    authorRepository.save(eric);
    bookRepository.save(ddd);
    publisherRepository.save(pub1);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "342342342342");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    noEJB.setPublisher(pub1);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publisherRepository.save(pub1);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of Books: " + bookRepository.count());
    System.out.println("Publisher number of Books: " + pub1.getBooks().size());
  }

}
