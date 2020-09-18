package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/18
 */
interface Factory<Name, Product : Producible<Name>> {

    fun create(name: Name): Product
}

interface Producible<Name> {

    val productName: Array<out Name>
}

fun <Name, Product> Array<Product>.toFactory(): Factory<Name, Product>
    where Product : Producible<Name> {
    val map = mutableMapOf<Name, Product>()
    this.forEach { product ->
        product.productName.forEach { name ->
            map[name] = product
        }
    }
    return object : Factory<Name, Product> {

        override fun create(name: Name): Product {
            return map[name]!!
        }
    }
}
