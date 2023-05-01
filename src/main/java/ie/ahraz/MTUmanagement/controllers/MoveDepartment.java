package ie.ahraz.MTUmanagement.controllers;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record MoveDepartment(@Min(1) @NotNull int titleId) {

}
