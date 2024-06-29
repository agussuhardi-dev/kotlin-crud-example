package io.github.dev.agussuhardi.crud.crudkotlin.service.impl

import io.github.dev.agussuhardi.crud.crudkotlin.dto.CategoryDTO
import io.github.dev.agussuhardi.crud.crudkotlin.entity.Category
import io.github.dev.agussuhardi.crud.crudkotlin.repository.CategoryRepository
import io.github.dev.agussuhardi.crud.crudkotlin.service.CategoryService
import io.github.dev.agussuhardi.crud.crudkotlin.vo.CategoryVO
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

/**
 * @author agussuhardi
 * {@code @created} 6/29/24 5:51 AM
 * {@code @project} crud-kotlin
 */
@Service
class CategoryServiceImpl(val repository: CategoryRepository) : CategoryService {
    override fun create(vo: CategoryVO): CategoryDTO {
        var category: Category = Category(
            id = "",
            name = vo.name!!
        )
        category = repository.save(category)
        BeanUtils.copyProperties(category, CategoryDTO::class.java)
        return CategoryDTO(
            id = category.id!!,
            name = category.name
        )
    }

    override fun update(vo: CategoryVO): CategoryDTO {
        var category: Category = repository.findById(vo.id!!).orElseThrow()
        category.name = vo.name!!
        category = repository.save(category)
        BeanUtils.copyProperties(category, CategoryDTO::class.java)
        return CategoryDTO(
            id = category.id!!,
            name = category.name
        )
    }

    override fun delete(vo: CategoryVO) {
        val category = repository.findById(vo.id!!).orElseThrow()
        repository.delete(category)
    }

    override fun findById(id: String): CategoryDTO {
        val category = repository.findById(id).orElseThrow()
        BeanUtils.copyProperties(category, CategoryDTO::class.java)
        return CategoryDTO(
            id = category.id!!,
            name = category.name
        )
    }

    override fun findAll(): List<CategoryDTO> {
        val categories = repository.findAll()
        val list: MutableList<CategoryDTO> = mutableListOf()
        categories.forEach { category ->
            BeanUtils.copyProperties(category, CategoryDTO::class.java)
            list.add(
                CategoryDTO(
                    id = category.id!!,
                    name = category.name
                )
            )
        }
        return list
    }

}
