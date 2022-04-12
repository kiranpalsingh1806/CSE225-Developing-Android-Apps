package com.example.formwithexternalstorage

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import java.io.*

class MainActivity : AppCompatActivity() {
    private val filepath = "MyFileStorage"
    internal var myExternalFile: File?=null
    private val isExternalStorageReadOnly: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            true
        } else {
            false
        }
    }
    private val isExternalStorageAvailable: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            true
        } else{
            false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fileName = findViewById(R.id.etFileName) as EditText
        val fileData1 = findViewById(R.id.etFileDataOne) as EditText
        val fileData2 = findViewById(R.id.etFileDataTwo) as EditText
        val fileData3 = findViewById(R.id.etFileDataThree) as EditText
        val saveButton = findViewById<Button>(R.id.btnSave) as Button
        val viewButton = findViewById(R.id.btnView) as Button

        saveButton.setOnClickListener(View.OnClickListener {
            myExternalFile = File(getExternalFilesDir(filepath), fileName.text.toString())
            try {
                val fileOutPutStream = FileOutputStream(myExternalFile)
                fileOutPutStream.write(fileData1.text.toString().toByteArray() + "  ".toByteArray())
                fileOutPutStream.write(fileData2.text.toString().toByteArray()+ "  ".toByteArray())
                fileOutPutStream.write(fileData3.text.toString().toByteArray()+ "  ".toByteArray())
                fileOutPutStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"Data saved",Toast.LENGTH_SHORT).show()
        })
        viewButton.setOnClickListener(View.OnClickListener {
            myExternalFile = File(getExternalFilesDir(filepath), fileName.text.toString())

            val filename = fileName.text.toString()
            myExternalFile = File(getExternalFilesDir(filepath),filename)
            if(filename.toString()!=null && filename.toString().trim()!=""){
                var fileInputStream =FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    stringBuilder.append(text)
                }
                fileInputStream.close()
                Toast.makeText(applicationContext,stringBuilder.toString(),Toast.LENGTH_SHORT).show()
            }
        })

        if (!isExternalStorageAvailable || isExternalStorageReadOnly) {
            saveButton.isEnabled = false
        }
    }
}