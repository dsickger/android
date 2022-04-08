package com.example.polk.quiz

import kotlin.random.Random

object Constants {

    fun getQuestion(): ArrayList<Question>{


        val questionlist=ArrayList<Question>()

        for (i in 1 until 5){
            var a= Random.nextInt(0,1000)
            var b=Random.nextInt(0,1000)
            questionlist.add(Question(
                    i,
                    "${a}-$b",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${a-b}",
                    5
            )
            )
        }
        for (i in 1 until 5){
            var a= Random.nextInt(0,1000)
            var b=Random.nextInt(1,1000)
            questionlist.add(Question(
                    i,
                    "${a}/$b",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${a/b}",
                    5
            )
            )
        }
        for (i in 1 until 5){
            var a= Random.nextInt(0,1000)
            var b=Random.nextInt(0,1000)
            questionlist.add(Question(
                    i,
                    "${a}+$b",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${a+b}",
                    5
            )
            )
        }
        for (i in 1 until 5){
            var a= Random.nextInt(0,1000)
            var b=Random.nextInt(0,1000)
            questionlist.add(Question(
                    i,
                    "${a}*$b",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${Random.nextInt(0,1000)}",
                    "${a*b}",
                    5
            )
            )
        }









//        val question1=Question(
//            1,
//            "6-2",
//            "1",
//            "4",
//            "3",
//            "5",
//            "0",
//            2
//        )
//        questionlist.add(question1)
//
//        val question2=Question(
//            2,
//            "6+2",
//            "8",
//            "11",
//            "3",
//            "5",
//            "0",
//            1
//        )
//        questionlist.add(question2)
//        val question3=Question(
//            3,
//            "6*2",
//            "1",
//            "4",
//            "3",
//            "5",
//            "12",
//            5
//        )
//        questionlist.add(question3)

        return questionlist
    }

}