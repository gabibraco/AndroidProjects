package com.example.arturo.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    //Definimos las variables necesarias
    boolean nuevaVentana = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos el objeto de tipo EditText
        final EditText editText = (EditText) findViewById(R.id.editText);

        //Creamos el botón
        Button button = (Button) findViewById(R.id.button);

        //Creamos el objeto WebView en nuestro view generado en activity_main.xml
        final WebView webview = (WebView) this.findViewById(R.id.webView);
        //Habilitamos JavaScript
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Cargamos la pagina en el WebView al hacer click en el botón
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = editText.getText().toString();
                if(!nuevaVentana) {
                    //Si no está marcado nueva ventana cargamos la página en la ventana actual
                    webview.loadUrl(url);
                } else {
                    //Si está marcado el radio button Nueva ventana cargamos la pagína en una nueva ventana
                    Uri uri = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
            }
        });

    }

    //Método para saber qué radioButton está seleccionado
    public void onRadioButtonClicked(View view) {
        //Comprobamos que hay uno seleccionado
        boolean checked = ((RadioButton) view).isChecked();
        //Comprobamos cual está seleccionado
        switch(view.getId()) {
            //Si está seleccionado el de Ventana actual se define la variable nuevaVentana como false
            case R.id.radioButton:
                if (checked)
                    nuevaVentana = false;
                    break;
            //Si está seleccionado el de Ventana actual se define la variable nuevaVentana como true
            case R.id.radioButton2:
                if (checked)
                    nuevaVentana = true;
                    break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
