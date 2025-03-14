package com.eduplus.eduplus_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class FP_W1_Module extends AppCompatActivity {


    TextView t1,t2,t3,t4, t5,t6,t7;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w1__module);

        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
*/
        ImageView toolbarLeft = (ImageView) findViewById(R.id.leftNavigate);
        toolbarLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FP_W1_Module.this, SkillFP.class));
                finish();
            }
        });

        ImageView toolbarLRight = (ImageView) findViewById(R.id.rightNavigate);
        toolbarLRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("SkillPage", "FP_W2_Module").apply();
                sharedPreferences.edit().commit();
                startActivity(new Intent(FP_W1_Module.this, FP_W2_Module.class));
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

        t1.setText(Html.fromHtml(" <p><span style=\"font-weight: 400;\">Personal finance is all about managing your money and meeting your financial goals. Let us consider an example to understand this concept:&#xA0;</span></p>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <p><span style=\"font-weight: 400;\">Consider a scenario where you receive a pocket money of 500 INR every week. Now, you are supposed to meet all your expenses such as buying stationary, spending it on friends birthday parties, dining out with your friends, etc within this amount of money. You found out that your old cricket bat is broken and you want to buy a new one worth RS. 2000. You decided to buy the Bat next month. There are two ways you can achieve your goal:&#xA0;</span></p>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <ol>\n" +
                "            <li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Either you completely cut down all your expenses for the next month.&#xA0;</span></li>\n" +
                "        </ol>\n" +
                "        <p style=\"text-align: center;\"><strong>Or</strong></p>\n" +
                "        <ol>\n" +
                "            <li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">You can start saving some part of your pocket money (30%) from this month itself in order to meet the requirement for the next month.&#xA0;</span></li>\n" +
                "        </ol>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <p><span style=\"font-weight: 400;\">Now, in both the scenarios you will be able to buy the bat, but completely cutting down on your expenses would mean that you&#8217;ll not be well prepared for any emergency situation. What if you have to buy a textbook to prepare for your exams? What if you want to buy a gift for your best friend&#8217;s birthday? See, following the first method doesn&#8217;t prepare you for all these situations. Method 2 on the other hand will allow you to operate on 70% of your pocket money since you are already saving money from the previous month. Yes, you will have to cut down on some unnecessary expenses, you will have to plan your monthly expenses and this is what we call </span><strong>Financial planning.</strong><span style=\"font-weight: 400;\">&#xA0;</span></p>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <p><span style=\"font-weight: 400;\">Planning your personal finances beforehand have several benefits such as, it makes you ready for an emergency situation, it prepares you for the ups and downs of the future. Some of the well known benefits of financial literacy are described in the chart below:&#xA0;</span></p>\n" +
                "    ", Html.FROM_HTML_MODE_COMPACT));

        t2.setText(Html.fromHtml("<p style=\"text-align: justify;\">Financial planning also involves setting up personal financial goals that you want&#xA0; to achieve. To take control of the financial life one requires planning and that starts with setting goals. In this section we will discuss some of the ways in which you can set your financial goals.&#xA0;</p>\n" +
                "        <p style=\"text-align: justify;\">&#xA0;</p>\n" +
                "        <p style=\"text-align: justify;\"><span style=\"text-decoration: underline; color: #008000;\"><strong>SMART Goals:</strong></span></p>\n" +
                "        <p style=\"text-align: justify;\">&#xA0;</p>\n" +
                "        <p style=\"text-align: justify;\"><span style=\"font-weight: 400;\">When it comes to setting goals, be it any life goal or financial goal, you can follow the SMART goal strategy. For any goal to be S.M.A.R.T it need to fulfill certain conditions that are as follows:</span></p>\n" +
                "        <p style=\"text-align: justify;\"><span style=\"font-weight: 400;\">The goal must be Specific, Measurable, Attainable, Relevant and Time based. Before setting any goal you should judge it on these basis. </span><strong>For Ex:</strong><span style=\"font-weight: 400;\"> Consider the above case where you wanted to buy a cricket bat, now let us analyse whether this goal is SMART or not. Let us begin by asking the following questions:&#xA0;</span></p>\n" +
                "        <ul>\n" +
                "        <li style=\"font-weight: 400; text-align: left;\"><strong>Is it Specific?</strong><span style=\"font-weight: 400;\">&#xA0;</span></li>\n" +
                "        <ul>\n" +
                "        <li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">I want a cricket bat v/s I want a cricket bat worth RS 2000 next month as my old bat is broken. The latter is more specific and a better way to set well defined goals.&#xA0;</span></li>\n" +
                "        </ul>\n" +
                "        </ul>", Html.FROM_HTML_MODE_COMPACT));

        t3.setText(Html.fromHtml("<p>&#xA0;</p>\n" +
                "        <ul>\n" +
                "        <li><strong>Is it Measurable?</strong>\n" +
                "        <ul>\n" +
                "        <li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Since you have to buy the bat next month, if you save 250 RS every week for 2 months, you will be able to buy it. If you can measure your progress this way, it will help you stay focused and motivated.&#xA0;</span></li>\n" +
                "        </ul>\n" +
                "        </li>\n" +
                "        </ul>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <ul>\n" +
                "        <li><strong><strong>Is it Attainable and Relevant</strong></strong>\n" +
                "        <ul>\n" +
                "        <li><span style=\"font-weight: 400;\">Is your goal attainable? Do you have the time, money and resources to achieve it? And is it relevant? Do you really need to buy a cricket bat or maybe you can play with your friend&#8217;s bat if you don&#8217;t play that often. Considering these questions will save you a lot of time, money and efforts.&#xA0;</span></li>\n" +
                "        </ul>\n" +
                "        </li>\n" +
                "        </ul>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <ul>\n" +
                "        <li><strong><strong>Is your goal Time based?</strong></strong>\n" +
                "        <ul>\n" +
                "        <li>Time is money. Set deadlines for your goals and try to achieve it within the specified time.&#xA0;</li>\n" +
                "        </ul>\n" +
                "        </li>\n" +
                "        </ul>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <p><span style=\"text-decoration: underline;\"><span style=\"color: #008000; text-decoration: underline;\"><strong>Personal Finance Strategies:</strong><span style=\"font-weight: 400;\">&#xA0;</span></span></span></p>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <p><span style=\"font-weight: 400;\">The sooner you start financial planning the better it is. But it is never too late to create your financial goals to give yourself a sense of financial freedom. In this section we will discuss some of the strategies that will help you keep track of your goals.&#xA0;</span></p>\n" +
                "        <p>&#xA0;</p>\n" +
                "        <ol>\n" +
                "        <li><strong>Make a Budget: </strong><span style=\"font-weight: 400;\">Budgeting helps you control your spending, track your expenses and increases your savings. It also helps you make better financial decisions, get out of debt, prepare for emergencies, and meet your long term financial goals. The 50/30/20 budgeting framework is a great example, it breaks down like this:</span></li>\n" +
                "        </ol>", Html.FROM_HTML_MODE_COMPACT));

        t4.setText(Html.fromHtml("<p><span style=\"font-weight: 400;\">Let us fit this framework in the above mentioned scenario of cricket bat:</span></p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Maximum 50% of your pocket money goes towards meeting your essential requirements such as buying your stationary, commutation expenses, e.t.c&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">30% of your pocket money will cover your lifestyle expenses such as dining out,attending birthday parties, e.t.c.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">And at least 20% of your pocket money you can save to buy a cricket bat.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>Just like the above example you can also create your own budgeting framework that fits your requirements and goals. Later in this module you will create your own budgeting framework that will help you achieve your financial goal.&nbsp;&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Maintain your personal Savings Statement:&nbsp;</strong><span style=\"font-weight: 400;\">Your personal savings statement is nothing but a list of all your expenses and income. It helps to keep track of your expenses and maximise your savings. By comparing your current savings statement with the savings statement of your previous years, you can keep track of your financial progress. Your net expense minus your income will be your </span><strong>Net savings</strong><span style=\"font-weight: 400;\"> for that period.</span><strong><span style=\"font-weight: 400;\">&nbsp;</span></strong></li>\n" +
                "</ul>\n" +
                "<p><span style=\"font-weight: 400;\">&nbsp; &nbsp; &nbsp;&nbsp;</span></p>\n" +
                "<p style=\"text-align: center;\"><span style=\"font-weight: 400;\">&nbsp;&nbsp;<strong>&nbsp;&nbsp;</strong></span><strong>Net Savings =&nbsp; Income - Expenses</strong></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Let us look at the savings statement of Joe, who is a college student,&nbsp; and estimate his net savings for this month:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p style=\"text-align: center;\"><strong>&nbsp;Joe&rsquo;s&nbsp; Savings Statement for the current month</strong></p>", Html.FROM_HTML_MODE_COMPACT));

        t5.setText(Html.fromHtml("<p><span style=\"font-weight: 400;\">Maximise your savings by calculating your current savings and &nbsp; comparing it with that of previous months</span></p>\n" +
                "<p><span style=\"font-weight: 400;\">&nbsp;</span></p>\n" +
                "<ul>\n" +
                "<li><strong>Develop Saving Habits:</strong>&nbsp;&nbsp;The key to achieve your money goals is to build a collection of smaller everyday habits. Let us look at some of the smaller habits you can develop today that will eventually help you grow your money.</li>\n" +
                "</ul>", Html.FROM_HTML_MODE_COMPACT));

        t6.setText(Html.fromHtml("  <ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Reviewing your monthly bills can help you cut down on your unnecessary expenses</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Maximising your tax savings can help you repay your past debts</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">It&rsquo;s very important to set aside some money for unexpected expenses such as medical emergencies, a big car car repair, e.t.c.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Record everything that you purchase on a weekly basis so that you can look back on each expenditure.&nbsp;</span></li>\n" +
                "</ul>", Html.FROM_HTML_MODE_COMPACT));

        t7.setText(Html.fromHtml("<ul>\n" +
                "<li style=\"font-weight: 400;\">\n" +
                "<p><span style=\"font-weight: 400;\">Understanding your money personality is the first step towards financial health. We have listed down some of the extreme behaviours and the traits associated with them that people show when it comes to money. Most of the people don&rsquo;t exhibit these extremes most of the time, rather they have traits of each of these behaviours.&nbsp;</span></p>\n" +
                "<br />\n" +
                "<p><strong>Fun Activity:</strong><span style=\"font-weight: 400;\">&nbsp;</span></p>\n" +
                "<p><span style=\"font-weight: 400;\">Take the questionnaire given below to identify your money personality. Answer each question as per the instruction and at the end you will receive a score that will indicate which money personality best describes you.</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #339966;\"><a style=\"color: #339966;\" href=\"https://docs.google.com/forms/d/1Nd4F30T5eEx1kjyFUx5MJkKPhdtMWDtMwrr4SQ90B1o/edit\">Take the Money Personality Quiz Now!</a></span><span style=\"color: #339966;\">&nbsp;</span>&nbsp;&nbsp;</strong></p>\n" +
                "", Html.FROM_HTML_MODE_COMPACT));
        t7.setMovementMethod(LinkMovementMethod.getInstance());


        //  m1pdf = (PDFView) findViewById(R.id.pdf1);
      //  m1pdf.fromAsset("Week1Module.pdf").load();

    }
}
