package br.com.somtotal.infra;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import net.vidageek.mirror.dsl.Mirror;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.proxy.SuperMethod;

@Component
public class CriadorDeSession implements ComponentFactory<Session> {

	private final SessionFactory factory;
	private Session session;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}

	@PostConstruct
	public void abre() {
		this.session = factory.openSession();
	}

	@Override
	public Session getInstance() {
		return this.session;
	}

	@PreDestroy
	public void fecha() {
		this.session.close();
	}

}
