package com.smoothstack.utopia.airplane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping(path="/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneRepository airplaneRepository;

    @PostMapping
    public @ResponseBody String addNewAirplane (@RequestBody Airplane airplane) {
        Integer outputId = airplaneRepository.save(airplane).getId();
        return String.format("Created Airplane ID: %s", outputId);
    }

    @GetMapping()
    public @ResponseBody Iterable<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Airplane getAirplaneById(
            @PathVariable(value = "id") Integer id) {
        Optional<Airplane> a = airplaneRepository.findById(id);

        if (a.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airplane not found");

        return a.get();
    }

    @PutMapping("/{id}")
    public @ResponseBody String updateAirplane(
            @PathVariable(value= "id") Integer id,
            @RequestBody Airplane airplane) {
        airplane.setId(id);
        Integer outputId = airplaneRepository.save(airplane).getId();
        return String.format("Updated Airplane ID: %s", outputId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAirplane(
            @PathVariable(value = "id") Integer id) {
        try {
            airplaneRepository.deleteById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(String.format("Deleted Airplane ID: %s", id));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("Airplane ID Not Found: %s", id));
        }
    }
}