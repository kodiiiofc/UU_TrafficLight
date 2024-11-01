package com.kodiiiofc.urbanuniversity.trafficlight

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.kodiiiofc.urbanuniversity.trafficlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigateUpButtonSwitcher {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit_menu -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun switchNavigateUpButton(status: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(status)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}