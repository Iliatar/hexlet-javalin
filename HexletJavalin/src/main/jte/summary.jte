@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage coursePage

@template.layout.page(
    content = @`
        <h1>${coursePage.getHeader()}</h1>
        @if(coursePage.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var course : coursePage.getCourses())
                <div>
                    <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                    <p>${course.getDescription()}</p>
                </div>
            @endfor
        @endif
    `
)