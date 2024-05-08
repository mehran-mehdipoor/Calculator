package dev.mehdipoor;

public class Calculator{
    public String calculation(String Total,String Number, String operator){
        Double result = null;
        switch (operator){
            case "+":
                result = Double.parseDouble(Total) + Double.parseDouble(Number);
                break;
            case "-":
                result = Double.parseDouble(Total) - Double.parseDouble(Number);
                break;
            case "/":
                result = Double.parseDouble(Total) / Double.parseDouble(Number);;
                break;
            case "*":
                result = Double.parseDouble(Total) * Double.parseDouble(Number);
                break;
        }

        return parse(result);
    }
    public static String parse(double num) {
        if((int) num == num){
            return Integer.toString((int) num);
        }
        return String.valueOf(num);
    }
}
