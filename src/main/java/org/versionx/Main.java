package org.versionx;

import org.versionx.functionbridge.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Initialize the function registry
        FunctionRegistry registry = new FunctionRegistry();

        // Register Python functions
        registry.registerFunction("add", new MultiLanguageFunction("python", "functions/functions.py", "add"));
        registry.registerFunction("multiply", new MultiLanguageFunction("python", "functions/functions.py", "multiply"));

        // User provided script in Python
        String userScript = "result_add = add(5, 3)\n" +
                "result_multiply = multiply(5, 3)\n" +
                "print(result_add)\n" +
                "print(result_multiply)\n" +
                "result_add";

        // Execute the user script
        Object result = DynamicScriptExecutor.executeScript("python", userScript, registry);
        System.out.println(result);
    }
}