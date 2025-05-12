package com.ifts4.introduccionandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.ifts4.introduccionandroid.databinding.ActivityHomeBinding
import com.ifts4.introduccionandroid.fragments.FirstFragment
import com.ifts4.introduccionandroid.fragments.SecondFragment
import com.ifts4.introduccionandroid.fragments.ThirdFragment

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout

        val toolBar = binding.toolBar
        setSupportActionBar(toolBar)


        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.nav_drawer_home_open,R.string.nav_drawer_home_close)
        drawerLayout.addDrawerListener(toggle)

        binding.navigationView.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_burguer)


        if (savedInstanceState == null) {
            replaceFragment(FirstFragment())
            binding.navigationView.setCheckedItem(R.id.nav_item_one)
        }
    }


    private fun logOut() {
        val preferences = getSharedPreferences(RegisterActivity.CREDENTIALS, MODE_PRIVATE)
        preferences.edit().clear().apply()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_one -> {
                replaceFragment(FirstFragment())
            }

            R.id.nav_item_two -> {
                replaceFragment(SecondFragment())
            }

            R.id.nav_item_three -> {
                replaceFragment(ThirdFragment())
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }
}