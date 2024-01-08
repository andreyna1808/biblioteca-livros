package com.andreyna.bibliotecalivros.service

import com.andreyna.bibliotecalivros.exception.AuthenticationException
import com.andreyna.bibliotecalivros.repository.CustomerRepository
import com.andreyna.bibliotecalivros.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val customerRepository: CustomerRepository
): UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val customer = customerRepository.findById(id.toInt())
            .orElseThrow { AuthenticationException("Usuario não encontrado", "999") }
        return UserCustomDetails(customer)
    }
}