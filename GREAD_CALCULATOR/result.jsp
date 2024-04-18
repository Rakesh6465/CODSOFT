<!DOCTYPE html>
<html>
<head>
    <title>Grade Calculator Result</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Results</h2>
    <p>Total Marks: <%= request.getAttribute("totalMarks") %></p>
    <p>Average Percentage: <%= request.getAttribute("averagePercentage") %> %</p>
    <p>Grade: <%= request.getAttribute("grade") %></p>
</body>
</html>
