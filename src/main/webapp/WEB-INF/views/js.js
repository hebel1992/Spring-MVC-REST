$(function () {
    //Dodawanie ksiazki

    $("#add-book").submit(function (event) {
        var id = $("#id").val();
        var isbn = $("#isbn").val();
        var title = $("#title").val();
        var author = $("#author").val();
        var publisher = $("#publisher").val();
        var type = $("#type").val();

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/books/",
            data: JSON.stringify({
                isbn: isbn,
                title: title,
                author: author,
                publisher: publisher,
                type: type
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).done(function (response) {
                    console.log("completed")
                    window.location.reload();
                }).fail(function (err) {
                    console.log(err)
                })
        event.preventDefault()
    })
})