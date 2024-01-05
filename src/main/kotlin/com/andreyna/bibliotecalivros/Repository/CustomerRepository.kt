package com.andreyna.bibliotecalivros.Repository

import com.andreyna.bibliotecalivros.Model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel> // Com isso o Spring já vai saber que ele precisa filtrar por nome
    // findByNameContaining vai buscar pelos nomes que contém essa string
    // findByName Ele busca exatamente o nome
    // Ex.: existe Andreyna se eu pesquisar findByNameContaining("a") vai me retornar o Andreyna
    // Se eu pesquisar findByName("a") vai me voltar vazio []
}