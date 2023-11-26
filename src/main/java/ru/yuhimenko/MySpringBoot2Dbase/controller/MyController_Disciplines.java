package ru.yuhimenko.MySpringBoot2Dbase.controller;

import lombok.extern.slf4j.Slf4j;
import model.Response;
import model.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yuhimenko.MySpringBoot2Dbase.entity.Discipline;
import ru.yuhimenko.MySpringBoot2Dbase.service.DisciplineService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/discipline")
public class MyController_Disciplines {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping()
    public Response<List<Discipline>> allDiscipline() {
        Response.ResponseBuilder<List<Discipline>> responseBuilder = Response.builder();
        try {
            List<Discipline> allDiscipline = disciplineService.getAllDiscipline();
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(allDiscipline);
        } catch (Exception exception) {
            log.error("GET /api/discipline: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @GetMapping("/{id}")
    public Response<Discipline> getDiscipline(@PathVariable("id") int id) {
        Response.ResponseBuilder<Discipline> responseBuilder = Response.builder();
        try {
            Discipline discipline = disciplineService.getDiscipline(id);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(discipline);
        } catch (Exception exception) {
            log.error("GET /api/discipline/{}: {}", id, exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @PostMapping()
    public Response<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        Response.ResponseBuilder<Discipline> responseBuilder = Response.builder();
        try {
            Discipline updatedDiscipline = disciplineService.saveDiscipline(discipline);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(updatedDiscipline);
        } catch (Exception exception) {
            log.error("POST /api/discipline: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @PutMapping()
    public Response<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        Response.ResponseBuilder<Discipline> responseBuilder = Response.builder();
        try {
            Discipline updatedDiscipline = disciplineService.saveDiscipline(discipline);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(updatedDiscipline);
        } catch (Exception exception) {
            log.error("PUT /api/discipline: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @DeleteMapping("/discipline/{id}")
    public Response<Object> deleteDiscipline(@PathVariable("id") int id) {
        Response.ResponseBuilder<Object> responseBuilder = Response.builder();
        try {
            disciplineService.deleteDiscipline(id);
            responseBuilder.code(ResponseCode.SUCCESS);
        } catch (Exception exception) {
            log.error("DELETE /api/discipline/{}: {}", id, exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }
}
