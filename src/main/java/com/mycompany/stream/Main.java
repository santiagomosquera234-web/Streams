
package com.mycompany.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    
public static void main(String[] args) {
    
        List<Estudiantes> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiantes("Ana", "Software", 4.8));
        estudiantes.add(new Estudiantes("Luis", "Software", 3.5));
        estudiantes.add(new Estudiantes("Carlos", "Sistemas", 4.2));
        estudiantes.add(new Estudiantes("Maria", "Software", 2.8));
        estudiantes.add(new Estudiantes("Pedro", "Industrial", 4.5));
        estudiantes.add(new Estudiantes("Laura", "Sistemas", 3.9));
        estudiantes.add(new Estudiantes("Andres", "Industrial", 2.5));
        estudiantes.add(new Estudiantes("Camila", "Software", 4.7));
        estudiantes.add(new Estudiantes("Jorge", "Sistemas", 3.2));
        estudiantes.add(new Estudiantes("Sofia", "Industrial", 4.0));

     
        System.out.println("APROBADOS");

        estudiantes.stream()
                .filter(e -> e.getNota() >= 3)
                .forEach(System.out::println);

       
        System.out.println("\n TOP 3 ");

        estudiantes.stream()
                .sorted((a, b) -> Double.compare(b.getNota(), a.getNota()))
                .limit(3)
                .forEach(System.out::println);

       
        double promedio = estudiantes.stream()
                .mapToDouble(Estudiantes::getNota)
                .average()
                .orElse(0);

        System.out.println("\nPromedio General: " + promedio);

        
        System.out.println("\nPROMEDIO POR PROGRAMA ");

        Map<String, Double> programas = estudiantes.stream()
                .collect(Collectors.groupingBy(
                        Estudiantes::getPrograma,
                        Collectors.averagingDouble(Estudiantes::getNota)
                ));

        System.out.println(programas);

        
        System.out.println("\n APROBADOS Y REPROBADOS ");

        Map<Boolean, List<Estudiantes>> resultado = estudiantes.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getNota() >= 3
                ));

        System.out.println(resultado);

       
        System.out.println("\n MAP NOMBRE -> NOTA ");

        Map<String, Double> notas = estudiantes.stream()
                .collect(Collectors.toMap(
                        Estudiantes::getNombre,
                        Estudiantes::getNota
                ));

        System.out.println(notas);
    }
}
