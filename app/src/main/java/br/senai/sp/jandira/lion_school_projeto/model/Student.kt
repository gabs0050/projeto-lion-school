package br.senai.sp.jandira.lion_school_projeto.model

data class Student(
    val name: String,
    val registrationNumber: String,
    val year: Int,
    val photoId: Int // Placeholder for image resource ID (e.g., R.drawable.profile1)
)