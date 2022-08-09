package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@Autowired
	private HelloService service;

	@GetMapping("/hello")
	public ModelAndView getHello() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	// helloからname属性で受け取った値を@RequestParamで指定し、引数の型と変数名を指定する
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {

		// Modelクラスを使うことで第１引数をキー、第２引数を値として保存する
		model.addAttribute("sample", str);
		// test用
		// 値を渡した後の遷移先の指定
		return "hello/response";
	}

	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2") String id, Model model) {

		Employee employee = service.getEmployee(id);

		model.addAttribute("employee", employee);

		return "hello/db";
	}
}
