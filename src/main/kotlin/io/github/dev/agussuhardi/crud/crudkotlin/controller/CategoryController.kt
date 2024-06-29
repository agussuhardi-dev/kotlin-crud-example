package io.github.dev.agussuhardi.crud.crudkotlin.controller

import io.github.dev.agussuhardi.crud.crudkotlin.dto.CategoryDTO
import io.github.dev.agussuhardi.crud.crudkotlin.repository.CategoryRepository
import io.github.dev.agussuhardi.crud.crudkotlin.service.CategoryService
import io.github.dev.agussuhardi.crud.crudkotlin.vo.CategoryVO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author agussuhardi
 * {@code @created} 6/29/24 7:06 AM
 * {@code @project} crud-kotlin
 */
@RestController
@RequestMapping("/api/categories", produces = ["application/json"])
class CategoryController(val service: CategoryService, private val categoryRepository: CategoryRepository) {

    @PostMapping(consumes = ["application/json"])
    fun create(@RequestBody vo: CategoryVO): ResponseEntity<CategoryDTO> {
        val dto = service.create(vo)
        return ResponseEntity.status(HttpStatus.CREATED).body(dto)
    }

    @PutMapping(consumes = ["application/json"])
    fun update(@RequestBody vo: CategoryVO): ResponseEntity<CategoryDTO> {
        return ResponseEntity.ok().body(service.update(vo))
    }

    @DeleteMapping(consumes = ["application/json"])
    fun delete(@RequestBody vo: CategoryVO): ResponseEntity<Void> {
        service.delete(vo)
        println("success")
        return ResponseEntity.ok().build()
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: String): ResponseEntity<CategoryDTO> {
        return ResponseEntity.ok().body(service.findById(id))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<CategoryDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }
}
