package co.edu.uninorte.notas;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClickButton2(View view) {
        Float valorP,valorT = 0f;
        int count = 0;
        boolean missing = false;
        EditText etUserName1 = (EditText) findViewById(R.id.editText1);
        EditText etUserName2 = (EditText) findViewById(R.id.editText2);
        EditText etUserName3 = (EditText) findViewById(R.id.editText3);
        EditText etUserName4 = (EditText) findViewById(R.id.editText4);
        EditText etUserNameDef = (EditText) findViewById(R.id.editTextDef);

        //Toast.makeText(this,"click",Toast.LENGTH_SHORT);
        ArrayList<EditText> lista = new ArrayList<>();
        lista.add(etUserName1);
        lista.add(etUserName2);
        lista.add(etUserName3);
        lista.add(etUserName4);

        for(EditText edit : lista){
            edit.setTextColor(Color.BLACK);
            if(TextUtils.isEmpty(edit.getText())){
                //edit.setError("Tiene que dar un valor");
                count++;
                missing = true;
            } else {
                valorP = Float.valueOf(edit.getText().toString());
                valorT = valorP*0.25f + valorT;
            }
        }
        if (!missing) {
            valorT = valorT;
            etUserNameDef.setText(valorT.toString());
        } else {
            Float test = (3.8f - valorT)/(count*0.25f);
            Log.d("PromedioApp","valorT "+valorT + " need " +test);

            for(EditText edit : lista){
                if(TextUtils.isEmpty(edit.getText())){
                    edit.setText(test.toString());
                    edit.setTextColor(Color.BLUE);
                }
            }
            valorT = 0f;
            for(EditText edit : lista){
                valorP = Float.valueOf(edit.getText().toString());
                valorT = valorP*0.25f + valorT;
            }
            etUserNameDef.setText(valorT.toString());



        }

    }
}
