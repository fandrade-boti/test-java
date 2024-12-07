package br.com.blz.testjava

data class Product(
  val sku: Long,
  val name: String, // Nome do produto, que deve ser do tipo String
  val inventory: Inventory
) {
  val isMarketable: Boolean
    get() = inventory.quantity > 0
}

data class Inventory(
  val warehouses: List<Warehouse>
) {
  val quantity: Int
    get() = warehouses.sumOf { it.quantity }
}

data class Warehouse(
  val locality: String,
  val quantity: Int,
  val type: String
)
