package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivityIslemPratikBinding
import com.google.android.gms.ads.*


class IslemPratikActivity : AppCompatActivity() {
   private lateinit var vt:VeritabaniYardimcisi
    //lateinit var mAdView : AdView

    private lateinit var tasarim: ActivityIslemPratikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityIslemPratikBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

      //  loadBannerAdd()

        tasarim.toolbarIslemPratik.title = "MATEMATİK"
        tasarim.toolbarIslemPratik.subtitle = "İşlem Pratiği"
        setSupportActionBar(tasarim.toolbarIslemPratik)


        vt = VeritabaniYardimcisi(this@IslemPratikActivity)
        val islemListe = IslemPratikDao().tumIslemler(vt)

        for (i in islemListe) {
            if (i.islem == i.islem) {
                tasarim.cardDevam.setOnClickListener {
                    val islemListe = IslemPratikDao().tumIslemler(vt)
                    for (a in islemListe) {
                        tasarim.textViewIslemGoster.text = a.islem
                        tasarim.cardKontrol.setOnClickListener {

                            if (tasarim.editTextTextGirilenIslemSonucu.text.toString() == a.islem_cevap){
                                tasarim.textViewKontrolslem.text = "Cevabınız Doğrudur :) Devam edin veya bitirin"
                            }else{
                                tasarim.textViewKontrolslem.text = "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                            }
                            tasarim.textViewKontrolslem.visibility = View.VISIBLE
                            tasarim.editTextTextGirilenIslemSonucu.setText("")

                        }
                    }
                }
            }
            tasarim.textViewIslemGoster.text = i.islem

            tasarim.cardKontrol.setOnClickListener {

                    if (tasarim.editTextTextGirilenIslemSonucu.text.toString() == i.islem_cevap){
                        tasarim.textViewKontrolslem.text = "Cevabınız Doğrudur :) Devam edin veya bitirin"
                    }else{
                        tasarim.textViewKontrolslem.text = "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                    }
                    tasarim.textViewKontrolslem.visibility = View.VISIBLE
                    tasarim.editTextTextGirilenIslemSonucu.setText("")

                }
            }


        tasarim.cardBitis.setOnClickListener {
            startActivity(Intent(this@IslemPratikActivity,BitisActivity::class.java))
            finish()
        }

    }

   /* private fun loadBannerAdd(){

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