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

public class FP_W2_Module extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w2__module);
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
        t10 = (TextView) findViewById(R.id.text10);

        t1.setText(Html.fromHtml(" <p><span style=\"font-weight: 400;\">Cash flow is nothing but movement of money </span><strong>in</strong><span style=\"font-weight: 400;\"> and </span><strong>out</strong><span style=\"font-weight: 400;\"> of your wallet. Positive cash flow indicates your net worth is increasing. Let us look at some of the sources of inflow and outflow of money:</span></p>\n",
                   Html.FROM_HTML_MODE_COMPACT));

        t2.setText(Html.fromHtml("  <p><strong><span style=\"text-decoration: underline; color: #339966;\">Assets:</span></strong></p>\n" +
                "        <p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">The sources that put money in your wallet are assets. These sources add to your income. </span><strong>Ex: </strong><span style=\"font-weight: 400; color: #993300;\">The money kept in the bank is an asset since the bank pays you interest on that money. That interest adds to your cash inflow and hence it is an asset. </span></p>\n" +
                "  ",Html.FROM_HTML_MODE_COMPACT));

        t3.setText(Html.fromHtml("  <p><span style=\"text-decoration: underline; color: #008000;\"><strong>Liabilities:</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">The sources that take money out of your wallet are liabilities. These are the things that require additional cost of operation or maintenance. </span><strong>Ex:</strong><span style=\"font-weight: 400; color: #993300;\"> When you have a car, you need fuel to drive it, it requires maintenance and insurance as well. Now the cost of all this&nbsp; is outflow of cash and hence the car is a liability.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"text-decoration: underline; color: #808080;\"><strong>Difference between Assets &amp; Liabilities:</strong><strong>&nbsp;</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Inorder to make the most out of your financial resources, one needs to know the fundamental difference between&nbsp; an asset and liability. Let us understand this difference with the help of a simple example.&nbsp;</span></p>\n" +
                "<p><strong>Ex:</strong> <span style=\"color: #993300;\"><span style=\"font-weight: 400;\">Consider a scenario where you are the owner of a house. Now, that house can be an asset or a liability depending upon how much positive or negative cash flow is contributed by that property. It is explained in the diagram below:</span><span style=\"font-weight: 400;\">&nbsp;</span></span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t4.setText(Html.fromHtml("  <p style=\"text-align: justify;\"><span style=\"font-weight: 400;\">In case I, the house is an asset since the rent received exceeds the mortgage and maintenance cost, hence contributing to a positive cashflow. However, the same house in case II is a liability since it contributes to a negative cashflow.&nbsp;</span></p>\n" +
                "<p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"text-decoration: underline; color: #808080;\"><strong>Types of Income Sources:</strong><span style=\"font-weight: 400;\">&nbsp;</span></span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-weight: 400;\">There are mainly two types of income sources:&nbsp;</span></p>\n" +
                "<p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "<ul style=\"text-align: justify;\">\n" +
                "<li><span style=\"color: #008000;\"><strong>Active income sources: </strong></span><span style=\"font-weight: 400;\">It is the hard earned money that one gets in exchange for performing a service. </span><strong>Ex:</strong><span style=\"color: #993300;\"> <span style=\"font-weight: 400;\">Salary from Job.</span><span style=\"font-weight: 400;\">&nbsp;</span></span></li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "<li><span style=\"color: #008000;\"><strong>Passive income sources:</strong></span><span style=\"font-weight: 400;\"> It is the money that requires little work or no active engagement to earn. </span><strong>Ex</strong><span style=\"font-weight: 400;\">: </span><span style=\"color: #993300;\"><span style=\"font-weight: 400;\">Money earned via interest from the bank.</span><span style=\"font-weight: 400;\">&nbsp;</span></span></li>\n" +
                "</ul>\n" +
                "<p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-weight: 400;\">Financial freedom is a stage where you can meet all your expenses from the&nbsp;</span><span style=\"font-weight: 400;\">money generated by your passive sources of income. The more assets you&nbsp;</span><span style=\"font-weight: 400;\">accumulate, greater will be your passive income. This cycle is explained well in&nbsp;</span><span style=\"font-weight: 400;\">the diagram below:</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t5.setText(Html.fromHtml("\n" +
                " <p style=\"text-align: justify;\"><span style=\"font-weight: 400;\">One can increase his income from passive sources by investing the money earned via active sources. Let us learn more about investment in the next section.&nbsp;</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t6.setText(Html.fromHtml("  <p><span style=\"font-weight: 400;\">Investment is basically an asset that is purchased with the intention that it will generate income at some point in future. When you buy a commodity as an investment, the intent is not to utilise that commodity, but rather wait for its value to go higher inorder to receive greater returns.&nbsp;</span></p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p><strong>Ex: </strong><span style=\"font-weight: 400; color: #993300;\">Let say you bought 10gm of 24 carat pure gold today at a price of 50,000 INR and after 5 years the price of gold went high and you sold it for 60,000 INR, this would mean that you invested 50,000 Rs on gold and you got 10,000 Rs as a return on that investment after 5 years.&nbsp;</span></p>\n" +
                "    <p style=\"text-align: justify;\"><br /><br /></p>\n" +
                "    <p><span style=\"font-weight: 400;\">Depending upon the type of returns, there are mainly two types of investments:&nbsp;</span></p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p><span style=\"text-decoration: underline; color: #008000;\"><strong>Fixed Return Investments:</strong></span></p>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <p><span style=\"font-weight: 400;\">These are the types of investments where the principal amount of investment is fixed and the interest rate you receive on that amount is also known and is fixed. Most common examples of these investments are:&nbsp;</span></p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <ul>\n" +
                "        <li style=\"font-weight: 400;\"><strong>Fix Deposit:</strong><span style=\"font-weight: 400;\">&nbsp;A FD is an investment offered by banks where you can deposit a lump sum of money for a specific&nbsp; period of time and the bank will offer you interest on that amount compounded annually. </span><strong>Ex:</strong><span style=\"font-weight: 400; color: #993300;\"> If you deposit 1,00,000 Rs in FD for a tenure of 5 years at a rate of 5%, you will receive 1,27,000 Rs at the end of 5 years.&nbsp;</span></li>\n" +
                "    </ul>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <ul>\n" +
                "        <li><strong><strong>Recurring Deposit:&nbsp;&nbsp;</strong></strong>A RD is similar to FD except that in RD you can deposit a fixed amount of money each month and earn interest on it.&nbsp;</li>\n" +
                "    </ul>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <p style=\"text-align: justify;\"><br /><br /></p>\n" +
                "    <p><span style=\"text-decoration: underline;\"><strong>When to use:</strong></span>&nbsp;<span style=\"font-weight: 400;\">The risk associated with these investments is low but at the same time the return rate is also on the lower side. They are beneficial when you want to invest your money for the short term and keep the money safe.&nbsp;</span></p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p><span style=\"text-decoration: underline; color: #008000;\"><strong>Variable Return Investments:</strong></span></p>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <p><span style=\"font-weight: 400;\">These are the types of investments where the return rate is variable and depends upon the performance of the market.&nbsp;</span></p>\n" +
                "    <p><span style=\"font-weight: 400;\">Examples of these investments are:&nbsp;</span></p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <ul>\n" +
                "        <li><strong><strong>Real Estate: </strong></strong>This involves purchase of land and property inorder to earn profit. Ex: <span style=\"color: #993300;\">If you would have bought a plot for 1,00,000 Rs in 2015 the value of that plot in 2020 would be around 1,61,000 Rs considering a 10% rise in property prices every year.</span> Returns in real estate are mostly dependent on the development of the nearby area which is likely to happen in the long term.</li>\n" +
                "    </ul>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <ul>\n" +
                "        <li><strong><strong>Stocks:</strong> </strong>In order to understand stocks, consider a company called Dell. Now Dell is a company that manufactured Computers. In order to run their business, companies raise funds by issuing stocks which are nothing but shares that represent ownership of a fraction of a company. If a company issues 1000 stocks and you bought 500 stocks of that company, then you are the owner of 50% of that company. If you own 50% of the stocks in that company, that means you are entitled to 50% of the total profit that the company will make. At the same time if the company suffers any loss, you will have to bear 50% of that loss. That is why investing in stocks is risky but yields greater returns. Ex:<span style=\"color: #993300;\"> Consider the case of Dell itself. The stock price of Dell in 2018 was around 40$ whereas its stock price in 2020 is around 60$. Which means that if you would have bought Dell stock in 2018 then you would have received a 50% return on that stock in 2020.&nbsp;</span></li>\n" +
                "    </ul>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <ul>\n" +
                "        <li><strong><strong>Mutual Fund: </strong></strong>To understand Mutual funds, one needs to understand that investing in stocks is tricky and requires expertise. Now, if you don&rsquo;t have expertise to analyse the market trends and you want to save your time, this is where mutual funds come into play. Mutual fund is a pool which collects money from different people who want to invest in any asset. The mutual fund manager, who has the required expertise in this field, then collects all the money and reinvest that money, on your behalf, in different investing opportunities. The profit gained by those investments is then redistributed to all the people who invested in the mutual fund. Some part of the profit is also kept by the fund manager as the management fees.</li>\n" +
                "    </ul>\n" +
                "    <p>&nbsp;</p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p><strong>When to use: </strong><span style=\"font-weight: 400;\">The risk associated with these investments is high but the return </span> <span style=\"font-weight: 400;\">rate is also on the higher side. They are most beneficial when you want to invest your money for a long term and willing to accept fluctuations.&nbsp;</span></p>\n" +
                "    <p style=\"text-align: justify;\">&nbsp;</p>\n" +
                "    <p><span style=\"font-weight: 400;\">Difference between fixed return and variable return investment will become more clear with the help of the table given below:&nbsp;</span></p>\n" +
                "   ", Html.FROM_HTML_MODE_COMPACT));


        t7.setText(Html.fromHtml("\n" +
                "      <p><span style=\"font-weight: 400;\">There is definitely some risk associated when it comes to investments but either you can step back from taking risks or you can learn to manage risks. Let us discuss some of the ways in which we can manage these risks and come up with a successful investment strategy. </span></p>\n" +
                "   ", Html.FROM_HTML_MODE_COMPACT));

        t8.setText(Html.fromHtml("        \n" +
                "<p><span style=\"font-weight: 400;\">An investment portfolio is simply a collection of all your financial investments like FD, stocks, Mutual funds, etc. Let us understand this with the help of an example:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Consider a person A whose active income from his job is 30,000 Rs/month. His monthly expenses like electricity bill, water bill, house maintenance, e.t.c amounts to 20,000 Rs/month. So his net savings will be 10,000 Rs/month.&nbsp;</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t9.setText(Html.fromHtml("  <p><span style=\"font-weight: 400;\">Now if he decided to keep his 10,000 Rs in his savings account, he will receive very low interest on that money and his savings won&rsquo;t be able to generate any passive income. So he decided to invest his money in assets that will generate passive income for him.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Now, let us consider the choices he has in front of him:&nbsp;</span></p>\n" +
                "<ol>\n" +
                "<li style=\"font-weight: 400;\"><strong>Variable return investment</strong><span style=\"font-weight: 400;\">, where there are higher returns but at the cost of high risk.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Or he can invest his money on</span><strong> Fixed return investments</strong><span style=\"font-weight: 400;\"> where his money will be safe but will yield lower returns.&nbsp;</span></li>\n" +
                "</ol>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">But person A wants a higher return but at the same time he doesn&rsquo;t want to risk all his savings on one particular type of investment. This is where making your own investment portfolio is helpful.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Rather than investing in a single type of asset, he decided to invest in multiple assets at the same time. Here is the portfolio of all his investments:</span></p>\n" +
                "    ", Html.FROM_HTML_MODE_COMPACT));

        t10.setText(Html.fromHtml("<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">He invested 40% (4,000 Rs) of his savings in Fixed deposit where he will receive a return rate of 6%, which is on a lower side but his money will be safe.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">35%(3,500 Rs) of his savings is invested in Real estate where he can potentially get a return rate of 8-12% depending upon the fluctuations. He can potentially receive a higher return at the cost of slightly higher risk.&nbsp;</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Lastly, 25%(2,500 Rs) of his savings he invested in stocks of multinational companies where he can potentially get a return of 15-20% but at the same time his principal amount can also go down significantly depending upon the market fluctuations.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Now by diversifying his investment he has minimized a significant risk of loss from his high risk investment in stocks. Even if he incurs a loss from stocks, his returns from the FD and Real estate assets will be enough to mitigate the effect of that loss. This is how managing your own investment portfolio helps you to minimize the risks related to the investment.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Let us quickly recap the benefits of maintaining an investment portfolio:&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"text-decoration: underline;\"><span style=\"color: #008000;\"><strong>Benefits of Investment Portfolio:</strong></span></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Helps you to do </span><strong>optimal allocation of funds</strong><span style=\"font-weight: 400;\">.</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Helps in </span><strong>reducing risks</strong><span style=\"font-weight: 400;\"> related to variable return investments</span></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Maintaining all your investment at one place helps you to </span><strong>track the performances of the assets</strong></li>\n" +
                "<li style=\"font-weight: 400;\"><span style=\"font-weight: 400;\">Managing your portfolio allows you to </span><strong>readjust your investments</strong><span style=\"font-weight: 400;\"> with time depending upon your financial goals.&nbsp;</span></li>\n" +
                "</ul>\n" +
                "<p><br /><br /></p>\n" +
                "<p><span style=\"font-weight: 400;\">This is how a better investment strategy can really help you boost your passive income from assets and help you achieve financial freedom early in your life.&nbsp;</span></p>\n" +
                "  ", Html.FROM_HTML_MODE_COMPACT));




    }
}