package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "кровать", 150_000);
        Product product2 = new Product(50, "торшер", 11_000);
        Product product3 = new Product(267, "гардеробная", 300_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(50);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "кровать", 150_000);
        Product product2 = new Product(50, "торшер", 11_000);
        Product product3 = new Product(267, "гардеробная", 300_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(15)
        );
    }
}