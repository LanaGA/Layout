package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val values = listOf("ldpi", "mdpi", "tvdpi", "hdpi", "xhdpi")
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.values,
            R.layout.support_simple_spinner_dropdown_item,
        )
        menu.adapter = adapter
        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                result.text = transform()

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!input.text.isNullOrEmpty()) {
                    result.text = transform()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    fun transform(): String {
        return when (menu.selectedItem.toString()) {
            "ldpi" -> input.text.toString().toDouble() * 0.75
            "mdpi" -> input.text.toString().toDouble() * 1
            "tvdpi" -> input.text.toString().toDouble() * 1.33
            "hdpi" -> input.text.toString().toDouble() * 1.5
            "xhdpi" -> input.text.toString().toDouble() * 2
            else -> "Nothing"
        }.toString()

    }
}