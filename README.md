# HospitalBedBackEnd

This application will deal with all of the logic of providing a back-end REST application which will deal with the functionality of each of the components of the recovery bed system

## Endpoints

### Request Bed

endpoint: /request/bed/{operating_room_number}
Description: Requested by an operating room only

### Accept Bed Request

endpoint: /request/?room={operating_room_number}&bed={bed_number_reserved}&result='accept'
Description: Response by the recovery room

### Reject Bed Request

endpoint: /request/?room={operating_room_number}&bed={bed_number_reserved}&result='reject'
Description: Response by the recovery room

### Clear Bed

endpoint: /bed/?bed={bed_number_cleared}
Description: The recovery room clearing a bed once a patient is ready to go. Mostly here for a more automated solution in the future, if desired
