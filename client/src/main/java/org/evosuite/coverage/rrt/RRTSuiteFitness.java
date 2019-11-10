package org.evosuite.coverage.rrt;

import org.evosuite.testcase.ExecutableChromosome;
import org.evosuite.testsuite.AbstractTestSuiteChromosome;
import org.evosuite.testsuite.TestSuiteFitnessFunction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RRTSuiteFitness extends TestSuiteFitnessFunction {
    @Override
    public double getFitness(AbstractTestSuiteChromosome<? extends ExecutableChromosome> individual) {
        throw new NotImplementedException();
    }
}
