package com.apodaca.testing.shopping.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.apodaca.testing.shopping.domain.Product
import com.apodaca.testing.shopping.domain.ShoppingCartCache

class ShoppingCartCacheImpl(
    private val sharedPreferences: SharedPreferences
): ShoppingCartCache {

    override fun saveCart(items: List<Product>) {
        sharedPreferences.edit()
            .putString("shopping_cart", Gson().toJson(items))
            .apply()
    }

    override fun loadCart(): List<Product> {
        val json = sharedPreferences.getString("shopping_cart", null)
        return json?.let {
            Gson().fromJson(it, object : TypeToken<ArrayList<String>>() {}.type)
        } ?: emptyList()
    }

    override fun clearCart() {
        sharedPreferences.edit().clear().apply()
    }
}