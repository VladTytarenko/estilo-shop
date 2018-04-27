<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/customer/{id}/update" method="POST">
    Id: <br>
    <input type="text" name="customerId" value="${customer.customerId}" readonly/><br>
    Name:<br>
    <input type="text" name="name" value="${customer.name}"/><br>
    Phone:<br>
    <input type="text" name="mobilePhone" value="${customer.mobilePhone}"/><br>
    Email:<br>
    <input type="email" name="customerEmail" value="${customer.customerEmail}"/><br>
    Password:<br>
    <input type="password" name="password" value=""${customer.password}"/>
    <input type="submit" value="OK"/>
</form>



</body>
</html>