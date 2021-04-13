package com.eduplus.eduplus_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class EP_S2_Module extends AppCompatActivity {

    TextView t1,t2,t3,t4, t5,t6, t7, t8, t9;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_p__s2__module);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        t8 = (TextView) findViewById(R.id.text8);
        t9 = (TextView) findViewById(R.id.text9);

        t1.setText(Html.fromHtml("\n" +
                "      <p><span style=\"font-weight: 400;\">In this module we will explore entrepreneurship as a career option. We will learn about the difference between small business and a startup. We will also look into the process of how to convert your idea into a potential business model. So let&rsquo;s get started.&nbsp;</span></p>\n"
                , Html.FROM_HTML_MODE_COMPACT));

        t2.setText(Html.fromHtml("\n" +
                "        <p><span style=\"font-weight: 400;\">To understand the difference between startups and small scale businesses, we first need to understand what is a startup?&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>&ldquo;A startup is basically an organized form to search for a repeatable and scalable business model&rdquo;</strong></p>\n" +
                "<p style=\"text-align: right;\"><span style=\"font-weight: 400;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><strong>&nbsp;- Steve Blank</strong></p>\n" +
                "<p><br /><span style=\"font-weight: 400;\">This means that a startup is a company that is not only looking to execute their business model but they are also looking to do so very quickly in a way that will significantly change the market.</span><strong> For Ex: </strong><span style=\"font-weight: 400;\">Consider the case of Uber. Before Uber most of the people used to commute using Auto Rickshaw and would have to </span></p>\n"
                , Html.FROM_HTML_MODE_COMPACT));

        t3.setText(Html.fromHtml("\n" +
                " <p><span style=\"font-weight: 400;\">wait for the Rickshaw to arrive. But after the arrival of Uber, people can now book the Taxi by their phone app and don't have to wait for a long time. So, Uber significantly changed the transportation market in a very short span of time and hence it can be categorised a startup.&nbsp;</span></p>\n" +
                "<p><span style=\"font-weight: 400;\">So now that you have understood what a startup is, let us now look at the some of the characteristics that differentiates between a startup and&nbsp; a small business:</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t4.setText(Html.fromHtml(" <p><span style=\"font-weight: 400;\">It is important to make the distinction between startup and small business because making the distinction early on will help define the path for your future business: what your early expectations are, how you plan on growing, who you plan on partnering with, and how you&rsquo;ll define success in the end.</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t5.setText(Html.fromHtml("\n" +
                "        <p><span style=\"font-weight: 400;\">In this section we look at what it really takes to come with a startup idea and turn it into a scalable business model. Let us now look at the various stages involved in starting a startup step by step:</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><span style=\"color: #008000;\"><strong><strong><span style=\"text-decoration: underline;\">Coming up with the Idea</span>&nbsp;</strong></strong></span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">The first and the foremost thing is to come up with a business idea. A business idea is nothing but a problem that you are trying to solve and by solving it you will make people&rsquo;s life easier and in turn people can pay you money in return for your product or service. Let us understand this with the help of an example:&nbsp;</span></p>\n" +
                "<p><strong>Ex:</strong><span style=\"font-weight: 400;\"> Before Google started the service of Gmail, people used to send Mails offline via Post. Sending mails by post would take several days to reach its destination and the person would have to wait for another 2-3 days to receive the reply. Also sending Mails via post would require efforts to go to the post office and also involved post chargers. But after google started the Gmail Service people could literally send mails to any person in the world within seconds. Gmail saved people&rsquo;s time and efforts. As a result, today, billions of people across the globe are using Gmail in their day to day life.</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t6.setText(Html.fromHtml("\n" +
                "        <p><strong>How do I find a startup Idea?&nbsp;</strong></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">The right approach is not to run blindly behind finding a startup idea but to look for the problems that you are facing in your day to day life. The best startups ideas have two things in common:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">They are something that the founders themselves want. Or</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">It is something the founders themselves can build or have expertise in it</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Facebook, google, microsoft all started in the same way. The key is to be active enough to identify the problems you are passionate about and should be able to solve them in an effective and innovative way. </span><strong>And do not make the mistake of solving problems no one has.</strong><span style=\"font-weight: 400;\"> Once you identify a problem, you must validate it by talking to people whether or not they are actually facing that problem and would want someone to solve it.&nbsp;</span></p>\n" +
                "<p><br /><br /></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><span style=\"text-decoration: underline; color: #008000;\"><strong><strong>Building an MVP (Minimum Viable Product)</strong></strong></span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Once you have identified a problem and validated it, the next step is to build the solution. Your solution can be a product or service that people need and would pay for. Now no product is complete in itself when you are just starting to build it. It will keep getting better after several iterations. So how do you decide what shall be the minimum features that the product should have at the time of launching?&nbsp;</span></p>\n" +
                "<p><span style=\"font-weight: 400;\">This where MVP comes into picture. </span><strong>MVP is Minimum Viable Product.</strong><span style=\"font-weight: 400;\"> MVP is that version of a new product which allows a startup team to collect the maximum amount of validated learning about customers with the least effort. This validated learning comes in the form of whether your customers will actually purchase your product or not.&nbsp;</span></p>\n" +
                "<p><strong>For Ex: </strong><span style=\"font-weight: 400;\">&nbsp;When Facebook was starting out in 2004, it was just for the purpose of connecting students at Harvard university allowing them to post messages online on their facebook profile.</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t7.setText(Html.fromHtml("\n" +
                "        <p><span style=\"font-weight: 400;\">But in no time, most of the students at Harvard started using Thefacebook and the website became popular in the university. Once it became&nbsp; popular in Harvard, facebook was expanded into other universities like Cmabridge, Yale, Stanford, etc and on September 26, 2006, Facebook opened its services to everyone with a valid email address aged 13 years or older. This was the official start of the Facebook we know and use today.</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Benefits of MVP&nbsp;</strong></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">The primary benefit of an MVP is you can gain understanding about your customers&rsquo; interest in your product without fully developing the product.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">The minimum aspect of MVP encourages teams to do the least amount of work possible to useful feedback which helps them avoid working on a product that no one wants.</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Proper use of an MVP allows the team to change a product that they deliver to their customers or abandon the product altogether based on feedback they receive from their customers</span></li>\n" +
                "</ul>\n" +
                "<p><br /><br /></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><span style=\"text-decoration: underline; color: #008000;\"><strong><strong>Find your first Customers&nbsp;</strong></strong></span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">After building the MVP, the next step is to search the market for your first base of customers. Listed below are some of the strategies you can use to identify and attract those critical first customers:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><strong>Reach out to your network:</strong><span style=\"font-weight: 400;\"> A quick way to do some customer development is to reach out to your existing network and ask them specific questions about your product and market. You can do so with the help of social media networks like FB, Linkedin, etc.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><strong>Cold Email:</strong><span style=\"font-weight: 400;\"> One of the most straightforward ways to get your first customers is through cold email. It&rsquo;s relatively easy to find the email addresses of your potential customers, and it&rsquo;s easy to reach out to a high volume of people relatively quickly.</span></li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><strong>Paid Advertisements:</strong><span style=\"font-weight: 400;\"> You can use Google Adwords or Facebook advertising service to run target ads for your product to attract customers.&nbsp;</span></li>\n" +
                "</ul>\n", Html.FROM_HTML_MODE_COMPACT));

        t8.setText(Html.fromHtml("\n" +
                " <p>&nbsp;</p>\n" +
                "<ul>\n" +
                "    <li><strong>Give it away for Free:</strong> <span style=\"font-weight: 400;\">You can offer your product or service for free for the first few months and once people develop a habit of it you can start charging for it. </span><strong>Netflix, Hotstar</strong><span style=\"font-weight: 400;\"> are some of the best examples that follow this strategy. They offer a 1 month free trial to its new users and once the user is hooked to their content they charge them to continue the services.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Your first customers are extremely valuable not just because they are buying your physical product but they can teach you how to grow. They show you what your future customers want. They are the guiding light to future success.</span></p>\n" +
                "<p><br /><br /><br /></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><span style=\"text-decoration: underline; color: #008000;\"><strong><strong>Raise Funding&nbsp;</strong></strong></span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Once you have acquired your initial customer base, the next step is to expand your business and for that you&rsquo;ll need to hire more employees, attract specialists in the field, invest in production costs, invest in marketing and keep the operations running steadily in the development phase. For all these things you need more money and that&rsquo;s where funding comes into play. Let us look at some of the funding options for startups:&nbsp;</span></p>\n" +
                "    ", Html.FROM_HTML_MODE_COMPACT));

        t9.setText(Html.fromHtml("    <p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li>Bootstrapping: <span style=\"font-weight: 400;\">Self-funding, also known as bootstrapping, is an effective way of startup financing, especially when you are just starting your business. First-time entrepreneurs often have trouble getting funding without first showing some traction and a plan for potential success. You can invest from your own savings or can get your family and friends to contribute. However, Bootstrapping </span><span style=\"font-weight: 400;\">is suitable only if the initial requirement is small as it might wipe out your savings and the entire risk of the business is on the entrepreneur and his team.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Angel Investments: </strong><span style=\"font-weight: 400;\">An angel investor is a person who invests in a new or small business venture, providing capital for start-up or expansion. Angel investors are typically individuals who have spare cash available and are looking for a higher rate of return than would be given by more traditional investment. Angel investment is basically equity financing where the investor supplies cash in exchange for company ownership. </span><strong>Ex: </strong><span style=\"font-weight: 400;\">An angel investor may provide a funding of around 1 Cr Rs to your startup in return for 30% stake in the company.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Advantage:</strong><span style=\"font-weight: 400;\"> The big advantage is that financing from angel investments is much less risky than debt financing. Unlike a loan, invested capital does not have to be paid back in the event of business failure. And, most angel investors understand business and take a long-term view.</span></p>\n" +
                "<p><strong>Disadvantage:</strong><span style=\"font-weight: 400;\"> The primary disadvantage of using angel investors is the loss of complete control as a part-owner. Your angel investor will have a say in how the business is run and will also receive a portion of the profits that the business will make.&nbsp;</span></p>\n" +
                "<p><span style=\"font-weight: 400;\">Some of the Angel investors in India are: </span><span style=\"color: #339966;\"><a style=\"color: #339966;\" href=\"http://www.mumbaiangels.com/\">Mumbai Angels</a></span>, <span style=\"color: #339966;\"><a style=\"color:#339966;\"  href=\"http://indianangelnetwork.com/\"> India Angel Network </a></span>\n" +
                "</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Venture Capital (VC) Funding: </strong><span style=\"font-weight: 400;\">Venture capitals are professionally managed funds who invest in companies that have huge potential. They also supply cash in exchange for equity in the company. The difference between Angel investment and venture capital is that angel investors invest their own money however venture capitalists invest money pooled from investment companies, large corporations, and pension funds. Typically, VCs do not use their own money to invest in companies. Also the amount of money invested by VCs is usually more than Angel investors. According to a study, the average venture capital deal is $11.7 million whereas the average angel investment is $330,000.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Some of the Angel investors in India are: </span><span style=\"color: #339966;\"><a style=\"color: #339966;\" href=\" https://www.kalaari.com/\"> Kalaari Capital </a></span>, <span style=\"color: #339966;\"><a style=\"color:#339966;\"  href=\" https://www.sequoiacap.com/india\"> Sequoia Capital</a></span>\n" +
                "</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li><strong>Funding From Business Incubators &amp; Accelerators: </strong><span style=\"font-weight: 400;\">At a high level, startup accelerators and incubators are organizations that seek to help startups attain success. Startup accelerators tend to focus on providing startups with mentorship, advice, and resources to help the startups succeed. They also help to connect the startups with the potential investors by organizing a demo day where the startup founders can pitch their idea to the investors. There are many startup incubators and accelerators and each of them have their own programs through which they select potential startups and provide them mentorship through their 3-4 week programs.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Some of the famous startup accelerators are: </span><span style=\"color: #339966;\"><a style=\"color: #339966;\" href=\"https://www.ycombinator.com\"> Y- Combinator </a></span>, <span style=\"color: #339966;\"><a style=\"color:#339966;\"  href=\" https://www.techstars.com/\"> TechStars</a></span><span style=\"font-weight: 400;\">, etc. </span>\n" +
                "</p>\n", Html.FROM_HTML_MODE_COMPACT));
        t9.setMovementMethod(LinkMovementMethod.getInstance());


    }
}