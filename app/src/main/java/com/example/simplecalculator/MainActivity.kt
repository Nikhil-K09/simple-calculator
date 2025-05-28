package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var workingsTV:TextView
    private lateinit var resultsTV:TextView
    private var canAddOperation=false
    private var canAddDecimal=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        workingsTV=findViewById(R.id.workingsTV)
        resultsTV=findViewById(R.id.resultsTV)
    }
    fun numberAction(view: View){
        if(view is Button){
            if(view.text=="."){
                if(canAddDecimal)
                    workingsTV.append(view.text)
                canAddDecimal=false
            }else{
                workingsTV.append(view.text)
            }
            canAddOperation=true
        }
    }
    fun operatorAction(view: View){
        if(view is Button && canAddOperation){
            workingsTV.append(view.text)
            canAddOperation=false
            canAddDecimal=true
        }
    }
    fun allClearAction(view: View) {
        workingsTV.text=""
        resultsTV.text=""
    }
    fun backSpaceAction(view: View) {
        val length =workingsTV.length()
        if(length>0){
            workingsTV.text=workingsTV.text.subSequence(0,length-1)
        }
        canAddOperation=true
    }
    fun equalsAction(view: View) {
        resultsTV.text=calculateResults()
    }

    private fun calculateResults(): String {
        return ""
    }
    private fun digitsOperators():MutableList<Any>{
        val list= mutableListOf<Any>()
        var currentDigit=""

        return list
    }

}