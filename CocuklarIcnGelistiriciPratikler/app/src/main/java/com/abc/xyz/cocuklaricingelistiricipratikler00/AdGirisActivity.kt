package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivityAdGirisBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AdGirisActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivityAdGirisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityAdGirisBinding.inflate(layoutInflater)
        setContentView(tasarim.root)


        tasarim.buttonGiris.setOnClickListener {

            val ad = tasarim.editTextTakmaAd.text.toString()

            if (ad == null){
                val sp = getSharedPreferences("adTutucu",Context.MODE_PRIVATE)
                val editor = sp.edit()
                editor.putString("ad",ad)
                editor.commit()
            }else{
                val intent = Intent(this@AdGirisActivity, SecimEkraniActivity::class.java)
                intent.putExtra("ad",ad)
            }

            val sp = getSharedPreferences("adTutucu",Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("ad",ad)
            editor.commit()

            if (tasarim.editTextTakmaAd.text.isNotEmpty()) {
                cokluAnimasyon()

                val intent = Intent(this@AdGirisActivity, SecimEkraniActivity::class.java)
                intent.putExtra("ad",ad)

                runBlocking {

                    launch {
                        delay(500)
                        startActivity(intent)
                        finish()
                    }
                }

            } else {
                Toast.makeText(applicationContext,"Lütfen takma adınızı giriniz",Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun cokluAnimasyon() {
        tasarim.imageViewAdDogru.visibility = View.VISIBLE

        val resimx = ObjectAnimator.ofFloat(tasarim.imageViewAdDogru, "scaleX", 1.0f, 2.0f)
        val resimy = ObjectAnimator.ofFloat(tasarim.imageViewAdDogru, "scaleY", 1.0f, 2.0f)

        val ayniAndaAnimasyon = AnimatorSet().apply {
            duration = 0
            playTogether(resimx, resimy)
        }
        ayniAndaAnimasyon.start()
    }


}