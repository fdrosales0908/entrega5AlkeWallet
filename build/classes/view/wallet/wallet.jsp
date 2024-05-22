<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Alke Wallet</title>
</head>
<body>
    <h1>Alke Wallet</h1>
    <h2>Saldo: ${balance}</h2>

    <form action="wallet" method="post">
        <label for="amount">Cantidad:</label>
        <input type="text" id="amount" name="amount" required>
        <button type="submit" name="action" value="deposit">Depositar</button>
        <button type="submit" name="action" value="withdraw">Retirar</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</body>
</html>
