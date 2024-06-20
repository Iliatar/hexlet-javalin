@import org.example.hexlet.model.Course
@param Course course

@template.layout.page(
    content = @`
        <h1>${course.getName()}</h1>
        <div>
            <h2>This course about</h2>
            <p>${course.getDescription()}</p>
        </div>
    `
)