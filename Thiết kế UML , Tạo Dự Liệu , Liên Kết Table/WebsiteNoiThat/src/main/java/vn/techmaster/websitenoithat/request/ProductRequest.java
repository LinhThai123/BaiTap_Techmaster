package vn.techmaster.websitenoithat.request;

import javax.validation.constraints.NotBlank;

public record ProductRequest(
        @NotBlank(message = "Name cannot null") String name,

        @NotBlank(message = "Quantity cannot null") int quantity ,

        @NotBlank(message = "Price cannot null") double price ,

         double discount ,

        @NotBlank(message = "Image cannot null") String image ,

        @NotBlank(message = "Description cannot null") String description) {
}
