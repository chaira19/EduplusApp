package com.eduplus.dashboardpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //Nav drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.dashboard:
                Intent intent = new Intent(MainActivity.this, ProgressDashboard.class);
                startActivity(intent);
                break;
            case R.id.programming:
                Intent intent1 = new Intent(MainActivity.this, Programming.class);
                startActivity(intent1);
                break;
            case R.id.skill:
                Intent intent2 = new Intent(MainActivity.this, Skill.class);
                startActivity(intent2);
                break;
            case R.id.career:
                Intent intent3 = new Intent(MainActivity.this, Career.class);
                startActivity(intent3);
                break;
            case R.id.Competitions:
                Intent intent4 = new Intent(MainActivity.this, Competition.class);
                startActivity(intent4);
                break;
            case R.id.feedback:
                Intent intent5 = new Intent(MainActivity.this, Feedback.class);
                startActivity(intent5);
                break;
            case R.id.contact:
                Intent intent6 = new Intent(MainActivity.this, Contact.class);
                startActivity(intent6);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}