package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "American Gods", 100, "Neil Gainman");
    private Book second = new Book(2, "Anansi Boys", 200, "Neil Gainman");
    private Book third = new Book(3, "The Goldfinch", 300, "Donna Tartt");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void removeByIdIfExists() {

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdIfDoesntExist() {

        assertThrows(NotFoundException.class, () -> repository.removeById(4));
    }
}