package com.wisely.highlight_springmvc4.web.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.highlight_springmvc4.domain.DemoObj;

@RestController
@RequestMapping("rest")
public class DemoRestController {
	
	@RequestMapping(value="getjson", produces={"application/json;charset=UTF-8"})
	public DemoObj getjson(DemoObj obj){
		return new DemoObj(obj.getId(), obj.getName() + "XX");
		
	}
	
	@RequestMapping(value="getxml", produces={"application/xml;charset=UTF-8"})
	public DemoObj getXml(DemoObj obj){
		return new DemoObj(obj.getId(), obj.getName() + "YY");
	}

}
