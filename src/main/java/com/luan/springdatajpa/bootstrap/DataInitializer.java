 package com.luan.springdatajpa.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.luan.springdatajpa.domain.Book;
import com.luan.springdatajpa.repositories.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner{

	
	private final BookRepository bookRepository;

	public DataInitializer(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
 
	@Override
	public void run(String... args) throws Exception {
		Book bookEA = new Book("Entendendo Algoritmos", "123", "novatec");
		Book saveEA = bookRepository.save(bookEA);
		
		System.out.println("Id: " + saveEA.getId());
		
		Book bookCC = new Book("Código Limpo", "8576082675", "Alta Books");
		Book saveCC = bookRepository.save(bookCC);

		System.out.println("Id: " + saveCC.getId());
		
		bookRepository.findAll().forEach(book -> {
			System.out.println("Id do livro: " + book.getId());
			System.out.println("Titulo do livro: " + book.getTitle());
		});
		

	}

}
