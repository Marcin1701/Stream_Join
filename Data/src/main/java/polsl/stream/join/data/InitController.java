package polsl.stream.join.data;

import org.springframework.web.bind.annotation.*;
import polsl.stream.join.data.model.Config;

import java.util.List;

@RestController
@RequestMapping("/data")
public class InitController {

    private final CsvReader csvReader;

    private final ConfigService configService;

    public InitController(CsvReader csvReader, ConfigService configService) {
        this.csvReader = csvReader;
        this.configService = configService;
    }

    @GetMapping("/joins")
    public List<String> getJoinTypes() {
        return this.configService.getJoinTypes();
    }

    @GetMapping("/fileData/{filename}")
    public List<?> getFileData(@PathVariable String filename) {
        return this.csvReader.readDataFromFile(filename);
    }

    @GetMapping
    public List<String> getReadDataFileNames() {
        return this.csvReader.getFileNames();
    }

    @PostMapping
    public void startCalculation(@RequestBody Config configClass) {
        this.configService.startAlgorithm(configClass);
    }
}
