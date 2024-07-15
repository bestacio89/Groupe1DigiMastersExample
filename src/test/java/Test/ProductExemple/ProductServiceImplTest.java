package Test.ProductExemple;

import org.ProductExample.Entites.Model.Product;
import org.ProductExample.Repository.ProductRepository;
import org.ProductExample.Service.ProductService;
import org.ProductExample.Service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepositoryMock;

    private Validator validator;

    private ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        productService = new ProductServiceImpl();
    }

    @Test
    public void testFindAll() {
        // Given
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product 1");
        product1.setDescription("Description 1");
        productList.add(product1);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Product 2");
        product2.setDescription("Description 2");
        productList.add(product2);

        when(productRepositoryMock.findAll()).thenReturn(productList);

        // When
        List<Product> result = productService.findAll();

        // Then
        assertEquals(2, result.size());
        assertEquals(productList, result);
    }

    @Test
    public void testFindById() {
        // Given
        Long productId = 1L;

        Product product = new Product();
        product.setId(productId);
        product.setName("Product 1");
        product.setDescription("Description 1");

        when(productRepositoryMock.findById(productId)).thenReturn(product);

        // When
        Optional<Product> result = productService.findById(productId);

        // Then
        assertEquals(product, result.orElse(null));
    }

    @Test
    public void testSave() {
        // Given
        Product productToSave = new Product();
        productToSave.setName("Product 1");
        productToSave.setDescription("Description 1");

        when(productRepositoryMock.save(any(Product.class))).thenReturn(productToSave);

        // When
        Product savedProduct = productService.save(productToSave);

        // Then
        assertEquals("Product 1", savedProduct.getName());
        assertEquals("Description 1", savedProduct.getDescription());
    }

    @Test
    public void testSaveWithValidation() {
        // Given
        Product invalidProduct = new Product();
        invalidProduct.setName(""); // Invalid because of @Size constraint
        invalidProduct.setDescription(""); // Invalid because of @Size constraint

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productService.save(invalidProduct);
        });

        // Then
        String expectedMessage = "Validation failed for";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testDeleteById() {
        // Given
        Long productId = 1L;

        // When
        productService.deleteById(productId);

        // Then
        verify(productRepositoryMock, times(1)).deleteById(productId);
    }

    private void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Condition is not true");
        }
    }
}
