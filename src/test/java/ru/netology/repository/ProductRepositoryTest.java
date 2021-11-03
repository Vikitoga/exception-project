package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private Product first = new Product(1, "Cake", 500);
    private Product second = new Product(2, "Juice", 120);
    private Book third = new Book(3, "Java Forever", 500, "Ivan Ivanov", 320, 2019);
    private ProductRepository repo = new ProductRepository();

    @BeforeEach
    public void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    public void shouldRemoveIfExists(){
        repo.removeById(2);
        assertEquals(null, repo.findById(2));

    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(120);
        });
    }
}