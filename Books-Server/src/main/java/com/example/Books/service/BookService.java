package com.example.Books.service;

import com.example.Books.models.dto.AuthorDTO;
import com.example.Books.models.dto.BookDTO;
import com.example.Books.models.entity.Author;
import com.example.Books.models.entity.Book;
import com.example.Books.repository.AuthorRepository;
import com.example.Books.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

//    public long createBook(BookDTO newBook) {
//        String authorName = newBook.getAuthor().getName();
//        Optional<Author> authorOpt = this.authorRepository.findAuthorByName(authorName);
//
//        Book newBookEntity = new Book().
//                setTitle(newBook.getTitle()).
//                setIsbn(newBook.getIsbn()).
//                setAuthor(authorOpt.orElseGet(() -> createNewAuthor(authorName)));
//
//        return bookRepository.save(newBook).getId();
//    }

    private Author createNewAuthor(String authorName) {
        return authorRepository.save(new Author().setName(authorName));
    }

    public void deleteById(Long bookId) {
        bookRepository.
                findById(bookId).
                ifPresent(bookRepository::delete);
    }

    public Optional<BookDTO> findBookById(Long bookId) {
        return bookRepository.
                findById(bookId).
                map(this::map);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().
                stream().
                map(this::map).
                toList();
    }

    private BookDTO map(Book book) {

        AuthorDTO authorDTO = new AuthorDTO().setId(book.getAuthor().getId()).
                setName(book.getAuthor().getName());

        return new BookDTO().setId(book.getId()).
                setAuthor(authorDTO).
                setIsbn(book.getIsbn()).
                setTitle(book.getTitle());
    }
}
