package com.example.example_n2.data.storage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.example_n2.domain.models.GetName
import com.example.example_n2.domain.models.SaveName
import com.example.example_n2.domain.repository.RepositoryDomain

private const val KEY_SHARED = "shared_pref"
private const val KEY_NAME = "save_name"

class DataStorage(context: Context) : RepositoryDomain {

    val getSharedPreferences: SharedPreferences = context.getSharedPreferences(KEY_SHARED,Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    override fun save(data: SaveName): Boolean {
        getSharedPreferences.edit().putString(KEY_NAME,data.name).apply()
        return true
    }

    override fun getName(): GetName {
        val name = getSharedPreferences.getString(KEY_NAME,"")
        return GetName(name = name)
    }


}