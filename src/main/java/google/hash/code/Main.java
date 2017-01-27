package google.hash.code;


import google.hash.code.input.InputReader;
import google.hash.code.model.Drone;
import google.hash.code.model.World;
import google.hash.code.output.Writer;
import google.hash.code.process.SimpleProcessor;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class Main {
    public static final Logger LOGGER = getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        SimpleProcessor simpleProcessor = new SimpleProcessor();
        InputReader inputReader = new InputReader();
        Writer writer = new Writer();

        String[] fileNames = {"simple.in"};// For training
        // TODO For Real
        // String[] fileNames = {"busy_day.in", "redundancy.in", "mother_of_all_warehouses.in"};

        for (String fileName : fileNames) {
            LOGGER.info("File " + fileName + " loading");
            World world = inputReader.parse("/" + fileName);

            LOGGER.info("World Processing");
            List<Drone> drones = simpleProcessor.process(world);

            LOGGER.info("Result writing");
            writer.write(drones, new FileWriter(new File("target/" + fileName.replace(".in", ".out"))));
        }
    }
}
