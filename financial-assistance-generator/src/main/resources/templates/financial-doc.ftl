<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"></meta>
    <style>
        body {
            width: 400px;
            margin: auto;
        }

        table {
            width: 100%;
            overflow-y: auto;
            font-size: 10pt;
            border-collapse: collapse;
        }

        h2 {
            text-align: center;
        }

        hr {
            height: 2px;
            background-color: #dddddd;
            border: none;
            width: 100%;
            padding: 0;
            margin-top: 25px;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: center;
            padding: 4px;
        }

        th {
            background-color: #dddddd;
            font-weight: bold;
            font-size: 12pt;
        }

        .filled {
            font-style: italic;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Financial assistance providing</h2>

    <p>For the student <i>${student.lastName} ${student.firstName}</i> provide financial assistance for 10000 rubles per month.</p>

    <table>
        <tr>
            <th colspan="2">Student personal info</th>
        </tr>
        <tr>
            <td>First name</td>
            <td class="filled">${student.firstName}</td>
        </tr>
        <tr>
            <td>Last name</td>
            <td class="filled">${student.lastName}</td>
        </tr>
        <tr>
            <td>Age</td>
            <td class="filled">${student.age}</td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td class="filled">${student.phone}</td>
        </tr>
        <tr>
            <td>Course</td>
            <td class="filled">${student.course}</td>
        </tr>
        <tr>
            <td>Residence place</td>
            <td class="filled">${student.residencePlace}</td>
        </tr>
    </table>

    <p class="filled">Date create: ${.now?string["dd.MM.yyyy"]}</p>

    <hr></hr>

    <p style="margin-top: 5px; text-align: center">
        <b>Training Center: </b>+7(999)999-99-99, admin@train-center.ru
    </p>
</div>
</body>
</html>