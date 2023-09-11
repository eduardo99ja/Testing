package com.apodaca.testing.core.domain

import com.apodaca.testing.core.domain.Product

interface ProductRepository {
    suspend fun purchaseProducts(products: List<Product>): Result<Unit>
    suspend fun cancelPurchase(purchaseId: Int): Result<Unit>
}