package com.erhanarslan.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.erhanarslan.model.Author;
import com.erhanarslan.model.Book;
import com.erhanarslan.model.Publisher;
import com.erhanarslan.repository.AuthorRepo;
import com.erhanarslan.repository.BookRepo;
import com.erhanarslan.repository.PublisherRepo;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepo authorrepo;
	private final BookRepo bookrepo;
	private final PublisherRepo publisherrepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher();
		publisher.setName("Erhan Publishing");
		publisher.setCity("Eskişehir");
		publisher.setAddressLine("Bozüyük");
	
		publisherrepo.save(publisher);
		
		System.out.println("Publisher name" + publisherrepo.findAll());
		
		Author eric =new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "121212");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		
		authorrepo.save(eric);
		bookrepo.save(ddd);
		publisherrepo.save(publisher);
		
		Author rod =new Author("Rod", "Jhonson");
		Book noEJB =new Book("J2EE Development without EJB", "23232323");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		
		authorrepo.save(rod);
		bookrepo.save(noEJB);
		publisherrepo.save(publisher);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookrepo.count());
		System.out.println("Publisher Number of Books: "+ publisher.getBooks().size());
	}

}
