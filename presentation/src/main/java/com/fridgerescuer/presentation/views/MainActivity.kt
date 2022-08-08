package com.fridgerescuer.presentation.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityMainBinding
import com.fridgerescuer.presentation.views.location.LocationActivity
import com.fridgerescuer.presentation.views.mypage.MypageActivity
import com.fridgerescuer.presentation.views.recipe.RecipeActivity
import com.fridgerescuer.presentation.views.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presetWidget()
        presetMyIngr()
    }

    private fun presetWidget() {
        // action bar
        setSupportActionBar(binding.mainToolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        // search bar
        binding.mainSearchButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, SearchActivity::class.java))
            overridePendingTransition(R.anim.anim_rightin, 0)
        }

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

    private fun presetMyIngr(){
        val ingrView0 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.mainIngrContainer, true)
        val ingrView1 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.mainIngrContainer, true)
        val ingrView2 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.mainIngrContainer, true)
        val ingrView3 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.mainIngrContainer, true)
        val ingrView4 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.mainIngrContainer, true)
        val ingrView5 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.mainIngrContainer, true)


    }

    // actionbar click override
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