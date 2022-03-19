package com.example.example_n2.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.example_n2.R
import com.example.example_n2.data.storage.DataStorage
import com.example.example_n2.domain.models.SaveName
import com.example.example_n2.domain.usecase.GetName_usecase
import com.example.example_n2.domain.usecase.SaveName_usecase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataStorage by lazy { DataStorage(applicationContext) }
    private val saveName_usecase by lazy { SaveName_usecase(repositoryDomain = dataStorage) }
    private val getName_usecase by lazy { GetName_usecase(repository = dataStorage) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_btn.setOnClickListener {
            val name = name_et.text.toString()
            val saveModel = SaveName(name)
            val result = saveName_usecase.execute(model = saveModel)
            if (result) result_tv.text = "Muvaffaqiyatli saqlab olindi"
            else result_tv.text = "Siz hech narsa yozmadingiz"
        }
        getName_btn.setOnClickListener {
            val data = getName_usecase.execute()
            result_tv.text = "Name = ${data.name}"
        }

    }
}