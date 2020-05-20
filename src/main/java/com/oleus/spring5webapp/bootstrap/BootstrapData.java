package com.oleus.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.oleus.spring5webapp.domain.Author;
import com.oleus.spring5webapp.domain.Book; 
import com.oleus.spring5webapp.repositories.AuthorRepository;
import com.oleus.spring5webapp.repositories.BookRepository; 

@Component
public class BootstrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository; 
	
	
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) { 
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository; 
	}



	@Override
	public void run(String... args) throws Exception {
		Author memo = new Author("Guillermo", "Oleus");
		Book book1 = new Book("Kelly", "rgrehgthte");
		Author oleus = new Author("G. Oleus", "Hernandez");
		Book book2 = new Book("Dreams", "rgrehgt080hte");
		
		memo.getBooks().add(book1);
		book1.getAuthors().add(memo);
		oleus.getBooks().add(book2);
		book2.getAuthors().add(oleus);
		
		authorRepository.save(memo);
		authorRepository.save(oleus);
		bookRepository.save(book1);
		bookRepository.save(book2);
		
		System.out.println("Number of books: "+ bookRepository.count()); 
	}

}
