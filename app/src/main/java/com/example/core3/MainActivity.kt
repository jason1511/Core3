package com.example.core3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datastream: InputStream = resources.openRawResource(R.raw.medallists)
        var medalist:MutableList<Medallist> = arrayListOf()
        val reader = datastream.bufferedReader()
        reader.readLine()
        var line = reader.readLine()
        while (line!=null){
            val coll:List<String> = line.split(",")
            val itemlist = Medallist(coll[0],
                coll[1],
                coll[2].toInt(),
                coll[3].toInt(),
                coll[4].toInt(),
                coll[5].toInt())
            medalist.add(itemlist)
            line = reader.readLine()
        }
        val listmain = findViewById<RecyclerView>(R.id.listmedal)
        listmain.layoutManager = LinearLayoutManager(this)
        listmain.adapter = MedalAdaptor(medalist)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE)
        val savedTitle = sharedPreferences.getString("title",null)
        val savedIOC = sharedPreferences.getString("IOC",null)
        val id = item.itemId
        if(id==R.id.save){
            val i = Intent(this, MainActivity2::class.java).apply {
                putExtra("title",savedTitle)
                putExtra("IOC",savedIOC)
            }
            startActivity(i)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}