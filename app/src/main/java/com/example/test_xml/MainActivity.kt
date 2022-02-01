package com.example.test_xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Числа и точка
        findViewById<TextView>(R.id.tv_number_zero).setOnClickListener { pokazat_na_pole_vvoda("0",true) }
        findViewById<TextView>(R.id.tv_number_one).setOnClickListener { pokazat_na_pole_vvoda("1",true) }
        findViewById<TextView>(R.id.tv_number_two).setOnClickListener { pokazat_na_pole_vvoda("2",true) }
        findViewById<TextView>(R.id.tv_number_three).setOnClickListener { pokazat_na_pole_vvoda("3",true) }
        findViewById<TextView>(R.id.tv_number_four).setOnClickListener { pokazat_na_pole_vvoda("4",true) }
        findViewById<TextView>(R.id.tv_number_five).setOnClickListener { pokazat_na_pole_vvoda("5",true) }
        findViewById<TextView>(R.id.tv_number_six).setOnClickListener { pokazat_na_pole_vvoda("6",true) }
        findViewById<TextView>(R.id.tv_number_seven).setOnClickListener { pokazat_na_pole_vvoda("7",true) }
        findViewById<TextView>(R.id.tv_number_eight).setOnClickListener { pokazat_na_pole_vvoda("8",true) }
        findViewById<TextView>(R.id.tv_number_nine).setOnClickListener { pokazat_na_pole_vvoda("9",true) }
        findViewById<TextView>(R.id.tv_action_dot).setOnClickListener { pokazat_na_pole_vvoda(".",true) }


        //Операции
        findViewById<TextView>(R.id.tv_action_plus).setOnClickListener { pokazat_na_pole_vvoda("+",false) }
        findViewById<TextView>(R.id.tv_action_minus).setOnClickListener { pokazat_na_pole_vvoda("-",false) }
        findViewById<TextView>(R.id.tv_action_divide).setOnClickListener { pokazat_na_pole_vvoda("/",false) }
        findViewById<TextView>(R.id.tv_action_multiply).setOnClickListener { pokazat_na_pole_vvoda("*",false) }
        findViewById<TextView>(R.id.tv_action_open).setOnClickListener { pokazat_na_pole_vvoda("(",false) }
        findViewById<TextView>(R.id.tv_action_close).setOnClickListener { pokazat_na_pole_vvoda(")",false) }

        //Очистить все
        findViewById<TextView>(R.id.tv_action_clear).setOnClickListener {
            findViewById<TextView>(R.id.tv_expression).text = ""
            findViewById<TextView>(R.id.tv_result).text = ""
        }

        //Стереть 1 знак
        findViewById<TextView>(R.id.tv_action_back).setOnClickListener {
            var expression =  findViewById<TextView>(R.id.tv_expression)
            val stroka = expression.text.toString()
            if(stroka.isNotEmpty())
            {
                expression.text = stroka.substring(0,stroka.length-1)
            }
            findViewById<TextView>(R.id.tv_result).text = ""
        }

        //Вычисление
        findViewById<TextView>(R.id.tv_action_equals).setOnClickListener {
        try{
            val expression_evaluate = ExpressionBuilder(findViewById<TextView>(R.id.tv_expression).text.toString()).build()
            val result = expression_evaluate.evaluate()

            val long_result = result.toLong()

            if(result == long_result.toDouble())
                findViewById<TextView>(R.id.tv_result).text = long_result.toString()
            else
                findViewById<TextView>(R.id.tv_result).text = result.toString()

        }
        catch (e:Exception)
        {
            Log.d("Произошла ошибка!", " " + e.message)

        }
        }




    }


    fun pokazat_na_pole_vvoda(stroka: String, mozhno_ochistit: Boolean) {

        var result =findViewById<TextView>(R.id.tv_result)
        var expression =  findViewById<TextView>(R.id.tv_expression)

        if (result.text.isNotEmpty()) {
          expression.text = ""
        }
        if(mozhno_ochistit)
        {
            result.text = ""
            expression.append(stroka)
        }
        else
        {
            expression.append(result.text)
            expression.append(stroka)
            result.text = ""
        }
    }
}