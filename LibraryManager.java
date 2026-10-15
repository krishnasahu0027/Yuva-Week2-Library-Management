import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Provides the library's data operations.
 * ArrayList stores the books in memory while the program is running.
 */
public class LibraryManager {
    private final List<Book> books = new ArrayList<Book>();
    private int nextId = 1;

    /** CREATE: validate and add a book with an automatically generated ID. */
    public Book addBook(String title, String author, String isbn, int year) {
        if (findByIsbn(isbn).isPresent())
            throw new IllegalArgumentException("A book with this ISBN already exists.");

        Book book = new Book(nextId, title, author, isbn, year);
        books.add(book);
        nextId++;
        return book;
    }

    /** READ: return a copy of the book list. */
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(books);
    }

    /** READ: search for a book by its unique numeric ID. */
    public Optional<Book> findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return Optional.of(book);
        }
        return Optional.empty();
    }

    private Optional<Book> findByIsbn(String isbn) {
        if (isbn == null) return Optional.empty();
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn.trim())) return Optional.of(book);
        }
        return Optional.empty();
    }

    /** UPDATE: update a book while preserving its ID and ISBN uniqueness. */
    public boolean updateBook(int id, String title, String author, String isbn, int year) {
        Optional<Book> match = findById(id);
        if (!match.isPresent()) return false;

        Optional<Book> duplicate = findByIsbn(isbn);
        if (duplicate.isPresent() && duplicate.get().getId() != id)
            throw new IllegalArgumentException("Another book already uses this ISBN.");

        // Validate all replacement values before changing the existing record.
        Book validated = new Book(id, title, author, isbn, year);
        Book current = match.get();
        current.setTitle(validated.getTitle());
        current.setAuthor(validated.getAuthor());
        current.setIsbn(validated.getIsbn());
        current.setPublicationYear(validated.getPublicationYear());
        return true;
    }

    /** DELETE: remove a book by ID and report whether it existed. */
    public boolean deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
}
