package io.github.surfla.training

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGo.setOnClickListener{
            try {
                if (inputYear.text != null){
                    val year = inputYear.text.toString().toInt()
                    val e = when(year%10){
                        0 -> arrayOf("庚","かのえ","こう")
                        1 -> arrayOf("辛","かのと","しん")
                        2 -> arrayOf("壬","みずのえ","じん")
                        3 -> arrayOf("癸","みずのと","き")
                        4 -> arrayOf("甲","きのえ","こう")
                        5 -> arrayOf("乙","きのと","おつ")
                        6 -> arrayOf("丙","ひのえ","へい")
                        7 -> arrayOf("丁","ひのと","てい")
                        8 -> arrayOf("戊","つちのえ","ぼ")
                        9 -> arrayOf("己","つちのと","き")
                        else -> arrayOf("?","????","??")
                    }
                    val to = when(year%12){
                        0  -> arrayOf("申","さる","しん")
                        1  -> arrayOf("酉","とり","ゆう")
                        2  -> arrayOf("戌","いぬ","じゅつ")
                        3  -> arrayOf("亥","い","がい")
                        4  -> arrayOf("子","ね","し")
                        5  -> arrayOf("丑","うし","ちゅう")
                        6  -> arrayOf("寅","とら","いん")
                        7  -> arrayOf("卯","う","ぼう")
                        8  -> arrayOf("辰","たつ","しん")
                        9  -> arrayOf("巳","み","し")
                        10 -> arrayOf("午","うま","ご")
                        11 -> arrayOf("未","ひつじ","び")
                        else -> arrayOf("?","?","?")
                    }
                    resultYear.text = year.toString()
                    resultEtoYomi.text = "${e[1]}${to[1]}/${e[2]}${to[2]}"
                    resultEto.text = e[0] + to[0]
                }
            }//end try
            catch (e: Exception){
                resultYear.text = "ERR"
                resultEtoYomi.text = "エラー\n${e.toString()}"
                resultEto.text = "ERR"
            }
        }//end buttonGo.setOnClickListener
    }
}
