package com.entelgy.retotecnico;

import javax.xml.bind.PrintConversionEvent;

import org.json.JSONObject;

public class MiTest {

    void test_get_from_api(){
        RetoService consum = new RetoService();
        String hola = consum.get_from_api("https://reqres.in/api/users");
        System.out.println(hola);
    }
    void test_adapter_string_a_json() {
        String get_from_api = "{'page':1,'per_page':6,'total':12,'total_pages':2,'data':[{'id':1,'email':'george.bluth@reqres.in','first_name':'George','last_name':'Bluth','avatar':'https://reqres.in/img/faces/1-image.jpg'},{'id':2,'email':'janet.weaver@reqres.in','first_name':'Janet','last_name':'Weaver','avatar':'https://reqres.in/img/faces/2-image.jpg'},{'id':3,'email':'emma.wong@reqres.in','first_name':'Emma','last_name':'Wong','avatar':'https://reqres.in/img/faces/3-image.jpg'},{'id':4,'email':'eve.holt@reqres.in','first_name':'Eve','last_name':'Holt','avatar':'https://reqres.in/img/faces/4-image.jpg'},{'id':5,'email':'charles.morris@reqres.in','first_name':'Charles','last_name':'Morris','avatar':'https://reqres.in/img/faces/5-image.jpg'},{'id':6,'email':'tracey.ramos@reqres.in','first_name':'Tracey','last_name':'Ramos','avatar':'https://reqres.in/img/faces/6-image.jpg'}],'support':{'url':'https://reqres.in/#support-heading','text':'To keep ReqRes free, contributions towards server costs are appreciated!'}}";
        RetoService consum = new RetoService();
        JSONObject hola = consum.adapter_string_a_json(get_from_api);
    
        System.out.println(get_from_api);
        System.out.println("######################################################################");
        System.out.println(hola.get("page"));
        
    }

    void test_adapter_json_a_json() {
        String get_from_api = "{'page':1,'per_page':6,'total':12,'total_pages':2,'data':[{'id':1,'email':'george.bluth@reqres.in','first_name':'George','last_name':'Bluth','avatar':'https://reqres.in/img/faces/1-image.jpg'},{'id':2,'email':'janet.weaver@reqres.in','first_name':'Janet','last_name':'Weaver','avatar':'https://reqres.in/img/faces/2-image.jpg'},{'id':3,'email':'emma.wong@reqres.in','first_name':'Emma','last_name':'Wong','avatar':'https://reqres.in/img/faces/3-image.jpg'},{'id':4,'email':'eve.holt@reqres.in','first_name':'Eve','last_name':'Holt','avatar':'https://reqres.in/img/faces/4-image.jpg'},{'id':5,'email':'charles.morris@reqres.in','first_name':'Charles','last_name':'Morris','avatar':'https://reqres.in/img/faces/5-image.jpg'},{'id':6,'email':'tracey.ramos@reqres.in','first_name':'Tracey','last_name':'Ramos','avatar':'https://reqres.in/img/faces/6-image.jpg'}],'support':{'url':'https://reqres.in/#support-heading','text':'To keep ReqRes free, contributions towards server costs are appreciated!'}}";
        RetoService consum = new RetoService();
        JSONObject json_a_trabajar = consum.adapter_string_a_json(get_from_api);
        JSONObject json_trabajado = consum.adapter_json_a_json(json_a_trabajar);
        System.out.println(json_trabajado.toString(4));
    }

    void test_facade() {
        // String get_from_api = "{'page':1,'per_page':6,'total':12,'total_pages':2,'data':[{'id':1,'email':'george.bluth@reqres.in','first_name':'George','last_name':'Bluth','avatar':'https://reqres.in/img/faces/1-image.jpg'},{'id':2,'email':'janet.weaver@reqres.in','first_name':'Janet','last_name':'Weaver','avatar':'https://reqres.in/img/faces/2-image.jpg'},{'id':3,'email':'emma.wong@reqres.in','first_name':'Emma','last_name':'Wong','avatar':'https://reqres.in/img/faces/3-image.jpg'},{'id':4,'email':'eve.holt@reqres.in','first_name':'Eve','last_name':'Holt','avatar':'https://reqres.in/img/faces/4-image.jpg'},{'id':5,'email':'charles.morris@reqres.in','first_name':'Charles','last_name':'Morris','avatar':'https://reqres.in/img/faces/5-image.jpg'},{'id':6,'email':'tracey.ramos@reqres.in','first_name':'Tracey','last_name':'Ramos','avatar':'https://reqres.in/img/faces/6-image.jpg'}],'support':{'url':'https://reqres.in/#support-heading','text':'To keep ReqRes free, contributions towards server costs are appreciated!'}}";
        RetoService consum = new RetoService();
        JSONObject hola = consum.facade("https://reqres.in/api/users");
        System.out.println(hola.toString(4));
    }

}
