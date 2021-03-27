package com.eduplus.eduplus_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class FP_W2_Module extends AppCompatActivity {

    TextView t1,t2,t3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w2__module);



        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);

        t1.setText(Html.fromHtml(" <p><span style=\"font-weight: 400;\">Cash flow is nothing but movement of money </span><strong>in</strong><span style=\"font-weight: 400;\"> and </span><strong>out</strong><span style=\"font-weight: 400;\"> of your wallet. Positive cash flow indicates your net worth is increasing. Let us look at some of the sources of inflow and outflow of money:</span></p>\n",
                   Html.FROM_HTML_MODE_COMPACT));

        t2.setText(Html.fromHtml("  <p><strong><span style=\"text-decoration: underline; color: #339966;\">Assets:</span></strong></p>\n" +
                "        <p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">The sources that put money in your wallet are assets. These sources add to your income. </span><strong>Ex: </strong><span style=\"font-weight: 400; color: #993300;\">The money kept in the bank is an asset since the bank pays you interest on that money. That interest adds to your cash inflow and hence it is an asset. </span></p>\n" +
                "  ",Html.FROM_HTML_MODE_COMPACT));
    }
}