package com.apodaca.testing.core.data

import com.apodaca.testing.core.domain.Product
import com.apodaca.testing.core.domain.ProductRepository


class ProductRepositoryFake : ProductRepository {

    private val purchasedProducts = mutableListOf<Product>()
    var shouldReturnError = false

    override suspend fun purchaseProducts(products: List<Product>): Result<Unit> {
        products.forEach {
            purchasedProducts.add(it)
        }
        return if (shouldReturnError) {
            Result.failure(Exception())
        } else Result.success(Unit)
    }

    override suspend fun cancelPurchase(purchaseId: Int): Result<Unit> {
        purchasedProducts.removeIf {
            it.id == purchaseId
        }
        return if (shouldReturnError) {
            Result.failure(Exception())
        } else Result.success(Unit)
    }
}