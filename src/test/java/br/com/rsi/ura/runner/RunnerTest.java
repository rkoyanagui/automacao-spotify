package br.com.rsi.ura.runner;

import org.apache.log4j.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.rsi.exception.SetupAppException;
import br.com.rsi.ura.acceptance.DefaultAcceptanceTestRunner;
import io.openbdt.run.SuiteTestRunner;
import io.openbdt.util.file.FileUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/appcontext.xml")
@PropertySource("application.properties")
public class RunnerTest {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(RunnerTest.class);
	
	/**
	 * @Inject
	 */
	@Autowired
	private SuiteTestRunner suiteTestRunner;
	@Value("${openbdt.arquivos.dados}")
	private String caminhoArquivos;

	@Value("${openbdt.ura.dias.expurgo}")
	private String diasExpurgo;

	@Before
	public void init() throws SetupAppException {
		
		//Armazena o caminho dos audios para os gravadores/tradutores
		System.setProperty("openbdt.data.files", caminhoArquivos);
		
		//Exclui arquivos antigos
		LOG.info("Excluindo arquivos gerados a mais de " + diasExpurgo + " dias.");
		FileUtil.deleteOlderFiles(Long.valueOf(diasExpurgo), caminhoArquivos+"/audio");
	}
	
	@Test
	public void test() {
		LOG.info(">>>>>>>>>>>>>>> Start test "); 
		
		this.suiteTestRunner.runWithJunit(DefaultAcceptanceTestRunner.class);
		
		LOG.info(">>>>>>>>>>>>>>> End test ");
	}
}
