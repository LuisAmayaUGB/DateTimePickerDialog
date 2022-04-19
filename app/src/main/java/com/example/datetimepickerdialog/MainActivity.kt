package com.example.datetimepickerdialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
 import android.text.format.DateFormat


import java.util.*

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {
    lateinit var textView: TextView
    lateinit var button: Button

    var currentHour = 0
    var currentMinut: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.btnPick)
        button.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()

            hour = calendar.get(Calendar.HOUR)
            minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(this@MainActivity, this@MainActivity, hour, minute,
                DateFormat.is24HourFormat(this))

            timePickerDialog.show()
        }
    }



    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minuteOfDay: Int) {
        currentHour = hourOfDay
        currentMinut = minuteOfDay
        textView.setText(String.format("%02d",currentHour)+":"+String.format("%02d",currentMinut))
    }
}