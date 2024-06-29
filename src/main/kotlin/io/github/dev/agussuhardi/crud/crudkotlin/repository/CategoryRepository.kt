package io.github.dev.agussuhardi.crud.crudkotlin.repository

import io.github.dev.agussuhardi.crud.crudkotlin.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author agussuhardi
 * {@code @created} 6/29/24 5:41 AM
 * {@code @project} crud-kotlin
 */
interface CategoryRepository : JpaRepository<Category, String>
