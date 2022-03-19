package com.example.example_n2.domain.repository

import com.example.example_n2.domain.models.GetName
import com.example.example_n2.domain.models.SaveName

interface RepositoryDomain {

    fun save(data : SaveName) : Boolean

    fun getName() : GetName
}