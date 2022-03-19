package com.example.example_n2.domain.usecase

import com.example.example_n2.domain.models.GetName
import com.example.example_n2.domain.repository.RepositoryDomain

class GetName_usecase(private val repository : RepositoryDomain) {

    fun execute() : GetName{
        return repository.getName()
    }

}