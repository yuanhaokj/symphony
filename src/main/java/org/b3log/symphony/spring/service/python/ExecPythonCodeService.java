package org.b3log.symphony.spring.service.python;

import org.python.core.Py;
import org.python.core.PyException;
import org.python.util.PythonInterpreter;

import java.io.*;
import java.util.Properties;

public class ExecPythonCodeService {

    private PythonInterpreter interpreter;

    private Properties props = new Properties();

    public ExecPythonCodeService(){
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        interpreter = new PythonInterpreter();
    }


    public String execPythonCodeForLine(String pythonCode) throws IOException, PyException {
        //设置执行结果
        StringWriter out = new StringWriter();
//        PyObject pyObject = new PyObject();
        interpreter.setOut(out);
        //执行Python语句,UTF-8编码
        interpreter.exec(Py.newStringUTF8(pythonCode));
        String result = out.toString();
        return result;
    }

    public static String execPythonCode(String pythonCode){
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        //设置执行结果
        StringWriter out = new StringWriter();
        interpreter.setOut(out);
        //执行Python语句,UTF-8编码
        interpreter.exec(Py.newStringUTF8(pythonCode));
        return out.toString();
    }


    public static String execPythonCodeFile(String pythonCodeFile, String... args){
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, args);
        PythonInterpreter interpreter = new PythonInterpreter();
        //设置执行结果
        StringWriter out = new StringWriter();
        interpreter.setOut(out);
        //执行Python语句,UTF-8编码
        interpreter.execfile(pythonCodeFile);
        return out.toString();
    }

    public static String execPythonCodeInputStream(InputStream pythonCodeFileInputStream, String... args){
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, args);
        PythonInterpreter interpreter = new PythonInterpreter();
        //设置执行结果
        StringWriter out = new StringWriter();
        interpreter.setOut(out);
        //执行Python语句,UTF-8编码
        interpreter.execfile(pythonCodeFileInputStream);
        return out.toString();
    }

}
