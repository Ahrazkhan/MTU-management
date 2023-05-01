package ie.ahraz.MTUmanagement.controllers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record NewDepartment (@Size(min=1,max = 40)@NotBlank @NotEmpty @NotNull String titleName, String emailAddress) {
}
