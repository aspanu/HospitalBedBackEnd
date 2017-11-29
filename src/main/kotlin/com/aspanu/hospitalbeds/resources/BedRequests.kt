package com.aspanu.hospitalbeds.resources;

import com.aspanu.hospitalbeds.data.Bed
import com.aspanu.hospitalbeds.data.BedQueue
import com.aspanu.hospitalbeds.data.Request
import java.time.LocalDateTime
import java.util.*
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam

/**
 * Created by aspanu on 2017-11-19.
 */
@Path("/")
class BedRequests {

    private val numBeds = 3
    private val beds = BedQueue(freeBeds = LinkedList<Bed>(), takenBeds = HashSet()).intializeBeds(numBeds)
    private val requests = LinkedList<Request>()

    @Path("/request/bed/{operating_room_name}")
    @POST
    fun requestBed(@PathParam("operating_room_name") opRoomName: String ): Int {
        val bedToOffer = beds.getNextFreeBed() ?: return addToWaitingRequests(opRoomName)
        beds.takeBed(bedToOffer)

        return bedToOffer.number
    }

    private fun addToWaitingRequests(opRoomName: String): Int {
        requests.add(Request(operatingRoomName = opRoomName, timeRequested = LocalDateTime.now(), timeFilled = null))
        return -1
    }

    @Path("/bed/clear")
    @POST
    fun clearBed(@QueryParam("bedNum") bedNum: Int): Int {
        beds.clearBed(bedNum)
        assignBedIfNecessary()
        return bedNum
    }

    private fun assignBedIfNecessary() {
        if (requests.isEmpty()) {
            return
        }
        val bed = beds.getNextFreeBed() ?: return // If someone beat us to this bed, then just don't do anything
        val request = requests.pop()
        beds.takeBed(bed)

        request.timeFilled = LocalDateTime.now()
        // TODO: callback to the OR that they have a bed
        // callbackForBedDone(request, bed)
    }


}
