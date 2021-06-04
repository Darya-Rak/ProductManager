package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    private ProductRepository repository=new ProductRepository();
    private Book coreJava=new Book();

    @Test
    public void shouldSaveOneItem(){
        repository.save(coreJava);

        Product[] expected=new Product[]{coreJava};
        Product[] actual= repository.findAll();
        assertArrayEquals(expected, actual);

    }
    @Test
    void removeAll() {
        int idToRemove=1;
        repository.removeById(idToRemove);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }

}
