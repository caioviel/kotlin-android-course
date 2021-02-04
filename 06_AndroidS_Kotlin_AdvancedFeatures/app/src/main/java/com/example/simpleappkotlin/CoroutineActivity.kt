package com.example.simpleappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

class CoroutineActivity : AppCompatActivity() {
    lateinit var lbl_animation : TextView
    lateinit var btn_with_coroutine : Button
    lateinit var btn_graphic_thread : Button
    lateinit var finishToast : Toast

    var listOfPerson = mutableListOf<Person>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        finishToast = Toast.makeText(this, "Finished!", Toast.LENGTH_SHORT)


        lbl_animation = findViewById(R.id.lbl_animation)
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_rotate)
        lbl_animation.startAnimation(animation)

        btn_with_coroutine = findViewById(R.id.btn_with_coroutine)
        btn_with_coroutine.setOnClickListener { _ -> onBtnWithCoroutine() }

        btn_graphic_thread = findViewById(R.id.btn_graphic_thread)
        btn_graphic_thread.setOnClickListener { _ -> onBtnGraphicThread() }
    }

    private fun onBtnGraphicThread() {
        listOfPerson.clear()

        for (index in 1 .. 1000000) {
            listOfPerson.add(Person(
                "Nome $index",
                "Sobrenome $index",
                Random.nextInt(18,80))
            )
        }

        finishToast.show()
    }

    private fun onBtnWithCoroutine() {
        GlobalScope.launch {
            for (index in 1 .. 1000000) {
                listOfPerson.add(Person(
                    "Nome $index",
                    "Sobrenome $index",
                    Random.nextInt(18,80))
                )
            }
            runOnUiThread {
                finishToast.show()
            }
        }

    }
}