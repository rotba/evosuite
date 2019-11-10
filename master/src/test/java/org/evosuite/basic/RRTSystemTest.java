package org.evosuite.basic;
import com.examples.with.different.packagename.rrt.p_1.Amit;
import org.evosuite.EvoSuite;
import org.evosuite.Properties;
import org.evosuite.SystemTestBase;
import org.evosuite.ga.metaheuristics.GeneticAlgorithm;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.junit.Test;

public class RRTSystemTest extends SystemTestBase {
    @Test
    public void testNullString() {
        EvoSuite evosuite = new EvoSuite();

        String targetClass = Amit.class.getCanonicalName();
        String buggyCP = getSUT1BuggyCP();

        Properties.TARGET_CLASS = targetClass;

        String[] command = new String[] {
                "-generateSuite",
                "-class", targetClass,
                "-buggyProjectCP",buggyCP,
                "-criterion","BRANCH:EXCEPTION:METHOD:RRT",
        };

        Object result = evosuite.parseCommandLine(command);
        GeneticAlgorithm<?> ga = getGAFromResult(result);
        TestSuiteChromosome best = (TestSuiteChromosome) ga.getBestIndividual();
    }

    private String getSUT1BuggyCP() {
        return "C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\buggy\\MavenProj\\sub_mod_1\\target\\classes";
    }
}
