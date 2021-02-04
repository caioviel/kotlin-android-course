package com.example.simpleappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_coroutine).setOnClickListener { _ ->
            run {
                val intent = Intent(this, CoroutineActivity::class.java)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.btn_scoped_functions).setOnClickListener { _ ->
            run {
                val intent = Intent(this, ScopeFunActivity::class.java)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.btn_extensions_delegates).setOnClickListener { _ ->
            run {
                val intent = Intent(this, ExtensionDelegateActivity::class.java)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.btn_ho_functions).setOnClickListener { _ ->
            run {
                val intent = Intent(this, HighOrderFunctionsActivity::class.java)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.btn_generics).setOnClickListener { _ ->
            run {
                val intent = Intent(this, GenericActivity::class.java)
                startActivity(intent)
            }
        }
    }
}