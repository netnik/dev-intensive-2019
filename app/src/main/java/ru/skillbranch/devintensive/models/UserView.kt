package ru.skillbranch.devintensive.models

/**
 * Created by CheNeo on 01.07.2019.
 * Copyright (c) 2019 NetNik. All rights reserved.
 **/

class UserView(
    val id: String,
    val fullName: String,
    val nickName: String,
    var avatar: String? = null,
    var status: String? = "offline",
    val initials: String?

) {
    fun printMe() {
        println("""
            id: $id
            fullName: $fullName
            nickName: $nickName
            avatar: $avatar 
            status: $status 
            initials: $initials
        """.trimIndent())
    }
}
