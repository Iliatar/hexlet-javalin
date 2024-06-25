@import gg.jte.Content

@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <header>
            <a href="/courses">К списку курсов</a>
        </header>
        <div>${content}</div>
    </body>
    <footer>
        <p><a href="https://github.com/Iliatar">My GitHUB repository</a></p>
    </footer>
</html>