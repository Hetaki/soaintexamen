package com.jhuaman.soaint.examen;

import javax.xml.ws.Endpoint;

import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.jhuaman.soaint.examen.rest.BancoRestService;
import com.jhuaman.soaint.examen.rest.EjercicioRestService;
import com.jhuaman.soaint.examen.rest.OrdenPagoRestService;
import com.jhuaman.soaint.examen.rest.SucursalRestService;
import com.jhuaman.soaint.examen.ws.BancoWS;
import com.jhuaman.soaint.examen.ws.BancoWSImpl;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        /*factory.setResourceClasses(BancoVO.class);
        factory.setResourceClasses(SucursalVO.class);
        factory.setResourceClasses(OrdenP.class);*/
        factory.setResourceClasses(BancoRestService.class);
        factory.setResourceClasses(SucursalRestService.class);  
        factory.setResourceClasses(OrdenPagoRestService.class);
        factory.setResourceClasses(EjercicioRestService.class);
        factory.setResourceProvider(BancoRestService.class,
                new SingletonResourceProvider(new BancoRestService()));  
        factory.setResourceProvider(SucursalRestService.class,
                new SingletonResourceProvider(new SucursalRestService()));
        factory.setResourceProvider(OrdenPagoRestService.class,
                new SingletonResourceProvider(new OrdenPagoRestService()));
        factory.setResourceProvider(EjercicioRestService.class,
                new SingletonResourceProvider(new EjercicioRestService()));
        factory.setAddress("http://localhost:9090/");
        factory.setProvider(new JacksonJsonProvider());
        factory.create();

        BancoWS implementor = new BancoWSImpl();
        Endpoint.publish("http://localhost:9000/BancoWS",
        implementor,
        new LoggingFeature());

        System.out.println("Iniciando servidor");
        Thread.sleep(5 * 60 * 100000);
        
        System.out.println("Terminando servidor");
        System.exit(0);
    }
}
