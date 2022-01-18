package com.example.swipe_able

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swipe_able.adapter.ViewPagerAdapter
import com.example.swipe_able.api.API
import com.example.swipe_able.api.Network
import com.example.swipe_able.model.Data
import com.example.swipe_able.repository.TextRepository
import com.example.swipe_able.viewmodel.TextViewModel
import com.example.swipe_able.viewmodel.TextViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var textViewModel: TextViewModel
    private var textList = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api=Network.getInstance().create(API::class.java)
        val textRepository=TextRepository(api)

        textViewModel=ViewModelProvider(this,TextViewModelFactory(textRepository)).get(TextViewModel::class.java)
        textViewModel.text.observe(this, Observer {

            it.let {
                textList.clear()
                textList.addAll(it.data)
                setViewPager()
            }
        })
    }
    private fun setViewPager(){
        viewPager.adapter=ViewPagerAdapter(textList)
    }
}