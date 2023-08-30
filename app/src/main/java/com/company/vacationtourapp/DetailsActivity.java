package com.company.vacationtourapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class DetailsActivity extends AppCompatActivity implements PaymentResultListener {

    Button PayBtn;
    TextView PayStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Checkout.preload(getApplicationContext());

        PayBtn = findViewById(R.id.pay_btn);
        PayStatus = findViewById(R.id.pay_status);


        PayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentNow("1");
            }
        });

    }

    private void PaymentNow(String amount) {

        final Activity activity = this;

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_Q9qn16CQPSGNmR");
        checkout.setImage(R.drawable.profile);

        double finalAmount = Float.parseFloat(amount)*100;

        try {
            JSONObject options = new JSONObject();
            options.put("name", "TOURER");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#0b51c1");
            options.put("currency", "INR");
            options.put("amount", finalAmount+"");//300 X 100
            options.put("prefill.email", "chaskarvedant1@gmail.com");
            options.put("prefill.contact","8828234700");

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }



    }


    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(),"Payment Success!",Toast.LENGTH_SHORT).show();
        PayStatus.setText(s);
    }


    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),"Payment Failure!",Toast.LENGTH_SHORT).show();
        PayStatus.setText(s);
    }
}
