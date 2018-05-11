package br.com.rsi.ura.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageObjectSpotify {

	@FindBy(name = "Sua Biblioteca")
	private WebElement botaoBiblioteca;
	
	@FindBy(name = "Playlists")
	private WebElement botaoPlaylists;
	
	@FindBy(name = "CRIAR")
	private WebElement botaoCriar;
	
	@FindBy(id = "com.spotify.music:id/edit_text")
	private WebElement campoNomePlaylist;
	
	@FindBy(name = "CRIAR")
	private WebElement botaoCriarPlaylist;
	
	@FindBy(name = "Quer adicionar músicas a esta playlist?")
	private WebElement mensagemValidacao;
	
	@FindBy(name = "Mostrar menu de contexto")
	private WebElement botaoOpcoesPlaylist;
	
	@FindBy(id = "android:id/text1")
	private WebElement classname;
	
	@FindBy(name = "Apagar playlist")
	private WebElement botaoApagar;
	
	@FindBy(name = "Apagar")
	private WebElement botaoConfirmaApagar;

	public WebElement getBotaoConfirmaApagar() {
		return botaoConfirmaApagar;
	}

	public WebElement getBotaoApagar() {
		return botaoApagar;
	}

	public WebElement getClassname() {
		return classname;
	}

	public WebElement getBotaoOpcoesPlaylist() {
		return botaoOpcoesPlaylist;
	}

	public WebElement getMensagemValidacao() {
		return mensagemValidacao;
	}

	public WebElement getBotaoCriarPlaylist() {
		return botaoCriarPlaylist;
	}

	public WebElement getBotaoBiblioteca() {
		return botaoBiblioteca;
	}

	public WebElement getBotaoPlaylists() {
		return botaoPlaylists;
	}

	public WebElement getBotaoCriar() {
		return botaoCriar;
	}

	public WebElement getCampoNomePlaylist() {
		return campoNomePlaylist;
	}
}
