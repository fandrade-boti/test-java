package br.com.blz.testjava

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ProductService {

    private val productMap: MutableMap<Long, Product> = ConcurrentHashMap()

    fun createProduct(product: Product) {
        if (productMap.containsKey(product.sku)) {
            throw ProductAlreadyExistsException("Product with this SKU already exists.")
        }
        productMap[product.sku] = product
    }

    fun updateProduct(sku: Long, product: Product) {
        productMap[sku] = product
    }

    fun getProduct(sku: Long): Product? {
        return productMap[sku]
    }

    fun deleteProduct(sku: Long) {
        productMap.remove(sku)
    }
}