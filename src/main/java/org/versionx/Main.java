package org.versionx;

import org.versionx.functionbridge.oldcode.DynamicScriptExecutor;
import org.versionx.functionbridge.oldcode.FunctionRegistry;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static void main(String[] args) {
//
//
//        Long startTime = System.currentTimeMillis();
//        // Initialize the function registry
//        FunctionRegistry registry = new FunctionRegistry();
//
//        // Register Python functions
//        registry.registerFunction("add", new MultiLanguageFunction("python", "src/main/resources/functions/functions.py", "add"));
//        registry.registerFunction("multiply", new MultiLanguageFunction("python", "src/main/resources/functions/functions.py", "multiply"));
//
//        // User provided script in Python
//        String userScript = "result_add = add(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "print(result_add)\n" +
//                "print(result_multiply)\n" +
//                "result_add";
//
//        // Execute the user script
//        Object result = DynamicScriptExecutor.executeScript("python", userScript, registry);
//        System.out.println(result);
//        Long endTime = System.currentTimeMillis();
//        System.out.println("Execution time: " + (endTime - startTime) + "ms");
//    }

//    public static void main(String[] args) throws IOException {
//        // Initialize the function registry
//        Long startTime = System.currentTimeMillis();
//
//        //Get input from user
//
//
//        FunctionRegistry registry = new FunctionRegistry("python");
//        FunctionRegistry registry2 = new FunctionRegistry("python");
//        FunctionRegistry registry3 = new FunctionRegistry("python");
//
//        // Register Python functions
//        registry.registerMultiLanguageFunction("add", "python", "src/main/resources/functions/functions.py", "add");
//        registry.registerMultiLanguageFunction("multiply", "python", "src/main/resources/functions/functions.py", "multiply");
//
//        registry2.registerMultiLanguageFunction("add", "python", "src/main/resources/functions/functions.py", "add");
//        registry2.registerMultiLanguageFunction("multiply", "python", "src/main/resources/functions/functions.py", "multiply");
//
//        registry3.registerMultiLanguageFunction("add", "python", "src/main/resources/functions/functions.py", "add");
//        registry3.registerMultiLanguageFunction("multiply", "python", "src/main/resources/functions/functions.py", "multiply");
//
//        ExecutionContext executionContext = new ExecutionContext("1","2");
//
//        registry.setExecutionContext(executionContext);
//        registry2.setExecutionContext(executionContext);
//        registry3.setExecutionContext(executionContext);
//
//        // User provided script in Python
//        String userScript = "result_add = add(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "print(result_add)\n" +
//                "print(result_multiply)\n" +
//                "result_add";
//
//        // Execute the user script
//        Object result = DynamicScriptExecutor.executeScript("python", userScript, registry);
//        Object result2 = DynamicScriptExecutor.executeScript("python", userScript, registry2);
//        Object result3 = DynamicScriptExecutor.executeScript("python", userScript, registry3);
//
//        ExecutionContext executionContext2 = new ExecutionContext("3","4");
//
//        registry.setExecutionContext(executionContext2);
//
//        // Execute the user script
//        result = DynamicScriptExecutor.executeScript("python", userScript, registry);
//
//
//        Long endTime = System.currentTimeMillis();
//        System.out.println("Execution time: " + (endTime - startTime) + "ms");
//    }

    public static class ExecutionContext {
        public String a = "can access private";
        public String b = "can access public";

        public ExecutionContext(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public void printSomething(){
            System.out.println("printing something");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        FunctionRegistry registry = new FunctionRegistry("python");

        // Register Python functions
        registry.registerMultiLanguageFunction("add", "python", "src/main/resources/functions/functions.py", "add");
        registry.registerMultiLanguageFunction("multiply", "python", "src/main/resources/functions/functions.py", "multiply");

        ExecutionContext executionContext = new ExecutionContext("1","2");

        registry.setExecutionContext(executionContext);

        while (!exit) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Long start = System.currentTimeMillis();
                    registry.setExecutionContext(executionContext);
                    for(int i=0;i<10;i++)
                        runScript(registry);
                    Long end = System.currentTimeMillis();
                    System.out.println("Execution time: " + (end - start) + " ms");
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void runScript(FunctionRegistry registry) {
        String userScript = "result_add = add(b=5)\n" +
//                "result_multiply = multiply(a=5,  b=3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
//                "result_multiply = multiply(5, 3)\n" +
                "print(result_add)\n" +
//                "print(result_multiply)\n" +
                "result_add";

        // Execute the user script
        Object result = new DynamicScriptExecutor().executeScript("python", userScript, registry);
    }


}