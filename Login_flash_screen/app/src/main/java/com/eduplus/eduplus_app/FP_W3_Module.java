package com.eduplus.eduplus_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class FP_W3_Module extends AppCompatActivity {

    TextView t1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w3__module);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        t1 = (TextView) findViewById(R.id.text1);


        t1.setText(Html.fromHtml("\n" +
                        "    <p><span style=\"font-weight: 400;\">Through this activity students will learn:&nbsp;</span></p>\n" +
                        "        <p>&nbsp;</p>\n" +
                        "<ul>\n" +
                        "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">How important is it to develop savings habits in order to achieve&nbsp; your personal financial goals</span></li>\n" +
                        "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">How to keep track of your expenses</span></li>\n" +
                        "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Importance of investment inorder to generate passive income from savings</span></li>\n" +
                        "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">How to invest smartly by making their own investment portfolio</span></li>\n" +
                        "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">How to maximise returns and minimise risk</span></li>\n" +
                        "</ul>",
                Html.FROM_HTML_MODE_COMPACT));
    }
}