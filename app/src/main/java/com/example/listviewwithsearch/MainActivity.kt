package com.example.listviewwithsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    var edSearch:EditText?=null
    var ListViews1:ListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectViews()
        prepareListView()
    }
    private fun connectViews(){ edSearch=findViewById(R.id.edSearch);ListViews1=findViewById(R.id.ListViews1) }
    private fun prepareListView(){
        var array:ArrayList<String> = ArrayList()
        array.add("فيصـل")
        array.add("خالد")
        array.add("عمر")
        array.add("علي")
        array.add("محمد")
        array.add("عبدالله")
        array.add("فارس")
        var arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,array)
        ListViews1?.adapter = arrayAdapter
        ListViews1?.setOnItemClickListener { parent, view, position, id -> Log.e("onClickListener","${array.get(position)}");array.removeAt(position);arrayAdapter.notifyDataSetChanged() }

        edSearch?.addTextChangedListener { arrayAdapter.filter.filter(it) }
    }

}