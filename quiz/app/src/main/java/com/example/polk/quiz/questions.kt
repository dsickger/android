package com.example.polk.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_questions.*

class questions : AppCompatActivity() {


    private var currentposition:Int=1
    private var questionlist:ArrayList<Question>?=null
    private var selectoption:Int=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


        questionlist=Constants.getQuestion()
        setQuestion()

        take_1.setOnClickListener { onClick(take_1) }
        take_2.setOnClickListener { onClick(take_2) }
        take_3.setOnClickListener { onClick(take_3) }
        take_4.setOnClickListener { onClick(take_4)}
        take_5.setOnClickListener { onClick(take_5) }
        submit.setOnClickListener { onClick(submit) }

    }




    @SuppressLint("SetTextI18n")
    private fun setQuestion()
    {
        val q=questionlist!!.get(currentposition-1)

        defaultoption()

        if(currentposition==questionlist!!.size)
        {
            submit.text="finish"
        }

        else
        {
            submit.text="submit"
        }

        progress.progress=currentposition
        tv_progress.text="$currentposition"+"/"+progress.max
        quest.text=q.q
        take_1.text=q.one
        take_2.text=q.two
        take_3.text=q.three
        take_4.text=q.four
        take_5.text=q.five

    }

     @SuppressLint("SetTextI18n")
     fun onClick(v: View?){

       if(v!=null) {
           when (v.id) {
               R.id.take_1 -> {
                   selectedOption(take_1, 1)
               }
               R.id.take_2 -> {
                   selectedOption(take_2, 2)
               }
               R.id.take_3 -> {
                   selectedOption(take_3, 3)
               }
               R.id.take_4 -> {
                   selectedOption(take_4, 4)
               }
               R.id.take_5 -> {
                   selectedOption(take_5, 5)
               }


               R.id.submit -> {
                   if(submit.text=="next") {
                       currentposition++
                       setQuestion()
                   }
                   else {
                       if (selectoption == 0) {
                           when {
                               currentposition <= questionlist!!.size -> {
                                   setQuestion()
                               }
                               else -> {
                                   Toast.makeText(this, "complete", Toast.LENGTH_SHORT).show()
                                   val intent = Intent(this, MainActivity::class.java)
                                   startActivity(intent)
                               }
                           }

                       } else {

                           val question = questionlist?.get(currentposition - 1)
                           if (question!!.correct != selectoption) {

                               answerView(selectoption)

                           }
                           answerCorrect(question.correct)
                           if (currentposition == questionlist!!.size) {
                               submit.text = "finish"
                           } else {
                               submit.text = "next"
                           }
                           selectoption = 0
                       }
                   }
               }
           }
       }
    }






    private fun defaultoption()
    {
        val options= ArrayList<TextView>()
        options.add(0,take_1)
        options.add(1,take_2)
        options.add(2,take_3)
        options.add(3,take_4)
        options.add(4,take_5)

        for(o in options){
            o.setBackgroundColor(Color.GRAY)

    }
    }


    private fun selectedOption(tv:TextView, selectedOptionNumber:Int){

        defaultoption()
        selectoption=selectedOptionNumber
        tv.setBackgroundColor(Color.BLUE)
    }

    private fun answerView(answer:Int)
    {
        when(answer){
            1->
            {
                take_1.setBackgroundColor(Color.RED)
            }
            2->
            {
                take_2.setBackgroundColor(Color.RED)
            }
            3->
            {
                take_3.setBackgroundColor(Color.RED)
            }
            4->
            {
                take_4.setBackgroundColor(Color.RED)
            }
            5->
            {
                take_5.setBackgroundColor(Color.RED)
            }
        }
    }

    private fun answerCorrect (answer:Int)
    {
        when(answer){
            1->
            {
                take_1.setBackgroundColor(Color.GREEN)
            }
            2->
            {
                take_2.setBackgroundColor(Color.GREEN)
            }
            3->
            {
                take_3.setBackgroundColor(Color.GREEN)
            }
            4->
            {
                take_4.setBackgroundColor(Color.GREEN)
            }
            5->
            {
                take_5.setBackgroundColor(Color.GREEN)
            }
        }
    }


}