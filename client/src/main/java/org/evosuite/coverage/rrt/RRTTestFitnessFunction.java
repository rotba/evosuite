package org.evosuite.coverage.rrt;
import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testcase.execution.ExecutionResult;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RRTTestFitnessFunction extends TestFitnessFunction {

    private ClassLoader buggySUTClassLoader;

    public RRTTestFitnessFunction(ClassLoader buggySUTClassLoader) {
        this.buggySUTClassLoader = buggySUTClassLoader;
    }

    @Override
    public double getFitness(TestChromosome individual, ExecutionResult result) {
        return 0;
    }

    @Override
    public int compareTo(TestFitnessFunction other) {
        return 0;
    }

    @Override
    public int hashCode() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object other) {
        throw new NotImplementedException();
    }

    @Override
    public String getTargetClass() {
        return null;
    }

    @Override
    public String getTargetMethod() {
        return null;
    }
}
