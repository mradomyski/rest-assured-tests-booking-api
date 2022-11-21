package pl.mradomyski.restassured.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Booking {

    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("totalprice")
    private Integer totalPrice;
    @SerializedName("depositpaid")
    private boolean depositPaid;
    @SerializedName("bookingdates")
    private BookingDates bookingDates;
    @SerializedName("additionalneeds")
    private String additionalNeeds;


    public Booking() {
    }

    public Booking(String firstName, String lastName, Integer totalPrice, boolean depositPaid, BookingDates bookingDates, String additionalNeeds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
    }

    public Booking(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return depositPaid == booking.depositPaid &&
                Objects.equals(firstName, booking.firstName) &&
                Objects.equals(lastName, booking.lastName) &&
                Objects.equals(totalPrice, booking.totalPrice) &&
                Objects.equals(bookingDates, booking.bookingDates) &&
                Objects.equals(additionalNeeds, booking.additionalNeeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, totalPrice, depositPaid, bookingDates, additionalNeeds);
    }

    @Override
    public String toString() {
        return "\"firstname\": \"" + firstName +
                "\", \"lastname\": \"" + lastName +
                "\", \"totalprice\": \"" + totalPrice +
                "\", \"depositpaid\": \"" + depositPaid +
                "\", \"bookingdates\": {" + bookingDates +
                "\"}, \"additionalneeds\": \"" + additionalNeeds +"\"}";
    }
}
