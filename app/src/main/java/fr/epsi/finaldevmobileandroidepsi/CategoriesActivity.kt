package fr.epsi.finaldevmobileandroidepsi

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle("Rayons")
        showBackButton()

        val categories = arrayListOf<Category>()
        val recyclerviewCategories = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerviewCategories.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoryAdapter(categories)
        recyclerviewCategories.adapter = categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = "https://www.ugarit.online/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if (data != null) {
                    val jsCategories = JSONObject(data)
                    val jsArrayCategories = jsCategories.getJSONArray("items")
                    for (i in 0 until jsArrayCategories.length()) {
                        val js = jsArrayCategories.getJSONObject(i)
                        val category = Category(
                            js.optString("category_id", "not found"),
                            js.optString("title", "not found"),
                            js.optString("products_url", "not found")
                        )
                        categories.add(category)
                        runOnUiThread(Runnable {
                            categoryAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }

        })
    }
}