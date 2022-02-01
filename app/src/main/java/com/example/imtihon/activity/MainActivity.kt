package com.example.imtihon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imtihon.adapter.CustomAdapter
import com.example.imtihon.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import com.example.imtihon.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val members = prepareMember()
        refreshAdapter(members)
    }
    fun initViews(){
        val sdk = Build.VERSION.SDK_INT
        if (sdk <= Build.VERSION_CODES.ECLAIR) {
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 1)
        }

    }
    fun prepareMember(): ArrayList<Member>{
        var members = ArrayList<Member>()
        for (i in 0..10){
            members.add(Member("Diner Steakhouse", R.drawable.img))
            members.add(Member("Diner Steakhouse", R.drawable.img_1))
            members.add(Member("Diner Steakhouse", R.drawable.img_2))
            members.add(Member("Diner Steakhouse", R.drawable.img_3))
            members.add(Member("Diner Steakhouse", R.drawable.img_4))
            members.add(Member("Diner Steakhouse", R.drawable.img))
            members.add(Member("Diner Steakhouse", R.drawable.img_1))
            members.add(Member("Diner Steakhouse", R.drawable.img_2))
            members.add(Member("Diner Steakhouse", R.drawable.img_3))
            members.add(Member("Diner Steakhouse", R.drawable.img_4))
        }
        return members
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }

}