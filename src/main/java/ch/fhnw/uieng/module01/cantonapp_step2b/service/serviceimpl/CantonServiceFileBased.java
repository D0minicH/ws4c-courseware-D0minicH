package ch.fhnw.uieng.module01.cantonapp_step2b.service.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.uieng.module01.cantonapp_step2b.service.CantonDTO;
import ch.fhnw.uieng.module01.cantonapp_step2b.service.CantonService;

/**
 * @author Dieter Holz
 */
public class CantonServiceFileBased implements CantonService {

    private static final String FILE_NAME = "/data/cantons.csv";
    private static final String DELIMITER = ";";

    @Override
    public List<CantonDTO> findAll() {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {             // try-with-resources schliesst automatisch den Stream
            return streamOfLines.skip(1)                                               // erste Zeile ist die Headerzeile; ueberspringen
                                .map(line -> new CantonDTO(line.split(DELIMITER, 12))) // aus jeder Zeile ein DTO machen
                                .collect(Collectors.toList());                         // alles aufsammeln
        }

    }

   	private Stream<String> getStreamOfLines(String fileName) {
   		try {
   			return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
   		} catch (IOException e) {
   			throw new IllegalStateException(e);
   		}
   	}

   	private Path getPath(String fileName)  {
   		try {
   			return Paths.get(getClass().getResource(fileName).toURI());
   		} catch (URISyntaxException e) {
   			throw new IllegalArgumentException(e);
   		}
   	}
}
