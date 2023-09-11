package com.apodaca.testing.core.data

import com.apodaca.testing.core.domain.Product
import com.apodaca.testing.core.domain.ShoppingCartCache


class ShoppingCartCacheFake: ShoppingCartCache {

    private var items = emptyList<Product>()

    override fun saveCart(items: List<Product>) {
        this.items = items
    }

    override fun loadCart(): List<Product> {
        return items
    }

    override fun clearCart() {
        items = emptyList()
    }
}