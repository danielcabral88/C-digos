package br.com.somtotal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.somtotal.dao.EstacaoDAO;
import br.com.somtotal.dao.EstiloDAO;
import br.com.somtotal.dao.MusicaDAO;
import br.com.somtotal.dao.RegiaoDAO;
import br.com.somtotal.dao.Top10DAO;
import br.com.somtotal.model.Estacao;
import br.com.somtotal.model.Estilo;
import br.com.somtotal.model.Musica;
import br.com.somtotal.model.Regiao;
import br.com.somtotal.model.Top10;

@Resource
public class Top10Controller {

	private final Top10DAO dao;
	private final EstacaoDAO estacaodao;
	private final MusicaDAO musicadao;
	private final RegiaoDAO regiaodao;
	private final EstiloDAO estilodao;
	private final Result result;

	public Top10Controller(Top10DAO dao, EstacaoDAO estacaodao,
			RegiaoDAO regiaodao, EstiloDAO estilodao, MusicaDAO musicadao,
			Result result) {
		this.dao = dao;
		this.musicadao = musicadao;
		this.estacaodao = estacaodao;
		this.estilodao = estilodao;
		this.regiaodao = regiaodao;
		this.result = result;
	}

	@Post("/top10")
	public void salvar(Top10 top10, List<Musica> musicas) {
		// top10.getMusicas().add(e);
		for (Musica m : musicas) {
			top10.getMusicas().add(musicadao.recuperar(m.getId()));
		}

		dao.salvar(top10);
		result.redirectTo(this).recuperar();
	}

	@Get("/top10")
	public void recuperar() {
		result.include("estacaoList", estacaodao.recuperar());
		result.include("regiaoList", regiaodao.recuperar());
		result.include("estiloList", estilodao.recuperar());
	}

	/*@Post("/top10/musicas")
	public List<Musica> recuperar(String opt, Top10 top10, Estacao estacao,
			Regiao regiao, Estilo estilo) {

		String diaOuMes = opt;
		Date dia = null;
		int idEstacao = 0;
		int idRegiao = 0;
		int idEstilo = 0;
		if (top10 != null)
			dia = top10.getDia();
		if (estacao != null)
			idEstacao = estacao.getId();
		if (regiao != null)
			idRegiao = regiao.getId();
		if (estilo != null)
			idEstilo = estilo.getId();

		return musicadao.recuperarComFiltro(dia, diaOuMes, idEstacao, idRegiao,
				idEstilo);
	}
*/
	@Get("/top10/musicasjson/{data}/{opt}/{estilo}/{regiao}/{estacao}")
	public void recuperarJson(String data, String opt, int estilo, int regiao,
			int estacao) {

		Date date = null;
		if(!data.isEmpty()){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			try {
				date = formatter.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			date = new Date();
		}
	
		String diaOuMes = opt;
		
		result.use(Results.json())
				.withoutRoot()
				.from(musicadao.recuperarComFiltro(date, diaOuMes, estacao,
					regiao, estilo)).include("estilo").serialize();

	}

	// RECURSO RESTFUL
	// recuperar top 10 por região
	@Get("recurso/getTop10/porRegiao/{idregiao}")
	public List<Musica> recuperaTop10PorRegiao(
			@PathParam("regiao") String idregiao) {

		result.use(Results.json())
				.withoutRoot()
				.from(musicadao.recuperarComFiltro(null, "", 0,
						Integer.valueOf(idregiao), 0)).include("estilo")
				.serialize();

		return null;
	}

	// RECURSO RESTFUL
	// recuperar top 10 por mes
	@Get("recurso/getTop10/porMes/{mes}")
	public List<Musica> recuperaTop10PorMes(@PathParam("mes") String mes) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, Integer.valueOf(mes) - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		result.use(Results.json())
				.withoutRoot()
				.from(musicadao.recuperarComFiltro(calendar.getTime(), "mes",
						0, 0, 0)).include("estilo").serialize();

		return null;
	}

	// RECURSO RESTFUL
	// recuperar top 10 por estilo
	@Get("recurso/getTop10/porEstilo/{idestilo}")
	public List<Musica> recuperaTop10PorEstilo(
			@PathParam("estilo") String idestilo) {

		result.use(Results.json())
				.withoutRoot()
				.from(musicadao.recuperarComFiltro(null, "", 0, 0,
						Integer.valueOf(idestilo))).include("estilo")
				.serialize();

		return null;
	}

	// RECURSO RESTFUL
	@Get("recurso/getEstilos")
	public List<Estilo> recuperaTodosEstilos() {

		result.use(Results.json()).withoutRoot().from(estilodao.recuperar())
				.serialize();

		return null;
	}

	@Get("/top10/novo")
	public void formulario() {
		result.include("estacaoList", estacaodao.recuperar());
		result.include("musicaList", musicadao.recuperar());
	}

	@Delete("/top10/{id}")
	public void excluir(int id) {
		Top10 top10 = dao.recuperar(id);
		dao.excluir(top10);
		result.redirectTo(this).recuperar();
	}

}
