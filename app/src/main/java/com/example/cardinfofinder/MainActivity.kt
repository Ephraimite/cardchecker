package com.example.cardinfofinder

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.cardinfofinder.Models.CardInfoResponse
import com.example.cardinfofinder.Repositories.APIinterface
import com.example.cardinfofinder.Repositories.ApiClient.client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var info: TextView? = null
    var bank_name: TextView? = null
    var card_brand: TextView? = null
    var country: TextView? = null
    var card_type: TextView? = null
    private  lateinit var progressBar: ProgressBar
    var binNumber: String? = null
    var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        info = findViewById(R.id.card_info)
        val proceed_check:Button = findViewById(R.id.proceed_check)
        val cardNumber:EditText = findViewById(R.id.card_number)
        progressBar = findViewById(R.id.myProgressBar)


        proceed_check.setOnClickListener {
            binNumber = cardNumber.getText().toString()
            progressBar.setVisibility(View.VISIBLE)
            if (TextUtils.isEmpty(binNumber)) {
                Toast.makeText(this@MainActivity, "input card number", Toast.LENGTH_LONG).show()
                progressBar.setVisibility(View.INVISIBLE)
            } else if (binNumber!!.length < 6) {
                Toast.makeText(this@MainActivity, "card number cannot be less than 6", Toast.LENGTH_LONG).show()
                progressBar.setVisibility(View.INVISIBLE)
            } else {
                cardInformation()
                openDialog()
            }
        }
    }

    private fun cardInformation() {
        val apIinterface = client!!.create(APIinterface::class.java)

        val call = apIinterface.getCardDetails(binNumber)

        call?.enqueue(object : Callback<CardInfoResponse?> {
            override fun onResponse(call: Call<CardInfoResponse?>, response: Response<CardInfoResponse?>) {

                if (!response.isSuccessful) {
                    info!!.text = "Code:" + response.code()
                    return
                } else {

                    val cardInfo = response.body()
                    bank_name!!.text = cardInfo!!.getmBank()?.name
                    card_brand!!.text = cardInfo.getmBrand()
                    country!!.text = cardInfo.getmCountryInfo()?.name
                    card_type!!.text = cardInfo.getmType()

                    progressBar.visibility = View.INVISIBLE
                }
            }

            override fun onFailure(call: Call<CardInfoResponse?>, t: Throwable) {
                t.message
            }
        })
    }

    private fun openDialog() {
        val alert = AlertDialog.Builder(this@MainActivity)
        val view1 = layoutInflater.inflate(R.layout.custom_dialog, null)

        val alertBtn:Button = view1.findViewById(R.id.alertDialogButton)
        bank_name = view1.findViewById(R.id.bank_name)
        card_brand = view1.findViewById(R.id.card_brand)
        country = view1.findViewById(R.id.card_country)
        card_type = view1.findViewById(R.id.card_type)

        alert.setView(view1)
        alertBtn.setOnClickListener { alertDialog!!.dismiss() }

        let {  alertDialog = alert.create()}
        alertDialog?.setCanceledOnTouchOutside(false)
        alertDialog?.show()
    }


}