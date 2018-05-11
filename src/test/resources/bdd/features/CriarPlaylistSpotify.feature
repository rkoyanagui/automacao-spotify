Feature: Playlist Spotify 
# Atualizado  09/03/2018

Scenario Outline: Criar playlist Spotify 

	Given inicializo o telefone para a aplicação 
	When clico em 'biblioteca' 
	And clico em 'Playlists' 
	And clico em criar playlists 
	And digito o nome da playlist "<nomePlaylist>" 
	And crio a playlist
	And a
	Then valido que a playlist foi criada "<validacao>" 
	
	
	
	Examples: 
	
	|nomePlaylist|validacao								 |
	|testeRSI    |Quer adicionar músicas a esta playlist?|

		