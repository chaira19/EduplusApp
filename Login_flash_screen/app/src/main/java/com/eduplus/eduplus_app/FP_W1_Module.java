package com.eduplus.eduplus_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class FP_W1_Module extends AppCompatActivity {


    TextView t1,t2,t3;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w1__module);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);
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


      //  m1pdf = (PDFView) findViewById(R.id.pdf1);
      //  m1pdf.fromAsset("Week1Module.pdf").load();

    }
}
