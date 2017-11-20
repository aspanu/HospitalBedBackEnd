package com.aspanu.hospitalbeds.data

import java.util.*

/**
 * Created by aspanu on 2017-11-19.
 */
data class Bed(val number: Int)

data class BedQueue(val freeBeds: Queue<Bed>, val takenBeds: MutableCollection<Bed>) {
    fun intializeBeds(numBeds: Int): BedQueue {
        (1..numBeds).mapTo(takenBeds) { Bed(number = it) }
        return this
    }

    @Synchronized
    fun getNextFreeBed(): Bed? {
        return freeBeds.poll()
    }

    fun takeBed(bedTaken: Bed) {
        takenBeds.add(bedTaken)
    }

    fun clearBed(bedNum: Int) {
        val bed = Bed(number = bedNum)
        takenBeds.remove(bed)
        freeBeds.add(bed)
    }
}