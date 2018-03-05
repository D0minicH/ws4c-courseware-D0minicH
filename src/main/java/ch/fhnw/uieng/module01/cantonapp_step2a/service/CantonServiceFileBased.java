package ch.fhnw.uieng.module01.cantonapp_step2a.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dieter Holz
 */
public class CantonServiceFileBased implements CantonService {
    private static final String FILE_NAME = "/data/cantons.csv";
    private static final String DELIMITER = ";";






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

	@Override
	public List<CantonDTO> findAll() {

    	return getStreamOfLines(FILE_NAME)
				.skip(1)
				.map(line -> new CantonDTO(line.split(DELIMITER,12)))
				.collect(Collectors.toList());
	}
}
