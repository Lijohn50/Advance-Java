package com.example.hotel_booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    private final BookingRepository bookingRepository;

    public List<Guest> getAllGuests() {

        return guestRepository.findAll();
    }

    public void saveGuest(Guest guest) {

        guestRepository.save(guest);
    }

    public void editGuest(Guest guest, int id) {

        guest.setId(id);
        guestRepository.save(guest);
    }

    public Guest EditGuestById(int id) {

        return guestRepository.findById(id).orElse(null);
    }

    public void deleteGuest(int id) {

        guestRepository.deleteById(id);
    }

    public long count() {

        return guestRepository.count();
    }

    public void saveBooking(Booking booking) {

        if(booking.getCheckIn() != null && booking.getCheckOut() != null) {

            long nights = ChronoUnit.DAYS.between(booking.getCheckIn(), booking.getCheckOut());
            booking.setDays(nights);
        }
        bookingRepository.save(booking);
    }
}
