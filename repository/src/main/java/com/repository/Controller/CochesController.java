package com.repository.Controller;

import com.repository.Exception.AlreadyExistsException;
import com.repository.Exception.IsEmptyException;
import com.repository.Exception.NotExistsException;
import com.repository.Exception.NullException;
import com.repository.Service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CochesController {

    @Autowired
    private CocheService cochesService;

    @PostMapping("/coches")
    public ResponseEntity<String> anyadirCoche(@RequestBody CocheInput coche) {
        try {
            cochesService.anyadirCoche(coche);
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        } catch (IsEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch (NullException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/coches")
    public ResponseEntity<List<CocheOutput>> listarCoches() {
        List<CocheOutput> coches = null;
        try {
            coches = cochesService.getCoches();
            return ResponseEntity.ok(coches);
        } catch (IsEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch (NullException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }
    @GetMapping("coches/{matricula}")
    public ResponseEntity<CocheOutputMatricula> listarCocheId(@PathVariable String matricula) {
        try {
            CocheOutputMatricula c = cochesService.getCocheId(matricula);
            return ResponseEntity.ok(c);
        } catch (IsEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch (NullException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch (NotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
