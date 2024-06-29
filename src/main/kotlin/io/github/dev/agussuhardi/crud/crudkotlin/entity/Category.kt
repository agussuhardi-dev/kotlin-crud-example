package io.github.dev.agussuhardi.crud.crudkotlin.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.UuidGenerator

/**
 * @author agussuhardi
 * {@code @created} 6/29/24 5:50 AM
 * {@code @project} crud-kotlin
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
data class Category(
    @Column(name = "id", nullable = false)
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue
    var id: String?,
    var name: String
) {
    constructor() : this(null, "")
}
