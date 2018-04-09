package ch.fhnw.uieng.module04.mountainapp_solution.service.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.uieng.module04.mountainapp_solution.service.MountainDTO;
import ch.fhnw.uieng.module04.mountainapp_solution.service.Page;
import ch.fhnw.uieng.module04.mountainapp_solution.service.PagingService;

/**
 * @author Dieter Holz
 */
public class MountainServiceFileBased implements PagingService<MountainDTO> {

    private static final String FILE_NAME = "/data/mountains.csv";
    private static final String DELIMITER = ";";

    public MountainServiceFileBased() {
    }

    @Override
    public Page<MountainDTO> getPage(int start, int pageSize, String filter) {
        List<MountainDTO> items = getItems(start, pageSize, filter);
        return new Page<>(getFilteredCount(filter), getTotalCount(), start, items.size(), items);
    }

    @Override
    public int getFilteredCount(String filter) {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return (int) streamOfLines.skip(1)
                                      .filter(line -> contains(line, filter))
                                      .map(s -> new MountainDTO(s.split(DELIMITER, 12)))
                                      .count();
        }
    }

    private int getTotalCount() {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return (int) streamOfLines.skip(1)
                                      .count();
        }
    }

    private List<MountainDTO> getItems(int start, int pageSize, String filter) {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return streamOfLines.skip(start + 1)
                                .filter(line -> contains(line, filter))
                                .map(s -> new MountainDTO(s.split(DELIMITER, 12)))
                                .limit(pageSize)
                                .collect(Collectors.toList());
        }
    }

    private boolean contains(String line, String filter){
        return filter == null || filter.isEmpty() || line.toLowerCase().contains(filter.toLowerCase());
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
