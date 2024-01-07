package com.andreyna.bibliotecalivros.Service

import org.springframework.stereotype.Service
import com.andreyna.bibliotecalivros.Model.CustomerModel
import com.andreyna.bibliotecalivros.Repository.CustomerRepository
import com.andreyna.bibliotecalivros.enums.CustomerStatus
import com.andreyna.bibliotecalivros.enums.Errors
import com.andreyna.bibliotecalivros.exception.Request.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Service
class CustomerService (val customerRepository: CustomerRepository, val bookService: BookService) {

    fun getFilterCustomer(name: String?, pageable: Pageable): Page<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(name, pageable)
        } //Se não for nulo, let então eu quero que rode

        return customerRepository.findAll(pageable)
    }

    fun getCustomerById(id: Int): CustomerModel { // :CustomerModel significa o tipo de retorno que eu daria
        return customerRepository.findById(id).orElseThrow{ NotFoundException(Errors.C001.message.format(id), Errors.C001.code) } // Se não tiver dados inputa uma execpetion
    }

    fun createCustomer(customer: CustomerModel) { // Quero que a request venha do Body e receba os dados do CustomerModel
        customerRepository.save(customer)
    }

    fun updateCustomer(id: Int, customer: CustomerModel) {

        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception( NotFoundException(Errors.C001.message.format(customer.id), Errors.C001.code) )
        }

        customerRepository.save(customer) // Para criar e atualizar ambos usam save, mas tem que fazer uma validaçao antes
    }

    fun deleteCustomer(id: Int) {
        val customer = getCustomerById(id)

        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
    }
}