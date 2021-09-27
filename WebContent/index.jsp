<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8"/>
		<title>Login</title>
	</head>
	<body>
		
		<h1>Login</h1>
		
		<form action="ServletLogin" method="post">
			
			<label for="usuario" class="descricao-campo">Usuário</label>
			<input name="usuario" type="text" class="campo"/>
			
			<br/><br/>
			
			<label for="senha" class="descricao-campo">Senha</label>
			<input name="senha" type="password" class="campo"/>
			
			<br/><br/>
			
			<button type="submit">Entrar</button>
			
		</form>
		
	</body>
</html>