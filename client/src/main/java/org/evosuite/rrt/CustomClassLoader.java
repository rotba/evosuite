package org.evosuite.rrt;

import org.evosuite.instrumentation.InstrumentingClassLoader;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class CustomClassLoader extends ClassLoader{
    private static int DEL_ME = 0;
    private final Map<String, Class<?>> classes = new HashMap<>();

    protected CustomClassLoader(ClassLoader parent) {
        super(parent);
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

    public CustomClassLoader(InstrumentingClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(!name.equals("p_1.Amit") )return getParent().loadClass(name);
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
}
