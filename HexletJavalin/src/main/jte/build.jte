@template.layout.page(
    content = @`
        <form action="/course" method="post">
            <div>
                <label>Название курса
                    <input type="text" name="name"/>
                </label>
            </div>
            <div>
                <label>Описание
                    <input type="text" name="desc"/>
                </label>
            </div>
            <div>
                <label>Цена
                    <input type="text" name="price">
                </label>
            </div>
            <div>
                <input type="submit" name="Создать">
            </div>
        </form>
    `
)
