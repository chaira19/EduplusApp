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

public class FP_W4_Module extends AppCompatActivity {

    TextView t1,t2,t3,t4, t5,t6,t7;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w4__module);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
*/
        ImageView toolbarLeft = (ImageView) findViewById(R.id.leftNavigate);
        toolbarLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("SkillPage", "FP_W3_Module").apply();
                sharedPreferences.edit().commit();
                startActivity(new Intent(FP_W4_Module.this, FP_W3_Module.class));
                finish();
            }
        });

        ImageView toolbarLRight = (ImageView) findViewById(R.id.rightNavigate);
        toolbarLRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FP_W4_Module.this, SkillContent.class));
                finish();
            }
        });

        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);
        t4 = (TextView) findViewById(R.id.text4);
        t5 = (TextView) findViewById(R.id.text5);
        t6 = (TextView) findViewById(R.id.text6);
        t7 = (TextView) findViewById(R.id.text7);


        t1.setText(Html.fromHtml("<p><span style=\"font-weight: 400;\">Let us understand about insurance with the help of an example:&nbsp;</span></p>\n" +
                "<br />\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Consider there are 40 kids in a class. At the beginning of the year, the teacher asks everyone to pay 10 Rs into her bowl.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">She told all her students that if anyone got stung by a bee, he or she can take 50 Rs from the bowl to buy medicine.</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Let say this year, 5 kids got stung buy the bee, the teacher will give 20*5 = 250 Rs to them to buy the medicine and the remaining money, that is, 40*10 - 250 = 150 will be kept for the future. This way next year she will have&nbsp; 40*10 + 150 = 550 Rs.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">In case if a crazy year of bee stung happens and 10 students get stung by the bee, the teacher can pay for everyone's medical expenses.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "        <p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">In this example the students are being </span><strong>insured</strong><span style=\"font-weight: 400;\">, that is, if in case they get stung by the bee, their medical expenses will be covered by the teacher who, in this case, is the </span><strong>insurer</strong><span style=\"font-weight: 400;\">. Also, paying 10 Rs every year will make them less nervous, as now they will be able to afford the 50 Rs medicine in case of emergency. This 10 Rs is called the </span><strong>premium of the insurance</strong><span style=\"font-weight: 400;\">.&nbsp;&nbsp;</span></p>\n" +
                "<br />\n" +
                "<p><strong>In formal terms:</strong><span style=\"font-weight: 400;\">&nbsp; Insurance is a legal agreement between two parties where the insurance company(insurer) promises to cover the losses of the individual(insured). These losses can be death of the individual, damage or destruction of the property, etc. The individual pays a premium in return of the promise made by the insurer.&nbsp;&nbsp;</span></p>\n" +
                "<br />\n" +
                "<p><span style=\"text-decoration: underline;\"><span style=\"color: #008000;\"><strong>Why is Insurance important?</strong></span></span></p>\n" +
                "<br />\n" +
                "<p><span style=\"font-weight: 400;\">As we move through life, the importance of insurance in a long term plan increases because insurance is all about providing financial security to yourself and to your loved ones. Let us look at four key reasons why insurance is important:&nbsp;</span></p>\n ", Html.FROM_HTML_MODE_COMPACT));

        t2.setText(Html.fromHtml(" <p><span style=\"text-decoration:underline; color: #008000;\"><strong>Types of Insurance</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">There are various types of insurances that are available, but in this module we will cover the 2 most important ones:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Life Insurance&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p><span style=\"font-weight: 400;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&amp;</span></p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Health Insurance&nbsp;</span></li>\n" +
                "</ul>\n" +
                "        <p>&nbsp;</p>\n" +
                "<p><strong>Life Insurance:&nbsp;</strong></p>\n" +
                "\n" +
                "<p><span style=\"font-weight: 400;\">As the name suggests, life insurance is the insurance on your life. You buy life insurance to ensure that in case of your untimely demise, your family will be financially secured. It becomes even more important if you are the only earning member and your whole family is financially dependent upon you for their living. Life insurance is the best investment that you can make because it protects you and your family from financial hardships if something unexpected happens.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "        <p><span style=\"text-decoration:underline; color: #666666;\"><strong>Example of a Life insurance policy:\n" +
                "</strong></span></p>\n" +
                "<p><span style=\"font-weight: 400;\">Let us consider an example where&nbsp; a bank &ldquo;B&rdquo; offers a life cover of 1 crore Rs upto 70 years and has a claim settlement ratio of 98%. All this at a premium of 600 Rs./month.&nbsp;&nbsp;</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t3.setText(Html.fromHtml(" <p><span style=\"font-weight: 400;\">Let us understand what each of these term means:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Life Cover:</strong><span style=\"font-weight: 400;\"> This is the amount that the insurance company will provide to your family in case of your untimely death. In this example, the amount of life cover is 1cr Rs.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Premium:</strong><span style=\"font-weight: 400;\"> This is the amount you will have to pay to the insurance company in the form of monthly installment. In the above example that amount is 600 Rs/month.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Limit:</strong><span style=\"font-weight: 400;\"> It is the maximum age of the individual upot which he can claim the insurance amount. In this example, if the person died after he or she is 70 years of age, they won&rsquo;t be able to claim the insurance money.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Claim Settlement Ratio(CSR):</strong><span style=\"font-weight: 400;\"> It is defined as the percentage of insurance claims settled by the company to the total number of claims received by them. Insurance claims can be rejected under certain conditions such as death due to suicide, drug overdose, or by accident due to intoxication. Under these conditions the claim does not come under any valid category and is rejected by the insurance company. </span><strong>For Ex:</strong><span style=\"font-weight: 400;\"> In the above scenario, the CSR is 98% which means that out of every 100 claims, 98 are paid by the insurer and remaining 2 are rejected.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Note: </strong><span style=\"font-weight: 400;\">Getting your life insurance early is very beneficial because when you are in your 20&rsquo;s, the premium of insurance policy is generally low and the life cover is high.&nbsp;</span></p>\n" +
                "<p><br /><br /></p>\n" +
                "<p><strong>Health Insurance:&nbsp;</strong></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Health insurance covers medical expenses that arise due to an illness. These expenses could be doctor&rsquo;s consultation fees, medicine or hospitalization expenses.&nbsp;</span></p>"
                , Html.FROM_HTML_MODE_COMPACT));

        t4.setText(Html.fromHtml("<p><strong>Need for health insurance:</strong><span style=\"font-weight: 400;\"> A serious illness can strike anyone at any time. Also, the cost of treating severe illness can cause a serious financial impact on the savings you have accumulated over time.&nbsp; Treatment of a disease like cancer can take upto 25 Lakhs of Rs. Spending such a huge amount means you might have to compromise on your child&rsquo;s quality education, or your retirement plans, which is not the kind of future you would want for yourself and your family. So getting a health insurance cover is a great way to secure yourself from any kind of medical expenses that may arise due to severe illness.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Following are the tips on how to choose a good health insurance:&nbsp;</strong></p>\n" +
                "\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><span style=\"font-weight: 400;\">The insurance must cover protection against a large number of diseases.&nbsp;</span></li>\n" +
                "<li><span style=\"font-weight: 400;\">Policy cover should be long enough to cover you even in your old age.&nbsp;</span></li>\n" +
                "<li><span style=\"font-weight: 400;\">You should have the flexibility to choose your health cover.&nbsp;</span></li>\n" +
                "<li><span style=\"font-weight: 400;\">You should be able to claim your insurance across a large hospital network.&nbsp;</span></li>\n" +
                "</ul> "
                , Html.FROM_HTML_MODE_COMPACT));

        t5.setText(Html.fromHtml("<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>O.M.G: Official money guide for Teenagers (by Susan &amp; Michael beacham)</strong></li>\n" +
                "</ul> ", Html.FROM_HTML_MODE_COMPACT));

        t6.setText(Html.fromHtml("<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Rich Dad Poor Dad (by Robert Kiyosaki)</strong></li>\n" +
                "</ul> ", Html.FROM_HTML_MODE_COMPACT));

        t7.setText(Html.fromHtml("<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Financial Basics: A money management guide for students (by Susan Knox)</strong></li>\n" +
                "</ul>", Html.FROM_HTML_MODE_COMPACT));
    }
}