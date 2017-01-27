package google.hash.code.process;


import google.hash.code.model.Drone;
import google.hash.code.model.World;

import java.util.List;

public interface Processor {

    List<Drone> process(World world);

}
