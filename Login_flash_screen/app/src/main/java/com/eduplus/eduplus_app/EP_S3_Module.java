package com.eduplus.eduplus_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class EP_S3_Module extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;

    TextView t1,t2,t3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_p__s3__module);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        youTubePlayerView = findViewById(R.id.video1);
        youTubePlayerView = findViewById(R.id.video2);
        getLifecycle().addObserver(youTubePlayerView);

        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);

        t1.setText(Html.fromHtml("\n" +
                "        <p><span style=\"font-weight: 400;\">In this section we will look at some of the successful entrepreneurship stories that will inspire you to make big in the entrepreneurial world. These success stories are nothing short of inspiring and prove one fact over and over again &ndash; everything is possible; if you have the will to accomplish it.&nbsp;</span></p>\n" +
                "<p><br /><br /></p>\n" +
                "<p><span style=\"text-decoration: underline; color: #008000;\"><strong>The Facebook Story</strong></span></p>\n" +
                "<p><span style=\"font-weight: 400;\">Facebook&nbsp; was founded by Mark Zuckerberg, along with his fellow roommates and students at Harvard College. Originally known as TheFacebook.com. Today Facebook is one of the world's most valuable companies. It is considered one of the Big Five companies in the U.S. information technology industry, along with Google, Apple, Microsoft, and Amazon. Let us look at how it all started.</span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t2.setText(Html.fromHtml(" <p><span style=\"text-decoration: underline; color: #008000;\"><strong>The OYO Story</strong></span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><span style=\"font-weight: 400;\">Oyo Rooms, also known as Oyo Hotels &amp; Homes, is an Indian hospitality chain of leased and franchised hotels, homes and living spaces. OYO was founded by Ritesh Agarwal in 2013 and today OYO is worth $8 Billion. Let us see how Ritesh started OYO and what are the challenges he faced. </span></p>\n", Html.FROM_HTML_MODE_COMPACT));

        t3.setText(Html.fromHtml("   <p><span style=\"font-weight: 400;\">Here are some of the websites and channels from where you can get updates of what&rsquo;s happening in the entrepreneurship world in India as well as in the outside world.&nbsp;</span></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Websites &amp; Magazines</strong></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "    <li style=\"font-weight: 400;\"><span style=\"color: #339966;\"><a href=\"https://www.forbes.com/leadership/?sh=6e89ce461d66\">Forbes</a></span></li>\n" +
                "    <li style=\"font-weight: 400;\"><span style=\"color: #339966;\"><a href=\"https://yourstory.com/\">Your Story</a></span><span style=\"font-weight: 400;\">&nbsp;</span></li>\n" +
                "    <li style=\"font-weight: 400;\"><span style=\"color: #339966;\"><a href=\"https://www.entrepreneur.com/\">Entrepreneur India</a></span></li>\n" +
                "    <li style=\"font-weight: 400;\"><span style=\"color: #339966;\"><a href=\"https://hbr.org/\">Harvard Business Review</a></span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><strong>Channels</strong></p>\n" +
                "<p>&nbsp;</p>\n" +
                "<ul>\n" +
                "    <li style=\"font-weight: 400;\"><span style=\"color: #339966;\"><a href=\"https://www.youtube.com/user/TEDtalksDirector\">TED Talks</a></span></li>\n" +
                "    <li style=\"font-weight: 400;\"><span style=\"color: #339966;\"><a href=\"https://www.youtube.com/user/EntrepreneurOnline\">Entrepreneur</a></span></li>\n" +
                "    <li style=\"font-weight: 400;\"><span style=\"color: #339966;\"><a href=\"https://www.youtube.com/user/slidebean\">SlideBean</a></span></li>\n" +
                "</ul>", Html.FROM_HTML_MODE_COMPACT));
        t3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}