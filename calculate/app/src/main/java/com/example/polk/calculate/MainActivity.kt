package com.example.polk.calculate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i=0
        var s:String=""
        btn_0.setOnClickListener { setTextFields("0") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener {

                setTextFields("9") }

        btn_minus.setOnClickListener {

                setTextFields("-") }
        btn_plus.setOnClickListener { setTextFields("+") }
        btn_mult.setOnClickListener { setTextFields("*") }
        btn_div.setOnClickListener { setTextFields("/") }

        btn_leftbracket.setOnClickListener {
            setTextFields("(")
    }
        btn_rightbracket.setOnClickListener {
            setTextFields(")") }

        btn_ac.setOnClickListener {
            operation.text=""
            result.text=""
        }


        btn_back.setOnClickListener {
            val str = operation.text.toString()
            if (str.isNotEmpty())
                operation.text=str.substring(0,str.length-1)
            result.text=""
        }



        btn_res.setOnClickListener {
            try {
                val ex = ExpressionBuilder(operation.text.toString()).build()
                val r=ex.evaluate()

                val longr=r.toLong()
                if(r==longr.toDouble())
                    result.text=longr.toString()
                else
                    result.text=r.toString()
            }
            catch (e:Exception)
            {
                Log.d("ошибка", "сщщбщение: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {

        if(result.text!="")
        {
            operation.text=result.text
            result.text=""
        }
        operation.append(str)
    }
}