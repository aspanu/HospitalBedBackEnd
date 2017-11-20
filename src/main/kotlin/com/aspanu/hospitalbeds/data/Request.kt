package com.aspanu.hospitalbeds.data

import java.time.LocalDateTime

/**
 * Created by aspanu on 2017-11-19.
 */

data class Request(val operatingRoomName: String, var timeRequested: LocalDateTime, var timeFilled: LocalDateTime?)