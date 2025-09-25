package com.example.maps12.controller;

import com.example.maps12.dto.UbicacionDTO;
import com.example.maps12.entity.Repartidor;
import com.example.maps12.repository.RepartidorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repartidores")
@RequiredArgsConstructor
public class RepartidorController {

    private final RepartidorRepository repo;

    @PutMapping("/{id}/ubicacion")
    public ResponseEntity<?> actualizarUbicacion(
            @PathVariable Long id,
            @RequestBody UbicacionDTO ubicacion) {
        Repartidor r = repo.findById(id).orElseThrow();
        r.setUbicacionLat(ubicacion.getLat());
        r.setUbicacionLon(ubicacion.getLon());
        repo.save(r);
        return ResponseEntity.ok("Ubicación actualizada");
    }

    @GetMapping("/{id}/ubicacion")
    public ResponseEntity<UbicacionDTO> obtenerUbicacion(@PathVariable Long id) {
        Repartidor r = repo.findById(id).orElseThrow();
        return ResponseEntity.ok(new UbicacionDTO(r.getUbicacionLat(), r.getUbicacionLon()));
    }
}