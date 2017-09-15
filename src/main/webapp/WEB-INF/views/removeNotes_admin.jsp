<html>
<head>
<title>Remove Notes Page</title>
</head>
<body>
<h1>Remove notes </h1>
<p><font color="green">${Success}</font></p>
    <form action="/removeNotes" method=POST>
       Remove notes:
       <select name = "Denomination">
  	<option value="20">20</option>
  	<option value="50">50</option> 
</select>
         <input name="Count" type="number" />
        <input type="submit" />
    </form>
</body>
</html>