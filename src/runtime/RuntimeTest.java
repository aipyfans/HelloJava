package runtime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Runtime
 * <p>
 * https://www.jianshu.com/p/af4b3264bc5d
 * http://yangfangs.github.io/2016/03/16/java-waitfor-block-deadlock/
 */
public class RuntimeTest {


    public static void main(String[] args) {
        aboutMemory();
        aboutCmd();
    }

    /**
     * 内存相关的操作
     */
    private static void aboutMemory() {
        Runtime runtime = Runtime.getRuntime();

        long availableProcessors = runtime.availableProcessors();
        System.out.println("返回可用于Java虚拟机的处理器数量：" + availableProcessors);

        long maxMemory = runtime.maxMemory();
        System.out.println("JVM最大内存量：" + maxMemory);

        long freeMemory = runtime.freeMemory();
        System.out.println("JVM空闲内存量：" + freeMemory);

        long totalMemory = runtime.totalMemory();
        System.out.println("JVM总的内存量：" + totalMemory);


        String str = "Hello " + "World" + "!!!" + "\t" + "Welcome " + "To " + "MLDN" + "~";
        System.out.println(str);
        for (int x = 0; x < 1000; x++) {
            str += x;          // 循环修改内容，会产生多个垃圾
        }

        freeMemory = runtime.freeMemory();
        System.out.println("操作String之后的,JVM空闲内存量：" + freeMemory);

        runtime.gc();      // 进行垃圾收集，释放空间

        freeMemory = runtime.freeMemory();
        System.out.println("垃圾回收之后的,JVM空闲内存量：" + freeMemory);
        System.out.println("--------------------------------------------------------");
    }


    /**
     * 命令相关的操作
     */
    private static void aboutCmd() {
        try {
            String[] cmd = {"/bin/bash"};
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            bufferedWriter.write("pwd\n");
            bufferedWriter.write("cd ~\n");
            bufferedWriter.write("pwd\n");
            bufferedWriter.write("ls");
            bufferedWriter.flush();
            bufferedWriter.close();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuffer cmdOut = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                cmdOut.append(line + "\n");
            }
            bufferedReader.close();
            System.out.println(cmdOut.toString());

            process.waitFor();
            System.out.println("return: " + process.exitValue());

            process.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------");
    }


}
