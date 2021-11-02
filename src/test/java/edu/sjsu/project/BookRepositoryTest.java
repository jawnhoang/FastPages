package edu.sjsu.project;


import edu.sjsu.project.books.Book;
import edu.sjsu.project.books.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BookRepositoryTest {
    @Autowired
    private BookRepository repo;

    @Test
    public void testCreateBook(){
        /**
         * test create books
         */
        Book bookEntry = new Book();
        bookEntry.setTitle("Think Java How to Think Like a Computer Scientist");
        bookEntry.setAuthor("Allen Downey");
        bookEntry.setYear(2004);
        //bookEntry.setUser("1");

    }
}
