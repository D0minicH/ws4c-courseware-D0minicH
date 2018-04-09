package ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.service.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.service.CommuneDTO;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_step1.service.CommuneService;

/**
 * @author Dieter Holz
 */
public class CommuneServiceFileBased implements CommuneService {

    private static final String FILE_NAME = "/data/communes.txt";
    private static final String DELIMITER = "\t";

    @Override
    public int getCount() {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return (int) streamOfLines.skip(1)
                                      .count();
        }
    }

    @Override
    public CommuneDTO get(int index) {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return streamOfLines.skip(1 + index)
                                .limit(1)
                                .map(s -> new CommuneDTO(s.split(DELIMITER, 12)))
                                .findAny()
                                .orElseThrow(NoSuchElementException::new);
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
