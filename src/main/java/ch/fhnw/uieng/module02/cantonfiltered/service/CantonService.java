package ch.fhnw.uieng.module02.cantonfiltered.service;

import java.util.List;

/**
 * Services bieten die notwendigen CRUD-Operationen für eine Entität.
 *
 * In diesem Beispiel die Operationen für die Entität 'Canton'
 *
 * Dieser Service wird noch weiter ausgebaut werden.
 *
 * @author Dieter Holz
 */
public interface CantonService {

    // Services arbeiten mit DTOs (Data Transfer Objects)
    // die lediglich zum Transport zwischen der Datenquelle und dem PresentationLayer dienen.
    List<CantonDTO> findAll();

    // typische weitere Operationen dieses Services (für dieses Beispiel vorerst nicht gebraucht)
//    CantonDTO get(int cantonId);
//
//    CantonDTO create(CantonDTO dto);
//
//    CantonDTO update(CantonDTO dto);
//
//    void delete(int cantonID);


}
