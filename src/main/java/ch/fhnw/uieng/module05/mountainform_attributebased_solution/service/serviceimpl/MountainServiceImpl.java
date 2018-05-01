package ch.fhnw.uieng.module05.mountainform_attributebased_solution.service.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Stream;

import ch.fhnw.uieng.module05.mountainform_attributebased_solution.service.MountainDetailDTO;
import ch.fhnw.uieng.module05.mountainform_attributebased_solution.service.MountainService;

/**
 * @author Dieter Holz
 */
public class MountainServiceImpl implements MountainService {
    private static final String FILE_NAME = "/data/mountains.csv";
    private static final String DELIMITER = ";";

    @Override
    public MountainDetailDTO findAny() {
        int randomIndex = new Random().nextInt(getTotalCount());

        return get(randomIndex);
    }

    @Override
    public void save(MountainDetailDTO dto) {
        // ToDo: implementation
    }

    private MountainDetailDTO get(int index){
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return streamOfLines
                    .skip(1 + index)
                    .map(line -> new MountainDetailDTO(line.split(DELIMITER)))
                    .findAny()
                    .orElseThrow(NoSuchElementException::new);
        }
    }

    private int getTotalCount() {
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
