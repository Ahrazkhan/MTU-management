package ie.ahraz.MTUmanagement.controllers;

import ie.ahraz.MTUmanagement.controllers.dto.DepartmentDto;
import ie.ahraz.MTUmanagement.controllers.dto.DepartmentDtoMapper;
import ie.ahraz.MTUmanagement.controllers.dto.OfficeDto;
import ie.ahraz.MTUmanagement.controllers.dto.OfficeDtoMapper;
import ie.ahraz.MTUmanagement.dao.DepartmentRepo;
import ie.ahraz.MTUmanagement.dao.OfficeRepo;
import ie.ahraz.MTUmanagement.entites.Department;
import ie.ahraz.MTUmanagement.entites.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class WebService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private OfficeRepo officeRepo;

    @Autowired
    private DepartmentDtoMapper departmentDtoMapper;

    @Autowired
    private OfficeDtoMapper officeDtoMapper;

    @GetMapping("/department")
    public CollectionModel<DepartmentDto> getAllDepartment(){
       return departmentDtoMapper.toCollectionModel(departmentRepo.findAll());
    }

    @GetMapping("/office")
    public CollectionModel<OfficeDto> getAllOffice(){
        return officeDtoMapper.toCollectionModel(officeRepo.findAll());
    }

    @PostMapping({"/department","/department/"})
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDto addDepartment(@RequestBody @Valid NewDepartment payload, BindingResult bindingResult){

        try{
            if (bindingResult.hasErrors())
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Buddy there is an error");
            Department newDepartment = new Department(payload.titleName(), payload.emailAddress());
            return departmentDtoMapper.toModel(departmentRepo.save(newDepartment));

        }
        catch (DataIntegrityViolationException ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Department with titleName:"+ payload.titleName()+ " already exist.");
        }

    }

    @PostMapping({"/office","/office/"})
    @ResponseStatus(HttpStatus.CREATED)
    public OfficeDto addOffice(@RequestBody @Valid NewOffice payload, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Missing Data or typing error");
        Optional<Department> departmentOptional = departmentRepo.findById(payload.titleId());
        if(departmentOptional.isPresent()){
            Office newOffice = new Office(payload.officeNumber(), payload.maxOccupancy(), payload.currentOccupancy(), departmentOptional.get());
            return officeDtoMapper.toModel(officeRepo.save(newOffice));
        }
        else{
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Department with ID"+ payload.titleId()+" could not be found ");
        }
    }
    //IN move method i might be using a wrong query i could not figure it out so i commented it would be helpful if u let comment where i was doing wrong thanks

//    @PatchMapping("/office/{id}/move")
//    public OfficeDto moveDepartment(@PathVariable("id") int officesId, @Valid @RequestBody MoveDepartment payload, BindingResult bindingResult){
//        try {
//            if (bindingResult.hasErrors())
//                throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing data or something else is missing.");
//            officeRepo.moveDepartment(officesId, payload.titleId());
//            return officeDtoMapper.toModel(officeRepo.findById(officesId).get());
//        }
//        catch (DataIntegrityViolationException ex){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Department with Id:" + payload.titleId()+" could not be found.");
//        }
//    }

    @GetMapping("/department/{id}")
    public Department getADepartmentById(@PathVariable("id")int titleId) {
        Optional<Department> departmentOptional = departmentRepo.findById(titleId);
        if (departmentOptional.isPresent()) return departmentOptional.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"department with id:"+ titleId + " not found");
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartmentById(@PathVariable("id")int titleId) {
        try{
            departmentRepo.deleteById(titleId);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department with ID: "+ titleId +" Not Found");
        }

    }

    @GetMapping("/office/{id}")
    public Office getAOfficeById(@PathVariable("id")int officeId) {
        Optional<Office> officeOptional = officeRepo.findById(officeId);
        if (officeOptional.isPresent()) return  officeOptional.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Office with ID: "+ officeId + " not found");
    }

    @DeleteMapping("/office/{id}")
    public void deleteOfficeById(@PathVariable("id")int officeId) {
        try{
            officeRepo.deleteById(officeId);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Office with ID: " + officeId+ " Not Found");
        }

    }

//    http://localhost:3000/department/{Id}/office
    @GetMapping("/department/{id}/office")
     public List<Office> getOfficeInDepartment(@PathVariable("id")int titleId){
        if(departmentRepo.existsById(titleId))
             return officeRepo.findAllByDepartment_TitleId(titleId);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Department with ID: " + titleId + " Not Found");
    }
}
