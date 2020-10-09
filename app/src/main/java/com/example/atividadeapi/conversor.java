package com.example.atividadeapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
public class conversor {
    public pessoa getInformacao(String end){
        String json = conexao.getJsonFromApi(end);
        pessoa retorno = parseJson(json);
        return retorno;
    }
*/
public class conversor {
    public itens getInformacao(String end){
        String json = conexao.getJsonFromApi(end);
        itens retorno = parseJson(json);
        return retorno;
    }


    private itens parseJson(String json){
        try {
            itens itens = new itens();

            JSONObject jsonObj = new JSONObject(json);
            itens.setIcon_url(jsonObj.getString("icon_url"));
            itens.setUrl(jsonObj.getString("url"));
            itens.setId(jsonObj.getString("id"));
            String value = jsonObj.getString("value").replaceAll("\"" , "");

            itens.setValue(value);

            return itens;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
/**
    private pessoa parseJson(String json){
        try {
            pessoa pessoa = new pessoa();

            JSONObject jsonObj = new JSONObject(json);
            pessoa.setUrl(jsonObj.getString("html_url"));
            pessoa.setId(jsonObj.getString("id"));
            pessoa.setLogin(jsonObj.getString("login"));

            return pessoa;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
 */
}