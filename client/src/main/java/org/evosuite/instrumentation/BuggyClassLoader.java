package org.evosuite.instrumentation;

import org.evosuite.Properties;
import org.evosuite.TestGenerationContext;
import org.evosuite.classpath.ResourceList;
import org.evosuite.runtime.instrumentation.RuntimeInstrumentation;
import org.evosuite.runtime.javaee.db.DBManager;
import org.objectweb.asm.ClassReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.evosuite.Properties;
import org.evosuite.TestGenerationContext;
import org.evosuite.classpath.ResourceList;
import org.evosuite.runtime.instrumentation.RuntimeInstrumentation;
import org.evosuite.runtime.javaee.db.DBManager;
import org.objectweb.asm.ClassReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;

/**
 *
 * @author Rotem Barak
 * @author Gordon Fraser
 */
public class BuggyClassLoader extends ClassLoader {
    private Map<String, Class<?>> classes = new HashMap<>();
    private List availableClasses = new ArrayList();

    public BuggyClassLoader(InstrumentingClassLoader parent, List availableClasses) {
        super(parent);
        this.availableClasses = availableClasses;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(shouldOverride(name))return override(name);
        else return getParent().loadClass(name);
    }

    private boolean shouldOverride(String name) {
        return availableClasses.contains(name);
    }

    private Class<?> override(String name) throws ClassNotFoundException {
        Class<?> res = classes.get(name);
        if(res == null) return findClass(name);
        else return res;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if(!name.equals("p_1.Amit") )return getParent().loadClass(name);
        byte[] b = loadClassFromFile();
        Class<?> result = defineClass(name, b, 0, b.length);
        classes.put(name, result);
        return result;
    }
    private byte[] loadClassFromFile()  {
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
//                "C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\buggy\\MavenProj\\sub_mod_1\\target\\classes\\p_1\\Amit.class"
//        );
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    "C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\buggy\\MavenProj\\sub_mod_1\\target\\classes\\p_1\\Amit.class"
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }

    @Override
    public URL getResource(String name) {
        return getParent().getResource(name);
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        return getParent().getResources(name);
    }


    @Override
    public InputStream getResourceAsStream(String name) {
        return getParent().getResourceAsStream(name);
    }




    @Override
    public void setDefaultAssertionStatus(boolean enabled) {
        getParent().setDefaultAssertionStatus(enabled);
    }

    @Override
    public void setPackageAssertionStatus(String packageName, boolean enabled) {
        getParent().setPackageAssertionStatus(packageName, enabled);
    }

    @Override
    public void setClassAssertionStatus(String className, boolean enabled) {
        getParent().setClassAssertionStatus(className, enabled);
    }

    @Override
    public void clearAssertionStatus() {
        getParent().clearAssertionStatus();
    }


}

