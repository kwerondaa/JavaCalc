package com.Kweronda.Organized;

import java.awt.*;
import java.util.Scanner;

public class Main<myVar> {

    public static void main(String[] args) {

        double[] leftVals = {49f, 34.5, 56, 4f, 90.4f};
        double[] rightVals = {13f, 12f, 20.4f, 18.9f};
        char[] opCode = {'a', 'm', 's', 'd'};
        double[] result = new double[opCode.length];

        if (args.length == 0) {
            for (int i = 0; i < opCode.length; i++) {
                result[i] = execute(opCode[i], leftVals[i], rightVals[i]);
            }


            for (double currentResult : result)
                System.out.println(currentResult);

        }else if(args.length == 1 && args[0].equals("interactive"))
            executeInteractively();

        else if (args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Add opcode and 2 digits");
    }

    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput=scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode =opCodeFromString(parts[0]);
        double leftVal =valueFromWord(parts[1]);
        double rightVal =valueFromWord(parts[2]);
        double result = execute(opCode , leftVal, rightVal);
        displayResult(opCode, leftVal, rightVal, result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
//        StringBuilder builder = new StringBuilder(20);
//        builder.append(leftVal);
//        builder.append(" ");
//        builder.append(symbol);
//        builder.append(" ");
//        builder.append(rightVal);
//        builder.append(" = ");
//        builder.append(result);
//        String output = builder.toString();



        String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode){
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol =' ';
        for (int index =0; index< opCodes.length; index++){
            if(opCode == opCodes[index]){
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal){ //marking this method as static
        double result;
        switch (opCode) {


            case 'a':
                result = leftVal + rightVal;
                break;

            case 'm':
                result = leftVal * rightVal;
                break;

            case 's':
                result = leftVal - rightVal;
                break;


            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid code " + opCode);
                result = 0.0d;
                break;
        }
        return result;

    }

    static char opCodeFromString(String operationName){
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word){ //marking our method as static
        String[] numberWords = {
                "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for (int index =0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        return value;
    }




}
