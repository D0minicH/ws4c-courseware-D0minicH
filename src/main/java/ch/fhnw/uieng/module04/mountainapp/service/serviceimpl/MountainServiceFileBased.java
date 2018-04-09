package ch.fhnw.uieng.module04.mountainapp.service.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.uieng.module04.mountainapp.service.MountainDTO;
import ch.fhnw.uieng.module04.mountainapp.service.PagingService;

/**
 * @author Dieter Holz
 */
public class MountainServiceFileBased implements PagingService<MountainDTO> {

    private static final String FILE_NAME = "/data/mountains.csv";
    private static final String DELIMITER = ";";

    public MountainServiceFileBased() {
    }

    @Override
    public List<MountainDTO> getPage(int start, int pageSize) {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return streamOfLines.skip(start + 1)
                                .map(s -> new MountainDTO(s.split(DELIMITER, 12)))
                                .limit(pageSize)
                                .collect(Collectors.toList());
        }

    }

    @Override
    public int getCount() {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return (int) streamOfLines.skip(1)
                                      .count();
        }
    }

    private Stream<String> getStreamOfLines(String fileName) {
        try {
            return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Path getPath(String fileName) {
        try {
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
