package com.andreyna.bibliotecalivros.Controller

import com.andreyna.bibliotecalivros.Controller.Request.PostCustomerRequest
import com.andreyna.bibliotecalivros.Controller.Request.PutCustomerRequest
import com.andreyna.bibliotecalivros.Model.CustomerModel
import com.andreyna.bibliotecalivros.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers") // Define o caminho no Params
class CustomerController(val customerService: CustomerService) { // Assim o Spring vai saber que precisa injetar a CustomerService

    @GetMapping // Dá um get geral nos customers
    fun getCustomer(@RequestParam name: String?): List<CustomerModel> { // Se tiver, passa o params
       return customerService.getFilterCustomer(name)
    }

    @GetMapping("/{id}") // Dá um get de Acordo com o Id
    fun getCustomerById(@PathVariable id: Int): CustomerModel {
        return customerService.getCustomerById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Mudo o status de sucesso 200 para created 201
    fun createCustomer(@RequestBody customer: PostCustomerRequest) { // Quero que a request venha do Body e receba os dados do CustomerModel
        customerService.createCustomer(customer)
    }

    @PutMapping("/{id}") // Dá um update de Acordo com o Id
    @ResponseStatus(HttpStatus.NO_CONTENT) // Mudo o status de sucesso 200 para no content 204
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest): PutCustomerRequest {
        return customerService.updateCustomer(id, customer)
    }

    @DeleteMapping("/{id}") // Dá um delete de Acordo com o Id
    @ResponseStatus(HttpStatus.NO_CONTENT) // Mudo o status de sucesso 200 para no content 204
    fun deleteCustomer(@PathVariable id: Int): String { // :String significa o tipo de retorno que eu daria
        return customerService.deleteCustomer(id)
    }
}