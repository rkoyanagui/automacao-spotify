package br.com.rsi.ura.steps.business;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import br.com.rsi.ura.pages.PageObjectSpotify;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

@ContextConfiguration("/appcontext.xml")
@PropertySource("application.properties")
public class StepBussinesSpotify {
	private static final Logger LOG = Logger.getLogger(StepBussinesSpotify.class);

	@SuppressWarnings("rawtypes")
	private AndroidDriver driver;

	private PageObjectSpotify page;

	public void configurarApp() {
		LOG.info("Configurar App");

		try {
			final DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "0025177605");
			capabilities.setCapability("platformName", "android");
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("newCommandTimeout", "1000000");
			capabilities.setCapability("app", "C:\\aplicativosextraidos\\Spotify.apk");
			this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			this.page = PageFactory.initElements(driver, PageObjectSpotify.class);

			LOG.info("******************************* INICIANDO APLICATIVO *******************************");

		} catch (MalformedURLException e) {
			LOG.error(e);
		}
	}

	public void clicarBiblioteca() {
		this.page.getBotaoBiblioteca().click();
	}

	public void clicarPlaylists() {
		this.page.getBotaoPlaylists().click();
	}

	public void clicarBotaoCriarPlaylist() {
		this.page.getBotaoCriar().click();
	}

	public void preencheCampoNomePlaylist(String nomePlaylist) {
		this.page.getCampoNomePlaylist().sendKeys(nomePlaylist);
	}

	public void clicarBotaoCriarPlaylistFinal() {
		this.page.getBotaoCriarPlaylist().click();
	}

	public void validaPlaylist(String validacao) {
		this.page.getMensagemValidacao().getText();
		LOG.info(">> " + page.getMensagemValidacao().getText());
		assertEquals(validacao, page.getMensagemValidacao().getText());
	}

	public void verifica(String nomePlaylist) {

		String playlist;
		List<WebElement> myElements = driver.findElements(By.id("android:id/text1"));

		for (WebElement listas : myElements) {
			playlist = listas.getText();
			System.out.println(listas.toString() + " = " + listas.getText());

			if (playlist.equals(nomePlaylist)) {
				System.out.println("entrei aqui");

				new TouchAction(driver).longPress(driver.findElement(By.xpath("//*[@text='" + nomePlaylist + "']")))
						.waitAction(1200).release().perform();

			}

		}
	}

	public void clicaApagar() {
		this.page.getBotaoApagar().click();
	}
	
	public void clicaConfirmaApagar() {
		this.page.getBotaoConfirmaApagar().click();
	}
	
}
