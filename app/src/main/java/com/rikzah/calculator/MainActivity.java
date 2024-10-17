
package com.rikzah.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    //All variables are declared private to restrict their access only to methods within the same class.
    //Constants for different Arithmetic Operations:
    private static final char ADDITION = '+',SUBTRACTION = '-',MULTIPLICATION = '*';
    private static final char PERCENT = '%',DIVISION = '/';


    //Variables to store the current state of the calculator, including the values entered by the user and references to UI elements:
    private char currentSymbol;

    // Represents the first operand for mathematical operations, initialized as Not a Number (NaN).
    private double firstValue = Double.NaN;
    private double secondValue;
    private DecimalFormat decimalFormat;
    private EditText InputDisplay;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.welcometoast,null);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        //Limit Decimal precision to 5 decimal places
        decimalFormat= new DecimalFormat("#.#####");



        // Initialize the variables
        Result= findViewById(R.id.Result);
        InputDisplay=findViewById(R.id.InputDisplay);

        ImageButton deleteImageButton = findViewById(R.id.delete);
        Button clearButton = findViewById(R.id.clear);
        Button addButton = findViewById(R.id.add);
        Button subtractButton = findViewById(R.id.subtract);
        Button divideButton = findViewById(R.id.divide);
        Button multiplyButton = findViewById(R.id.multiply);

        Button plusMinusButton = findViewById(R.id.plusminus);
        Button pointButton = findViewById(R.id.point);
        Button percentageButton = findViewById(R.id.percentage);
        Button equalsButton = findViewById(R.id.equals);

        Button oneButton = findViewById(R.id.one);
        Button twoButton = findViewById(R.id.two);
        Button threeButton = findViewById(R.id.three);
        Button fourButton = findViewById(R.id.four);
        Button fiveButton = findViewById(R.id.five);
        Button sixButton = findViewById(R.id.six);
        Button sevenButton = findViewById(R.id.seven);
        Button eightButton = findViewById(R.id.eight);
        Button nineButton = findViewById(R.id.nine);
        Button zeroButton = findViewById(R.id.zero);

        plusMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "-");Result.setText("-");
            }

        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "0");


            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "1");} });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "2");
            } });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "3");
            } });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "4");
            } });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "5");
            } });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "6");
            } });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "7");
            } });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "8");
            } });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDisplay.setText(InputDisplay.getText() + "9");
            } });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a toast message indicating the selection of the first number
                if (!InputDisplay.getText().toString().isEmpty() || !Double.isNaN(firstValue)) {
                    Number1toast();

                    allCalculations();
                    currentSymbol = ADDITION;
                    Result.setText(decimalFormat.format(firstValue) + "+");
                    InputDisplay.setText("");
                    Number2toast();
                }
                else{
                    Result.setText("+");
                    InputDisplay.setText("");
                    displayError("Enter First Number");

                }
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a toast message indicating the selection of the first number
                if (!InputDisplay.getText().toString().isEmpty() || !Double.isNaN(firstValue)) {
                    Number1toast();

                    allCalculations();
                    currentSymbol = SUBTRACTION;
                    Result.setText(decimalFormat.format(firstValue) + "-");
                    InputDisplay.setText("");
                    Number2toast();
                }
                else{
                    Result.setText("-");
                    InputDisplay.setText("");
                    displayError("Enter First Number");
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a toast message indicating the selection of the first number
                if (!InputDisplay.getText().toString().isEmpty() || !Double.isNaN(firstValue)) {
                    Number1toast();

                    allCalculations();
                    currentSymbol = MULTIPLICATION;
                    Result.setText(decimalFormat.format(firstValue) + "x");
                    InputDisplay.setText("");
                    Number2toast();
                }
                else{
                    Result.setText("x");
                    InputDisplay.setText("");
                    displayError("Enter First Number");
                }
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a toast message indicating the selection of the first number
                if (!InputDisplay.getText().toString().isEmpty() || !Double.isNaN(firstValue)) {
                    Number1toast();

                    allCalculations();
                    currentSymbol = DIVISION;
                    Result.setText(decimalFormat.format(firstValue) + "/");
                    InputDisplay.setText("");
                    Number2toast();
                }
                else{
                    Result.setText("/");
                    InputDisplay.setText("");
                    displayError("Enter First Number");
                }
            }
        });
        percentageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a toast message indicating the selection of the first number
                if (!InputDisplay.getText().toString().isEmpty() || !Double.isNaN(firstValue)) {
                    Number1toast();

                    allCalculations();
                    currentSymbol = PERCENT;
                    Result.setText(decimalFormat.format(firstValue) + "%");
                    InputDisplay.setText("");
                    Number2toast();
                }
                else{
                    Result.setText("%");
                    InputDisplay.setText("");
                    displayError("Enter First Number");
                }
            }
        });

        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = InputDisplay.getText().toString();

                // Check if the current input already contains a decimal point
                if (!currentInput.contains(".")) {
                    InputDisplay.setText(currentInput + ".");
                } else {
                    // Display a custom toast error if a decimal point already exists
                    // Display a custom Toast with the error message
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.errortoast,null);

                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 200);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();displayError("Decimal point already exists.");
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstValue = Double.NaN;
                secondValue = Double.NaN;
                InputDisplay.setText("");
                Result.setText("");
            }

        });
        deleteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence currentText = InputDisplay.getText();
                int length = currentText.length();

                if (length > 0) {
                    // Remove the last character
                    InputDisplay.setText(currentText.subSequence(0, length - 1));
                } else {
                    // If there are no characters, reset values
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    InputDisplay.setText("");
                }
            }
        });
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                Result.setText(""); // Clear Result EditText before displaying the result
                if (firstValue == Double.NaN) {
                    Result.setText("");
                    InputDisplay.setText("");
                } else {
                    Result.append(decimalFormat.format(firstValue));
                    InputDisplay.setText(decimalFormat.format(firstValue));
                    firstValue = Double.NaN;
                    currentSymbol = '\0'; // Reset currentSymbol
                }
            }
        });

    }
    private void allCalculations() {
        if (!Double.isNaN(firstValue)) {
            String inputText = InputDisplay.getText().toString();

            // Check for empty input
            if (inputText.isEmpty()) {
                displayError("Please enter a number.");
                return;
            }
            // Process the input text
            String processedInput = inputText;
            secondValue = Double.parseDouble(processedInput);
            InputDisplay.setText(null);

            // Rest of your calculation logic
            try {
                if (currentSymbol == ADDITION)
                    firstValue += secondValue;
                else if (currentSymbol == SUBTRACTION)
                    firstValue -= secondValue;
                else if (currentSymbol == MULTIPLICATION)
                    firstValue *= secondValue;
                else if (currentSymbol == DIVISION)
                    if (secondValue != 0) {
                        firstValue /= secondValue;
                    } else {
                        displayError("Cannot divide by zero.");
                        firstValue=Double.NaN;
                    }
                else if (currentSymbol == PERCENT){
                    if (secondValue != 0) {
                        firstValue %= secondValue;
                    }
                    else {
                        displayError("Invalid operation: Modulo by zero.");
                        firstValue=Double.NaN;}
                }


            } catch (ArithmeticException e) {
                // Handle arithmetic exceptions, e.g., overflow or other arithmetic errors
                displayError("An arithmetic error occurred.");
                firstValue = Double.NaN;
            } catch (NumberFormatException e) {
                // Handle number format exceptions, e.g., invalid number format
                displayError("Invalid number format.");
                firstValue = Double.NaN;
            }
        }
        else {
            try {
                String inputText = InputDisplay.getText().toString();
                // Process the input text
                String processedInput = inputText;

                firstValue = Double.parseDouble(processedInput);
            } catch (NumberFormatException e) {
                // Handle number format exceptions, e.g., invalid number format
                displayError("Invalid number format.");
                firstValue = Double.NaN;
            }


        }

    }

    private void displayError(String errorMessage) {
        // Display a custom Toast with the error message
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.errortoast2, null);

        // Find the TextView in your custom layout
        TextView errorTextView = layout.findViewById(R.id.textView);

        // Set the error message
        errorTextView.setText(errorMessage);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 90, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    private void Number1toast() {
        // Display a custom Toast with the error message
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.number1toast,null);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 90, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    private void Number2toast() {
        // Display a custom Toast with the error message
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.number2toast,null);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 90, 200);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}
