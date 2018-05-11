Feature: Playlist Spotify 
# Atualizado  09/03/2018

Scenario Outline: Apagar playlist Spotify 

	Given inicializo o telefone para a aplicação 
	When clico em 'biblioteca' 
	And clico em 'Playlists' 
	And verifico e clico na playlist a ser apagada "<nomePlaylist>" 
	And clico em 'Apagar playlist'
	Then confirmo que quero apagar 
	
	
	Examples: 
	
	|nomePlaylist |
	|testeRSI2    |
	|testeRSI     |
	


		