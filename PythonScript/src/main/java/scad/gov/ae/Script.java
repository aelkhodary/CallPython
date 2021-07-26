package scad.gov.ae;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.apache.commons.io.IOUtils;


//ProcessBuilder API
public class Script {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*
        ProcessBuilder processBuilder = new ProcessBuilder("python", resolvePythonScriptPath("hello.py"));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        List<String> results = readProcessOutput(process.getInputStream());
        results.forEach(str -> {
            System.out.println(str);
            System.out.println("<==================================>");
        });
        */



        Script sc = new Script();
        System.out.println(sc.getOutput());

        /*int exitCode = process.waitFor();
        System.out.println(exitCode);
        System.out.println("-------------------------------------------------");

        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> engines = manager.getEngineFactories();

        for (ScriptEngineFactory engine : engines) {
            System.out.println("Engine name:" + engine.getEngineName());
            System.out.println("Version:" + engine.getEngineVersion());
            System.out.println("Language:" + engine.getLanguageName());

            System.out.println("\nShort Names:");
            for (String names : engine.getNames()) {
                System.out.println(names);
            }
        }*/
    }

    public String getOutput() {

        ProcessBuilder processBuilder = new ProcessBuilder("python", resolvePythonScriptPath("hello.py"));
        processBuilder.redirectErrorStream(true);

        Process process;
        try {
            process = processBuilder.start();

            List<String> results = readProcessOutput(process.getInputStream());

            return results.get(0);
        } catch (IOException e) {
        }

        return "NO Data Founded";
    }

    private static List<String> readProcessOutput(InputStream inputStream) throws IOException {
        return IOUtils.readLines(inputStream, "UTF-8");
    }

    private static String resolvePythonScriptPath(String filename) {
        //File file = new File("src/test/resources/" + filename);
        File file = new File("/stage/SFTPIntegration/FileData/" + filename);
        return file.getAbsolutePath();
    }
}
