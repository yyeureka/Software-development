package edu.gatech.seclass.sdpencryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private EditText textInput;
    private EditText textArgA;
    private EditText textArgB;
    private Button buttonEncipher;
    private EditText textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = (EditText) findViewById(R.id.payloadID);
        textArgA = (EditText) findViewById(R.id.argAlphaID);
        textArgB = (EditText) findViewById(R.id.argBetaID);
        buttonEncipher = (Button) findViewById(R.id.encipherButtonID);
        textOutput = (EditText) findViewById(R.id.payloadEncipheredID);

        this.setTitle("SDP Encryptor Spring 22");
    }

    public void handleClick(View view) {
        boolean valid = true;
        String input = textInput.getText().toString();
        String argA = textArgA.getText().toString();
        String argB = textArgB.getText().toString();

        // invalid input
        if ((0 == input.length()) || (!input.matches(".*[a-zA-Z]+.*"))) {
            textInput.setError("Invalid Payload");
            valid = false;
        }
        // invalid argA
        int a = Integer.parseInt(argA);
        if ((a < 1) || (a >= 26) || (0 == (a % 2)) || (0 == (a % 13))) {
            textArgA.setError("Invalid Arg Alpha");
            valid = false;
        }
        // invalid argB
        int b = Integer.parseInt(argB);
        if ((b < 1) || (b >= 26)) {
            textArgB.setError("Invalid Arg Beta");
            valid = false;
        }

        if (!valid) {
            textOutput.setText("");
        }
        else {
            textOutput.setText(encipher(input, a, b));
        }
    }

    private String encipher(String input, int a, int b) {
        StringBuilder sb = new StringBuilder("");
        char[] ch = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(ch[i])) {
                char c = (char)(((ch[i] - 'A') * a + b) % 26 + 'a');
                sb.append(c);
            }
            else if (Character.isLowerCase(ch[i])) {
                char c = (char)(((ch[i] - 'a') * a + b) % 26 + 'A');
                sb.append(c);
            }
            else {
                sb.append(ch[i]);
            }
        }

        return sb.toString();
    }
}