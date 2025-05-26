package com.ifts4.introduccionandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ifts4.introduccionandroid.bottomMenuFragments.DescriptionFragment
import com.ifts4.introduccionandroid.bottomMenuFragments.SettingsFragment
import com.ifts4.introduccionandroid.databinding.ActivityBottomMenuBinding

class BottomMenuActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityBottomMenuBinding
    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navigation = binding.navView
        navigation.setOnNavigationItemSelectedListener(this)

        supportFragmentManager.commit {
            replace(R.id.fragmentContainer2, DescriptionFragment())
            addToBackStack("replacement")
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.itemLoginFragment -> {
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainer2, DescriptionFragment())
                    addToBackStack("replacement")
                }
                true
            }


            R.id.itemRegisterFragment -> {
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainer2, DescriptionFragment())
                    addToBackStack("replacement")
                }
                true
            }

            else -> {
                false
            }
        }
    }
}