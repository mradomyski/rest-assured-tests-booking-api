package pl.mradomyski.restassured.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ErrorMessage {

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @SerializedName("reason")
    private String reason;


    public ErrorMessage() {
    }

    public ErrorMessage(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason);
    }

    @Override
    public String toString() {
        return reason;
    }
}
