package com.acme.graduates.demo.controller;

import com.acme.graduates.demo.domain.model.Graduate;
import com.acme.graduates.demo.domain.service.GraduateService;
import com.acme.graduates.demo.resource.GraduateResource;
import com.acme.graduates.demo.resource.SaveGraduateResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GraduateController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private GraduateService graduateService;

    @Operation(summary = "Get All graduate", description = "Get All available graduate", tags = {"graduate"})
    @GetMapping("/graduate")
    public List<Graduate> getAllGraduate() {
        return graduateService.getAllGraduates();
    }

    @Operation(summary = "Get graduate By Id", description = "Get graduate for given Id", tags = {"graduate"})
    @GetMapping("/graduate/{id}")
    public GraduateResource getGraduateById(@PathVariable(name = "id") Long id){
        return convertToResource(graduateService.getGraduatesById(id));
    }

    @Operation(summary = "Create graduate", description = "Create a new graduate", tags = {"graduate"})
    @PostMapping("/graduate")
    public GraduateResource createGraduate(@Valid @RequestBody SaveGraduateResource resource){
        Graduate userNoChef = convertToEntity(resource);
        return convertToResource(graduateService.createGraduate(userNoChef));
    }

    @Operation(summary = "Update graduate", description = "Update graduate with given Id", tags = {"graduate"})
    @PutMapping("/graduate/{id}")
    public GraduateResource updateGraduateResource(@PathVariable(name = "id") Long userNoChefId,
                                                 @Valid @RequestBody SaveGraduateResource resource){
        return convertToResource(graduateService.updateGraduate(userNoChefId,convertToEntity(resource)));
    }

    @Operation(summary = "Delete graduate", description = "Delete graduate with given Id", tags = {"graduate"})
    @DeleteMapping("/graduate/{id}")
    public ResponseEntity<?> deleteGraduate (@PathVariable(name = "id")  Long id){
        return graduateService.deleteGraduate(id);
    }

    private Graduate convertToEntity(SaveGraduateResource resource) {
        return mapper.map(resource, Graduate.class);
    }

    private GraduateResource convertToResource(Graduate entity) {
        return mapper.map(entity, GraduateResource.class);
    }
}
