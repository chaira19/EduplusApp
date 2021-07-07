package com.eduplus.eduplus_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class FP_W3_Module extends AppCompatActivity {

    TextView t1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w3__module);
       /* getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
*/
        ImageView toolbarLeft = (ImageView) findViewById(R.id.leftNavigate);
        toolbarLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("SkillPage", "FP_W2_Module").apply();
                sharedPreferences.edit().commit();
                startActivity(new Intent(FP_W3_Module.this, FP_W2_Module.class));
                finish();
            }
        });

        ImageView toolbarLRight = (ImageView) findViewById(R.id.rightNavigate);
        toolbarLRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("SkillPage", "FP_W4_Module").apply();
                sharedPreferences.edit().commit();
                startActivity(new Intent(FP_W3_Module.this, FP_W4_Module.class));
                finish();
            }
        });

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