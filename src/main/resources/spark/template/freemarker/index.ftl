<!DOCTYPE html>
<html>
<head>
</head>
<style>
    table{
        border-collapse: collapse;
    }
    th,td {
        padding: 15px;
        text-align: center;
        border:1px solid gray;
    }
    th{
        background-color: darkseagreen;
        color: white;
    }
    td{
        text-align: rigth;
    }
</style>
<body>
    <h1>Resultados Tarea 7</h1>
    <table>
        <tr>
            <th>r</th>
            <td>${resultado.getR()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>r2</th>
            <td>${resultado.getR2()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>significance</th>
            <td>${resultado.getSignificancia()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>b0</th>
            <td>${resultado.getB0()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>b1</th>
            <td>${resultado.getB1()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>Proxy Mejorado</th>
            <td>${resultado.getProxyMejorado()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>Range</th>
            <td>${resultado.getRango()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>UPI</th>
            <td>${resultado.getRangoUpi()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>LPI</th>
            <td>${resultado.getRangoLpi()?string("####.##########")}</td>
        </tr>
    </table>
</body>
</html>