<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>${fullName}</h1>
<h1>${email}</h1>
<h1>${code}</h1>
<h1>${phoneNumber}</h1>
<button type="button" style="background-color: green">
    <a href="http://localhost:8080/api/auth/confirm?email=${email}&code=${code}">Activate</a>
</button>
<button type="button" style="background-color: green">
    <a href="http://localhost:8080/api/auth/cancel?email=${email}&code=${code}">cancel</a>
</button>
</body>
</html>