package ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.CommuneDTO;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class CommuneServiceFileBased implements CommuneService {

    private static final String FILE_NAME = "/data/communes.txt";
    private static final String DELIMITER = "\t";

	@Override
	public int getTotalCount() {
		try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
			return (int)streamOfLines.skip(1)
										.count();
		}
	}

	@Override
	public CommuneDTO getCommune(int rowIndex) {
		try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
			return streamOfLines.skip(1 + rowIndex).map(line -> new CommuneDTO(line.split(DELIMITER, 12)))
					.findAny()
					.orElseThrow(IllegalArgumentException:: new);

		}
	}

	@Override
    public List<CommuneDTO> findAll() {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {        // try-with-resources schliesst automatisch den Stream
            return streamOfLines.skip(1)                                          // erste Zeile ist die Headerzeile; ueberspringen
                                .map(s -> new CommuneDTO(s.split(DELIMITER, 12)))  // aus jeder Zeile ein DTO machen
                                .collect(Collectors.toList());                    // alles aufsammeln
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
