package com.entelgy.retotecnico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetoTecnicoApplicationTests {

	@Autowired
	private RetoService retoService;

	// @Test
	void contextLoads() {
	}

	@Test
	void test_facade() throws JSONException {
		// String get_from_api =
		// "{'page':1,'per_page':6,'total':12,'total_pages':2,'data':[{'id':1,'email':'george.bluth@reqres.in','first_name':'George','last_name':'Bluth','avatar':'https://reqres.in/img/faces/1-image.jpg'},{'id':2,'email':'janet.weaver@reqres.in','first_name':'Janet','last_name':'Weaver','avatar':'https://reqres.in/img/faces/2-image.jpg'},{'id':3,'email':'emma.wong@reqres.in','first_name':'Emma','last_name':'Wong','avatar':'https://reqres.in/img/faces/3-image.jpg'},{'id':4,'email':'eve.holt@reqres.in','first_name':'Eve','last_name':'Holt','avatar':'https://reqres.in/img/faces/4-image.jpg'},{'id':5,'email':'charles.morris@reqres.in','first_name':'Charles','last_name':'Morris','avatar':'https://reqres.in/img/faces/5-image.jpg'},{'id':6,'email':'tracey.ramos@reqres.in','first_name':'Tracey','last_name':'Ramos','avatar':'https://reqres.in/img/faces/6-image.jpg'}],'support':{'url':'https://reqres.in/#support-heading','text':'To
		// keep ReqRes free, contributions towards server costs are appreciated!'}}";
		JSONObject json_de_api = retoService.facade("https://reqres.in/api/users");
		JSONObject json_test = new JSONObject("	{'data': [    '1|Bluth|george.bluth@reqres.in',    '2|Weaver|janet.weaver@reqres.in',    '3|Wong|emma.wong@reqres.in',    '4|Holt|eve.holt@reqres.in',    '5|Morris|charles.morris@reqres.in',    '6|Ramos|tracey.ramos@reqres.in']}");
		boolean test = true;

		for (int i = 0; i < json_test.getJSONArray("data").length(); i++) {
			String a0 = json_test.getJSONArray("data").getString(i);
			String a1 = json_de_api.getJSONArray("data").getString(i);
			if (a0.equals(a1)) {
			} else {
				test = false;
			}
		}
		assertTrue(test);
	}
}

// 1|Bluth|george.bluth@reqres.in
// 1|Bluth|george.bluth@reqres.in