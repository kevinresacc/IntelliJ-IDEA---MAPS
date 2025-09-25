package com.example.maps12.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "repartidores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Repartidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;
    private Double ubicacionLat;
    private Double ubicacionLon;
}
