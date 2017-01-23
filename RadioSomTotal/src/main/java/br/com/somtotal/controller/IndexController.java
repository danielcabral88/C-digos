package br.com.somtotal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {

	@Get("/")
	public String index(){
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return "Bem vindo, hoje é " + dataFormatada.format(new Date(System.currentTimeMillis()));
	}
}
