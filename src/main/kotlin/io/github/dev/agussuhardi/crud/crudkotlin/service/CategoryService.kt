package io.github.dev.agussuhardi.crud.crudkotlin.service

import io.github.dev.agussuhardi.crud.crudkotlin.dto.CategoryDTO
import io.github.dev.agussuhardi.crud.crudkotlin.vo.CategoryVO

/**
 * @author agussuhardi
 * {@code @created} 6/29/24 5:47 AM
 * {@code @project} crud-kotlin
 */
interface CategoryService {
    fun create(vo: CategoryVO): CategoryDTO
    fun update(vo: CategoryVO): CategoryDTO
    fun delete(vo: CategoryVO)
    fun findById(id: String): CategoryDTO
    fun findAll(): List<CategoryDTO>
}
