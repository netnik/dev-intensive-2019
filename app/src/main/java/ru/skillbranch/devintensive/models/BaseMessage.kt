package ru.skillbranch.devintensive.models

import java.util.*
import java.lang.*


/**
 * Created by CheNeo on 05.07.2019.
 * Copyright (c) 2019 NetNik. All rights reserved.
 **/


abstract class BaseMessage (
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {

    abstract  fun formatMessage(): String
    companion object AbstractFactory{
        var lastId = -1
        fun makeMessage(
            from: User?,
            chat: Chat,
            date: Date,
            type: String = "text",
            payload: Any?,
            isIncoming: Boolean = false
        ): BaseMessage {
            lastId++
            return when(type) {
                "image"-> ImageMessage("${lastId}", from, chat, date = date, image = payload as String, isIncoming = isIncoming)
                "text" -> TextMessage("${lastId}", from, chat, date = date, text = payload as String, isIncoming = isIncoming)
                else -> throw IllegalArgumentException()
            }
        }
    }

}

