package ch.fhnw.uieng.module03.lazyloading_idbased.service.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.uieng.module03.lazyloading_idbased.service.CommuneDTO;
import ch.fhnw.uieng.module03.lazyloading_idbased.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class CommuneServiceFileBased implements CommuneService {

    private static final String FILE_NAME = "/data/communes.txt";
    private static final String DELIMITER = "\t";

	@Override
	public List <Long> getAllIds() {
		try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {        	// try-with-resources schliesst automatisch den Stream
			return streamOfLines.skip(1)                                          	// erste Zeile ist die Headerzeile; ueberspringen
					.map(line -> Long.parseLong(line.split(DELIMITER, 12)[2]))
					.collect(Collectors.toList());                    				// alles aufsammeln
		}
	}

	@Override
	public CommuneDTO getCommuneById(long id) {
		try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
			return streamOfLines.skip(1)
					.filter(line -> Long.parseLong(line.split(DELIMITER, 12)[2])== id)
					.map(line -> new CommuneDTO(line.split(DELIMITER,12)))				//.map: Abbildung von einem Element in ein neues
					.findAny()
					.orElseThrow(IllegalArgumentException::new);
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
