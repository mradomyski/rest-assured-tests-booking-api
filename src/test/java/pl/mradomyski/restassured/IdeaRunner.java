package pl.mradomyski.restassured;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.utils.BookingRandomizer;

import java.io.IOException;

public class IdeaRunner {

        public static void main(String[] args) throws IOException, JsonGenerationException, JsonMappingException {

            BookingRandomizer bookingRandomizer = new BookingRandomizer();
            Booking randomBooking = bookingRandomizer.giveMeRandomBooking();
            ObjectMapper mapper = new ObjectMapper();
            String randomBookingString = mapper.writeValueAsString(randomBooking);
            System.out.println(randomBookingString); //Display the string.
        }

    }
