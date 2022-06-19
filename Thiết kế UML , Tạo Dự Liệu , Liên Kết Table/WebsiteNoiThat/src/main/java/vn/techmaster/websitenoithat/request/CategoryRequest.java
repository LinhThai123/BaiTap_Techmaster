package vn.techmaster.websitenoithat.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record CategoryRequest(

        @NotBlank(message = "Name cannot null") String name,

        @NotBlank(message = "code cannot null") String code)
         { }
