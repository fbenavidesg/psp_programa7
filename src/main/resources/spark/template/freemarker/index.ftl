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
    td{
        text-align: rigth;
    }
</style>
<body>
    <table>
        <tr>
            <th>r</th>
            <td>${resultado.getR()?string("####.##########")}</td>
        </tr>
        <tr>
            <th>r2</th>
            <td>${resultado.getR2()?string("####.##########")}</td>
        </tr>
    </table>
</body>
</html>