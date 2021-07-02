package pl.mradomyski.restassured.utils;

import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.pojos.BookingDates;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BookingRandomizer {

    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final java.util.Random rand = new java.util.Random();
    final Set<String> identifiers = new HashSet<String>();

    public Booking giveMeRandomBooking() {

        Booking randomBooking = new Booking();
        randomBooking.setLastName(randomName());
        randomBooking.setFirstName(randomName());
        randomBooking.setTotalPrice(5 + (int)(Math.random() * ((10 - 5) + 1)));
        randomBooking.setAdditionalNeeds(randomName());
        randomBooking.setBookingDates(randomBookingDates());
        randomBooking.setDepositPaid(randomBoolean());

        return randomBooking;
    }

    private String randomName() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    private boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private BookingDates randomBookingDates(){
     return new BookingDates(randomDate(), randomDate());
    }

    public static String randomDate() {
        int hundredYears = 100 * 365;
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, hundredYears)).toString();
    }
}
