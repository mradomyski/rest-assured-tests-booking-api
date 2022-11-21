package pl.mradomyski.restassured.utils;

import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.pojos.BookingDates;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BookingRandomizer {

    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final java.util.Random rand = new java.util.Random();
    final Set<String> identifiers = new HashSet<>();
    final List<String> bookingDetailsList = new ArrayList<>();


    public Booking giveMeRandomCredentials() {
        String firstName = getRandomName();
        String lastName = getRandomName();

        return new Booking(firstName, lastName);
    }

    public Booking giveMeRandomBooking() {

        Booking randomBooking = new Booking();
        randomBooking.setLastName(getRandomName());
        randomBooking.setFirstName(getRandomName());
        randomBooking.setTotalPrice(getRandomPrice());
        randomBooking.setAdditionalNeeds(getRandomName());
        randomBooking.setBookingDates(getRandomBookingDates());
        randomBooking.setDepositPaid(getRandomBoolean());

        return randomBooking;
    }

    public Booking giveMeRandomPartialBooking() {

        getBookingDetailsStringList();
        int randomDetailsAmount = 1 + (int) (Math.random() * ((6 - 1) + 1));

        List<String> pickedRandomDetails = new ArrayList<>();
        for (int i = 0; i < randomDetailsAmount; i++) {
            pickedRandomDetails.add(bookingDetailsList.get(i));
        }
        Booking randomPartialBooking = new Booking();

        for (String detail : pickedRandomDetails) {

            switch (detail) {
                case "lastname":
                    randomPartialBooking.setLastName(getRandomName());
                    break;
                case "firstname":
                    randomPartialBooking.setFirstName(getRandomName());
                    break;
                case "additionalneeds":
                    randomPartialBooking.setAdditionalNeeds(getRandomName());
                    break;
                case "bookingdates":
                    randomPartialBooking.setBookingDates(getRandomBookingDates());
                    break;
                case "despositpaid":
                    randomPartialBooking.setDepositPaid(getRandomBoolean());
                    break;
                case "totalprice":
                    randomPartialBooking.setTotalPrice(getRandomPrice());
                    break;
            }
        }

        return randomPartialBooking;
    }

    public Integer getRandomPrice() {
        return 5 + (int) (Math.random() * ((10 - 5) + 1));
    }

    public String getRandomName() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    private boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private BookingDates getRandomBookingDates() {
        return new BookingDates(randomDate(), randomDate());
    }

    public static String randomDate() {
        int hundredYears = 100 * 365;
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, hundredYears)).toString();
    }

    private void getBookingDetailsStringList() {
        bookingDetailsList.add("lastname");
        bookingDetailsList.add("firstname");
        bookingDetailsList.add("additionalneeds");
        bookingDetailsList.add("despositpaid");
        bookingDetailsList.add("bookingdates");
        bookingDetailsList.add("totalprice");
    }
}
