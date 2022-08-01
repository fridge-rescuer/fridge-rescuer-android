package com.fridgerescuer.presentation.views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityMainBinding
import com.fridgerescuer.presentation.views.location.LocationActivity
import com.fridgerescuer.presentation.views.mypage.MypageActivity
import com.fridgerescuer.presentation.views.myfridge.MyfridgeActivity
import com.fridgerescuer.presentation.views.recipe.RecipeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presetWidget()
    }

    private fun presetWidget(){
        // action bar
        setSupportActionBar(binding.mainToolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        // myfridge, recipe button
        binding.mainMyfridgeButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, MyfridgeActivity::class.java))
            overridePendingTransition(R.anim.anim_rightin, 0)
        }
        binding.mainRecipeButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecipeActivity::class.java))
            overridePendingTransition(R.anim.anim_rightin, 0)
        }
    }

    // actionbar click
    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_main, menu)
        return true
    }
    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent = Intent()
        when (item.itemId) {
            R.id.action_location -> intent = Intent(this@MainActivity, LocationActivity::class.java)
            R.id.action_mypage -> intent = Intent(this@MainActivity, MypageActivity::class.java)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.anim_rightin, 0)
        return super.onOptionsItemSelected(item)
    }
}