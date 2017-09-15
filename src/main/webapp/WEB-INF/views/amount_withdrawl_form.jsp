<html>
<head>
<title>AMT Withdrawl page</title>
</head>
<body>
<h1> Enter the amount </h1>
<p><font color="red">${errorMessage}</font></p>
    <form action="/displaynotes" method=POST>
        Amount to be withdrawn :
        <input name="amount" type="number" /> 
        <input type="submit" />
    </form>
</body>
</html>