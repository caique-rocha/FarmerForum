package com.abc.farmersconsult;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Dashboard extends AppCompatActivity {
   private DrawerLayout drawerLayout;
   private Toolbar mtoolbar;
   private NavigationView navigationView;
   private ActionBarDrawerToggle actionBarDrawerToggle;
   private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.Navigation_View);

        View navView=navigationView.inflateHeaderView(R.layout.navigation_header);
        mtoolbar = (Toolbar) findViewById(R.id.action_tool);
       setSupportActionBar(mtoolbar);
       getSupportActionBar().setTitle("Home");
       actionBarDrawerToggle=new ActionBarDrawerToggle(Dashboard.this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
       drawerLayout.addDrawerListener(actionBarDrawerToggle);
       actionBarDrawerToggle.syncState();
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              OnMenuItemSelected(item);
              
               return false;
           }
       });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    if(actionBarDrawerToggle.onOptionsItemSelected(item)){
        return  true;
    }
     return  super.onOptionsItemSelected(item);

    }



    private void OnMenuItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_home:
                Toast.makeText(getApplicationContext(),"Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_profile:
                Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_log_out:
                Toast.makeText(getApplicationContext(),"Log out", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(Dashboard.this, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                break;
        }
    }
}
