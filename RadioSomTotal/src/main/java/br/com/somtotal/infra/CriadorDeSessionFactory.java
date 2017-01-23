package br.com.somtotal.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements
		ComponentFactory<SessionFactory> {

	private SessionFactory factory;

	@PostConstruct
	public void abre() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
		this.factory = configuration.buildSessionFactory(serviceRegistry);
	}

	@Override
	public SessionFactory getInstance() {
		return this.factory;
	}

	@PreDestroy
	public void fecha() {
		this.factory.close();
	}

}
