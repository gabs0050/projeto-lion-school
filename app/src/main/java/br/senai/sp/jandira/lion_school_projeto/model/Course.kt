// Courses.kt
package br.senai.sp.jandira.lion_school_projeto.model

data class Course(
    val acronym: String,
    val nameResId: Int,
    val descriptionResId: Int,
    val durationResId: Int,
    val imageResId: Int? = null // Certifique-se de ter esta linha
)