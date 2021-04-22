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
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class EP_S1_Module extends AppCompatActivity {

    TextView t1,t2,t3,t4, t5,t6;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_p__s1__module);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//        ZoomLayout zoomlayout= findViewbyId(R.id.zoomLayout);
//        zoomlayout.setOnTouchListener(FullScreenVideoActivity.this);
//        public boolean onTouch(View v, MotionEvent event) {
//            linear.init(FullScreenVideoActivity.this);
//            return false;
//        }

        ImageView toolbarLeft = (ImageView) findViewById(R.id.leftNavigate);
        toolbarLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EP_S1_Module.this, CareerEP.class));
                finish();
            }
        });

        ImageView toolbarLRight = (ImageView) findViewById(R.id.rightNavigate);
        toolbarLRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("CareerPage", "EP_S2_Module").apply();
                sharedPreferences.edit().commit();
                startActivity(new Intent(EP_S1_Module.this, EP_S2_Module.class));
                finish();
            }
        });

        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);
        t4 = (TextView) findViewById(R.id.text4);
        t5 = (TextView) findViewById(R.id.text5);
        t6 = (TextView) findViewById(R.id.text6);

        t1.setText(Html.fromHtml("\n" +
                "        <p><span style=\"font-weight: 400;\">Entrepreneurship</span> <span style=\"font-weight: 400;\">is nothing but the process of creating, launching and running a new business which often starts as a small business but has the potential to scale in the future. The people who create these businesses are referred to as </span><strong>Entrepreneurs</strong><span style=\"font-weight: 400;\">. Let us understand this with the help of an example.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Ever heard of the Mickey Mouse? It is the character that was created by Walt Disney which led to the creation of a huge company name </span><strong>The Walt Disney Company.</strong><span style=\"font-weight: 400;\">&nbsp;</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t2.setText(Html.fromHtml(" <p><span style=\"font-weight: 400;\">Walt Disney grew up on a farm and spent time drawing pictures of farm animals. As an adult, he continued to draw and created a cartoon character for a major movie company he worked for. When that company decided to reduce his pay, Disney quit his job and created another cartoon character that led to the start of a huge company and that character was Mickey Mouse. Today, Disney company produces many animated movies and has a net worth of around 200 Billion USD as of 2020. This story shows how Disney turned his passion of drawing cartoons into a multi billion dollar company through his </span><strong>entrepreneurial</strong><span style=\"font-weight: 400;\"> skills.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"text-decoration: underline; color: #008000;\"><strong>Importance of Entrepreneurship:</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Entrepreneurship is as important as innovation for the economic growth of any country.</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><strong>Creation of Employment:</strong><span style=\"font-weight: 400;\"> Entrepreneurs are the people who create customers and customers, in turn, create jobs and economic growth.</span></li>\n" +
                "<li style=\"font-weight: 400;\"><strong>Entrepreneurship drives innovation</strong><span style=\"font-weight: 400;\">: You can think of innovation as a cart which is driven by a horse named entrepreneurship. Creativity, ideas, discovery and innovation are one side of the growth coin &ndash; the other side is commercialisation and entrepreneurship helps in commercialisation of these ideas.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><strong>Society and Community Development: </strong><span style=\"font-weight: 400;\">Entrepreneurship promotes facilities like better education, better sanitation, fewer slums, a higher level of homeownership, etc.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"text-decoration: underline; color: #008000;\"><strong>Why Choose Entrepreneurship?</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Pursuing entrepreneurship as a career has many positives to it. Let us discuss some of the benefits in detail:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Constant growth and development: </strong><span style=\"font-weight: 400;\">Starting a company forces you to constantly improve your skill set, from creating innovative products to marketing to closing deals. There is always more to learn and apply to your business, which can prevent complacency and encourage constant professional growth.</span></li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "<li><strong>You become a business leader: </strong><span style=\"font-weight: 400;\">Being able to see how your business has contributed to the local economy and provided jobs is incredibly rewarding. Your role as a business leader in your community is important and respectable.</span></li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "<li><strong>Excitement: </strong><span style=\"font-weight: 400;\">Part of what makes entrepreneurship so alluring is that it&rsquo;s both dynamic and exciting. The company is growing and adapting constantly, keeping everyone on their toes.</span></li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "<li><strong>You&rsquo;re the boss: </strong><span style=\"font-weight: 400;\">You have a large degree of say and control in what&rsquo;s happening when you&rsquo;re starting your own company.</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><br /><br /></p>\n" +
                "<p><span style=\"text-decoration: underline; color: #008000;\"><strong>Types of Entrepreneurship:</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Entrepreneurship can be classified mainly into 4 types:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Small Business: </strong><span style=\"font-weight: 400;\">These are the kind of businesses where people run and own their business with the help of their family members or local employees. For them making profit means to be able to meet the demands of their families and make a decent living out of their business. People take small financial risk in setting up these businesses initially but after setting up, they can earn from that business for life. </span><strong>Ex: </strong><span style=\"font-weight: 400;\">Businesses like local Kirana Stores, Medical stores, travel agents, etc, fall under this category.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><strong>Startup:</strong><span style=\"font-weight: 400;\"> Startup refers to a company which is still in its first stage of operation and is founded by one or more entrepreneurs who build products for which they believe there is a demand in the market. Their initial cost of operation might be high and revenue may be limited and that is why they take money from investors to scale their business. We will learn about this in detail in the next module. </span><strong>Ex:</strong><span style=\"font-weight: 400;\"> Zomato, Swiggy, Ola, OYO, etc are examples of some of the successful Indian startups.&nbsp;</span></li>\n" +
                "</ul>\n", Html.FROM_HTML_MODE_COMPACT));

        t3.setText(Html.fromHtml("\n" +
                "        <ul>\n" +
                "<li style=\"font-weight: 400;\"><strong>Large Company: </strong><span style=\"font-weight: 400;\">These are big companies that build new and innovative products and services that are used by millions of people worldwide. These companies constantly evolve themselves depending upon the technological advancements and market competitions.</span><strong> Ex:</strong><span style=\"font-weight: 400;\"> Companies like Google, Microsoft, etc fall under this category.&nbsp;</span></li>\n" +
                "</ul>", Html.FROM_HTML_MODE_COMPACT));

        t4.setText(Html.fromHtml("  <ul>\n" +
                "            <li style=\"font-weight: 400;\"><strong>Social Entrepreneurship:</strong><span style=\"font-weight: 400;\"> These are types of organisations whose main motive is to work for the betterment of society and not for profit. They focus on solving the existing social problems. NGOs are the best example of this type of entrepreneurship. Most of the NGOs raise money through crowdfund raising i.e. they ask people to donate money for the cause they are working. </span><strong>Ex: </strong><span style=\"color: #339966;\"><a style=\"color: #339966;\" href=\"https://www.teachforindia.org/\">Teach for India</a></span>, <span style=\"color: #339966;\"><a style=\"color: #339966;\" href=\"https://www.smilefoundationindia.org/\">Smile Foundation</a></span>.</li>\n" +
                "</ul>", Html.FROM_HTML_MODE_COMPACT));
        t4.setMovementMethod(LinkMovementMethod.getInstance());

        t5.setText(Html.fromHtml("\n" +
                "        <p><span style=\"font-weight: 400;\">The success of any enterprise largely depends upon the person who runs it. So creative and risk taking entrepreneurs are most important for any kind of business to be successful. Let us discuss some of the qualities that make&nbsp; a successful entrepreneur:&nbsp; </span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t6.setText(Html.fromHtml("\n" +
                "<p><span style=\"font-weight: 400;\">Entrepreneurs are often creative, daring people, and the businesses they operate are very important to communities. Entrepreneurs take risks and turn an idea into a company. An idea that makes people&rsquo;s lives easier and better. Let us look at some of the qualities and what it takes to become a successful entrepreneur:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"text-decoration: underline; color: #008000;\"><strong>Risk Taking Ability</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Entrepreneurship is all about taking risks. Entrepreneurs have the ability to take greater risks to achieve greater success. Let us discuss some of the scenarios where entrepreneurs take potential risks:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">An entrepreneur takes risk when he quits his job to work on his idea. If the idea becomes successful he will receive far greater returns but at the same time if the idea didn&rsquo;t work he will have to struggle to find another job.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">An entrepreneur takes risk when he spends his time and money on a product that can explode the market but at the same time has a chance that it might underperform. </span><strong>Ex:</strong><span style=\"font-weight: 400;\"> In 2019, the failure rate of startups was around 90%. Research concludes that 21.5% of startups fail in the first year, 30% in the second year, 50% in the fifth year, and 70% in their 10th year.</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">All entrepreneurs plan before taking risks and make a plan B (in case of any loss of mishap) and establish a suitable ground for the results of the risks.</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p style=\"text-align: center;\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&ldquo;With great risks, comes great rewards&rdquo;</strong></p>\n" +
                "<p><br /><br /></p>\n" +
                "<p><span style=\"text-decoration: underline; color: #008000;\"><strong>Delegator</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Delegation is simply the ability to assign specific tasks and purpose to a person or a group of people. This is the one quality which is very important if you want to succeed in your entrepreneurial journey.</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">A successful entrepreneur:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Collaborate, recognise and draw on people&rsquo;s abilities.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Encourages team contribution.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Understands people&rsquo;s skills and provides them tasks that suit them best.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Gives constructive feedback to his employees.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p><br /><br /></p>\n" +
                "<p><span style=\"text-decoration: underline;\"><span style=\"color: #008000;\"><strong>Knowledge Seeker</strong></span></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Entrepreneurs always need to keep their mind active and increase their knowledge.</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">They always keep themselves updated about any recent technological advancements.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">They write and share ideas and collaborate with others to get different perspectives on any subject.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Most of the successful entrepreneurs are great readers. They read a variety of books to keep themselves updated with lots of new things happening around the world.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p><br /><br /></p>\n" +
                "<p><span style=\"text-decoration: underline;\"><span style=\"color: #008000;\"><strong>Vision</strong></span></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">A successful entrepreneurial leader has a clear vision. He knows exactly where he wants to go and how to get there. They communicate their vision to the team and work with them to make the vision a reality.</span> <span style=\"font-weight: 400;\">Most of the successful companies in the world were started with a vision that now has changed the way the world functions.</span><strong> Ex:</strong><span style=\"font-weight: 400;\">&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><strong>Larry Page and Sergey Brin</strong><span style=\"font-weight: 400;\"> started google with the vision of, &ldquo;</span><span style=\"font-weight: 400;\">To organize the world's information and make it universally accessible and useful&rdquo; and now Google dominates 75% of the U.S. online search market. Every month millions of unique users perform billions of searches.</span></li>\n" +
                "<li style=\"font-weight: 400;\"><strong>Bill Gates</strong><span style=\"font-weight: 400;\"> started Microsoft with the vision of, &ldquo;Computer on every Desk&rdquo; and now it is almost impossible to imagine our lives without computers.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p><br /><br /></p>\n" +
                "<p><span style=\"text-decoration: underline; color: #008000;\"><strong>Persistence</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Persistence is the most basic and essential quality of a successful entrepreneur because even good entrepreneurs experience failures and hurdles. But with persistence, you&rsquo;re able to pick yourself back up and keep moving towards your goals.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Ex:</strong><span style=\"font-weight: 400;\"> Jack Ma&rsquo;s life is perhaps the greatest example of success through failure. He failed primary school twice and middle school three times. He also failed his university entry exam three times. He was rejected by the police force and even KFC. He applied for Harvard ten times and was rejected each and every time. Now, he is one of the richest people in the world as the founder of Alibaba, one of the biggest e-commerce companies on the planet.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Jack Ma&rsquo;s story teaches us the importance of persistence and never giving up on our dreams.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Apart from these, there are many other qualities that an entrepreneur should have like </span><strong>Self-confidence, Patience, Leadership quality, Managerial skill,</strong><span style=\"font-weight: 400;\"> etc. Inculcating these qualities in your personality is hard but once you develop these qualities, your chances of getting success in your entrepreneurial journey increase multi-folds.&nbsp;&nbsp;&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">In the next module we will learn how we can explore entrepreneurship as a career option.</span></p>\n"
                , Html.FROM_HTML_MODE_COMPACT));

    }
}