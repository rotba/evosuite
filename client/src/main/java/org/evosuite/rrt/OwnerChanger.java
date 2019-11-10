package org.evosuite.rrt;

import org.evosuite.Properties;
import org.evosuite.ga.Chromosome;
import org.evosuite.instrumentation.InstrumentingClassLoader;
import org.evosuite.testcase.DefaultTestCase;
import org.evosuite.testcase.ExecutableChromosome;
import org.evosuite.testcase.TestCase;
import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.statements.AbstractStatement;
import org.evosuite.testcase.statements.ConstructorStatement;
import org.evosuite.testcase.statements.Statement;
import org.evosuite.testsuite.AbstractTestSuiteChromosome;
import org.evosuite.testsuite.TestSuiteChromosome;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class OwnerChanger {

    public AbstractTestSuiteChromosome<? extends ExecutableChromosome> change(TestSuiteChromosome suite) {
        for (TestCase t:
             suite.getTests()) {
            change(t);
        }
        return suite;
    }

    private void change(TestCase t) {
        InstrumentingClassLoader icl = (InstrumentingClassLoader) Properties.getTargetClassAndDontInitialise().getClassLoader();
        ((DefaultTestCase)t).changeClassLoader(new CustomClassLoader(icl));
        ((DefaultTestCase)t).toString();
//        for (Statement s:
//                t) {
//            change(s);
//        }
    }

    private void change(Statement s) {
        InstrumentingClassLoader icl = (InstrumentingClassLoader) Properties.getTargetClassAndDontInitialise().getClassLoader();
        s.changeClassLoader(new CustomClassLoader(icl));
        s.getTestCase().toString();
    }

}
