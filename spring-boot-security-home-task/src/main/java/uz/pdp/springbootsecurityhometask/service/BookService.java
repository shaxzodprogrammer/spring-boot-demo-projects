package uz.pdp.springbootsecurityhometask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uz.pdp.springbootsecurityhometask.entity.Book;
import uz.pdp.springbootsecurityhometask.payload.ApiResponse;
import uz.pdp.springbootsecurityhometask.payload.BookDto;
import uz.pdp.springbootsecurityhometask.repository.BookRepository;
import uz.pdp.springbootsecurityhometask.utills.CommonUtils;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ApiResponse saveBook(BookDto dto) {
        try {
            Book book = new Book();
            book.setAuthor(dto.getAuthor());
            book.setName(dto.getName());
            bookRepository.save(book);

            return new ApiResponse("Saved", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Eror", false);
        }
    }

    public ApiResponse editBook(BookDto dto) {
        try {
            Book book = bookRepository.findById(dto.getId())
                    .orElseThrow(() -> new IllegalStateException("Book not found"));
            book.setAuthor(dto.getAuthor());
            book.setName(dto.getName());
            bookRepository.save(book);

            return new ApiResponse("Edited", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Eror", false);
        }
    }

    public ApiResponse getAllBooks(Integer page, Integer size) throws IllegalAccessException {
        Page<Book> books = bookRepository.findAll(CommonUtils.simplePageable(page, size));
        return new ApiResponse("Success",
                true,
                books.getTotalElements(),
                books.getTotalPages(),
                books.getContent());
    }

    public ApiResponse getOneBook(Integer id) throws IllegalAccessException {
        try {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("Book not found"));
            return new ApiResponse("Success", true, book);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Eror", false);
        }
    }

    public ApiResponse deleteBook(Integer id) throws IllegalAccessException {
        try {
            bookRepository.deleteById(id);
            return new ApiResponse("Success", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Eror", false);
        }

    }
}
