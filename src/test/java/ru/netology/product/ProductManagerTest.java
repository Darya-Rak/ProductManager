package ru.netology.product;

import org.junit.Before;
import org.junit.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
     private ProductRepository repository= new ProductRepository();
     private ProductManager manager= new ProductManager(repository);

     Product book1=new Book(1,"Book1",400,"Author1");
     Product book2=new Book(2,"Book2",300,"Author2");
     Product book3=new Book(3,"Book3",200, "Author3");
     Product smartphone1 =new Smartphone(5,"Smartphone1",4000,"Producer1");
     Product smartphone2 =new Smartphone(6,"Smartphone2",5000,"Producer2");
     Product smartphone3 =new Smartphone(7,"Smartphone3",8000,"Producer3");

    @Before
    public void addProduct(){
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }
    @Test
    public void shouldSearchByBookName(){
        Product[] actual=manager.searchBy("Book1");
        Product[] expected= new Product[]{book1};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByAuthor(){
        Product[] actual=manager.searchBy("Author2");
        Product[] expected= new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName(){
        Product[] actual=manager.searchBy("Smartphone3");
        Product[] expected= new Product[]{smartphone3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByProducer(){
        Product[] actual=manager.searchBy("Producer1");
        Product[] expected= new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNotBook() {
        Product[] actual = manager.searchBy("Book4");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }



}
