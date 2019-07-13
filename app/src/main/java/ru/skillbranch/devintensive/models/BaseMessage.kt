package ru.skillbranch.devintensive.models

import java.util.*


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
    companion object AbstractFactory {
        private var lastId: Int = -1
        fun makeMessage( from: User?, chat: Chat, date: Date, type: String = "text", payload: Any?, isIncoming: Boolean = false ) : BaseMessage {
            lastId++
            return when(type) {
                "image" -> ImageMessage(id = "$lastId", from = from, chat = chat, date = date, image = payload as String, isIncoming = isIncoming)
                else -> TextMessage(id = "$lastId", from = from, chat = chat, date = date, text = payload as String, isIncoming = isIncoming)
            }
        }
    }

}

