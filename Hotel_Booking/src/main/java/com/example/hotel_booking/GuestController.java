package com.example.hotel_booking;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class GuestController {

    private final GuestService guestService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("count", guestService.count());
        return "dashboard";
    }

    @GetMapping("/guests")
    public String guestList(Model model) {

        model.addAttribute("guest", guestService.getAllGuests());
        return "guests";
    }

    @GetMapping("/form")
    public String showForm(Model model) {

        model.addAttribute("guest", new Guest());
        return "form";
    }

    @PostMapping("/form")
    public String addGuest(@Valid @ModelAttribute Guest guest, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {

            return "form";
        }
        guestService.saveGuest(guest);
        return "redirect:/home/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {

        Guest guest = guestService.EditGuestById(id);

        model.addAttribute("guest", guest);

        return "form";
    }

    @PostMapping("/edit/{id}")
    public String editGuest(@Valid @ModelAttribute Guest guest, @PathVariable int id){


        guestService.editGuest(guest, id);
        return "redirect:/home/form";
    }

    @GetMapping("/guests/{id}")
    public String deleteGuest(@PathVariable int id) {

        guestService.deleteGuest(id);
        return "redirect:/home/guests";
    }

    @GetMapping("/booking")
    public String showBooking(Model model) {

        model.addAttribute("booking", new Booking());
        return "onetoone";
    }

    @PostMapping("/booking")
    public String addBooking(@ModelAttribute Booking booking) {

        System.out.println("hello from booking" + booking.getPaymentStatus());
        guestService.saveBooking(booking);
        return "redirect:/home/booking";
    }
}
