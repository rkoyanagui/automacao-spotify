package br.com.rsi.ura.steps.gherkin;

import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import br.com.rsi.ura.steps.business.StepBussinesSpotify;

@ContextConfiguration("/appcontext.xml")
public class StepGherkinSpotify {

	private static final Logger LOG = Logger.getLogger(StepGherkinSpotify.class);
	@Steps
	private StepBussinesSpotify stepB;


	@Given("^inicializo o telefone para a aplicação$")
	public void inicializo_o_telefone_para_a_aplicação() throws Throwable {
		LOG.info("Inicializa aplicação");
		this.stepB.configurarApp();
	}

	@When("^clico em 'biblioteca'$")
	public void clico_em_biblioteca() throws Throwable {
		this.stepB.clicarBiblioteca();
	}

	@When("^clico em 'Playlists'$")
	public void clico_em_Playlists() throws Throwable {
		this.stepB.clicarPlaylists();
		
	}

	@When("^clico em criar playlists$")
	public void clico_em_criar_playlists() throws Throwable {
		this.stepB.clicarBotaoCriarPlaylist();
	}
	
	@When("^digito o nome da playlist \"([^\"]*)\"$")
	public void digito_o_nome_da_playlist_ArquiRap(String nomePlaylist) throws Throwable {
		this.stepB.preencheCampoNomePlaylist(nomePlaylist);
	}

	@And("^crio a playlist$")
	public void crio_a_playlist() throws Throwable {
		this.stepB.clicarBotaoCriarPlaylistFinal();
	}
	
	@Then("^valido que a playlist foi criada \"([^\"]*)\"$")
	public void valido_que_a_playlist_foi_criada(String validacao) throws Throwable {
		this.stepB.validaPlaylist(validacao);
	}
	
	@When("^verifico e clico na playlist a ser apagada \"([^\"]*)\"$")
	public void verifico_e_clico_na_playlist_a_ser_apagada(String nomePlaylist) throws Throwable {
		this.stepB.verifica(nomePlaylist);
	}

	@When("^clico em 'Apagar playlist'$")
	public void clico_em_Apagar_playlist() throws Throwable {
		this.stepB.clicaApagar();
	}

	@Then("^confirmo que quero apagar$")
	public void confirmo_que_quero_apagar() throws Throwable {
		this.stepB.clicaConfirmaApagar();
	}
}
