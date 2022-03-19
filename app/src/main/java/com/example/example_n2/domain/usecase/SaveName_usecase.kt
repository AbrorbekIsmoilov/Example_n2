package com.example.example_n2.domain.usecase

import com.example.example_n2.domain.models.SaveName
import com.example.example_n2.domain.repository.RepositoryDomain

class SaveName_usecase(private val repositoryDomain: RepositoryDomain) {

    fun execute(model: SaveName) : Boolean{
        return if (model.name.isEmpty()){
            false
        } else {
            repositoryDomain.save(data = model)
        }

    }

}