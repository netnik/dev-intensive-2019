package ru.skillbranch.devintensive.models

import java.util.*


/**
 * Created by CheNeo on 05.07.2019.
 * Copyright (c) 2019 NetNik. All rights reserved.
 **/


class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
    " ${if (isIncoming) "получил" else "отправил"} Message \"$text\""
    //${date.humanizeDiff()}"  <-- homework
}


