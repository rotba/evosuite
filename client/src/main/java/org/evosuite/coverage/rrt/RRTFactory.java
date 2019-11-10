package org.evosuite.coverage.rrt;

import org.evosuite.Properties;
import org.evosuite.TestGenerationContext;
import org.evosuite.testsuite.AbstractFitnessFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class RRTFactory extends AbstractFitnessFactory<RRTTestFitnessFunction> {
    @Override
    public List<RRTTestFitnessFunction> getCoverageGoals() {
        return new ArrayList<RRTTestFitnessFunction>() {{
            add(
                    new RRTTestFitnessFunction(
                            TestGenerationContext.getInstance().getBuggyClassLoaderForSUT()
                    )
            );
        }};
    }
}
