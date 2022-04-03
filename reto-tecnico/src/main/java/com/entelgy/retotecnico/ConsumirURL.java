package com.entelgy.retotecnico;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConsumirURL {

    public String get_from_api(String miURL) {
        try {

            URL url = new URL(miURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;

            String response = new String();
            for (String line; (line = br.readLine()) != null; response += line);


            conn.disconnect();
            return response;

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return "asd";
    }

    public void hola() {
        try {
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
                
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    /*
     * String a JSON...
     */
    public JSONObject adapter_string_a_json(String asd) {
        JSONObject myObject = new JSONObject(asd);
        return myObject;
    }

    /*
     * de JSON get a JSON que queremos...
     */
    public JSONObject adapter_json_a_json(JSONObject json_antiguo) {
        JSONArray arreglo_antiguo = json_antiguo.getJSONArray("data");
        arreglo_antiguo.getJSONObject(1);

        JSONArray list = new JSONArray();

        for (int i = 0; i < arreglo_antiguo.length(); i++) {
            String aux = "";
            aux = String.valueOf(arreglo_antiguo.getJSONObject(i).getInt("id"));
            aux = aux + "|";
            aux = aux + arreglo_antiguo.getJSONObject(i).getString("last_name");
            aux = aux + "|";
            aux = aux + arreglo_antiguo.getJSONObject(i).getString("email");
            list.put(aux);
        }

        JSONObject json_nuevo = new JSONObject();
        json_nuevo.put("data", list);
        return json_nuevo;
    }

    /**
     * entrada: string recumerado de la url
     * sailda: JSONobject con el formato solcitado
     * 
     * @param texto
     */
    public JSONObject facade() {

        String texto = this.get_from_api("https://reqres.in/api/users");

        JSONObject json_antiguo = adapter_string_a_json(texto);

        JSONObject json_nuevo = adapter_json_a_json(json_antiguo);

        return json_nuevo;

    }
}
