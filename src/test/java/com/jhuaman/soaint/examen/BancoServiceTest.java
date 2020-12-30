package com.jhuaman.soaint.examen;

import java.util.List;

import com.jhuaman.soaint.examen.service.BancoService;
import com.jhuaman.soaint.examen.service.BancoServiceImpl;
import com.jhuaman.soaint.examen.utils.Utilitario;
import com.jhuaman.soaint.examen.vo.BancoVO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BancoServiceTest 
    extends TestCase
{

	BancoService bancoService = new BancoServiceImpl();

    public BancoServiceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BancoServiceTest.class );
    }

    public void testFindAll()
    {
    	List<BancoVO> respuesta = bancoService.findAll();

        assertTrue( !Utilitario.isEmpty(respuesta));
    }
}
