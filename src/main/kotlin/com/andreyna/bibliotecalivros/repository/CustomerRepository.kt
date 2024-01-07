package com.andreyna.bibliotecalivros.repository

import com.andreyna.bibliotecalivros.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Int> {

    fun findAll(pageable: Pageable): Page<CustomerModel>
    fun findByNameContaining(name: String, pageable: Pageable): Page<CustomerModel> // Com isso o Spring já vai saber que ele precisa filtrar por nome
    // findByNameContaining vai buscar pelos nomes que contém essa string
    // findByName Ele busca exatamente o nome
    // Ex.: existe Andreyna se eu pesquisar findByNameContaining("a") vai me retornar o Andreyna
    // Se eu pesquisar findByName("a") vai me voltar vazio []
}