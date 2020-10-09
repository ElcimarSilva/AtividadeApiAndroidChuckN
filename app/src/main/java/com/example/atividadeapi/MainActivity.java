package com.example.atividadeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView icon_url;
    private TextView id;
    private TextView url;
    private TextView value;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPessoa download = new DownloadPessoa();

        icon_url = (TextView) findViewById(R.id.iconView);
        id = (TextView) findViewById(R.id.idView);
        url = (TextView) findViewById(R.id.urlview);
        value = (TextView) findViewById(R.id.valueView);
        download.execute();
    }

    private class DownloadPessoa extends AsyncTask<Void, Void, itens> {

        @Override
        protected void onPreExecute() {
            //inicia o dialog
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde ...", "Obtendo Informações...");
        }
        /**
        @Override
        protected pessoa doInBackground(Void... params) {
            conversor util = new conversor();
            return util.getInformacao("https://api.github.com/users/elcimarsilva");
        }
        */
        @Override
        protected itens doInBackground(Void... params) {
            conversor util = new conversor();
            return util.getInformacao("https://api.chucknorris.io/jokes/random");
        }

        @Override
        protected void onPostExecute(itens itens) {
            //System.out.println(pessoa);
            icon_url.setText((itens.getIcon_url()));
            id.setText(itens.getId());
            url.setText(itens.getUrl());
            value.setText(itens.getValue());

            load.dismiss(); //deleta o dialog
        }

    }
}