package fr.epsi.finaldevmobileandroidepsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val title: String? = intent.extras!!.getString("title")
        setHeaderTitle(title.toString())
        showBackButton()

        val products = arrayListOf<Product>()
        val recyclerviewProducts = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerviewProducts.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter(products)
        recyclerviewProducts.adapter = productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = intent.extras!!.getString("url")
        val request = Request.Builder()
            .url(mRequestURL.toString())
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if (data != null) {
                    val jsProducts = JSONObject(data)
                    val jsArrayProducts = jsProducts.getJSONArray("items")
                    for (i in 0 until jsArrayProducts.length()) {
                        val js = jsArrayProducts.getJSONObject(i)
                        val product = Product(
                            js.optString("name", "not found"),
                            js.optString("description", "not found"),
                            js.optString("picture_url", "not found")
                        )
                        products.add(product)
                        runOnUiThread(Runnable {
                            productAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }

        })

    }
}