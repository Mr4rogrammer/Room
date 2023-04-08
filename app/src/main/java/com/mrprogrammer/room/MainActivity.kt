package com.mrprogrammer.room

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val save = (findViewById<Button>(R.id.save))
        val text = (findViewById<TextView>(R.id.all))

        save.setOnClickListener {
            val sample = Sample(null, name = (findViewById<EditText>(R.id.data).text.toString()))
            (findViewById<EditText>(R.id.data).text.clear())
            GlobalScope.launch {
                AppDb.getInstance(this@MainActivity).Query().insert(sample)

            }
        }


        GlobalScope.launch(Dispatchers.Main) {
            AppDb.getInstance(this@MainActivity).Query().getAll().observe(this@MainActivity) {
                runOnUiThread {
                    var allText=""
                    it.forEach {
                        allText = allText + "\n"+it.name
                    }
                    text.text = allText
                }
            }

        }
    }
}