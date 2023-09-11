package com.apodaca.testing.core.domain

import com.apodaca.testing.core.domain.Product

interface ShoppingCartCache {
    fun saveCart(items: List<Product>)
    fun loadCart(): List<Product>
    fun clearCart()
}