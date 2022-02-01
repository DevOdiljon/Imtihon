package com.example.imtihon.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imtihon.adapter.CustomAdapter
import com.example.imtihon.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import android.telephony.TelephonyManager
import android.telephony.TelephonyManager.PHONE_TYPE_NONE
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imtihon.R
import java.util.Objects.requireNonNull


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val members = prepareMember()
        refreshAdapter(members)
    }
    fun initViews(){
        val manager = applicationContext.getSystemService(Context.TELEPHONY_SERVICE)as TelephonyManager

        if (requireNonNull(manager).phoneType === PHONE_TYPE_NONE){
            recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        }else{
            recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)


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