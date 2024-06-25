@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage coursePage

@template.layout.page(
    content = @`
        <h1>${coursePage.getHeader()}</h1>
        @if(coursePage.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            <form action="/courses/" method="get">
                <input type="search" name="term" value="${coursePage.getTerm()}">
                <input type="submit" value="Поиск">
            </form>
            @for(var course : coursePage.getCourses())
                @if (coursePage.getTerm() == null || coursePage.getTerm().isEmpty() || course.getName().startsWith(coursePage.getTerm()))
                    <div>
                        <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                        <p>${course.getDescription()}</p>
                    </div>
                @endif
            @endfor
        @endif
    `
)