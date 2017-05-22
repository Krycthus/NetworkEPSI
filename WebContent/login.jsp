<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./ressources/css/style.css" />
<title>Accueil</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<p class="nav-text">EPSI</p>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div>
					<h1>mettre une image</h1>
				</div>
				<div>
					<p>EPSI - Chat</p>
				</div>
				<div class="groove">
					<ul class="nav nav-tabs">
					  <li class="active"><a data-toggle="tab" href="#login">Connexion</a></li>
					  <li ><a data-toggle="tab" href="#subscribe">Inscription</a></li>
					</ul>
					
					<div class="tab-content">
						<div id="login" class="tab-pane fade in active">
					    	<form action='validation.php' method=POST>
					    		<div>
					    			<label for="pseudo">Utilisateur :</label><br />
								    <input type=text id="pseudo" name='Admin' placeholder="pseudo"/>
					    		</div>
					    		<div>
					    			<label for ="pwd"> Mot de passe</label><br />
								    <input type="password" id="pwd" name="MotDePasse" placeholder="Mot de passe">
					    		</div>
							    <input type=submit>
							</form>
					  	</div>  	
					  	<div id="subscribe" class="tab-pane fade">
					    	<form action='validation.php' method=POST>
					    		<div>
					    			<label for="pseudo"> Votre nom d'utilisateur :</label><br />
								    <input type=text id="pseudo" name='Admin' placeholder="pseudo"/>
					    		</div>
					    		<div>
					    			<label for ="pwd"> Mot de passe</label><br />
								    <input type="password" id="pwd" name="MotDePasse" placeholder="Mot de passe">
					    		</div>
					    		<div>
					    			<label for ="pwd"> Confirmation du mot de passe</label><br />
								    <input type="password" id="pwd" name="MotDePasse" placeholder="Mot de passe">
					    		</div>
							    <input type=submit>
							</form>
				  		</div>				  	
					</div>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>