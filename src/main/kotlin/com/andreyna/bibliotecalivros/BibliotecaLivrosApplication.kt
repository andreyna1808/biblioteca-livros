package com.andreyna.bibliotecalivros

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class BibliotecaLivrosApplication

fun main(args: Array<String>) {
	runApplication<BibliotecaLivrosApplication>(*args)
}
