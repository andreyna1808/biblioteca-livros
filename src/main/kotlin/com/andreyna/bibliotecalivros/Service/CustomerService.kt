package com.andreyna.bibliotecalivros.Service

import org.springframework.stereotype.Service
import com.andreyna.bibliotecalivros.Controller.Request.PostCustomerRequest
import com.andreyna.bibliotecalivros.Controller.Request.PutCustomerRequest
import com.andreyna.bibliotecalivros.Model.CustomerModel

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getFilterCustomer(name: String?): List<CustomerModel> {
        name?.let { return customers.filter { it.name.contains(name, true) } } //Se não for nulo, let então eu quero que rode
        // filtrando os customers que contenham o nome selecionado e que deve ser ignorado Maiusculas de minusculas.

        return customers
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun createCustomer(customer: PostCustomerRequest) { // Quero que a request venha do Body e receba os dados do CustomerModel
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!! + 1
        }

        customers.add(CustomerModel(id, customer.name, customer.email)) // Lista adiciona esse novo customer model
    }

    fun updateCustomer(id: Int, customer: PutCustomerRequest): PutCustomerRequest {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }

        return customer
    }

    fun deleteCustomer(id: Int): String { // :String significa o tipo de retorno que eu daria
        customers.removeIf { it.id == id }

        return "Deletado com sucesso"
    }
}