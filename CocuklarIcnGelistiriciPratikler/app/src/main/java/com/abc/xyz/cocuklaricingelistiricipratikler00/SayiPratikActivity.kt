package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivitySayiPratikBinding

class SayiPratikActivity : AppCompatActivity() {
    private lateinit var vt: VeritabaniYardimcisi

    //lateinit var mAdView : AdView


    private lateinit var tasarim: ActivitySayiPratikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivitySayiPratikBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

       // loadBannerAdd()

        tasarim.toolbarSayiPratik.title = "MATEMATİK"
        tasarim.toolbarSayiPratik.subtitle = "Sayı Pratiği"
        setSupportActionBar(tasarim.toolbarSayiPratik)


        vt = VeritabaniYardimcisi(this@SayiPratikActivity)
        val sayiListe = SayiPratikDao().tumSayilar(vt)

        for (s in sayiListe){
            if (s.sayi == s.sayi){
                tasarim.cardDevamSayi.setOnClickListener {
                    val sayiListe = SayiPratikDao().tumSayilar(vt)
                    for (s2 in sayiListe){
                        tasarim.textViewSayiGoster.text = s2.sayi

                        tasarim.cardKontrolSayi.setOnClickListener {
                            if (tasarim.editTextTextGirilenSayi.text.toString() == s2.sayi_cevap){
                                tasarim.textViewKontrolSayi.text = "Cevabınız Doğrudur :) Devam edin veya bitirin"
                            }else{
                                tasarim.textViewKontrolSayi.text = "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                            }
                            tasarim.textViewKontrolSayi.visibility = View.VISIBLE
                            tasarim.editTextTextGirilenSayi.setText("")
                        }
                    }
                }
            }
            tasarim.textViewSayiGoster.text = s.sayi

            tasarim.cardKontrolSayi.setOnClickListener {
                if (tasarim.editTextTextGirilenSayi.text.toString() == s.sayi_cevap){
                    tasarim.textViewKontrolSayi.text = "Cevabınız Doğrudur :) Devam edin veya bitirin"
                }else{
                    tasarim.textViewKontrolSayi.text = "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                }
                tasarim.textViewKontrolSayi.visibility = View.VISIBLE
                tasarim.editTextTextGirilenSayi.setText("")
            }
        }

        tasarim.cardBitisSayi.setOnClickListener {
            startActivity(Intent(this@SayiPratikActivity,BitisActivity::class.java))
            finish()
        }

    }

  /*  private fun loadBannerAdd(){

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }

    }*/

}