package br.com.somtotal.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.somtotal.model.Musica;

@Component
public class MusicaDAO {


	private final Session session;
	
	public MusicaDAO(Session session){
		this.session = session;
	}
	 
	public List<Musica> recuperar() {
		return session.createCriteria(Musica.class).list();
	}

	public void salvar(Musica musica){
		Transaction tx = session.beginTransaction();
		this.session.save(musica);
		
		tx.commit();
	}

	public void atualizar(Musica musica) {
		Transaction tx = session.beginTransaction();
		this.session.update(musica);
		tx.commit();
	}
	
	public Musica recuperar(int id) {
		return (Musica) this.session.get(Musica.class, id);
	}
	
	public List<Musica> recuperarComFiltro(Date dia, String opt, int idEstacao, int idRegiao, int idEstilo){
		List<Musica> musicas = new ArrayList<Musica>();
		String hql = " select count(m.nome) as ct, m.id, m.nome, m.artista, m.estilo.id " +
		" from estacao as e, musica as m join m.top10 as m1, " +
		" top10 as t inner join t.musicas as tm " +
		" where  " +

		//" tm.top10.id = t.id " +
		//" and tm.id = m.id " +

		" m1.id = t.id " +
		" and tm.id = m.id " +		
		" and m1.estacao.id = t.estacao.id " +
		" and t.estacao.id = e.id ";
		
		if(dia != null){
			if(opt.equalsIgnoreCase("dia")){
				hql += " and t.dia = :dia ";
			}else if(opt.equalsIgnoreCase("mes")){
				//hql += " and t.dia between :dia1 and :dia2 ";
				hql += " and month(t.dia) = :mes ";
			}
		}
		
		if(idEstacao != 0)
			hql += " and e.id = :idestacao ";
		if(idRegiao != 0)
			hql += " and e.regiao.id = :idregiao ";
		if(idEstilo != 0)
			hql += " and m.estilo.id = :idestilo ";
		
		hql += " group by  " +
		" m.id  " +
		" order by " +
		" ct desc ";
	
		Query query = this.session.createQuery(hql);
		
		if(dia != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
			if(opt.equalsIgnoreCase("dia")){
				query.setParameter("dia",dia);
			}else if(opt.equalsIgnoreCase("mes")){
				Calendar cal = Calendar.getInstance();
			    cal.setTime(dia);
			    int month = cal.get(Calendar.MONTH);
			    
			    //cal.add(Calendar.MONTH, -1);
			    
			    query.setParameter("mes",month+1);
			    
				//query.setParameter("dia1",dia);
				//query.setParameter("dia2",cal.getTime());	
				
				
			}
		}
			
		if(idEstacao != 0)
			query.setParameter("idestacao",idEstacao);
		if(idRegiao != 0)
			query.setParameter("idregiao",idRegiao);
		if(idEstilo != 0)
			query.setParameter("idestilo", idEstilo);

		query.setMaxResults(10);
		
		Iterator results = query.list().iterator();
		while(results.hasNext()){
			Object[] tuple = (Object[]) results.next();
			Musica m = new Musica();
			
			System.out.println("count " +tuple[0]);
			System.out.println("id " +tuple[1]);
			System.out.println("nome " +tuple[2]);
			
			m.setId(Integer.parseInt(""+tuple[1]));
			m.setNome(String.valueOf(tuple[2]));
			m.setArtista(String.valueOf(tuple[3]));
			EstiloDAO dao = new EstiloDAO(this.session);
			m.setEstilo(dao.recuperar(Integer.parseInt(""+tuple[4])));
			musicas.add(m);
			
		} 

		return musicas;
	}

	public void excluir(Musica musica) {
		Transaction tx = session.beginTransaction();
		this.session.delete(musica);
		tx.commit();
	}

}
