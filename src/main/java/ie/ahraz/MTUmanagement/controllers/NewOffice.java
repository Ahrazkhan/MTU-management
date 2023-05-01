package ie.ahraz.MTUmanagement.controllers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record NewOffice (@Size(min = 1,max = 90)@NotNull @NotEmpty @NotBlank String officeNumber, int maxOccupancy, int currentOccupancy, @NotNull int titleId) {
}
