package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivityBitisBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class BitisActivity : AppCompatActivity() {

   // private var mInterstitialAd: InterstitialAd? = null

    private lateinit var tasarim: ActivityBitisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityBitisBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

       // loadinterAdd()


        tasarim.textViewAdBitis.text = "Daha başarılı olman için her gün düzenli bir şekilde pratik yapabilirsin :)"  //$ad"

        tasarim.buttonTekrarDene.setOnClickListener {

            val intent = Intent(this@BitisActivity,SecimEkraniActivity::class.java)
            startActivity(intent)

        }


      /*  val interAdBtn : Button = findViewById(R.id.buttonTekrarDene)

        interAdBtn.setOnClickListener {

            showInterAd()

        } */

    }

  /*  private fun showInterAd() {
        if (mInterstitialAd != null){
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback(){
                override fun onAdClicked() {
                    super.onAdClicked()
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)
                    val intent = Intent(this@BitisActivity,SecimEkraniActivity::class.java)
                    startActivity(intent)
                }

                override fun onAdImpression() {
                    super.onAdImpression()
                }

                override fun onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent()
                }


            }
            mInterstitialAd?.show(this)

        }else{
            val intent = Intent(this,SecimEkraniActivity::class.java)
            startActivity(intent)

        }

    }

    private fun loadinterAdd(){
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
    } */

}