package br.com.blz.testjava

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import org.springframework.http.HttpStatus
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductControllerTest {

  @Mock
  private lateinit var productService: ProductService

  @InjectMocks
  private lateinit var productController: ProductController

  @BeforeEach
  fun setUp() {
    MockitoAnnotations.openMocks(this)
  }

  @Test
  fun `should calculate inventory quantity correctly`() {
    // Simulando o produto esperado
    val product = Product(
      sku = 1L,
      name = "Produto Teste",
      inventory = Inventory(listOf(
        Warehouse("SP", 5, "ECOMMERCE"),
        Warehouse("RJ", 3, "PHYSICAL_STORE")
      ))
    )

    // Configurando o comportamento do mock
    whenever(productService.getProduct(1L)).thenReturn(product)

    // Invocando o método de teste
    val response = productController.getProduct(1L)
    val inventoryQuantity = response.body?.inventory?.quantity

    // Asserções
    assertEquals(8, inventoryQuantity)
    assertEquals(HttpStatus.OK, response.statusCode)
  }

}
