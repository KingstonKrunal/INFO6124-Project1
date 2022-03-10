package com.example.krunalshah.info6124_project1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    var myRecordList = ArrayList<String?>()
    val recordData = ArrayList<ItemsViewModel>()
    val adapter = myAdapter(recordData)
    var record: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsButton: Button = findViewById(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val intent = Intent(this, settingsActivity::class.java)
            startActivity(intent)
        }

        val addRecordButton: Button = findViewById(R.id.addRecordButton)
        addRecordButton.setOnClickListener {
            val intent = Intent(this, addRecords::class.java)
            startActivity(intent)
        }

        val removeLastButton: Button = findViewById(R.id.removeLastButton)
        removeLastButton.setOnClickListener {
            myRecordList.removeLast()
            recordData.removeLast()

            adapter.notifyDataSetChanged()
        }

        val removeAllButton: Button = findViewById(R.id.removeAllButton)
        removeAllButton.setOnClickListener {
            myRecordList.clear()
            recordData.clear()

            adapter.notifyDataSetChanged()
        }

        val recyclerview = findViewById<RecyclerView>(R.id.recordsRecyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        record = intent.getStringExtra("activity")

        myRecordList = getArrayPrefs(R.string.record_list.toString(), this)
        myRecordList.add(record)

        myRecordList.forEach {
            if (record!=null) {
                recordData.add(ItemsViewModel(it!!))
            }
        }

        adapter.notifyDataSetChanged()
    }

    fun setArrayPrefs(arrayName: String, array: ArrayList<String?>, mContext: Context) {
        val prefs = this.getPreferences(Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putInt(arrayName + "_size", array.size)

        for (i in 0 until array.size) editor.putString(arrayName + "_" + i, array[i])
        editor.apply()
    }

    fun getArrayPrefs(arrayName: String, mContext: Context): ArrayList<String?> {
        val prefs = this.getPreferences(Context.MODE_PRIVATE)
        val size = prefs.getInt(arrayName + "_size", 0)
        val array: ArrayList<String?> = ArrayList(size)

        for (i in 0 until size) array.add(prefs.getString(arrayName + "_" + i, null))

        return array
    }

    override fun onStop() {
        super.onStop()
        setArrayPrefs(R.string.dAndT_list.toString(), myRecordList, this)
    }
}