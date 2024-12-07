package br.com.blz.testjava

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

  // CREATE: Criação de um novo produto
  @PostMapping
  fun createProduct(@RequestBody product: Product): ResponseEntity<Unit> {
    return try {
      productService.createProduct(product)
      ResponseEntity(HttpStatus.CREATED) // Retorna 201 Created
    } catch (e: ProductAlreadyExistsException) {
      ResponseEntity(HttpStatus.CONFLICT) // Retorna 409 Conflict se o produto já existe
    }
  }

  // UPDATE: Atualização de um produto existente pelo SKU
  @PutMapping("/{sku}")
  fun updateProduct(@PathVariable sku: Long, @RequestBody product: Product): ResponseEntity<Unit> {
    productService.updateProduct(sku, product)
    return ResponseEntity(HttpStatus.NO_CONTENT) // Retorna 204 No Content após a atualização
  }

  // READ: Recuperação de um produto específico pelo SKU
  @GetMapping("/{sku}")
  fun getProduct(@PathVariable sku: Long): ResponseEntity<Product> {
    val product = productService.getProduct(sku)
    return if (product != null) {
      ResponseEntity(product, HttpStatus.OK) // Retorna 200 OK se o produto for encontrado
    } else {
      ResponseEntity(HttpStatus.NOT_FOUND) // Retorna 404 Not Found se o produto não for encontrado
    }
  }

  // DELETE: Exclusão de um produto pelo SKU
  @DeleteMapping("/{sku}")
  fun deleteProduct(@PathVariable sku: Long): ResponseEntity<Unit> {
    productService.deleteProduct(sku)
    return ResponseEntity(HttpStatus.NO_CONTENT) // Retorna 204 No Content após exclusão bem-sucedida
  }
}
