package com.andreyna.bibliotecalivros.Repository

import com.andreyna.bibliotecalivros.Model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Int> {
}